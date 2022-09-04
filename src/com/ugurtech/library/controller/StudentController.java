/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.ac_dataaccesslayer.student.StudentDao;
import com.ugurtech.library.ac_dataaccesslayer.student.StudentDaoImpl;
import com.ugurtech.library.model.SchoolModel;
import com.ugurtech.library.model.StudentModel;
import com.ugurtech.library.aa_presentation.view.student.StudentForm;
import java.util.List;

/**
 *
 * @author ugur
 */
public class StudentController {

    private final StudentForm studentForm;
    private final StudentDao studentDao;
    private StudentModel studentModel;
    private List<SchoolModel> schoolList;
    public StudentController(StudentForm studentForm) {
        this.studentForm = studentForm;
        this.studentDao = new StudentDaoImpl();
        
    }

//    public void getAllSchool() {
//        studentForm.getSchoolComboBox().removeAllItems();
//       // schoolList = studentDao.getAllSchool();
//        schoolList.forEach(value->studentForm.getSchoolComboBox().addItem(value.getSchoolName()));
//    }
//
//    public void addStudent() {
//        this.studentModel= new StudentModel();
//        studentModel.setFirstName(studentForm.getFirstNameTextField().getText());
//        studentModel.setLastName(studentForm.getLastNameTextField().getText());
//        studentModel.setStudenNumber(studentForm.getStudentNumberTextField().getText());
////        studentModel.setStudentClass(studentForm.getStudentClassTextField().getText());
//        schoolList.stream()
//                .filter(sm -> (sm.getSchoolName().equals(studentForm.getSchoolComboBox().getSelectedItem().toString())))
//                .forEachOrdered(sm -> {studentModel.setStudentSchool(sm.getSchoolId());});
//        studentModel.setBirthDate(new Date(studentForm.getBirthDateChooser().getDate().getTime()));
//        studentModel.setPhone(studentForm.getPhoneTextField().getText());
//        studentModel.setAddress(studentForm.getAddressTextArea().getText());
//  //      studentDao.addStudent(studentModel);
//    }  
}
