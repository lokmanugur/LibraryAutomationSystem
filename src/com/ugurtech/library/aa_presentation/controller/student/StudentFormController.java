/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.student;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.main.MainForm;
import com.ugurtech.library.aa_presentation.view.classstd.ClassForm;
import com.ugurtech.library.aa_presentation.view.student.StudentForm;
import com.ugurtech.library.aa_presentation.view.student.StudentSearchForm;
import com.ugurtech.library.ab_application.service.classstd.ClassStdService;
import com.ugurtech.library.ab_application.service.classstd.ClassStdServiceImpl;
import com.ugurtech.library.ab_application.service.school.SchoolService;
import com.ugurtech.library.ab_application.service.school.SchoolServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.classstd.ClassStdDaoImpl;
import com.ugurtech.library.ac_dataaccesslayer.school.SchoolDaoImpl;
import com.ugurtech.library.ad_model.ClassModel;
import com.ugurtech.library.ad_model.SchoolModel;
import com.ugurtech.library.ad_model.StudentModel;
import java.util.Date;
import java.util.Objects;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ugur
 *
 */
public final class StudentFormController extends StudentController implements Initialize {

    private final SchoolService schoolService = new SchoolServiceImpl(new SchoolDaoImpl());
    private final ClassStdService classStdService = new ClassStdServiceImpl(new ClassStdDaoImpl());
    private final StudentForm studentForm;
    private StudentModel studentModel;

    public StudentFormController(StudentForm studentForm) {
        this.studentForm = studentForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
        AutoCompleteDecorator.decorate(studentForm.getComboBoxClass());
        AutoCompleteDecorator.decorate(studentForm.getComboBoxSchool());
        fillAllSchoolToComboBox();
        fillAllClassToComboBox();
    }

    @Override
    public void initController() {

        studentForm.getButtonCancel().addActionListener((e) -> {
            cancel();
        });

        studentForm.getButtonAdd().addActionListener((e) -> {
            MainForm.getInstance().addDesktopPane(ClassForm.INSTANCE);
        });
        studentForm.getButtonSave().addActionListener((e) -> {
            add();
        });

        studentForm.getComboBoxSchool().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {

                }
            }
        });
        studentForm.getComboBoxClass().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {

                }
            }
        });
        studentForm.getComboBoxClass().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                fillAllClassToComboBox();
            }
        });
        studentForm.getComboBoxSchool().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                fillAllSchoolToComboBox();
            }
        });
    }

    private void fillAllSchoolToComboBox() {
        studentForm.getComboBoxSchool().removeAllItems();
        schoolService.getAll().forEach((SchoolModel item) -> studentForm.getComboBoxSchool().addItem(item));
    }

    private void fillAllClassToComboBox() {
        studentForm.getComboBoxClass().removeAllItems();
        classStdService.getAll().forEach((ClassModel item) -> studentForm.getComboBoxClass().addItem(item));
    }

    public void clearFormFields() {
        studentForm.getTextFieldFirstName().setText("");
        studentForm.getTextFieldLastName().setText("");
        studentForm.getTextFieldStudentNo().setText("");
        studentForm.getDateChooserBirth().setDate(null);
        studentForm.getFormattedTextFieldPhone().setText("");
        studentForm.getTextAreaAddress().setText("");
        fillAllClassToComboBox();
        fillAllSchoolToComboBox();
        StudentSearchForm.INSTANCE.getStudentSearchFormController().search();
    }

    private void add() {
        if (Objects.isNull(studentModel)) {
            add(formToModel(new StudentModel()));
            clearFormFields();
            setStudentModel(null);
        } else {
            update(formToModel(studentModel));
            clearFormFields();
            setStudentModel(null);
            studentForm.dispose();
        }
    }

    private void setLanguage() {

    }

    private void cancel() {
        clearFormFields();
        setStudentModel(null);
        studentForm.dispose();
        
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public void modelToForm(StudentModel studentModel) {
        studentForm.getTextFieldFirstName().setText(studentModel.getFirstName());
        studentForm.getTextFieldLastName().setText(studentModel.getLastName());
        studentForm.getTextFieldStudentNo().setText(studentModel.getStudentNumber());
        studentForm.getComboBoxClass().setSelectedItem(studentModel.getClssModel());
        studentForm.getComboBoxSchool().setSelectedItem(studentModel.getSchoolModel());
        studentForm.getDateChooserBirth().setDate(new Date(studentModel.getBirthDate()));
        studentForm.getFormattedTextFieldPhone().setText(studentModel.getPhone());
        studentForm.getTextAreaAddress().setText(studentModel.getAddress());
        this.studentModel = studentModel;
    }

    public StudentModel formToModel(StudentModel sm) {
        sm.setFirstName(studentForm.getTextFieldFirstName().getText());
        sm.setLastName(studentForm.getTextFieldLastName().getText());
        sm.setStudentNumber(studentForm.getTextFieldStudentNo().getText());
        sm.setClassModel((ClassModel) studentForm.getComboBoxClass().getSelectedItem());
        sm.setSchoolModel((SchoolModel) studentForm.getComboBoxSchool().getSelectedItem());
        sm.setBirthDate(studentForm.getDateChooserBirth().getDate().getTime());
        sm.setPhone(studentForm.getFormattedTextFieldPhone().getText());
        sm.setAddress(studentForm.getTextAreaAddress().getText());
        return sm;
    }
}
