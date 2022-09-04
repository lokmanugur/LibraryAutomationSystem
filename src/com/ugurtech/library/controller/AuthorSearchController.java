/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;


import com.ugurtech.library.persistance.author.AuthorDao;
import com.ugurtech.library.persistance.author.AuthorDaoImpl;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.aa_presentation.view.author.AuthorSearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 */
public class AuthorSearchController {
    
    private final AuthorSearchForm authorSearchForm;
    private final AuthorDao authorDao;
    private AuthorModel authorModel;

    public AuthorSearchController(AuthorSearchForm authorSearchForm) {
        this.authorSearchForm = authorSearchForm;
        this.authorDao = new AuthorDaoImpl();
    }
    
//    public void fillAllAuthor(){
//        Map<String,String> filters = new HashMap<>();
//        Optional.ofNullable(authorSearchForm.getAuthorIdTextField().getText())
//                .filter(value->!value.equals(""))
//                .ifPresent(value->filters.put("authorId", value));
//        Optional.ofNullable(authorSearchForm.getAuthorNameTextField().getText())
//                .filter(value->!value.equals(""))
//                .ifPresent(value->filters.put("authorName", value));
//        authorSearchForm.getAuthorTable().setModel(DbUtils.resultSetToTableModel(authorDao.fillAllAuthor(filters)));
//    }
//
//    public void deleteAuthor() {
//        if (authorSearchForm.getAuthorTable().getSelectedRow() == -1) {
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz satırı seçin");
//        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
//            authorDao.deleteAuthor((int) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 0));
//        }
//        fillAllAuthor();
//    }
//
//    public void updateAuthor() {
//        this.authorModel=new AuthorModel();
//        if (authorSearchForm.getAuthorTable().getSelectedRow() == -1) {
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen Güncellemek istediğiniz satırı seçin.");
//        }else{
//            authorModel.setAuthorId((int) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 0));
//            authorModel.setFirstName((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 1));
//            authorModel.setLastName((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 2));
//           // authorModel.setBirthDate(DateUtil.parseYYYYMMDDDate(authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(),3).toString()));
//            authorModel.setPhone((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 4));
//            authorModel.setAddress((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 5));
//            authorDao.updateAuthor(authorModel);
//        }
//        fillAllAuthor();
//    }
}
