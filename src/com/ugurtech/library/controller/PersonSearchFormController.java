/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.person.PersonDao;
import com.ugurtech.library.persistance.person.PersonDaoImpl;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.aa_presentation.view.person.PersonSearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 */
public class PersonSearchFormController {

    private final PersonSearchForm personSearchForm;
    private final PersonDao personDao;

    public PersonSearchFormController(PersonSearchForm personSearchForm) {
        this.personSearchForm=personSearchForm;
        this.personDao=new PersonDaoImpl();
    }

    public void fillAllPerson() {
        Map<String,String> filters=new HashMap<>();
        Optional.ofNullable(personSearchForm.getFirstNameTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("firstName", value));
        Optional.ofNullable(personSearchForm.getLastNameTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("lastName", value));
        personSearchForm.getPersonTable().setModel(DbUtils.resultSetToTableModel(personDao.fillAllPerson(filters)));
    }

    public void deletePerson() {
        if (personSearchForm.getPersonTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz satırı seçin");
        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
            personDao.deletePerson((int) personSearchForm.getPersonTable().getModel().getValueAt(personSearchForm.getPersonTable().getSelectedRow(), 0));
        }
        fillAllPerson();
    }
    
}
