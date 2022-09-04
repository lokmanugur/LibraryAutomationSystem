/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.booktype;

import com.ugurtech.library.ad_model.BookTypeModel;
import com.ugurtech.library.ab_application.service.Service;
import java.sql.ResultSet;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface BookTypeService extends Service<BookTypeModel> {

    public TableModel search(String text);
    
}
