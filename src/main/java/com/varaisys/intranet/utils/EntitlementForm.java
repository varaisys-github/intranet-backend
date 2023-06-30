package com.varaisys.intranet.utils;



public class EntitlementForm {

	private Long id;
	
	private String employeeName;

	private String employeeId;
	
	private String  fromDate;
	
	private  String toDate; 
	private float causalLeave;
	
	private float sickLeave;
	
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
