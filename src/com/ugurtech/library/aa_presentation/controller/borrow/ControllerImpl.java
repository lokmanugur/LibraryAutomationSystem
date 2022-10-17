/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.borrow;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Controller;
import com.ugurtech.library.ab_application.service.borrow.BorrowService;
import com.ugurtech.library.ab_application.service.borrow.BorrowServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.borrow.BorrowDaoImpl;
import com.ugurtech.library.ad_model.PersonBookModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class ControllerImpl extends AbstractController implements Controller<PersonBookModel>{
    private final BorrowService borrowService = new BorrowServiceImpl(new BorrowDaoImpl());
    
    public TableModel search(String searchText,int optionsId, int dateId, long startDate, long endDate) {
        return borrowService.search(dateId, startDate, endDate,optionsId, searchText);
    }
    
    @Override
    public void add(PersonBookModel personBookModel){
        borrowService.add(personBookModel);
    }

    @Override
    public List<PersonBookModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonBookModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PersonBookModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
