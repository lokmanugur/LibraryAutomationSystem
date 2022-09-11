/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.user;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.main.MainForm;
import com.ugurtech.library.aa_presentation.view.person.PersonForm;
import com.ugurtech.library.aa_presentation.view.user.UserForm;
import com.ugurtech.library.aa_presentation.view.usertype.UserTypeForm;
import com.ugurtech.library.ab_application.service.country.CountryService;
import com.ugurtech.library.ab_application.service.country.CountryServiceImpl;
import com.ugurtech.library.ab_application.service.language.LanguageService;
import com.ugurtech.library.ab_application.service.language.LanguageServiceImpl;
import com.ugurtech.library.ab_application.service.person.PersonService;
import com.ugurtech.library.ab_application.service.person.PersonServiceImpl;
import com.ugurtech.library.ab_application.service.usertype.UserTypeService;
import com.ugurtech.library.ab_application.service.usertype.UserTypeServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.country.CountryDaoImpl;
import com.ugurtech.library.ac_dataaccesslayer.language.LanguageDaoImpl;
import com.ugurtech.library.ac_dataaccesslayer.person.PersonDaoImpl;
import com.ugurtech.library.ac_dataaccesslayer.usertype.UserTypeDaoImpl;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ugur
 *
 */
public final class UserFormController extends UserController implements Initialize {

    private final UserForm userForm;
    private final LanguageService languageService = new LanguageServiceImpl(new LanguageDaoImpl());
    private final CountryService countryService = new CountryServiceImpl(new CountryDaoImpl());
    private final UserTypeService userTypeService = new UserTypeServiceImpl(new UserTypeDaoImpl());
    private final PersonService personService = new PersonServiceImpl(new PersonDaoImpl());

    public UserFormController(UserForm userForm) {
        this.userForm = userForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        userTypeService.getAll().forEach(userTypeModel -> {
            userForm.getComboBoxUserType().addItem(userTypeModel);
        });

        countryService.getAll().forEach(countryModel -> {
            userForm.getComboBoxCountry().addItem(countryModel);
        });

        languageService.getAll().forEach(languageModel -> {
            userForm.getComboBoxLanguage().addItem(languageModel);
        });
        personService.getAll().forEach(personModel -> {
            userForm.getComboBoxUser().addItem(personModel);
        });
    }

    @Override
    public void initController() {
        userForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            save();
        });

        userForm.getButtonCancel().addActionListener((java.awt.event.ActionEvent evt) -> {
            cancel();
        });
        userForm.getButtonAddUser().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(PersonForm.INSTANCE);
        });
        userForm.getButtonAddUserType().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(UserTypeForm.INSTANCE);
        });

        userForm.getTextFieldPassword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (!String.valueOf(userForm.getTextFieldRepeatPassword().getPassword()).equals("")) {
                    checkPassword();
                }
            }
        });

        userForm.getTextFieldRepeatPassword().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checkPassword();
            }
        });

        userForm.getComboBoxUser().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                //fetch data from databese
            }
        });

        userForm.getComboBoxUserType().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                //fetch data from databese
            }
        });

        userForm.getComboBoxUser().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //personComboBoxKeyReleased(evt);
            }
        });
        userForm.getComboBoxUserType().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //userTypeComboBoxKeyReleased(evt);
            }
        });
    }

    private void save() {

    }

    private void cancel() {

    }

    public void clearTextField() {
        userForm.getComboBoxUser().removeAllItems();
        userForm.getComboBoxUserType().removeAllItems();
        userForm.getTextFieldUserName().setText(null);
        userForm.getTextFieldPassword().setText(null);
        userForm.getTextFieldRepeatPassword().setText(null);
        userForm.getLabelInformUser().setText(null);
    }

    public void checkPassword() {
        boolean check = String.valueOf(userForm.getTextFieldPassword().getPassword()).equals(String.valueOf(userForm.getTextFieldRepeatPassword().getPassword()));
        if (check) {
            userForm.getLabelInformUser().setForeground(Color.BLACK);
            userForm.getLabelInformUser().setText(setLanguage("userformcontroller.password.match"));
            userForm.getButtonSave().setEnabled(true);
        } else {
            userForm.getLabelInformUser().setForeground(Color.RED);
            userForm.getLabelInformUser().setText(setLanguage("userformcontroller.password.dont.match"));
            userForm.getButtonSave().setEnabled(false);
        }
    }

    public boolean checkFields() {
        return userForm.getComboBoxUserType().getSelectedItem() != null && userForm.getComboBoxUser().getSelectedItem() != null
                && userForm.getTextFieldPassword().getPassword() != null && userForm.getTextFieldUserName().getText() != null;
    }
}
