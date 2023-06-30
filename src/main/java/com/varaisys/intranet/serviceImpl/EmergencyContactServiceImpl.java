package com.varaisys.intranet.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.EmergencyContactDao;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import com.varaisys.intranet.model.EmergencyContact;
import com.varaisys.intranet.service.EmergencyContactService;
import com.varaisys.intranet.utils.EmergencyContactForm;

@Service
@Transactional("mydb")
public class EmergencyContactServiceImpl implements EmergencyContactService {
    private boolean flag = false;
    @Autowired
    EmergencyContactDao emergencyContactDao;

    @Override
    public boolean AddEmergencyContact(EmergencyContactForm emergencyContactForm) throws PersonNotFoundException {
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setEmergencyName(emergencyContactForm.getEmergencyName());
        emergencyContact.setRelationship(emergencyContactForm.getRelationship());
        emergencyContact.setEmergencyMobile(emergencyContactForm.getEmergencyMobile());
        emergencyContact.setWorkTelephone(emergencyContactForm.getWorkTelephone());
        emergencyContact.setHomeTelephone(emergencyContactForm.getHomeTelephone());
        emergencyContactDao.AddEmergencyContact(emergencyContact);
        System.out.println("DEtails : " + flag + "....>>>>.kanishkaaa");
        return flag;

    }

    @Override
    public List<EmergencyContact> getPersonalContacts() {

        return emergencyContactDao.getAllContact();
    }

    @Override
    public EmergencyContact getPersonalContact(int Id) {
        EmergencyContact emergencyContact = emergencyContactDao.getContactById(Id);
        return emergencyContact;
    }

}

