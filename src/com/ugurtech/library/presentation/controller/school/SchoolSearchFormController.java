/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.school;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.school.SchoolForm;
import com.ugurtech.library.presentation.view.school.SchoolSearchForm;

/**
 *
 * @author ugur
 *
 */
public final class SchoolSearchFormController extends SchoolController implements Initialize {

    private final SchoolSearchForm schoolSearchForm;

    public SchoolSearchFormController(SchoolSearchForm schoolSearchForm) {
        this.schoolSearchForm = schoolSearchForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {

        schoolSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        schoolSearchForm.getButtonAdd().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
        });

        schoolSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        schoolSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });

        schoolSearchForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {
            writeExel();
        });

    }

    public void search() {
        schoolSearchForm.getTableSchool().setModel(search(schoolSearchForm.getTextFieldSearch().getText()));
    }

    private void add() {
        MainForm.INSTANCE.addDesktopPane(SchoolForm.INSTANCE);
    }

    private void update() {
        if (updateUnSelectRowMessage(schoolSearchForm.getTableSchool().getSelectedRow())) {
            MainForm.INSTANCE.addDesktopPane(SchoolForm.INSTANCE);
            SchoolForm.INSTANCE.setSchoolModel(get((int) schoolSearchForm.getTableSchool().getModel().getValueAt(schoolSearchForm.getTableSchool().getSelectedRow(), 0)));
            SchoolForm.INSTANCE.getSchoolFormController().modelToForm();
        }
    }

    private void delete() {
        if (deleteApproveMessage(schoolSearchForm.getTableSchool().getSelectedRow())) {
            delete((int) schoolSearchForm.getTableSchool().getModel().getValueAt(schoolSearchForm.getTableSchool().getSelectedRow(), 0));
        }
        search();
    }

    private void writeExel() {
        write(schoolSearchForm.getTableSchool(), schoolSearchForm.getTitle());
    }

    private void setLanguage() {
        schoolSearchForm.setTitle(setLanguage("schoolsearchform.title"));
        schoolSearchForm.getLabelSearch().setText(setLanguage("table.search"));
        schoolSearchForm.getButtonAdd().setText(setLanguage("table.button.add"));
        schoolSearchForm.getButtonUpdate().setText(setLanguage("table.button.update"));
        schoolSearchForm.getButtonDelete().setText(setLanguage("table.button.delete"));
        schoolSearchForm.getButtonWrite().setText(setLanguage("table.button.write.excel"));
    }
}
