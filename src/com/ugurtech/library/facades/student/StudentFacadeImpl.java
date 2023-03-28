/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.facades.student;

import com.ugurtech.library.application.service.student.StudentService;
import com.ugurtech.library.model.StudentModel;
import com.ugurtech.library.dto.StudentDTO;
import com.ugurtech.library.facades.PopulatingConverter;
import java.util.List;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;
    private final PopulatingConverter<StudentModel, StudentDTO> converter;

    public StudentFacadeImpl(StudentService studentService) {
        this.studentService = studentService;
        converter=PopulatingConverter.of(StudentDTO.class).withPopulator(new StudentPopulator());
    }
    
    @Override
    public List<StudentDTO> getAll() {
        return converter.convertAll(studentService.getAll());
    }

    @Override
    public StudentDTO get(int id) {
        return converter.convert(studentService.get(id));
    }
    
}
