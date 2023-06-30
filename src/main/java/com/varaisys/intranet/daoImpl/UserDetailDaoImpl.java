package com.varaisys.intranet.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.UserDetailDao;
import com.varaisys.intranet.model.UserDetail;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @ModifyDate - 09-11-2022
 * @Desc
 */
@Repository("userDetailDao")
public class UserDetailDaoImpl extends AbstractDao<Integer, UserDetail> implements UserDetailDao {

	@Override
	public UserDetail loadUserbyUserName(String userName) {
		System.out.println("UserDetailDaoImpl" + userName);
		UserDetail userDetail=null;
		try
		{
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("user_name", userName));
		userDetail = (UserDetail) criteria.uniqueResult();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(userDetail.getUser_name());
		System.out.println("username==> " + userDetail.getUser_name());
		}
		catch (Exception e) {
			
			// TODO: handle exception
		}
		return userDetail;
	}

}
