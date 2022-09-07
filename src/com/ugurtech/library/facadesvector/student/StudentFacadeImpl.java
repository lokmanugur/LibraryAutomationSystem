/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.facadesvector.student;

import com.ugurtech.library.ab_application.service.student.StudentService;
import com.ugurtech.library.ad_model.StudentModel;
import com.ugurtech.library.dto.StudentDTO;
import com.ugurtech.library.facades.PopulatingConverter;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;
    private final PopulatingConverter<StudentModel, StudentDTO> converter = PopulatingConverter.of(StudentDTO.class)
            .withPopulator(new StudentPopulator());

    public StudentFacadeImpl(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @Override
    public Vector<StudentDTO> getAll() {
        return converter.convertAll(studentService.getAll());
    }

    @Override
    public StudentDTO get(int id) {
        return converter.convert(studentService.get(id));
    }
    
}
