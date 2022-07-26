/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.modelv2.requestmodels.FirstStepModel;
import com.ugurtech.library.view.LoginForm;
import com.ugurtech.library.persistancev2.login.LoginDaoImpl;
import com.ugurtech.library.service.date.SimpleDate;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.service.login.LoginService;
import com.ugurtech.library.service.login.LoginServiceImpl;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.view.user.FirstStepForm;
import java.text.SimpleDateFormat;

/**
 *
 * @author ugur
 *
 */
public class LoginFormController {

    private final LoginForm loginForm;
    private final LoginService loginService;
    private final CurrentUserModel currentUserModel;
    private SimpleDate simpleDate;

    public LoginFormController(LoginForm loginForm, CurrentUserModel currentUserModel) {
        this.currentUserModel = currentUserModel;
        loginService = new LoginServiceImpl(new LoginDaoImpl());
        this.loginForm = loginForm;
        Internationalization.getInstance().setLocaleCountry(null, null);
        simpleDate = SimpleDate.getInstance();
        initView();
        initController();
        firstStep();
    }

    public void userEnter() {
        currentUserModel.setUserName(loginForm.getUserNameField().getText());
        currentUserModel.setUserPassword(String.valueOf(loginForm.getUserPaswordField().getPassword()));
        if (loginService.checkUser(currentUserModel)) {
            Internationalization.getInstance().setLocaleCountry(currentUserModel.getLanguage(), currentUserModel.getRegion());
            initView();
            setLanguage();
            loginForm.getInfolabel().setText("");
            MainForm.getInstance().getUserLabel().setText(currentUserModel.getFirstName() + " " + currentUserModel.getLastName()+" ");
            MainForm.getInstance().setVisible(true);
            simpleDate.setSimpleDateFormat(Internationalization.getInstance().getLable("simple.date.format"));
            loginForm.setVisible(false);
            loginForm.getUserNameField().setText("");
            loginForm.getUserPaswordField().setText("");
            simpleDate.setLoginWin(false);
            simpleDate.setSessionTime(currentUserModel.getSessionTime());
            simpleDate.setTimeStart();
        } else {
            loginForm.getInfolabel().setText(Internationalization.getInstance().getLable("loginform.infolabel"));
        }

    }

    public void loginExit() {
        simpleDate.interrupt();
        loginForm.dispose();
        MainForm.getInstance().dispose();
    }

    private void initView() {
        loginForm.getUserPaswordField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enterKey(evt);
            }
        });

        loginForm.getCloseButton().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginExit();
            }
        });
        loginForm.getLoginButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            userEnter();
        });

        loginForm.getUserNameField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enterKey(evt);
            }
        });

    }

    private void enterKey(java.awt.event.KeyEvent evt) {
        loginForm.getInfolabel().setText("");
        if (evt.getKeyCode() == 10) {
            userEnter();
        }
    }

    private void initController() {

    }

    private void firstStep() {
        if (loginService.checkExistUsers()) {
            loginForm.setVisible(true);
        } else {
            new FirstStepFormController(new FirstStepForm(), new FirstStepModel()).getClass();
        }
    }

    private void setLanguage() {
        loginForm.getLoginButton().setText(Internationalization.getInstance().getLable("loginform.button"));
        loginForm.getUserNameLable().setText(Internationalization.getInstance().getLable("loginform.usernamelabel"));
        loginForm.getPasswordLable().setText(Internationalization.getInstance().getLable("loginform.passwordlabel"));
    }
}
