package com.medify.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.ERole;
import com.medify.entity.Role;
import com.medify.entity.User;
import com.medify.security.login.payload.request.LoginRequest;
import com.medify.security.login.payload.request.RegisterRequest;
import com.medify.security.login.payload.response.UserInfoResponse;
import com.medify.security.login.payload.response.MessageResponse;
import com.medify.repository.RoleRepository;
import com.medify.repository.UserRepository;
import com.medify.security.jwt.JwtUtils;
import com.medify.service.UserDetailsImpl;

import javax.validation.Valid;


@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

	return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(new UserInfoResponse(
			userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles, userDetails.getStoreId()));
}

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
    if (userRepository.existsByUserName(registerRequest.getUsername())) {
      return ResponseEntity.status(201).body(new MessageResponse("Error: Username is already taken."));
    }

    if (userRepository.existsByEmail(registerRequest.getEmail())) {
      return ResponseEntity.status(201).body(new MessageResponse("Error: Email is already in use."));
    }

    
    User user = new User(registerRequest.getUsername(),
            encoder.encode(registerRequest.getPassword()), registerRequest.getFirstName(), 
            registerRequest.getLastName(),registerRequest.getMiddleName(),
            registerRequest.getGender(),
            registerRequest.getStoreId(), registerRequest.getEmail(), registerRequest.getMobileNumber(),
            registerRequest.getHouseNo(),registerRequest.getStreetName(),registerRequest.getState(),registerRequest.getCountry(),
            registerRequest.getCity(),
            registerRequest.getPostCode(),registerRequest.getDateOfBirth(),registerRequest.getDateOfJoining(),registerRequest.getCreatedAt()
            ,registerRequest.getUpdatedAt());
    

    Set<String> strRoles = registerRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.STAFF)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role.toLowerCase()) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "manager":
          Role modRole = roleRepository.findByName(ERole.MANAGER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.STAFF)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
}
