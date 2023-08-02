/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.database;
import com.ugurtech.library.model.DatabaseModel;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.lib.ManipulateXML;

/**
 *
 * @author www.lokmanugur.com
 */
public class DatabaseServiceImpl implements DatabaseService<DatabaseModel> {
    
    @Override
    public void add(DatabaseModel databaseModel) {
        try {
            ManipulateXML.INSTANCE.addToXMLFile(databaseModel);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DatabaseModel get() {
       return ManipulateXML.INSTANCE.readFromXMLFile();
    }
    
}
