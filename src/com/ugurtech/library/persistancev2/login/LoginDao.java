/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.persistancev2.login;

import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.persistancev2.Dao;

/**
 *
 * @author Teacher
 */
public interface LoginDao extends Dao<CurrentUserModel>{
    boolean checkExistUsers();
    boolean checkUser(CurrentUserModel currentUser);
}
