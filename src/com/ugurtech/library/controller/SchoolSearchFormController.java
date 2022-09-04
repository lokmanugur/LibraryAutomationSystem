/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.school.SchoolDao;
import com.ugurtech.library.persistance.school.SchoolDaoImpl;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.model.SchoolModel;
import com.ugurtech.library.aa_presentation.view.school.SchoolSearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 * 
 */
public class SchoolSearchFormController {
    
    private final SchoolSearchForm schoolSearchForm;
    private final SchoolDao schoolDao;
    private SchoolModel schoolModel;
    public SchoolSearchFormController(SchoolSearchForm schoolSearchForm) {
        this.schoolSearchForm=schoolSearchForm;
        schoolDao = new SchoolDaoImpl();
    }
    
//    public void addSchool(){
//        if(schoolSearchForm.getSchoolNameTextField().getText().equals("")){
//            UserInfoMessages.getInstance().showInfoMessages("Okul Adı Giriniz.");
//        }else{
//        schoolModel= new SchoolModel();
//        schoolModel.setSchoolName(schoolSearchForm.getSchoolNameTextField().getText());
//        schoolModel.setPhone(schoolSearchForm.getPhoneTextField().getText());
//        schoolModel.setAddress(schoolSearchForm.getAddressTextArea().getText());
//        schoolDao.addSchool(schoolModel);
//        }
//    }
//    
//    public void fillAllSchool(){
//        Map<String,String> filters=new HashMap<>();
//        Optional.ofNullable(schoolSearchForm.getSearchTextFeild().getText())
//                .filter(value->!value.isEmpty())
//                .ifPresent(value->filters.put("schoolName", value));
//        schoolSearchForm.getSchoolsTable().setModel(DbUtils.resultSetToTableModel(schoolDao.getAllSchool(filters)));
//    }
//
//    public void deleteSchool() {
//        if (schoolSearchForm.getSchoolsTable().getSelectedRow() == -1) {
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz satırı seçin");
//        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
//            schoolDao.deleteSchool((int) schoolSearchForm.getSchoolsTable().getModel().getValueAt(schoolSearchForm.getSchoolsTable().getSelectedRow(), 0));
//        }
//        fillAllSchool();
//    }
//
//    public void updateSchool() {
//        this.schoolModel= new SchoolModel();
//        if (schoolSearchForm.getSchoolsTable().getSelectedRow() == -1) {
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen Güncellemek istediğiniz satırı seçin.");
//        }else{
//            schoolModel.setSchoolId((int) schoolSearchForm.getSchoolsTable().getModel().getValueAt(schoolSearchForm.getSchoolsTable().getSelectedRow(), 0));
//            schoolModel.setSchoolName((String) schoolSearchForm.getSchoolsTable().getModel().getValueAt(schoolSearchForm.getSchoolsTable().getSelectedRow(), 1));
//            schoolModel.setPhone((String) schoolSearchForm.getSchoolsTable().getModel().getValueAt(schoolSearchForm.getSchoolsTable().getSelectedRow(), 2));
//            schoolModel.setAddress((String) schoolSearchForm.getSchoolsTable().getModel().getValueAt(schoolSearchForm.getSchoolsTable().getSelectedRow(), 3));
//            schoolDao.updateSchool(schoolModel);
//        }
//        fillAllSchool();
//    }
}
