/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.service.login;

import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.service.Service;


/**
 *
 * @author Teacher
 */
public interface LoginService extends Service<CurrentUserModel> {
    boolean checkExistUsers();
    boolean checkUser(CurrentUserModel currentUser);
}
