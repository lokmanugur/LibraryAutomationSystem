/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.author;

import com.ugurtech.library.model.AuthorModel;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author ugur
 */
public interface AuthorDao {
    
    public ResultSet fillAllAuthor(Map<String, String> filters);
    public AuthorModel getAuthor(int bookId);
    public void addAuthor(AuthorModel book);
    public void updateAuthor(AuthorModel book);
    public void deleteAuthor(int authorId);

    
}
