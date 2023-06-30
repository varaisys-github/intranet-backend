package com.varaisys.intranet.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.MyLeaveDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserDetail;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.ApplyLeaveForm;
import com.varaisys.intranet.utils.MyLeavePaylod;
@Repository
public class MyLeaveDaoImp extends AbstractDao<Long ,ApplyLeave> implements MyLeaveDao{
	
	@Autowired
	UserInfoDao userInfoDao;
	
//	@Override
//	public List<> myLeaveById(Long userId) {
//		ApplyLeave applyLeave = getByKey(userId);
//		return applyLeave;
//	
//	}

	@Override
	     public List<ApplyLeave> getMyLeave( Long userId ,MyLeavePaylod myLeavePaylod) {
		    Criteria criteria = createEntityCriteria();
		    criteria.add(Restrictions.eq("userId", userId));
		   
		    criteria.add(Restrictions.between("fromDate", myLeavePaylod.getFromDate(),myLeavePaylod.getToDate()))
		  
		   .add(Restrictions.eq("leaveType", myLeavePaylod.getLeaveType()))
		   .add(Restrictions.eq("status",myLeavePaylod.getStatus() ));
			
			System.out.println("Dao imp query");

			return criteria.list();
	
	}
	

//	@Override
//	public List getUserName(Long user_id) {
//		
//		Criteria criteria = createEntityCriteria();
//		criteria.add(Restrictions.eq("user_id", user_id));
//		  Projection projection = Projections.property("employeeName"); 
//		
//		 criteria.setProjection(projection); 
//		 ProjectionList pList = Projections.projectionList(); 
//		  pList.add(projection); 
//		    criteria.setProjection(pList); 
//		List result = criteria.list();
//		return result;
//	}

	@Override
	public List<?> myLeaveById(String id) {
		
		    Criteria criteria = createEntityCriteria();
//		    UserInfo userInfo=userInfoDao.getEmpId(id);
//			   String employeeId=userInfo.getEmployeeId();
		    criteria.add(Restrictions.eq("employeeId",id));
		    
		   
		List result = criteria.list();
		    
		return result;
	}

	@Override
	public void getLeaveBal(Long userId) {
		ApplyLeave applyLeave = getByKey(userId);
//		applyLeave.setLeave_Balance_Days(0);
		
		
		
	}


	@Override
	public void delectMyLeave(Long userId) {
		// TODO Auto-generated method stub
		
		
	}


	

}
