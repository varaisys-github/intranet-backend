package com.varaisys.intranet.serviceImpl;

import org.springframework.stereotype.Service;

import com.varaisys.intranet.model.ContactDetails;
import com.varaisys.intranet.service.ContactDeatilsService;
import com.varaisys.intranet.utils.ContactDetailsForm;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.varaisys.intranet.dao.ContactDetailsDao;
import java.util.List;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 1/feb/2023
 */
@Service()
@Transactional("mydb")
public class ContactDetailsServiceImpl implements ContactDeatilsService {
  private boolean flag = false;
  @Autowired
  ContactDetailsDao contactDetailsDao;

  @Override
  public boolean AddContact(ContactDetailsForm contactDetailsForm) throws PersonNotFoundException {
    ContactDetails contactDetails = new ContactDetails();
    contactDetails.setStreet1(contactDetailsForm.getStreet1());
    contactDetails.setStreet2(contactDetailsForm.getStreet2());
    contactDetails.setCity(contactDetailsForm.getCity());
    contactDetails.setState(contactDetailsForm.getState());
    contactDetails.setZipCode(contactDetailsForm.getZipCode());
    contactDetails.setCountry(contactDetailsForm.getCountry());
    contactDetails.setHome(contactDetailsForm.getHome());
    contactDetails.setMobile(contactDetailsForm.getMobile());
    contactDetails.setwork(contactDetailsForm.getWork());
    contactDetails.setWorkEmail(contactDetailsForm.getWorkEmail());
    contactDetails.setOtherEmail(contactDetailsForm.getOtherEmail());
    contactDetailsDao.AddContact(contactDetails);
    System.out.println("DEtails : " + flag + "++++++++");

    return flag;
  }

  @Override
  public ContactDetails getContactDetails(int id) {
    ContactDetails contactDetails = contactDetailsDao.getUserContact(id);
    return contactDetails;
  }

  // @Override
  // public void deleteContact(int id) {

  // // ContactDetailsDao.deleteContactid(id);
  // contactDetailsDao.

  // }

  @Override
  public List<ContactDetails> getContactDetails() {

    return contactDetailsDao.getAllContact();
  }

  public boolean ContactUser(ContactDetailsForm contactDetailsForm) {
    return false;
  }
}

