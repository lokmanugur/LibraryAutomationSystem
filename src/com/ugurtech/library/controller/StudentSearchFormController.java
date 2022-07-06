/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.student.StudentDao;
import com.ugurtech.library.persistance.student.StudentDaoImpl;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.view.student.StudentSearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 */
public final class StudentSearchFormController {
    
    private final StudentSearchForm studentSearchForm;
    private final StudentDao studentDao;

    public StudentSearchFormController(StudentSearchForm studentSearchForm) {
        this.studentSearchForm = studentSearchForm;
        studentDao = new StudentDaoImpl();
        fillAllStudents();
    }

    public void fillAllStudents() {
        Map<String,String> filters = new HashMap<>();
        Optional.ofNullable(studentSearchForm.getStudentNumberTextField().getText())
                .filter(value->!value.equals(""))
                .ifPresent(value->filters.put("studentNumber", value));
        Optional.ofNullable(studentSearchForm.getStudentNameTextField().getText())
                .filter(value->!value.equals(""))
                .ifPresent(value->filters.put("studentName", value));
        studentSearchForm.getStudentTable().setModel(DbUtils.resultSetToTableModel(studentDao.fillAllStudent(filters)));
    }

    public void updateStudent() {
        
    }

    public void deleteStudent() {
        if (studentSearchForm.getStudentTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz veriyi seçin");
        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
            studentDao.deleteStudent((String) studentSearchForm.getStudentTable().getModel().getValueAt(studentSearchForm.getStudentTable().getSelectedRow(), 0));
        }
        fillAllStudents();
    }

}
