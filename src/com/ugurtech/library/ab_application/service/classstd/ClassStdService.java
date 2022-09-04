/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.classstd;

import com.ugurtech.library.ab_application.service.Service;
import com.ugurtech.library.ad_model.ClassModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public interface ClassStdService extends Service<ClassModel>{

    public TableModel search(String str);
}
