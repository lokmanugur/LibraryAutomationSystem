/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.borrow;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.borrow.BorrowService;
import com.ugurtech.library.application.service.borrow.BorrowServiceImpl;
import com.ugurtech.library.application.service.student.StudentService;
import com.ugurtech.library.application.service.student.StudentServiceImpl;
import com.ugurtech.library.dataaccesslayer.borrow.BorrowDaoImpl;
import com.ugurtech.library.dataaccesslayer.student.StudentDaoImpl;
import com.ugurtech.library.model.PersonBookModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class ControllerImpl extends AbstractController implements Controller<PersonBookModel>{
    private final BorrowService borrowService = new BorrowServiceImpl(new BorrowDaoImpl());
    protected final StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
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
        return borrowService.get(id);
    }

    @Override
    public void update(PersonBookModel v) {
        borrowService.update(v);
    }

    @Override
    public void delete(int id) {
        borrowService.delete(id);
    }
    
}
