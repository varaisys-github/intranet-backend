package com.varaisys.intranet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.model.EmergencyContact;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 6/feb/2023
 */

@Repository
public interface EmergencyContactDao {
    public boolean AddEmergencyContact(EmergencyContact details);

    public List<EmergencyContact> getAllContact();

    public EmergencyContact getContactById(int Id);
}
