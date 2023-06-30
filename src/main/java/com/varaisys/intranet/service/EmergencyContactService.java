package com.varaisys.intranet.service;

import org.springframework.stereotype.Service;

import com.varaisys.intranet.utils.EmergencyContactForm;
import com.varaisys.intranet.model.EmergencyContact;
import java.util.List;

@Service

public interface EmergencyContactService {
    public List<EmergencyContact> getPersonalContacts();

    public EmergencyContact getPersonalContact(int Id);

    public boolean AddEmergencyContact(EmergencyContactForm emergencyContactForm);

}
