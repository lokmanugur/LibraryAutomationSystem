/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.classstd;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.classstd.ClassForm;
import com.ugurtech.library.presentation.view.classstd.ClassSearchForm;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public final class ClassSearchFormController extends ClassController implements Initialize {

    private final ClassSearchForm classSearchForm;

    public ClassSearchFormController(ClassSearchForm classSearchForm) {
        this.classSearchForm = classSearchForm;
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
        classSearchForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
            clearAllFields();
        });
        classSearchForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {

        });
        classSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        classSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
            clearAllFields();
        });
        classSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });
    }

    public void search() {
        classSearchForm.getTableSearch().setModel(search(classSearchForm.getTextFieldSearch().getText()));
    }

    protected void add() {
        MainForm.getInstance().addDesktopPane(ClassForm.INSTANCE);
    }

    protected void update() {
        if (classSearchForm.getTableSearch().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            MainForm.getInstance().addDesktopPane(ClassForm.INSTANCE);
            ClassForm.INSTANCE.setClassModel(get((int) classSearchForm.getTableSearch().getModel().getValueAt(classSearchForm.getTableSearch().getSelectedRow(), 0)));
            ClassForm.INSTANCE.getClassFormController().modelToForm();
        }
    }

    protected void delete() {
        if (classSearchForm.getTableSearch().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((Integer) (classSearchForm.getTableSearch().getModel().getValueAt(classSearchForm.getTableSearch().getSelectedRow(), 0)));

        }
        search();

    }

    public void clearAllFields() {
        classSearchForm.getTextFieldSearch().setText("");
    }

    private void setLanguage() {
        classSearchForm.setTitle(setLanguage("classform.title"));
        classSearchForm.getLabelSearch().setText(setLanguage("table.label.search"));
        classSearchForm.getButtonSave().setText(setLanguage("table.button.add"));
        classSearchForm.getButtonWrite().setText(setLanguage("table.button.write.excel"));
        classSearchForm.getButtonUpdate().setText(setLanguage("table.button.update"));
        classSearchForm.getButtonDelete().setText(setLanguage("table.button.delete"));
    }
}
