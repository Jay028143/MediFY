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


	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
		//this.niNumber=niNumber;
		this.mobileNumber = mobileNumber;
		//this.address = address;
		this.dateOfJoining=dateOfJoining;
		this.postCode = postCode;
		//this.createdAt = createdAt;
		//this.updatedAt = updatedAt;
	}
	
	

	public User( @NotBlank @Size(max = 20) String userName, @NotBlank @Size(max = 120) String password,
			String firstName, String lastName, String middleName, String gender, String storeId,
			@NotBlank @Size(max = 50) @Email String email, String mobileNumber, String houseNo,
			String streetName, String state, String country, String city, String postCode, Date dateOfBirth,
			Date dateOfJoining, String createdAt, String updatedAt) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		//this.roles = roles;
		this.storeId = storeId;
		this.email = email;
		//this.niNumber = niNumber;
		this.mobileNumber = mobileNumber;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.state = state;
		this.country = country;
		this.city = city;
		this.postCode = postCode;
		this.dateOfJoining = dateOfJoining;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
		

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	
	@Column(name = "middle_name")
	private String middleName;

	
	@Column(name = "gender")
	private String gender;

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

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "house_no")
	private String houseNo;

	@Column(name = "streetName")
	private String streetName;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;


	@Column(name = "postCode")
	private String postCode;
	
	
	
	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Column(name = "created_at")
	private String createdAt;

	@Column(name = "updated_at")
	private String updatedAt;
	
}
