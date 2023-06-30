package com.varaisys.intranet.globalExceptionHandling;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	@Override
	public String toString() {
		return "ErrorResponse [timeStamp=" + timeStamp + ", fieldErrors=" + fieldErrors + ", message=" + message + "]";
	}
	private LocalDateTime timeStamp;
	
	private List<String> fieldErrors =new ArrayList<>();
	
	public ErrorResponse(LocalDateTime timeStamp, String message,List<String> string) {
		super();
		this.timeStamp = timeStamp;
		this.fieldErrors = string;
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public List<String> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	

}
