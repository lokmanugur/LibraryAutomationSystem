/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.application.service.publisher;

import com.ugurtech.library.model.PublisherModel;
import com.ugurtech.library.application.service.Service;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface PublisherService extends Service<PublisherModel>{

    public TableModel search(String str);
    
}
