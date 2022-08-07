/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.service.localization.LanguageImpl;

/**
 *
 * @author Teacher
 */
public abstract class AbstractController {
    
    abstract void initView();
    abstract void initController();
    abstract void get();
    abstract void getAll();
    void add(){}
    void update(){}
    void delete(){}

    String setLanguage(String strng){
        return LanguageImpl.setLanguage(Internationalization::setLanguage, strng);
    }
}
