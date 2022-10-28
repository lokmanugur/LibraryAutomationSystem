/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.login;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.firststep.FirstStepFormController;
import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.model.requestmodels.FirstStepModel;
import com.ugurtech.library.presentation.view.login.LoginForm;
import com.ugurtech.library.dataaccesslayer.login.LoginDaoImpl;
import com.ugurtech.library.application.lib.date.SessionTimeCounter;
import com.ugurtech.library.application.lib.localization.Internationalization;
import com.ugurtech.library.application.service.login.LoginService;
import com.ugurtech.library.application.service.login.LoginServiceImpl;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.user.FirstStepForm;

/**
 *
 * @author ugur
 *
 */
public class LoginFormController extends AbstractController implements Initialize{

    private final LoginForm loginForm;
    private final LoginService loginService;
    private final CurrentUserModel currentUserModel;
    private final SessionTimeCounter sessionTimeCounter;

    public LoginFormController(LoginForm loginForm, CurrentUserModel currentUserModel) {
        this.currentUserModel = currentUserModel;
        loginService = new LoginServiceImpl(new LoginDaoImpl());
        this.loginForm = loginForm;
        Internationalization.getInstance().setLocaleCountry(null, null);
        sessionTimeCounter = SessionTimeCounter.getInstance();
        initView();
        initController();
        firstStep();
    }

    public void userLoginChecked() {
        currentUserModel.setUserName(loginForm.getUserNameField().getText());
        currentUserModel.setUserPassword(String.valueOf(loginForm.getUserPaswordField().getPassword()));
        if (loginService.checkUser(currentUserModel)) {
            Internationalization.getInstance().setLocaleCountry(currentUserModel.getLanguage(), currentUserModel.getRegion());
            initView();
            setLanguage();
            loginForm.getInfolabel().setText("");
            MainForm.INSTANCE.getUserLabel().setText(currentUserModel.getFirstName() + " " + currentUserModel.getLastName() + " ");
            MainForm.INSTANCE.setVisible(true);
            sessionTimeCounter.setSimpleDateFormat(setLanguage("simple.date.format"));
            loginForm.setVisible(false);
            loginForm.getUserNameField().setText("");
            loginForm.getUserPaswordField().setText("");
            sessionTimeCounter.setLoginWin(false);
            sessionTimeCounter.setSessionTime(currentUserModel.getSessionTime());
            sessionTimeCounter.setStartTime();
        } else {
            loginForm.getInfolabel().setText(setLanguage("loginform.infolabel"));
        }

    }

    public void closeButtonClicked() {
        sessionTimeCounter.interrupt();
        loginForm.dispose();
        MainForm.INSTANCE.dispose();
    }

    @Override
    public final void initView() {
    }

    private void textFieldKeyReleased(java.awt.event.KeyEvent evt) {
        loginForm.getInfolabel().setText("");
        if (evt.getKeyCode() == 10) {
            userLoginChecked();
        }
    }

    @Override
    public final void initController() {
        loginForm.getUserPaswordField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });

        loginForm.getCloseButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonClicked();
            }
        });
        loginForm.getLoginButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            userLoginChecked();
        });

        loginForm.getUserNameField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldKeyReleased(evt);
            }
        });
    }

    private void firstStep() {
        if (loginService.checkExistUsers()) {
            loginForm.setVisible(true);
        } else {
            new FirstStepFormController(new FirstStepForm(), new FirstStepModel()).getClass();
        }
    }

    private void setLanguage() {
        loginForm.getLoginButton().setText(setLanguage("loginform.button"));
        loginForm.getUserNameLable().setText(setLanguage("loginform.usernamelabel"));
        loginForm.getPasswordLable().setText(setLanguage("loginform.passwordlabel"));
    }

}
