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

    private static Internationalization INSTANCE;
    private static final String BASE_NAME = "resources/localization/MessagesBundle";
    private Locale languageCountry;
    private ResourceBundle messages;

    public static Internationalization getInstance() {

        if (INSTANCE == null) {
            return INSTANCE = new Internationalization();
        } else {
            return INSTANCE;
        }
    }

    private Internationalization() {     }

    public String getLable(String label) {
        return messages.getString(label);
    }

    public void setLocaleCountry(String language, String country) {
        if (language == null || country == null) {
            languageCountry = Locale.getDefault();
        } else {
            this.languageCountry = new Locale(language, country);
        }
        messages = ResourceBundle.getBundle(BASE_NAME, languageCountry);
        System.out.println(languageCountry.getCountry() + " " + languageCountry.getLanguage());
    }
}
