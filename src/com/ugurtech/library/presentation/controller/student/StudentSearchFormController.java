/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.student;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.student.StudentForm;
import com.ugurtech.library.presentation.view.student.StudentSearchForm;

/**
 *
 * @author ugur
 */
public final class StudentSearchFormController extends StudentController implements Initialize {

    private final StudentSearchForm studentSearchForm;

    public StudentSearchFormController(StudentSearchForm studentSearchForm) {
        this.studentSearchForm = studentSearchForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        search();
    }

    @Override
    public void initController() {
        studentSearchForm.getButtonAdd().addActionListener(e -> {
            add();
        });
        
        studentSearchForm.getButtonUpdate().addActionListener(e -> {
            update();
        });
        
        studentSearchForm.getButtonDelete().addActionListener(e -> {
            delete();
        });
        
        studentSearchForm.getButtonWrite().addActionListener(e -> {
            write();
        });
        
        studentSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });
    }

    private void add() {
        MainForm.getInstance().addDesktopPane(StudentForm.INSTANCE);
    }
    
    private void update() {
        MainForm.getInstance().addDesktopPane(StudentForm.INSTANCE);
        StudentForm.INSTANCE.getStudentFormController().modelToForm(
        get((int)studentSearchForm.getTableSearch().getValueAt(studentSearchForm.getTableSearch().getSelectedRow(), 0)));
    }

    private void delete() {
        if(deleteApproveMessage(studentSearchForm.getTableSearch().getSelectedRow())){
            delete((int)studentSearchForm.getTableSearch().getValueAt(studentSearchForm.getTableSearch().getSelectedRow(), 0));
        }
    }
    
    private void write() {
        write(studentSearchForm.getTableSearch(),studentSearchForm.getTitle());
    }

    public void search() {
       studentSearchForm.getTableSearch().setModel(search(studentSearchForm.getTextFieldSearch().getText()));
    }

}
