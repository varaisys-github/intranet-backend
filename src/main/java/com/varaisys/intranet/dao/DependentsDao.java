package com.varaisys.intranet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.model.Dependents;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 1/feb/2023
 */
@Repository
public interface DependentsDao {
    public boolean AddDependents(Dependents details);

    public List<Dependents> getAllDependents();
}

