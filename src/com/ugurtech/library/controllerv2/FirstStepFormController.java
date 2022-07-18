/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.responsmodels.CountryModel;
import com.ugurtech.library.modelv2.requestmodels.FirstStepModel;
import com.ugurtech.library.modelv2.responsmodels.LanguageModel;
import com.ugurtech.library.modelv2.responsmodels.UserTypeModel;
import com.ugurtech.library.persistancev2.country.CountryDaoImpl;
import com.ugurtech.library.persistancev2.firststep.FirstStepDaoImpl;
import com.ugurtech.library.persistancev2.language.LanguageDaoImpl;
import com.ugurtech.library.persistancev2.usertype.UserTypeDaoImpl;
import com.ugurtech.library.service.country.CountryService;
import com.ugurtech.library.service.country.CountryServiceImpl;
import com.ugurtech.library.service.firstStep.FirstStepService;
import com.ugurtech.library.service.firstStep.FirstStepServiceImpl;
import com.ugurtech.library.service.language.LanguageService;
import com.ugurtech.library.service.language.LanguageServiceImpl;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.service.usertype.UserTypeService;
import com.ugurtech.library.service.usertype.UserTypeServiceImpl;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.view.user.FirstStepForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
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
    private final UserTypeService userTypeService = new UserTypeServiceImpl(new UserTypeDaoImpl());
    private final FirstStepService firstStepService = new FirstStepServiceImpl(new FirstStepDaoImpl());
    private boolean saveFirstUserFlag;

    public FirstStepFormController(FirstStepForm firstStepForm, FirstStepModel firstStepModel) {
        this.saveFirstUserFlag = true;
        this.firstStepForm = firstStepForm;
        this.firstStepModel = firstStepModel;
        initView();
        initController();
        this.firstStepForm.setVisible(true);
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

        firstStepForm.getCountryComboBox().addActionListener((ActionEvent evt) -> {
            CountryModel country = (CountryModel) firstStepForm.getCountryComboBox().getSelectedItem();
            firstStepModel.setCountryId(country.getCountryid());
        });

        firstStepForm.getLanguageComboBox().addActionListener((ActionEvent e) -> {
            LanguageModel language = (LanguageModel) firstStepForm.getLanguageComboBox().getSelectedItem();
            firstStepModel.setLanguageId(language.getLanguageid());
        });

        firstStepForm.getUserTypeComboBox().addActionListener((ActionEvent e) -> {
            UserTypeModel userType = (UserTypeModel) firstStepForm.getUserTypeComboBox().getSelectedItem();
            firstStepModel.setUserTypeId(userType.getUserTypeId());
        });
        firstStepForm.getCancelButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            System.exit(0);

        });
        firstStepForm.getSaveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            saveFirstUser();
        });
    }

    private void initView() {
        for (UserTypeModel userTypeModel : userTypeService.getAll()) {
            firstStepForm.getUserTypeComboBox().addItem(userTypeModel);
        }

        for (CountryModel countryModel : countryService.getAll()) {
            firstStepForm.getCountryComboBox().addItem(countryModel);
        }
        for (LanguageModel languageModel : languageService.getAll()) {
            firstStepForm.getLanguageComboBox().addItem(languageModel);
        }
        firstStepForm.getSaveButton().setEnabled(false);
    }

    private void saveFirstUser() {
        
        firstStepModel.setFirstName(UserInfoMessages.getInstance().emptyField(firstStepForm.getFirstNameLabel(),firstStepForm.getFirstNameTextField().getText()));
        firstStepModel.setLastName(UserInfoMessages.getInstance().emptyField(firstStepForm.getSecondNameLabel(),firstStepForm.getSecondNameTextField().getText()));
        firstStepModel.setPhone(UserInfoMessages.getInstance().emptyField(firstStepForm.getPhoneLabel(), firstStepForm.getPhoneTextField().getText()));
        firstStepModel.setAddress(UserInfoMessages.getInstance().emptyField(firstStepForm.getAddressLabel(), firstStepForm.getAddressTextArea().getText()));
        firstStepModel.setUserName(UserInfoMessages.getInstance().emptyField(firstStepForm.getLabelUserName(), firstStepForm.getLoginNameTextField().getText()));
        firstStepModel.setPassword(UserInfoMessages.getInstance().emptyField(firstStepForm.getLabelPassword(), String.valueOf(firstStepForm.getPasswordTextField().getPassword())));
        firstStepModel.setBirtDate(UserInfoMessages.getInstance().emptyField(firstStepForm.getBirthDateLabel(), firstStepForm.getBirthDateChooser().getDate()));
        if(true) {
            
            UserInfoMessages.getInstance().showInfoMessages(Internationalization.getInstance().getLable("validation.message"));
            System.exit(0);
        }else{
            firstStepForm.getCheckLabel().setForeground(Color.RED);
            firstStepForm.getCheckLabel().setText(Internationalization.getInstance().getLable("message.for.blanck.fields"));
        }
    }

}
