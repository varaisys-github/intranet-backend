package com.varaisys.intranet.daoImpl;

import java.util.List;

import org.hibernate.type.AbstractStandardBasicType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.EmergencyContactDao;
import com.varaisys.intranet.model.EmergencyContact;

/**
 *
 * @author Kanishka Rajput
 * @Created on 1/feb/2023
 */
@Repository
@Transactional
public class EmergencyContactDaoImpl extends AbstractDao<Integer, EmergencyContact> implements EmergencyContactDao {
    @Override
    public boolean AddEmergencyContact(EmergencyContact detail) {
        System.out.println(detail);
        persist(detail);
        return true;
    }

    @Override
    public List<EmergencyContact> getAllContact() {

        return createEntityCriteria().list();
    }

    @Override
    public EmergencyContact getContactById(int Id) {
        EmergencyContact emergencyContact = getByKey(Id);
        return emergencyContact;
    }
}

