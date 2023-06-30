package com.varaisys.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @Author Madhu Kumari
 * @CreationDate - 07-02-2023
 * 
 */
@Entity
@Table(name="entitlement_details")
public class AddEntitlement {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Long id;
@Column(name="employee_name")
private String employeeName;
@Column(name="emp_code")
private String employeeId;
@Column(name="from_date")
private String  fromDate;
@Column(name="to_date")
private  String toDate; 
@Column(name="causal_leave")
private float causalLeave;
@Column(name="sick_leave")
private float sickLeave;
@Column(name="earn_leave")
private float earnLeave;
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getFromDate() {
	return fromDate;
}
public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}
public String getToDate() {
	return toDate;
}
public void setToDate(String toDate) {
	this.toDate = toDate;
}
public float getCausalLeave() {
	return causalLeave;
}
public void setCausalLeave(float causalLeave) {
	this.causalLeave = causalLeave;
}
public float getSickLeave() {
	return sickLeave;
}
public void setSickLeave(float sickLeave) {
	this.sickLeave = sickLeave;
}
public float getEarnLeave() {
	return earnLeave;
}
public void setEarnLeave(float earnLeave) {
	this.earnLeave = earnLeave;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
	
	
}
