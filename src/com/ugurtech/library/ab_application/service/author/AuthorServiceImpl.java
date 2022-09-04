/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.author;

import com.ugurtech.library.ac_dataaccesslayer.author.AuthorDao;
import com.ugurtech.library.ad_model.AuthorModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class AuthorServiceImpl implements AuthorService{
    
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
 
    @Override
    public List<AuthorModel> getAll() {
        return authorDao.getAll();
    }

    @Override
    public AuthorModel get(int id) {
        return authorDao.get(id);
    }

    @Override
    public void add(AuthorModel v) {
        authorDao.add(v);
    }

    @Override
    public void update(AuthorModel v) {
        authorDao.update(v);
    }

    @Override
    public void delete(int id) {
        authorDao.delete(get(id));
    }

    @Override
    public TableModel search(String string) {
       return authorDao.search(string);
    }
    
}
