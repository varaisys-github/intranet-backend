package com.varaisys.intranet.service;

import java.util.List;

import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.utils.EntitlementForm;

public interface EntitlementServices {
	public boolean saveEnt(EntitlementForm entForm);
	public List<AddEntitlement> getAllEnt();
	public float getSickLeaveBal(String id) ;
	public  float getCalusalLeaveBal(String id );
	public  float getEarnLeaveBal(String id );
	public List<AddEntitlement> getMyLeaveBal(String UserId);

	public void updateLeaveBal(String empcode,Long id);
	public boolean updateEnt(Long id,EntitlementForm entitlementForm);
}	
