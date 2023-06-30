package com.varaisys.intranet.service;

import java.util.List;

import com.varaisys.intranet.model.PersonalDetails;
import com.varaisys.intranet.utils.PersonalDetailForm;


/**
 * 
 * @author Babli Singh
 * @Created on 20/jan/2023
 * @Created on 20-jan-2023
 */


public interface PersonalDetailService {
	public List<PersonalDetails> getPersonalDetails();
	
	public PersonalDetails getPersonalDetail(int employeeId);
	
	
	public boolean addPerson(PersonalDetailForm personalDetailform);
	
	
	public boolean updateDetails(PersonalDetailForm personalDetailform);
	
	
	public void deletePerson(int employeeId);

}
