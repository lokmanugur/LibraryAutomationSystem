/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.facades.student;

import com.ugurtech.library.model.StudentModel;
import com.ugurtech.library.facades.Populator;
import com.ugurtech.library.dto.StudentDTO;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class StudentPopulator implements Populator<StudentModel, StudentDTO> {

    @Override
    public void populate(StudentModel source, StudentDTO target) {
        target.setStudentId(source.getStudentId());
        target.setStudentNumber(source.getStudentNumber());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setClassName(source.getClssModel().getClssName());
        target.setSchoolName(source.getSchoolModel().getSchoolName());
        target.setPhone(source.getPhone());
        target.setAddress(source.getAddress());
    }
}
