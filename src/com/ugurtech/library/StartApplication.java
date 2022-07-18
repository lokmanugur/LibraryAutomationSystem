/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library;

import com.ugurtech.library.controllerv2.LoginFormController;
import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.view.LoginForm;
import javax.swing.*;

/**
 *
 * @author ugur
 * 
 */
public class StartApplication {
    
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog( null,ex.getMessage(), "Application Start Error", JOptionPane.ERROR_MESSAGE );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            LoginForm loginForm = LoginForm.getInstance();
            LoginFormController loginFormController = new LoginFormController(loginForm,CurrentUserModel.getInstance());

        });
    }
}
