package com.varaisys.intranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Babli Singh
 * @Created on 20/jan/2023
 * @Created on 20-jan-2023
 */
@Entity
@Table(name = "Personal_details")
public class PersonalDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int employeeId;

	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "middle_Name")
	private String middleName;
	@Column(name = "last_Name")
	private String lastName;
	@Column(name = "nick_Name")
	private String nickName;
	@Column(name = "other_Id")
	private int otherId;
	@Column(name = "DL_Number")
	private String DLNumber;
	@Column(name = "license_ExpDate")
	private String licenseExpDate;
	@Column(name = "Country")
	private String Country;
	@Column(name = "marital_Status")
	private String maritalStatus;
	@Column(name = "dob")
	
	private String dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "adhar_Number")
	private String adharNumber;
	@Column(name = "pan_Number")
	private String panNumber;
	@Column(name = "militaryService")
	private String militaryService;
	@Column(name = "blood_Group")
	private String bloodGroup;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public long getOtherId() {
		return otherId;
	}

	public void setOtherId(int otherId) {
		this.otherId = otherId;
	}

	public String getDLNumber() {
		return DLNumber;
	}

	public void setDLNumber(String dLNumber) {
		DLNumber = dLNumber;
	}

	public String getLicenseExpDate() {
		return licenseExpDate;
	}

	public void setLicenseExpDate(String licenseExpDate) {
		this.licenseExpDate = licenseExpDate;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getMilitaryService() {
		return militaryService;
	}

	public void setMilitaryService(String militaryService) {
		this.militaryService = militaryService;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public PersonalDetails() {
		super();
	}

}
