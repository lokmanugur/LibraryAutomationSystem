/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.aa_presentation.controller;

import com.ugurtech.library.ab_application.af_lib.localization.Internationalization;
import com.ugurtech.library.ab_application.af_lib.localization.LanguageImpl;

/**
 *
 * @author Teacher
 */
public abstract class AbstractController {

    public String setLanguage(String strng) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, strng);
    }
}
