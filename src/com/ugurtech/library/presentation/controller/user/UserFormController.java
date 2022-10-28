/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.user;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.person.PersonForm;
import com.ugurtech.library.presentation.view.user.UserForm;
import com.ugurtech.library.presentation.view.user.UserSearchForm;
import com.ugurtech.library.presentation.view.usertype.UserTypeForm;
import com.ugurtech.library.application.service.country.CountryService;
import com.ugurtech.library.application.service.country.CountryServiceImpl;
import com.ugurtech.library.application.service.language.LanguageService;
import com.ugurtech.library.application.service.language.LanguageServiceImpl;
import com.ugurtech.library.application.service.person.PersonService;
import com.ugurtech.library.application.service.person.PersonServiceImpl;
import com.ugurtech.library.application.service.usertype.UserTypeService;
import com.ugurtech.library.application.service.usertype.UserTypeServiceImpl;
import com.ugurtech.library.dataaccesslayer.country.CountryDaoImpl;
import com.ugurtech.library.dataaccesslayer.language.LanguageDaoImpl;
import com.ugurtech.library.dataaccesslayer.person.PersonDaoImpl;
import com.ugurtech.library.dataaccesslayer.usertype.UserTypeDaoImpl;
import com.ugurtech.library.model.PersonModel;
import com.ugurtech.library.model.UserModel;
import com.ugurtech.library.model.responsmodels.CountryModel;
import com.ugurtech.library.model.responsmodels.LanguageModel;
import com.ugurtech.library.model.responsmodels.UserTypeModel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 *
 * @author ugur
 *
 */
public final class UserFormController extends UserController implements Initialize {

    private final UserForm userForm;
    private UserModel userModel;
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
        setLanguage();
        fillAllUserTypeToComboBox();
        fillAllCountryToComboBox();
        fillAllLanguageToComboBox();
        fillAllPersonToComboBox();
    }

    private void fillAllLanguageToComboBox() {
        languageService.getAll().forEach(languageModel -> {
            userForm.getComboBoxLanguage().addItem(languageModel);
        });
    }

    private void fillAllPersonToComboBox() {
        personService.getAll().forEach(personModel -> {
            userForm.getComboBoxUser().addItem(personModel);
        });
    }

    private void fillAllCountryToComboBox() {
        countryService.getAll().forEach(countryModel -> {
            userForm.getComboBoxCountry().addItem(countryModel);
        });
    }

    private void fillAllUserTypeToComboBox() {
        userTypeService.getAll().forEach(userTypeModel -> {
            userForm.getComboBoxUserType().addItem(userTypeModel);
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
            MainForm.INSTANCE.addDesktopPane(PersonForm.INSTANCE);
        });
        userForm.getButtonAddUserType().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.INSTANCE.addDesktopPane(UserTypeForm.INSTANCE);
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
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checkPassword();
            }
        });

        userForm.getComboBoxUser().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                userForm.getComboBoxUser().removeAllItems();
                fillAllPersonToComboBox();
            }
        });

        userForm.getComboBoxUserType().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                userForm.getComboBoxUserType().removeAllItems();
                fillAllUserTypeToComboBox();
            }
        });

        userForm.getComboBoxUser().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //personComboBoxKeyReleased(evt);
            }
        });
        userForm.getComboBoxUserType().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //userTypeComboBoxKeyReleased(evt);
            }
        });
    }

    private void save() {
        if (checkFields()) {
            if (Objects.isNull(userModel)) {
                add(formToModel(new UserModel()));
            } else {
                update(formToModel(userModel));
                userForm.dispose();
            }
            clearTextField();
            UserSearchForm.INSTANCE.getUserSearchFormController().search();
        }
    }

    private void cancel() {
        userForm.dispose();
        clearTextField();
    }

    public void clearTextField() {
        userForm.getComboBoxUser().setSelectedItem(null);
        userForm.getComboBoxUserType().setSelectedItem(null);
        userForm.getComboBoxCountry().setSelectedItem(null);
        userForm.getComboBoxLanguage().setSelectedItem(null);
        userForm.getTextFieldUserName().setText(null);
        userForm.getTextFieldSession().setText(null);
        userForm.getTextFieldPassword().setText(null);
        userForm.getTextFieldRepeatPassword().setText(null);
        userForm.getLabelInformUser().setText(null);
        userModel = null;
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

    private boolean checkFields() {
        return userForm.getComboBoxUserType().getSelectedItem() != null && userForm.getComboBoxUser().getSelectedItem() != null
                && userForm.getTextFieldPassword().getPassword() != null && userForm.getTextFieldUserName().getText() != null;
    }

    public UserModel formToModel(UserModel userModel) {
        userModel.setCountryModel((CountryModel) userForm.getComboBoxCountry().getSelectedItem());
        userModel.setLanguageModel((LanguageModel) userForm.getComboBoxLanguage().getSelectedItem());
        userModel.setUserTypeModel((UserTypeModel) userForm.getComboBoxUserType().getSelectedItem());
        userModel.setPersonModel((PersonModel) userForm.getComboBoxUser().getSelectedItem());
        userModel.setUserName(userForm.getTextFieldUserName().getText());
        userModel.setUserPassword(String.copyValueOf(userForm.getTextFieldPassword().getPassword()));
        userModel.setSessionTime(Integer.parseInt(userForm.getTextFieldSession().getText()));
        return userModel;
    }

    public void modelToForm(UserModel userModel) {
        userForm.getComboBoxUserType().setSelectedItem(userModel.getUserTypeModel());
        userForm.getComboBoxUser().setSelectedItem(userModel.getPersonModel());
        userForm.getComboBoxCountry().setSelectedItem(userModel.getCountryModel());
        userForm.getComboBoxLanguage().setSelectedItem(userModel.getLanguageModel());
        userForm.getTextFieldPassword().setText(userModel.getUserPassword());
        userForm.getTextFieldSession().setText(String.valueOf(userModel.getSessionTime()));
        userForm.getTextFieldUserName().setText(userModel.getUserName());
        this.userModel = userModel;
    }

    private void setLanguage() {
        userForm.setTitle(setLanguage("userform.title"));
        userForm.getLabelCountry().setText(setLanguage("userform.label.country"));
        userForm.getLabelLanguage().setText(setLanguage("userform.label.language"));
        userForm.getLabelPassword().setText(setLanguage("userform.label.password"));
        userForm.getLabelRepeatPassword().setText(setLanguage("userform.label.repeatpassword"));
        userForm.getLabelSessionTime().setText(setLanguage("userform.label.sessiontime"));
        userForm.getLabelUser().setText(setLanguage("userform.label.user"));
        userForm.getLabelUserName().setText(setLanguage("userform.label.username"));
        userForm.getLabelUserType().setText(setLanguage("userform.label.usertype"));
        userForm.getLabelMinute().setText(setLanguage("userform.label.minute"));
        userForm.getButtonSave().setText(setLanguage("form.button.save"));
        userForm.getButtonCancel().setText(setLanguage("form.button.cancel")); 
    }
}
