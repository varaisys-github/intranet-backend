package com.varaisys.intranet.utils;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
/**
 * @Author Madhu Kumari
 * @CreationDate - 17-01-2023
 * @Desc - paylod class
 */
public class ApplyLeaveForm {
		 private Long id;
		 @NotBlank(message = "Leave_Type is mandatory")
		 private String leaveType;
		 @NotBlank(message = "From Date is mandatory")
	     private String fromDate;
		 @NotBlank(message = "ToDate is mandatory")
	     private String toDate;
		 private String full_half;
		 private String manager_approval;
		 private String hr_approval;
		 private String comment;
		 private String status;
		 private LocalDateTime created_on;
		 private LocalDateTime modified_on;
		 private String employeeName;
		 private String employeeId;
//		 private String  availableCall;
		
//		  public String getAvailableCall() {
//			return availableCall;
//		}
//		public void setAvailableCall(String availableCall) {
//			this.availableCall = availableCall;
//		}
		public String getEmergencyNumber() {
			return emergencyNumber;
		}
		public void setEmergencyNumber(String emergencyNumber) {
			this.emergencyNumber = emergencyNumber;
		}
		private String emergencyNumber;
		 public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String name) {
			this.employeeName = employeeName;
		}
		private float leave_Balance_Days;
		 public float getLeave_Balance_Days() {
		 	return leave_Balance_Days;
		 }
		 public void setLeave_Balance_Days(float leave_Balance_Days) {
		 	this.leave_Balance_Days = leave_Balance_Days;
		 }
		
		
		 public String getNo_of_Days() {
			return no_of_Days;
		}
		public void setNo_of_Days(String no_of_Days) {
			this.no_of_Days = no_of_Days;
		}
		private String no_of_Days;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
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
		
		public String getLeaveType() {
			return leaveType;
		}
		public void setLeaveType(String leaveType) {
			this.leaveType = leaveType;
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
}
