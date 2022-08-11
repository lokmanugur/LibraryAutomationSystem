/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.publisher;

import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.service.Service;
import java.sql.ResultSet;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface PublisherService extends Service<PublisherModel>{

    public ResultSet search(String str);
    
}
