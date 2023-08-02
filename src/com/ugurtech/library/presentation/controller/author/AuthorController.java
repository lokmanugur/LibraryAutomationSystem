/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.author;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.dataaccesslayer.author.AuthorDaoImpl;
import com.ugurtech.library.service.author.AuthorService;
import com.ugurtech.library.service.author.AuthorServiceImpl;
import java.util.List;
import javax.swing.table.TableModel;
import com.ugurtech.library.presentation.controller.Controller;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class AuthorController extends AbstractController implements Controller<AuthorModel> {

    private final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());
    protected AuthorModel authorModel;

    @Override
    public List<AuthorModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AuthorModel get(int id) {
        return authorService.get(id);
    }

    @Override
    public void add(AuthorModel v) {
        authorService.add(v);
    }

    @Override
    public void update(AuthorModel v) {
        authorService.update(v);
    }

    @Override
    public void delete(int id) {
        authorService.delete(id);
    }
    
    public TableModel search(String str){
       return authorService.search(str);
    }

}
