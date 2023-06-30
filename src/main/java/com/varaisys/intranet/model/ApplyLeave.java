package com.varaisys.intranet.model;
import java.time.LocalDateTime;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @Author Madhu Kumari
 * @CreationDate - 17-01-2023
 * @Desc -  ApplyLeave Entity to store data in database
 */
@Entity
@Table(name="leave_details")
//@Table(name="leave_deatils_madhu")
public class ApplyLeave{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="leave_type")
private String leaveType;
@Column(name="leave_start_date")
// private Date fromDate;
private String fromDate;
@Column(name="leave_end_date")
// private Date toDate;
private String toDate;
@Column(name="full_half")
 private String full_half;
@Column(name="manager_approval")
private String manager_approval;
@Column(name="hr_approval")
 private String hr_approval;
@Column(name="comments")
private String comment;
@Column(name="status")
private String status;
@Column(name="created_on")
private LocalDateTime created_on;
@Column(name="modified_on")
private  LocalDateTime modified_on;

//@Column(name="available_call")
// private String  availableCall;
//@Column(name="emergency_number")
// private String emergencyNumber;
@Column(name="emp_code")

 private String employeeId;
@Column(name="employee_name")
private String employeeName;
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
@Column(name="no_of_Days")

 private String no_of_Days;
public String getNo_of_Days() {
	return no_of_Days;
}
public void setNo_of_Days(String no_of_Days) {
	this.no_of_Days = no_of_Days;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLeaveType() {
	return leaveType;
}
public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
}
@Column(name="leave_balance")
private float leave_Balance_Days;
public float getLeave_Balance_Days() {
	return leave_Balance_Days;
}
public void setLeave_Balance_Days(float leave_Balance_Days) {
	this.leave_Balance_Days = leave_Balance_Days;
}
//public Date getFromDate() {
//	return fromDate;
//}
//public void setFormDate(Date formDate) {
//	this.fromDate = formDate;
//}
//public Date getToDate() {
//	return toDate;
//}
//public void setToDate(Date toDate) {
//	this.toDate = toDate;
//}
public String getFull_half() {
	return full_half;
}
public void setFull_half(String full_half) {
	this.full_half = full_half;
}
public String getManager_approval() {
	return manager_approval;
}
public void setManager_approval(String manager_approval) {
	this.manager_approval = manager_approval;
}
public String getHr_approval() {
	return hr_approval;
}
public void setHr_approval(String hr_approval) {
	this.hr_approval = hr_approval;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public LocalDateTime getCreated_on() {
	return created_on;
}
public void setCreated_on(LocalDateTime created_on) {
	this.created_on = created_on;
}
public LocalDateTime getModified_on() {
	return modified_on;
}
public void setModified_on(LocalDateTime modified_on) {
	this.modified_on = modified_on;
}

public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}
public void setToDate(String toDate) {
	this.toDate = toDate;
}
public String getFromDate() {
	return fromDate;
}
public String getToDate() {
	return toDate;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
//public String getAvailableCall() {
//	return availableCall;
//}
//public void setAvailableCall(String availableCall) {
//	this.availableCall = availableCall;
//}
//public String getEmergencyNumber() {
//	return emergencyNumber;
//}
//public void setEmergencyNumber(String emergencyNumber) {
//	this.emergencyNumber = emergencyNumber;
//}

/**
 * @Author Madhu Kumari
 * @CreationDate - 17-01-2023
 * @Desc - Entity mapping 
 */




}







