package com.varaisys.intranet.utils;

import java.util.Date;
import java.util.List;

public class MyLeavePaylod {
private String fromDate;
private String toDate;
private String leaveType;
private String status;
private float leave_Balance_Days;
public float getLeave_Balance_Days() {
	return leave_Balance_Days;
}
public void setLeave_Balance_Days(float leave_Balance_Days) {
	this.leave_Balance_Days = leave_Balance_Days;
}
public float getNumber_of_Days() {
	return number_of_Days;
}
public void setNumber_of_Days(float number_of_Days) {
	this.number_of_Days = number_of_Days;
}
private float number_of_Days;
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
public String getLeaveType() {
	return leaveType;
}
public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
