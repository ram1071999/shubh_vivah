package com.Shubh_Vivah.Shubh_Vivah.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


public class User {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Full name is required")
	    @Column(name = "full_name", nullable = false)
	    private String fullName;

	    @NotBlank(message = "Gender is required")
	    private String gender;

	    @NotBlank(message = "Date of birth is required")
	    private String dob; // kept as String from the HTML date input, parsed if needed

	    private String religion;

	    private String caste;

	    @NotBlank(message = "Marital status is required")
	    @Column(name = "marital_status")
	    private String maritalStatus;

	    private String height;

	    private String education;

	    private String occupation;

	    @Column(name = "annual_income")
	    private String annualIncome;

	    private String city;

	    private String state;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Enter a valid email")
	    @Column(unique = true, nullable = false)
	    private String email;

	    @NotBlank(message = "Phone number is required")
	    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	    private String phone;

	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    @Column(nullable = false)
	    private String password;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt = LocalDateTime.now();

	    // Getters and setters

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getFullName() { return fullName; }
	    public void setFullName(String fullName) { this.fullName = fullName; }

	    public String getGender() { return gender; }
	    public void setGender(String gender) { this.gender = gender; }

	    public String getDob() { return dob; }
	    public void setDob(String dob) { this.dob = dob; }

	    public String getReligion() { return religion; }
	    public void setReligion(String religion) { this.religion = religion; }

	    public String getCaste() { return caste; }
	    public void setCaste(String caste) { this.caste = caste; }

	    public String getMaritalStatus() { return maritalStatus; }
	    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

	    public String getHeight() { return height; }
	    public void setHeight(String height) { this.height = height; }

	    public String getEducation() { return education; }
	    public void setEducation(String education) { this.education = education; }

	    public String getOccupation() { return occupation; }
	    public void setOccupation(String occupation) { this.occupation = occupation; }

	    public String getAnnualIncome() { return annualIncome; }
	    public void setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; }

	    public String getCity() { return city; }
	    public void setCity(String city) { this.city = city; }

	    public String getState() { return state; }
	    public void setState(String state) { this.state = state; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public LocalDateTime getCreatedAt() { return createdAt; }
	    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
	


}
