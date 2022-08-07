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

/**
 *
 * @author ugur
 *
 */
public class LoginFormController extends AbstractController {

    private final LoginForm loginForm;
    private final LoginService loginService;
    private final CurrentUserModel currentUserModel;
    private final SimpleDate simpleDate;

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

    public void userLoginChecked() {
        currentUserModel.setUserName(loginForm.getUserNameField().getText());
        currentUserModel.setUserPassword(String.valueOf(loginForm.getUserPaswordField().getPassword()));
        if (loginService.checkUser(currentUserModel)) {
            Internationalization.getInstance().setLocaleCountry(currentUserModel.getLanguage(), currentUserModel.getRegion());
            initView();
            setLanguage();
            loginForm.getInfolabel().setText("");
            MainForm.getInstance().getUserLabel().setText(currentUserModel.getFirstName() + " " + currentUserModel.getLastName() + " ");
            MainForm.getInstance().setVisible(true);
            simpleDate.setSimpleDateFormat(setLanguage("simple.date.format"));
            loginForm.setVisible(false);
            loginForm.getUserNameField().setText("");
            loginForm.getUserPaswordField().setText("");
            simpleDate.setLoginWin(false);
            simpleDate.setSessionTime(currentUserModel.getSessionTime());
            simpleDate.setTimeStart();
        } else {
            loginForm.getInfolabel().setText(setLanguage("loginform.infolabel"));
        }

    }

    public void closeButtonClicked() {
        simpleDate.interrupt();
        loginForm.dispose();
        MainForm.getInstance().dispose();
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

    @Override
    void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
