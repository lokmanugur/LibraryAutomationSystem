/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.user;

import com.ugurtech.library.model.PersonModel;
import com.ugurtech.library.model.UserModel;
import com.ugurtech.library.model.UserTypeModel;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ugur
 */
public interface UserDao {
    
   public ResultSet fillAllUser(Map<String, String> filters);
   public UserModel getUser(int userId);
   public void addUser(UserModel userModel);
   public void updateUser(UserModel userModel);
   public void deleteUser(int userId);
   public List<PersonModel> allPerson();
   public List<UserTypeModel> allUserType();

}