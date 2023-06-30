package com.varaisys.intranet.daoImpl;

import com.varaisys.intranet.dao.AbstractDao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.model.ContactDetails;
import com.varaisys.intranet.dao.ContactDetailsDao;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 1/feb/2023
 */
@Repository
@Transactional
public class ContactDetailsDaoImpl extends AbstractDao<Integer, ContactDetails> implements ContactDetailsDao {

    @Override
    public void AddContact(ContactDetails detail) {
        System.out.println(detail);
        persist(detail);

    }

    @Override
    public List<ContactDetails> getAllContact() {

        return createEntityCriteria().list();

    }

    @Override
    public ContactDetails getUserContact(int id) {
        ContactDetails contactDetails = getByKey(id);
        return contactDetails;
    }

    @Override
    public void deleteContactid(int id) {
        ContactDetails contactDetails = getByKey(id);
        delete(contactDetails);

    }

}

