/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.booktype.BookTypeDaoImpl;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.view.booktype.BookTypeForm;
import com.ugurtech.library.service.validation.UserInfoMessages;
import net.proteanit.sql.DbUtils;
import com.ugurtech.library.persistance.booktype.BookTypeDao;

/**
 *
 * @author ugur
 */
public class BooksTypeController {
    
    private final BookTypeForm booksTypeForm;
    private BookTypeModel booksTypeModel;
    private final BookTypeDao booksTypeDao;
    public BooksTypeController(BookTypeForm bookTypeForm) {
        this.booksTypeForm = bookTypeForm;
        this.booksTypeDao = new BookTypeDaoImpl();
    }
//    public void addBooksType(){
//        this.booksTypeModel = new BookTypeModel();
//        booksTypeModel.setTypeName(booksTypeForm.getBookTypeTextField().getText());
//        booksTypeModel.setAbbrivation(booksTypeForm.getAbbreviationTextField().getText());
//        if(!booksTypeForm.getBookTypeTextField().getText().equals("")&&!booksTypeForm.getAbbreviationTextField().getText().equals("")){
//            booksTypeDao.addBookType(booksTypeModel);
//        }else{
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen Kitap Türü ve Kısaltma alanlarını doldurunuz.");
//        }
//        fillAllBooksType();
//    }
//    public void fillAllBooksType(){
////        Map<String,String> filters = new HashMap<>();
////        Optional.ofNullable(booksTypeForm.getBookTypeTextField().getText())
////                .filter(value->!value.equals(""))
////                .ifPresent(value->filters.put("typeName", value));
////        Optional.ofNullable(booksTypeForm.getAbbreviationTextField().getText())
////                .filter(value->!value.equals(""))
////                .ifPresent(value->filters.put("abbreviation", value));
////        booksTypeForm.getBooksTypeTable().setModel(DbUtils.resultSetToTableModel(booksTypeDao.findBookTypeByFilter(filters)));
//        
//        booksTypeForm.getBooksTypeTable().setModel(DbUtils.resultSetToTableModel(booksTypeDao.findBookTypeByFilter()));
//    }
//    
//    public void deleteBookType(){
//        if (booksTypeForm.getBooksTypeTable().getSelectedRow() == -1) {
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz satırı seçin.");
//        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
//            booksTypeDao.deleteBookType((int)booksTypeForm.getBooksTypeTable().getModel().getValueAt(booksTypeForm.getBooksTypeTable().getSelectedRow(), 0));
//        }
//        fillAllBooksType();
//    }
//
//    public void updateBookType() {
//        this.booksTypeModel=new BookTypeModel();
//        if (booksTypeForm.getBooksTypeTable().getSelectedRow() == -1) {
//            UserInfoMessages.getInstance().showInfoMessages("Lütfen Güncellemek istediğiniz satırı seçin.");
//        }else{
//            booksTypeModel.setBookTypeId((int) booksTypeForm.getBooksTypeTable().getModel().getValueAt(booksTypeForm.getBooksTypeTable().getSelectedRow(), 0));
//            booksTypeModel.setTypeName((String) booksTypeForm.getBooksTypeTable().getModel().getValueAt(booksTypeForm.getBooksTypeTable().getSelectedRow(), 1));
//            booksTypeModel.setAbbrivation((String) booksTypeForm.getBooksTypeTable().getModel().getValueAt(booksTypeForm.getBooksTypeTable().getSelectedRow(), 2));
//            booksTypeDao.updateBookType(booksTypeModel);
//        }
//        fillAllBooksType();
//    }
}
