package com.varaisys.intranet.daoImpl;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.ApplyLeaveDao;
import com.varaisys.intranet.dao.EntitlementDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.ApplyLeaveForm;
@Repository
public class ApplyLeaveDaoImp extends AbstractDao<Long,ApplyLeave> implements ApplyLeaveDao{
	@Autowired
	UserInfoDao userInfoDao;
	@Override
	public boolean saveApplyLeave(ApplyLeave applyLeave) {
		System.out.println("leave Applied");
		System.out.println(applyLeave);
		System.out.println(applyLeave.getLeaveType());
		persist(applyLeave);
		return true;
	}
	@Override
	public List<ApplyLeave> getAllAppliedLeave() {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("status", "Applied"));
	
	
		return criteria.list();
	}

	@Override
	public List<ApplyLeave> getAllLeave() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		return criteria.list();
		
	}
	
//	@Override
//	public List<ApplyLeave> getAllApplyLeave() {
//		Criteria criteria = createEntityCriteria();
//		criteria.setFetchMode("userInfo", FetchMode.JOIN);
//		criteria.createAlias("userInfo", "user");
//
//		ProjectionList columns = Projections.projectionList()
//				        .add(Projections.property("user.employeeName"))
//						.add(Projections.property("fromDate"))
//						.add(Projections.property("toDate"))
//						.add(Projections.property("leaveType"))
//		                .add(Projections.property("status"));
//		                
//		                criteria.setProjection(columns);
//
//		List<ApplyLeave> applyLeave = criteria.list();
//	
//	
//		return applyLeave;
//	
//	
//	}

	
	
	
//	public List getUserName( Long user_id) {
////		Criteria criteria = createEntityCriteria();
////		  Projection projection = Projections.property("employeeName"); 
////		criteria.add(Restrictions.eq("user_id", user_id));
////		 criteria.setProjection(projection); 
////		List result = criteria.list();
////		return result;
//		return null;
//				
//		}

//	@Override
//	public List<ApplyLeave> getLeaveByUser(Long userId) {
//		UserInfo userInfo = new UserInfo();
//		System.out.println(userInfo.getUserId());
//		
//		Criteria criteria = createEntityCriteria();
//		
//		criteria.setFetchMode("userInfo", FetchMode.JOIN);
//		criteria.createAlias("userInfo", "user");	
//		criteria.add(Restrictions.eq("user.userId", userId));
//		System.out.println("message");
//		
//		ProjectionList columns = Projections.projectionList()
//				
//				.add(Projections.property("user.employeeName"))
//						.add(Projections.property("fromDate"))
//						.add(Projections.property("toDate"))
//						.add(Projections.property("leaveType"))
//		                .add(Projections.property("status"))
//		  .add(Projections.property("id"))
//		  .add(Projections.property("user.userId"));
//		
//						
//		criteria.setProjection(columns);
//
//		List<ApplyLeave> list = criteria.list();
//	
//		return list;
//
//	}
  
	

	

	




	@Override
	public boolean managerApproved(Long id, ApplyLeave applyLeave) {
		System.out.println("upated Successfully");
		ApplyLeave applyLeave1 = getByKey(id);
		applyLeave1.setManager_approval(applyLeave.getManager_approval());
		persist(applyLeave1);
		System.out.println("upated Successfully");
		return true;
	}

	@Override
	public boolean hrApproved(Long id, ApplyLeave applyLeave) {
	
		System.out.println("upated Successfully");
		ApplyLeave applyLeave1 = getByKey(id);
		applyLeave1.setHr_approval(applyLeave.getHr_approval());
		persist(applyLeave1);
		System.out.println("upated Successfully");
		return true;
		
	}

	@Override
	public boolean FinalApproved(Long id, ApplyLeave applyLeave) {
	
		
		ApplyLeave applyLeave1 = getByKey(id);
		System.out.println(applyLeave.getStatus());
		applyLeave1.setStatus(applyLeave.getStatus());
//		applyLeave1.setLeave_Balance_Days(applyLeave.getLeave_Balance_Days());
		persist(applyLeave1);
		System.out.println("upated Successfully");
		return true;
		
	}
	@Override
	public String getNoOfDays(Long id) 
	{
		Criteria criteria = createEntityCriteria();
		
//		   UserInfo userInfo=userInfoDao.getEmpId(id);
//		   String employeeId=userInfo.getEmployeeId();
		criteria.add(Restrictions.eq("id", id));
		
		ApplyLeave applyLeave = (ApplyLeave) criteria.uniqueResult();
		
		
				
				 String noOfDays= applyLeave.getNo_of_Days();
				 return noOfDays;
	}

	@Override
	public float getLeaveBal(Long id) {
		Criteria criteria = createEntityCriteria();
		
		   UserInfo userInfo=userInfoDao.getEmpId(id);
		   String employeeId=userInfo.getEmployeeId();
		criteria.add(Restrictions.eq("employeeId", employeeId));
		ApplyLeave applyLeave = (ApplyLeave) criteria.uniqueResult();
		
	
		
		return applyLeave.getLeave_Balance_Days();
		
	}

	@Override
	public String getLeaveType(Long id) {
		Criteria criteria = createEntityCriteria();
		
//		   UserInfo userInfo=userInfoDao.getEmpId(id);
//		   String employeeId=userInfo.getEmployeeId();
		criteria.add(Restrictions.eq("id", id));
		ApplyLeave applyLeave = (ApplyLeave) criteria.uniqueResult();
		
		return applyLeave.getLeaveType();
		
	}
	@Override
	public ApplyLeave getmyApplyLeave(Long id) {
		ApplyLeave applyLeave = getByKey(id);
		System.out.println(applyLeave +" applyLeave >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(applyLeave.getEmployeeId());
		return applyLeave;
	
	}
	@Override
	public boolean approve(ApplyLeave applyLeave) {
		
//		applyLeave1.setStatus(applyLeave.getStatus());
//		applyLeave1.setLeave_Balance_Days(applyLeave.getLeave_Balance_Days());
//		persist(applyLeave1);
		persist(applyLeave);
		return true;
	}


	@Override
	public String getEmpCodeByeaveId(Long id) {
		
		ApplyLeave applyLeave= getByKey(id);
		return applyLeave.getEmployeeId();
		
	}
	@Override
	public boolean saveAssignLeave(ApplyLeave applyLeave) {
	
		System.out.println("AssignLeave");
		persist(applyLeave);
		return true;
		
	}
	@Override
	public ApplyLeave getApplyLeaveByLeaveId(Long id) {
	  ApplyLeave applyLeave = getByKey(id);
	  return applyLeave;
		
	}
	

	
	
	
}
