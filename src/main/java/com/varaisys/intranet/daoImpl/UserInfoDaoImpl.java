package com.varaisys.intranet.daoImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.UserInfo;

@Repository
public class UserInfoDaoImpl extends AbstractDao<Long, UserInfo> implements UserInfoDao {

	private boolean flag = false;

	@Override
	public boolean saveUser(UserInfo userInfo) {
		persist(userInfo);
		flag = true;
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getAllUser() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

	@Override
	public UserInfo getUserById(Long id) {
		UserInfo userInfo = getByKey(id);
		return userInfo;
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public UserInfo userByCriteria(String userName, String role, String emoloyeeName, String status, String userEmail,
			String token) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("employeeName", emoloyeeName));
		criteria.add(Restrictions.eqOrIsNull("status", status));
		criteria.add(Restrictions.eq("userEmail", userEmail));
		
		criteria.add(Restrictions.eqOrIsNull("token", token));
		UserInfo userInfo = (UserInfo) criteria.uniqueResult();
		System.out.println("here is the userEmail "+  userInfo.getUserEmail());
		return userInfo;
	}
	
	
	@Override
	public UserInfo getEmpName(String id) {
//		UserInfo userInfo = getByKey(id);
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("employeeId", id));
		UserInfo userInfo = (UserInfo) criteria.uniqueResult();
		userInfo.getEmployeeName();
		
		return userInfo;
	}
	@Override
	public UserInfo getEmpId(Long id) {
			UserInfo userInfo = getByKey(id);
			if(userInfo!=null) {
			userInfo.getEmployeeId();
			return userInfo;
			}else {
				return null;
			}
			
		
		
	}
	@Override
	public UserInfo getNameByEmpCode(String empId) {
		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("employeeId", empId));
		 UserInfo userInfo = (UserInfo) criteria.uniqueResult();
		 System.out.println(userInfo.getEmployeeName());
		 userInfo.getEmployeeName();
		return userInfo;
	}

	@Override
	public List<UserInfo> getEmpName() {
		Criteria criteria = createEntityCriteria();
//		ProjectionList columns = Projections.projectionList()
//		        .add(Projections.property("employeeName"));
//		 criteria.setProjection(columns);
		return criteria.list();
	}
  
	
	

}
