package com.varaisys.intranet.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Sachin Kashyap
 * @Created on 07/nov/2022
 * @Created on 14-nov-2022
 */
@Entity
@Table(name = "user_mst")
public class UserInfo implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private Long userId;
@Column(name="user_name")
private String userName;
@Column(name="user_password")
private String password;
@Column(name="employee_name")
private String employeeName;
@Column(name="user_role")
private String role;
@Column(name="employee_status")
private String status="Enabled";
@Column(name="crt_date")
private LocalDateTime createdDate;
@Column(name="mod_date")
private LocalDateTime modifyDate;
@Column(name="deleted_date")
private LocalDateTime deletedDate;
@Column(name="emp_code")
private String employeeId;
@Column(name="user_email")
private String userEmail;
@Column(name="token")
private String token;
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public LocalDateTime getDeletedDate() {
	return deletedDate;
}
public void setDeletedDate(LocalDateTime deletedDate) {
	this.deletedDate = deletedDate;
}
public UserInfo(){
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
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public LocalDateTime getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDateTime createdDate) {
	this.createdDate = createdDate;
}
public LocalDateTime getModifyDate() {
	return modifyDate;
}
public void setModifyDate(LocalDateTime modifyDate) {
	this.modifyDate = modifyDate;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeCode(String employeeCode) {
	this.employeeId = employeeId;
}
}
