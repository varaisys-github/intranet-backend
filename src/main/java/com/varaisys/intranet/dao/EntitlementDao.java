package com.varaisys.intranet.dao;

import java.util.List;

import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.utils.ApplyLeaveForm;
import com.varaisys.intranet.utils.EntitlementForm;


public interface EntitlementDao {
	public boolean saveEnt( AddEntitlement addEnt);
	public List<AddEntitlement> getAllEnt();
	public List<AddEntitlement> getMyLeaveBal(String UserId);
	public  float getSickLeaveBal(String id);
	public  float getCalusalLeaveBal(String  id );
	public  float getEarnLeaveBal(String id );
	public void updateLeaveBal(String empcode ,Long leaveId);
	public AddEntitlement getMyEnt(Long id);
	public boolean updateEnt(Long id,EntitlementForm addEnt);
	
	
}
