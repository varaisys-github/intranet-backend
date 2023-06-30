package com.varaisys.intranet.service;

import java.util.List;

import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.utils.MyLeavePaylod;

public interface MyLeaveService {
	public List<?> myLeaveById(String id);
	public List<ApplyLeave> getMyLeave( Long userId,MyLeavePaylod myLeavePaylod);

	
	
	
}
