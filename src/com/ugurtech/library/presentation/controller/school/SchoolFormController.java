/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.school;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.school.SchoolForm;
import com.ugurtech.library.presentation.view.school.SchoolSearchForm;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.model.SchoolModel;
import java.util.Objects;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 *
 *
 */
public final class SchoolFormController extends SchoolController implements Initialize {

    private final SchoolForm schoolForm;

    public SchoolFormController(SchoolForm schoolForm) {
        this.schoolForm = schoolForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
    }

    @Override
    public void initController() {
        schoolForm.getButtonSave().addActionListener((e) -> {
            if (schoolForm.getSchoolModel() == null) {
                save();
            } else {
                update();
            }
        });
        schoolForm.getButtonCancel().addActionListener((e) -> {
            cancel();
        });
    }

    private SchoolModel formToModel() {
        SchoolModel schoolModel;
        if (schoolForm.getTextFieldName().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("authorcontroller.add.leaveblank.caution"));
            return null;
        } else {
            schoolModel = new SchoolModel();
            schoolModel.setSchoolId(Objects.isNull(schoolForm.getSchoolModel())? 0 : schoolForm.getSchoolModel().getSchoolId());
            schoolModel.setSchoolName(schoolForm.getTextFieldName().getText());
            schoolModel.setPhone(schoolForm.getFormattedTextFieldPhone().getText());
            schoolModel.setAddress(schoolForm.getTextAreaAddress().getText());
            return schoolModel;
        }
    }

    void modelToForm() {
        schoolForm.getTextFieldName().setText(schoolForm.getSchoolModel().getSchoolName());
        schoolForm.getFormattedTextFieldPhone().setText(schoolForm.getSchoolModel().getPhone());
        schoolForm.getTextAreaAddress().setText(schoolForm.getSchoolModel().getAddress());
    }

    private void cancel() {
        clearFields();
        schoolForm.setSchoolModel(null);
        schoolForm.dispose();
    }

    private void save() {
        add(formToModel());
        clearFields();
        refreshTable();
    }

    private void update() {
        update(formToModel());
        schoolForm.setSchoolModel(null);
        clearFields();
        refreshTable();
    }

    public void clearFields() {
        schoolForm.getTextFieldName().setText("");
        schoolForm.getFormattedTextFieldPhone().setText("");
        schoolForm.getTextAreaAddress().setText("");
    }
    
    private void refreshTable(){
        SchoolSearchForm.INSTANCE.getSchoolSearchFromController().search();
    }

    private void setLanguage() {
        schoolForm.setTitle(setLanguage("schoolform.title"));
        schoolForm.getLabelName().setText(setLanguage("schoolform.label.name"));
        schoolForm.getLabelPhone().setText(setLanguage("schoolform.label.phone"));
        schoolForm.getLabelAddress().setText(setLanguage("schoolform.label.address"));
        schoolForm.getButtonSave().setText(setLanguage("form.button.save"));
        schoolForm.getButtonCancel().setText(setLanguage("form.button.cancel"));
    }
}
