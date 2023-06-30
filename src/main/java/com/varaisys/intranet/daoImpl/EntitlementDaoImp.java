package com.varaisys.intranet.daoImpl;

import java.util.List;


import org.apache.commons.math3.analysis.function.Add;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.ApplyLeaveDao;
import com.varaisys.intranet.dao.EntitlementDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.serviceImpl.UserServiceImpl;
import com.varaisys.intranet.utils.ApplyLeaveForm;
import com.varaisys.intranet.utils.EntitlementForm;

@Repository
public class EntitlementDaoImp extends AbstractDao<Long,AddEntitlement> implements EntitlementDao{
 @Autowired ApplyLeaveDao applyLeavedao;
 @Autowired UserInfoDao userInfoDao;
	@Override
	public boolean saveEnt(AddEntitlement addEnt) {
		persist(addEnt);
		return true;
	
	}
	
	@Override
	public List<AddEntitlement> getAllEnt() {
		
		Criteria criteria = createEntityCriteria();
		return criteria.list();
		
	}

	@Override
	public float getSickLeaveBal(String id) {
		try {
			
		
		Criteria criteria = createEntityCriteria();
//		   UserInfo userInfo=userInfoDao.getEmpId(id);
//		   String employeeId=userInfo.getEmployeeId();
		 criteria.add(Restrictions.eq("employeeId", id));
		
		 AddEntitlement addEnt = (AddEntitlement) criteria.uniqueResult();
		    float add =addEnt.getSickLeave();
	   
			  
	    return add;
		} catch (Exception e) {
		
		e.printStackTrace();
		return 0;
		}
		
		
	}

	@Override
	public float getCalusalLeaveBal(String id) {
		
		
//			   UserInfo userInfo=userInfoDao.getEmpId(id);
//			   if(userInfo!=null) {
//			   String employeeId=userInfo.getEmployeeId();
			Criteria criteria = createEntityCriteria();
			 criteria.add(Restrictions.eq("employeeId",id));
			
			 AddEntitlement addEnt = (AddEntitlement) criteria.uniqueResult();
			 if(addEnt.getCausalLeave()!=0) {
			    float add =addEnt.getCausalLeave();
		   
		    return add;
			   }
			   else {
				   return 0;
			   }
			}
	
	

	@Override
	public float getEarnLeaveBal(String id) {
		try {
			
//			UserInfo userInfo=userInfoDao.getEmpId(id);
//			   String employeeId=userInfo.getEmployeeId();
			Criteria criteria = createEntityCriteria();
			 criteria.add(Restrictions.eq("employeeId",id));
			
			
			 AddEntitlement addEnt = (AddEntitlement) criteria.uniqueResult();
			    float add =addEnt.getEarnLeave();
		   
				  
		    return add;
			} catch (Exception e) {
			e.printStackTrace();
			return 0;
			}
	
		
	}

	@Override
	public List<AddEntitlement> getMyLeaveBal(String id) {
//		  UserInfo userInfo=userInfoDao.getEmpId(id);
//		  String employeeId=userInfo.getEmployeeId();
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("employeeId", id));
		
		return criteria.list();
		
	
	}
     
	@Override
	public void updateLeaveBal(String empcode ,Long leaveId) {
		
		float leaveBal;
		 String noOfDays=applyLeavedao.getNoOfDays(leaveId);
		 System.out.println("no_of days"+noOfDays);
		 System.out.println("hellp ");
		 float noOfDayaFloat=Float.parseFloat(noOfDays);  
//		 AddEntitlement addEnt = getByKey();
		 Criteria criteria = createEntityCriteria();
		 System.out.println("Employee id in update method");
			criteria.add(Restrictions.eq("employeeId", empcode));
			 AddEntitlement addEnt = ( AddEntitlement)criteria.uniqueResult();
		 String leaveType=applyLeavedao.getLeaveType(leaveId);
		 if(leaveType.equalsIgnoreCase("Casual Leave")){
		 leaveBal= addEnt.getCausalLeave()-noOfDayaFloat;
		 float x =  (leaveBal>=0)?leaveBal:0; 
		 addEnt.setCausalLeave(x);
		 
		
		 
		 }
		 else if(leaveType.equalsIgnoreCase("Sick Leave")){
			 leaveBal= addEnt.getSickLeave()-noOfDayaFloat;
			 
			 float x =  (leaveBal>=0)?leaveBal:0; 
	
			 
			 addEnt.setSickLeave(x);
		 }
			
		 else if(leaveType.equalsIgnoreCase("Earned Leave"))
		 {
			 leaveBal= addEnt.getEarnLeave()-noOfDayaFloat;
			 float x =  (leaveBal>=0)?leaveBal:0; 
				
			 addEnt.setEarnLeave(x);
			 }
		 else {
			leaveBal=0;
		}
		persist(addEnt);
	}

	@Override
	public AddEntitlement getMyEnt(Long id) {
		 AddEntitlement ent=getByKey(id);
		return ent;
	}

	@Override
	public boolean updateEnt(Long id,EntitlementForm entitlementForm) {
		
		 AddEntitlement addEntitlement=getByKey(id);
		 System.out.println("message add ent");
		 System.out.println(addEntitlement);
		 System.out.println("leave"+(addEntitlement.getCausalLeave()));
		 System.out.println("new Form"+entitlementForm.getCausalLeave());
		 System.out.println(addEntitlement.getCausalLeave()+entitlementForm.getCausalLeave());
		 addEntitlement.setCausalLeave(addEntitlement.getCausalLeave()+entitlementForm.getCausalLeave());
		
		 addEntitlement.setSickLeave(addEntitlement.getSickLeave()+entitlementForm.getSickLeave());
		 addEntitlement.setEarnLeave(addEntitlement.getEarnLeave()+entitlementForm.getEarnLeave());
		 addEntitlement.setToDate(entitlementForm.getToDate());
		 
		 System.out.println("AllLeave ......>>>>>>>>>>>>>>>>__________________");
//			 addEntitlement.setCausalLeave(entitlementForm.getCausalLeave());
//				
//				 addEntitlement.setSickLeave(entitlementForm.getSickLeave());
//				 addEntitlement.setEarnLeave(entitlementForm.getEarnLeave());
		 System.out.println("message persist data");
		persist(addEntitlement);
		return true;
	}


	

	

}
