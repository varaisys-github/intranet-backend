package com.varaisys.intranet.service;

import org.springframework.stereotype.Service;

import com.varaisys.intranet.utils.DependentsForm;
import com.varaisys.intranet.model.Dependents;
import java.util.List;

/**
 * 
 * @author Kanishka rajput
 * @Created on 6/feb/2023
 */
@Service

public interface DependentsService {
    public boolean AddDependents(DependentsForm dependentsForm);

    public List<Dependents> getDependents();

}

