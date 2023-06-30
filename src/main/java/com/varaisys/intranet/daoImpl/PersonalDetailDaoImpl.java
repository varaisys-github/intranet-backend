package com.varaisys.intranet.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.PersonalDetailsDao;
import com.varaisys.intranet.model.MyInfoFileupload;
import com.varaisys.intranet.model.PersonalDetails;
import com.varaisys.intranet.model.UserInfo;

/**
 * 
 * @author Babli Singh
 * @Created on 20/jan/2023
 * @Created on 20-jan-2023
 */
@Repository
public class PersonalDetailDaoImpl extends AbstractDao<Integer , PersonalDetails> implements PersonalDetailsDao {

	@Override
	public void saveUser(PersonalDetails detail) {
	persist(detail);
		
	}

	@Override
	public List<PersonalDetails> getAllUser() {
		
		return createEntityCriteria().list();
		
	}



	@Override
	public PersonalDetails getUserById(int id) {
		PersonalDetails personalDetails = getByKey(id);
		return personalDetails;
	}

	@Override
	public void deleteUserById(int id) {
		PersonalDetails personalDetails = getByKey(id);
		delete(personalDetails);
		
	}
	;

	

}
