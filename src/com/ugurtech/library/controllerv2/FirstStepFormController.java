/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.CountryModel;
import com.ugurtech.library.modelv2.FirstStepModel;
import com.ugurtech.library.modelv2.LanguageModel;
import com.ugurtech.library.persistancev2.country.CountryDaoImpl;
import com.ugurtech.library.persistancev2.language.LanguageDaoImpl;
import com.ugurtech.library.service.country.CountryService;
import com.ugurtech.library.service.country.CountryServiceImpl;
import com.ugurtech.library.service.language.LanguageService;
import com.ugurtech.library.service.language.LanguageServiceImpl;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.view.user.FirstStepForm;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.WindowConstants;

/**
 *
 * @author Teacher
 */
public class FirstStepFormController {

    private final FirstStepForm firstStepForm;
    private FirstStepModel firstStepModel;
    private final CountryService countryService = new CountryServiceImpl(new CountryDaoImpl());
    private final LanguageService languageService = new LanguageServiceImpl(new LanguageDaoImpl());

    public FirstStepFormController(FirstStepForm firstStepForm, FirstStepModel firstStepModel) {
        this.firstStepForm = firstStepForm;
        this.firstStepModel = firstStepModel;
        initView();
        initController();
    }

    public FirstStepForm getFirstStepForm() {
        return firstStepForm;
    }

    public FirstStepModel getFirstStepModel() {
        return firstStepModel;
    }

    public void setFirstStepModel(FirstStepModel firstStepModel) {
        this.firstStepModel = firstStepModel;
    }

    public void checkPassword() {
        boolean check = String.valueOf(firstStepForm.getPasswordTextField().getPassword()).equals(String.valueOf(firstStepForm.getPassMatchTextField().getPassword()));
        if (check) {
            firstStepForm.getCheckLabel().setForeground(Color.BLACK);
            firstStepForm.getCheckLabel().setText(Internationalization.getInstance().getLable("userformcontroller.password.match"));
            firstStepForm.getSaveButton().setEnabled(true);
        } else {
            firstStepForm.getCheckLabel().setForeground(Color.RED);
            firstStepForm.getCheckLabel().setText(Internationalization.getInstance().getLable("userformcontroller.password.dont.match"));
            firstStepForm.getSaveButton().setEnabled(false);
        }
    }

    private void initController() {
        firstStepForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        firstStepForm.getPassMatchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checkPassword();
            }
        });

        firstStepForm.getPasswordTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (!String.valueOf(firstStepForm.getPassMatchTextField().getPassword()).equals("")) {
                    checkPassword();
                }
            }
        });
        
        firstStepForm.getCountryComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstStepModel.getUserModel().setCountryModel((CountryModel)firstStepForm.getCountryComboBox().getSelectedItem());
            }
        });

        firstStepForm.getLanguageComboBox().addActionListener((java.awt.event.ActionEvent evt) -> {
            LanguageModel language = (LanguageModel) firstStepForm.getLanguageComboBox().getSelectedItem();
            System.out.println(language.getLanguageid());
            // firstStepModel.getUserModel().setLanguageModel((LanguageModel)firstStepForm.getLanguageComboBox().getSelectedItem());
        });
    }

    private void initView() {
        for (CountryModel countryModel : countryService.getAll()) {
            firstStepForm.getCountryComboBox().addItem(countryModel);
        }
        for (LanguageModel languageModel : languageService.getAll()) {
            firstStepForm.getLanguageComboBox().addItem(languageModel);
        }
        firstStepForm.getSaveButton().setEnabled(false);
        firstStepForm.getUserTypeComboBox().addItem("");
    }

}
