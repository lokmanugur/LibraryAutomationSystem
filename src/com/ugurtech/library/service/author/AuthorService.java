/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.author;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.service.Service;
import java.sql.ResultSet;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface AuthorService extends Service<AuthorModel> {

    public ResultSet search(String string);
    
}
