/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.FirstStepModel;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.view.user.FirstStepForm;
import java.awt.Color;
import javax.swing.WindowConstants;

/**
 *
 * @author Teacher
 */
public class FirstStepFormController {

    private final FirstStepForm firstStepForm;
    private FirstStepModel firstStepModel;

    public FirstStepFormController(FirstStepForm firstStepForm,FirstStepModel firstStepModel) {
        this.firstStepForm = firstStepForm;
        this.firstStepModel = firstStepModel;
        initializeController();
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

    public boolean checkPassword() {
        boolean check = String.valueOf(firstStepForm.getPasswordTextField().getPassword()).equals(String.valueOf(firstStepForm.getPassMatchTextField().getPassword()));
        if (check) {
            firstStepForm.getCheckLabel().setForeground(Color.BLACK);
            firstStepForm.getCheckLabel().setText(Internationalization.getInstance().getLable("userformcontroller.password.match"));
        } else {
            firstStepForm.getCheckLabel().setForeground(Color.RED);
            firstStepForm.getCheckLabel().setText(Internationalization.getInstance().getLable("userformcontroller.password.dont.match"));
        }
        return check;
    }

    private void initializeController() {
        firstStepForm.getPassMatchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passMatchTextFieldKeyReleased();
            }
        });
        firstStepForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
    }

    private void passMatchTextFieldKeyReleased() {
        checkPassword();
    }

}
