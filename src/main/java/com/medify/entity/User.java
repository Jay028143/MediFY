package com.medify.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
@Entity
public class User {

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public User( @NotBlank @Size(max = 20) String userName, @NotBlank @Size(max = 120) String password,
			String firstName, String lastName, String storeId,
			@NotBlank @Size(max = 50) @Email String email,String niNumber, String mobileNumber, String address
			, String postCode,Date createdAt, Date updatedAt, Date dateOfBirth, Date dateOfJoining) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.storeId = storeId;
		this.email = email;
		this.niNumber=niNumber;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.dateOfBirth=dateOfBirth;
		this.dateOfJoining=dateOfJoining;
		this.postCode = postCode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getNiNumber() {
		return niNumber;
	}

	public void setNiNumber(String niNumber) {
		this.niNumber = niNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "username")
	@NotBlank
	@Size(max = 20)
	private String userName;

	public User() {

	}

	@NotBlank
	@Size(max = 120)
	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Column(name = "store_id")
	private String storeId;

	@Column(name = "email")
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@Column(name = "ni_number")
	private String niNumber;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "postCode")
	private String postCode;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
}
