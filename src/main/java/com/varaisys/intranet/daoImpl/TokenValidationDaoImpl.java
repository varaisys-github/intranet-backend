package com.varaisys.intranet.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.TokenValidationDao;
import com.varaisys.intranet.model.UserInfo;

/**
 * @Author Babli Singh
 * @CreationDate - 13-02-2023
 * @ModifyDate - 13-02-2023
 * @Desc
 */

@Repository("TokenValidationDao")
public class TokenValidationDaoImpl  extends AbstractDao<Integer, UserInfo> implements TokenValidationDao{

	@Override
	public UserInfo matchByToken(String token) {
		
		
		
		UserInfo userInfo =null;
		try {
			
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("token", token));
			 userInfo = (UserInfo) criteria.uniqueResult();
			 System.out.println("dao token "+ token+ userInfo );
			 if(userInfo!=null) {
			 return userInfo;
			 }
			 
			 
		} catch (Exception e) {
			System.out.println("error"  +e);
		}
		return userInfo;
	}
	
	
	
	

}
