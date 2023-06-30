package com.varaisys.intranet.dao;

import java.util.List;

import com.varaisys.intranet.model.PersonalDetails;

/**
 * 
 * @author Babli Singh
 * @Created on 20/jan/2023
 * @Created on 20-jan-2023
 */

public interface PersonalDetailsDao {
	public  void saveUser(PersonalDetails detail);

	public List<PersonalDetails> getAllUser();

	public PersonalDetails getUserById(int employeeId );

	public void deleteUserById(int id);

}
