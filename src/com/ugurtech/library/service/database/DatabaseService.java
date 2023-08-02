/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.service.database;
/**
 *
 * @author www.lokmanugur.com
 * @param <DatabaseModel>
 */
public interface DatabaseService<DatabaseModel> {
   public void add(DatabaseModel databaseModel);
   public DatabaseModel get();
}
