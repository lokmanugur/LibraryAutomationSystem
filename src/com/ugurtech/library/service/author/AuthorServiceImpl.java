/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.author;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.persistancev2.author.*;
import java.sql.ResultSet;
import java.util.List;

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
    public void delete(AuthorModel v) {
        authorDao.delete(v);
    }

    @Override
    public ResultSet search(String string) {
       return authorDao.search(string);
    }
    
}
