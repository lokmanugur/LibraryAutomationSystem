/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.person;

import com.ugurtech.library.model.PersonModel;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author ugur
 */
public interface PersonDao {
  
    public PersonModel getPerson(int personId);
    public void insertPerson(PersonModel person);
    public void updatePerson(PersonModel person);
    public void deletePerson(int personId);
    public ResultSet fillAllPerson(Map<String, String> filters);
    
}
