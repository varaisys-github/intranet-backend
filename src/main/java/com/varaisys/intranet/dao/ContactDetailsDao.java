package com.varaisys.intranet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.model.ContactDetails;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 1/feb/2023
 */

@Repository
public interface ContactDetailsDao {
    public void AddContact(ContactDetails detail);

    public List<ContactDetails> getAllContact();

    public ContactDetails getUserContact(int id);

    public void deleteContactid(int id);

}

