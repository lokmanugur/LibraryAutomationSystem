/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.personbook.PersonBookDao;
import com.ugurtech.library.persistance.personbook.PersonBookDaoImpl;
import com.ugurtech.library.view.bookborrowing.TakenBackForm;
import com.ugurtech.library.model.TakenBackBookModel;

/**
 *
 * @author ugur
 */
public class TakenBackFormController {

    private final TakenBackForm takenBackForm;
    private TakenBackBookModel takenBackBookModel;
    private final PersonBookDao personBookDao;
    public TakenBackFormController(TakenBackForm takenBackFrom) {
        this.takenBackForm = takenBackFrom;
        this.personBookDao=new PersonBookDaoImpl();
        
    }
    
    public void getBackBook(){
        takenBackBookModel = new TakenBackBookModel();
        takenBackBookModel.setBookid(Integer.valueOf(takenBackForm.getBookIdTextField().getText()));
        takenBackBookModel.setBookIsbn(Long.valueOf(takenBackForm.getIsbnTextField().getText()));
        takenBackBookModel = personBookDao.getTakenBackBook(takenBackBookModel);
        takenBackForm.getBookTitleTextField().setText(takenBackBookModel.getBookTitle());
        takenBackForm.getAuthorTextField().setText(takenBackBookModel.getBookAuthor());
        takenBackForm.getBookTypeTextField().setText(takenBackBookModel.getBookType());
        takenBackForm.getStartDateTextField().setText(takenBackBookModel.getStartDate());
        takenBackForm.getFinishDateTextField().setText(takenBackBookModel.getFinishDate());
        takenBackForm.getBringbackDateTextField().setText(takenBackBookModel.getReturnDate());
        
        takenBackForm.getPersonFirstLastNameTextField().setText(takenBackBookModel.getFirstLastName());
        takenBackForm.getStudentNumberTextField().setText(takenBackBookModel.getStudentNumber());
        takenBackForm.getClassRoomTextField().setText(takenBackBookModel.getClassRoom());
        takenBackForm.getSchoolNameTextField().setText(takenBackBookModel.getSchoolName());
        takenBackForm.getPhoneTextField().setText(takenBackBookModel.getPhone());
        takenBackForm.getAddressTextArea().setText(takenBackBookModel.getAddress());
    }

    public void acceptBook() {
        if(takenBackBookModel.getBookIsbn()!= 0)
            personBookDao.acceptBook(takenBackBookModel);
    }

}
