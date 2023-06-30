package com.varaisys.intranet.service;

import java.util.List;
/**
 * 
 * @author Kanishka rajput
 * @Created on 1/feb/2023
 */

import org.springframework.stereotype.Service;

import com.varaisys.intranet.model.ContactDetails;
import com.varaisys.intranet.utils.ContactDetailsForm;

@Service
public interface ContactDeatilsService {
    public List<ContactDetails> getContactDetails();

    public ContactDetails getContactDetails(int id);

    public boolean AddContact(ContactDetailsForm contactDetailForm);

    // public boolean updateContact(ContactDetailsForm contactDetailform);

    // public void deleteContact(int id);

}

