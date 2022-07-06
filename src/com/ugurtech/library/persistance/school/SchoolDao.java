/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.school;

import com.ugurtech.library.model.SchoolModel;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author ugur
 * 
 */
public interface SchoolDao {
    public SchoolModel getSchool(int id);
    public void addSchool(SchoolModel schoolModel);
    public void updateSchool(SchoolModel schoolModel);
    public void deleteSchool(int schoolId);
    public ResultSet getAllSchool(Map<String, String> filters);
}
