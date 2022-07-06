/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.personbook;

import com.ugurtech.library.model.BookBorrowingModel;
import com.ugurtech.library.model.PersonBookBorrowingModel;
import com.ugurtech.library.model.PersonBookModel;
import com.ugurtech.library.model.TakenBackBookModel;
import java.util.List;

/**
 *
 * @author ugur
 * 
 */
public interface PersonBookDao {
    public List<PersonBookBorrowingModel> getAllPerson();
    public List<BookBorrowingModel> getAllBook();
    public PersonBookBorrowingModel getPersonBook(int id);
    public void addPersonBook(PersonBookModel personBookModel);
    public TakenBackBookModel getTakenBackBook(TakenBackBookModel takenBackBookModel);
    
    //this two method should be work under security surveillance
    public void updatePersonBook(PersonBookBorrowingModel personBookBorrowingModel);
    public void deletePersonBook(PersonBookBorrowingModel personBookBorrowingModel);

    public void acceptBook(TakenBackBookModel takenBackBookModel);
}
