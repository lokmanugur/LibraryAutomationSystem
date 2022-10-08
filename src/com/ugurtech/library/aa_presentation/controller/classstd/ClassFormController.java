/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.classstd;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.classstd.ClassForm;
import com.ugurtech.library.aa_presentation.view.classstd.ClassSearchForm;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ad_model.ClassModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public final class ClassFormController extends ClassController implements Initialize {

    private final ClassForm classForm;
    public ClassFormController(ClassForm classForm) {
        this.classForm = classForm;
        initView();
        initController();
    }

private void setLanguage() {
        classForm.setTitle(setLanguage("classform.title"));
        classForm.getLabelClassName().setText(setLanguage("classform.label.name"));
        classForm.getButtonCancel().setText(setLanguage("form.button.cancel"));
        classForm.getButtonSave().setText(setLanguage("form.button.save"));
    }

    private void add() {
        add(formToModel());
        ClassSearchForm.INSTANCE.getClassSearchFormController().initView();
    }

    @Override
    public void initView() {
        setLanguage();
    }

    @Override
    public void initController() {
        classForm.getButtonSave().addActionListener(((e) -> {
            if (classForm.getClassModel() != null) {
                updete();
                classForm.setClassModel(null);
                clearFields();
            } else {
                add();
                clearFields();
            }
        }));
        classForm.getButtonCancel().addActionListener(((e) -> {
            classForm.setClassModel(null);
            clearFields();
            classForm.dispose();
        }));
    }

    private void updete() {
        update(formToModel());
        ClassSearchForm.INSTANCE.getClassSearchFormController().initView();
    }

    private ClassModel formToModel() {
        ClassModel cm = null;
        if (classForm.getTextFieldClassName().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("classform.classname.empty"));
        } else {
            cm = new ClassModel();
            cm.setClassId(classForm.getClassModel()==null?0:classForm.getClassModel().getClassId());
            cm.setClassName(classForm.getTextFieldClassName().getText());
        }
        return cm;
    }

    public void modelToForm() {
        classForm.getTextFieldClassName().setText(classForm.getClassModel().getClssName());
    }

    public void clearFields() {
        classForm.getTextFieldClassName().setText("");
    }
    
}
