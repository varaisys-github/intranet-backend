package com.varaisys.intranet.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.PasswordResetDao;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.EmailDetails;



/**
 * @Author Babli Singh
 * @CreationDate - 7-02-2023
 * @ModifyDate - 7-02-2023
 * @Desc
 */
@Repository("PasswordResetDao")
public class PassWordResetDaoImpl extends AbstractDao<Integer, UserInfo> implements PasswordResetDao {

	@Override
	public UserInfo matchByMail(String email) {
		//System.out.println(email.getRecipient() + "----------------------");
		UserInfo userInfo =new UserInfo();
		try {
			
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("userEmail", email));
			System.out.println(email);
			 userInfo = (UserInfo) criteria.uniqueResult();
			System.out.println("here is the username " + userInfo.getUserName());
			System.out.println("here is the user password " + userInfo.getPassword());
			System.out.println("here is the user email " + userInfo.getUserEmail());
			System.out.println("here is the user token " + userInfo.getToken()); 
			 
		} catch (Exception e) {
			System.out.println("error"  +e);
		}
		
		return userInfo;
	}

}
