/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.person;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.person.PersonForm;
import com.ugurtech.library.ad_model.PersonModel;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ugur
 */
public final class PersonFormController extends PersonController implements Initialize {

    private final PersonForm personForm;
    private PersonModel personModel;

    public PersonFormController(PersonForm personForm) {
        this.personForm = personForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        
    }

    @Override
    public void initController() {
        personForm.getButtonSave().addActionListener((e) -> {
            add();
        });
        personForm.getButtonCancel().addActionListener((e) -> {
            cancel();

        });
    }

    public void clearAllFields() {
        personForm.getTextFieldName().setText("");
        personForm.getTextFieldSurname().setText("");
        personForm.getTextFieldPhone().setText("");
        personForm.getTextAreaAddress().setText("");
        personForm.getDateChooserBirth().setDate(null);
        personModel=null;
    }

    private void add() {
        if (Objects.isNull(personModel)) {
            add(formToModel(new PersonModel()));
        } else {
            update(formToModel(personModel));
            personForm.dispose();
        }
        clearAllFields();
    }

    private void cancel() {
        clearAllFields();
        personForm.dispose();
    }

    public PersonModel formToModel(PersonModel personModel) {
        personModel.setFirstName(personForm.getTextFieldName().getText());
        personModel.setLastName(personForm.getTextFieldSurname().getText());
        personModel.setPhone(personForm.getTextFieldPhone().getText());
        personModel.setAddress(personForm.getTextAreaAddress().getText());
        personModel.setBirthDate(personForm.getDateChooserBirth().getDate().getTime());
        return personModel;
    }

    public void modelToForm(PersonModel personModel) {
        personForm.getTextFieldName().setText(personModel.getFirstName());
        personForm.getTextFieldSurname().setText(personModel.getLastName());
        personForm.getTextFieldPhone().setText(personModel.getPhone());
        personForm.getTextAreaAddress().setText(personModel.getAddress());
        personForm.getDateChooserBirth().setDate(new Date(personModel.getBirthDate()));
        this.personModel = personModel;
    }
}