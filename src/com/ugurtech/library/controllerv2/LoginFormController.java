/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.modelv2.requestmodels.FirstStepModel;
import com.ugurtech.library.view.LoginForm;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.persistancev2.login.LoginDaoImpl;
import com.ugurtech.library.service.date.SimpleDate;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.service.login.LoginService;
import com.ugurtech.library.service.login.LoginServiceImpl;
import com.ugurtech.library.view.user.FirstStepForm;

/**
 *
 * @author ugur
 *
 */
public class LoginFormController {

    private final LoginForm loginForm;
    private final LoginService loginService;
    private final CurrentUserModel currentUserModel;

    public LoginFormController(LoginForm loginForm, CurrentUserModel currentUserModel) {
        this.currentUserModel = currentUserModel;
        loginService = new LoginServiceImpl(new LoginDaoImpl());
        this.loginForm = loginForm;
        initView();
        initController();
        firstStep();
    }

    public void userEnter() {
        currentUserModel.setUserName(loginForm.getUserNameField().getText());
        currentUserModel.setUserPassword(String.valueOf(loginForm.getUserPaswordField().getPassword()));
        if (loginService.checkUser(currentUserModel)) {
            loginForm.getInfolabel().setText("");
            MainForm.getInstance().getUserLabel().setText(currentUserModel.getFirstName() + " " + currentUserModel.getLastName());
            MainForm.getInstance().setVisible(true);
            loginForm.setVisible(false);
            loginForm.getUserNameField().setText("");
            loginForm.getUserPaswordField().setText("");
            SimpleDate.getInstance().setLoginWin(false);
            SimpleDate.getInstance().setSessionTime(currentUserModel.getSessionTime());
            SimpleDate.getInstance().setTimeStart();
        } else {
            loginForm.getInfolabel().setText(Internationalization.getInstance().getLable("loginform.infolabel"));
        }
    }

    public void loginExit() {
        SimpleDate.getInstance().interrupt();
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
        if(loginService.checkExistUsers()){
            loginForm.setVisible(true);}
        else{
            new FirstStepFormController(new FirstStepForm(), new FirstStepModel()).getClass();
        }
    }
}
