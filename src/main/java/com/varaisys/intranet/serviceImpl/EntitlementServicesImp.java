package com.varaisys.intranet.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.EntitlementDao;
import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.service.EntitlementServices;
import com.varaisys.intranet.utils.EntitlementForm;

@Service()
@Transactional("mydb")
public class EntitlementServicesImp  implements EntitlementServices{
@Autowired
EntitlementDao entitlementDao;

	private boolean checkSaveEnt=false;
	@Override
	public boolean saveEnt(EntitlementForm entForm) {
		AddEntitlement addEnt = new AddEntitlement();
		addEnt.setEmployeeName(entForm.getEmployeeName());
		addEnt.setEmployeeId(entForm.getEmployeeId());
		addEnt.setFromDate(entForm.getFromDate());
		addEnt.setToDate(entForm.getToDate());
	
		addEnt.setSickLeave(entForm.getSickLeave());
		addEnt.setEarnLeave(entForm.getEarnLeave());
		addEnt.setCausalLeave(entForm.getCausalLeave());
		checkSaveEnt=entitlementDao.saveEnt(addEnt)
;		 
		return checkSaveEnt;
		
	
	}
	@Override
	public List<AddEntitlement> getAllEnt() {
	
		return entitlementDao.getAllEnt();
	}
	

	@Override
	public float getSickLeaveBal(String id) {
		System.out.println("sickLeave Bal Ent method");
		return entitlementDao.getSickLeaveBal(id);
		
	}
	@Override
	public float getCalusalLeaveBal(String  id) {
		
		 return entitlementDao.getCalusalLeaveBal(id);
	}
	@Override
	public float getEarnLeaveBal(String  id) {
	
		return entitlementDao.getEarnLeaveBal(id);
	}
	@Override
	public List<AddEntitlement> getMyLeaveBal(String id) {
		
		return entitlementDao.getMyLeaveBal(id);
	}
	
	public void updateLeaveBal(String empcode,Long leaveId) {
		System.out.println("updated in services  method");
		entitlementDao.updateLeaveBal(empcode,leaveId);
	}
	public AddEntitlement getMyEnt(Long id) {
		
		return entitlementDao.getMyEnt( id);
	}
	
	@Override
	public boolean updateEnt(Long id, EntitlementForm entitlementForm) {
	entitlementDao.updateEnt(id, entitlementForm);
		return true;
	}
	
}
