/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Lokman Ugur
 *
 */
public class Internationalization {

    public static final Internationalization INSTANCE = new Internationalization();
    private static final String BASE_NAME = "resources/localization/MessagesBundle";
    private Locale languageCountry;
    private final ResourceBundle messages;
    

    private Internationalization() {
       // setLocaleCountry("en", "US");
        if (languageCountry == null) {
            languageCountry = Locale.getDefault();
        } else {}
        messages = ResourceBundle.getBundle(BASE_NAME, languageCountry);
    }

    public String getLable(String label) {
        return messages.getString(label);
    }

    public void setLocaleCountry(String language, String country) {
        this.languageCountry = new Locale(language, country);
    }
}
