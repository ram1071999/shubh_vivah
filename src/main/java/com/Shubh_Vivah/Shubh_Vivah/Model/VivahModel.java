package com.Shubh_Vivah.Shubh_Vivah.Model;


import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;


@Entity
@Table(name="vivah_model")
public class VivahModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	 
	 
	 @Column
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	private String fullName;
	@Column
	private String gender;
	@Column
	private String height;
	@Column
	private String weight;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	 private  Date dob;
	@Column
	 private String maritalStatus;
	@Column
	 private String language;
	
	
	//Religious Details
	@Column
	private String religion;
	@Column
	 private String caste;
	@Column
	 private String gotra;
	
	
	
	
	//Education & Career
	@Column
	private String education;
	@Column
	private String occupation;
	@Column
	private double income;
	
	
	//Family Details
	@Column
	private String fatherDetails;
	@Column
	private String motherDetails;
	@Column
	private String siblings;
	@Column
	private String familyType;
	
	
	
	//Content
	@Column
	private String mobile;
	@Column
	private String address;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String pincode;
	@Column
	private String email;
	@Column
	private String city;
	
	@Column
	private String prefAgeMin;
	@Column
	private String prefAgeMax;
	@Column
	private String prefReligion;
	@Column
	private String additionalPref;


	//Image
	private String profilePhoto; 
	
	 @Transient
	 private MultipartFile profilePhotoFile;

	 
	 public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public MultipartFile getProfilePhotoFile() {
		return profilePhotoFile;
	}

	public void setProfilePhotoFile(MultipartFile profilePhotoFile) {
		this.profilePhotoFile = profilePhotoFile;
	}
	

	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getGotra() {
		return gotra;
	}

	public void setGotra(String gotra) {
		this.gotra = gotra;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getFatherDetails() {
		return fatherDetails;
	}

	public void setFatherDetails(String fatherDetails) {
		this.fatherDetails = fatherDetails;
	}

	public String getMotherDetails() {
		return motherDetails;
	}

	public void setMotherDetails(String motherDetails) {
		this.motherDetails = motherDetails;
	}

	public String getSiblings() {
		return siblings;
	}

	public void setSiblings(String siblings) {
		this.siblings = siblings;
	}

	public String getFamilyType() {
		return familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrefAgeMin() {
		return prefAgeMin;
	}

	public void setPrefAgeMin(String prefAgeMin) {
		this.prefAgeMin = prefAgeMin;
	}

	public String getPrefAgeMax() {
		return prefAgeMax;
	}

	public void setPrefAgeMax(String prefAgeMax) {
		this.prefAgeMax = prefAgeMax;
	}

	public String getPrefReligion() {
		return prefReligion;
	}

	public void setPrefReligion(String prefReligion) {
		this.prefReligion = prefReligion;
	}

	public String getAdditionalPref() {
		return additionalPref;
	}

	public void setAdditionalPref(String additionalPref) {
		this.additionalPref = additionalPref;
	}

	@Transient
	public int getAge() {
	    if (dob == null) {
	        return 0;
	    }
	    java.time.LocalDate birthDate = dob.toInstant()
	            .atZone(java.time.ZoneId.systemDefault())
	            .toLocalDate();
	    return java.time.Period.between(birthDate, java.time.LocalDate.now()).getYears();
	}
	
	


	
	
	


}
