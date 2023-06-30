package com.varaisys.intranet.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.PersonalDetailsDao;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import com.varaisys.intranet.model.PersonalDetails;
import com.varaisys.intranet.service.PersonalDetailService;
import com.varaisys.intranet.utils.PersonalDetailForm;

/**
 * 
 * @author Babli Singh
 * @Created on 20/jan/2023
 * @Created on 20-jan-2023
 */

@Service()
@Transactional("mydb")
public class PersonalDetailServiceImpl implements PersonalDetailService  {
	private boolean flag = false;
	@Autowired
	PersonalDetailsDao personalDetailsDao;

	@Override
	public boolean addPerson(PersonalDetailForm personalDetailform) throws PersonNotFoundException{
		PersonalDetails personalDetails = new PersonalDetails();
		// d.setEmployeeId(detail.getEmployeeId());
		personalDetails.setFirstName(personalDetailform.getFirstName());
		personalDetails.setMiddleName(personalDetailform.getMiddleName());
		personalDetails.setLastName(personalDetailform.getLastName());
		personalDetails.setNickName(personalDetailform.getNickName());
		personalDetails.setOtherId(personalDetailform.getOtherId());
		personalDetails.setDLNumber(personalDetailform.getDLNumber());
		personalDetails.setLicenseExpDate(personalDetailform.getLicenseExpDate());
		personalDetails.setCountry(personalDetailform.getCountry());
		personalDetails.setMaritalStatus(personalDetailform.getMaritalStatus());
		personalDetails.setDob(personalDetailform.getDob());
		personalDetails.setGender(personalDetailform.getGender());
		personalDetails.setAdharNumber(personalDetailform.getAdharNumber());
		personalDetails.setPanNumber(personalDetailform.getPanNumber());
		personalDetails.setMilitaryService(personalDetailform.getMilitaryService());
		personalDetails.setBloodGroup(personalDetailform.getBloodGroup());
		personalDetailsDao.saveUser(personalDetails);
		System.out.println("DEtails : " + flag + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		return flag;
	}

	@Override
	public PersonalDetails getPersonalDetail(int employeeId) {
		PersonalDetails personalDetails = personalDetailsDao.getUserById(employeeId);
		return personalDetails;
	}

	@Override
	public void deletePerson(int employeeId) {

		personalDetailsDao.deleteUserById(employeeId);

	}

	@Override
	public List<PersonalDetails> getPersonalDetails() {

		return personalDetailsDao.getAllUser();
	}

//	@Override
//	public boolean updateDetails(PersonalDetailForm personalDetailform) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean updateDetails(PersonalDetailForm personalDetailform) {
		boolean fla = false;
		PersonalDetails personalDetails = personalDetailsDao.getUserById(personalDetailform.getEmployeeId());
		if (personalDetails != null) {
			personalDetails.setEmployeeId(personalDetailform.getEmployeeId());
			personalDetails.setFirstName(personalDetailform.getFirstName());
			personalDetails.setMiddleName(personalDetailform.getMiddleName());
			personalDetails.setLastName(personalDetailform.getLastName());
			personalDetails.setNickName(personalDetailform.getNickName());
			personalDetails.setOtherId(personalDetailform.getOtherId());
			personalDetails.setDLNumber(personalDetailform.getDLNumber());
			personalDetails.setLicenseExpDate(personalDetailform.getLicenseExpDate());
			personalDetails.setCountry(personalDetailform.getCountry());
			personalDetails.setMaritalStatus(personalDetailform.getMaritalStatus());
			personalDetails.setDob(personalDetailform.getDob());
			personalDetails.setGender(personalDetailform.getGender());
			personalDetails.setAdharNumber(personalDetailform.getAdharNumber());
			personalDetails.setPanNumber(personalDetailform.getPanNumber());
			personalDetails.setMilitaryService(personalDetailform.getMilitaryService());
			personalDetails.setBloodGroup(personalDetailform.getBloodGroup());
			personalDetailsDao.saveUser(personalDetails);
			flag = true;
		}
		return fla;
	}

}
