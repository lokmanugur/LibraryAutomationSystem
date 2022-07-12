
package com.ugurtech.library.modelv2;

/**
 *
 * @author Teacher
 */
public class FirstStepModel {
    private UserModel userModel;

    public FirstStepModel(UserModel userModel) {
        this.userModel = userModel;
    }
    
    public FirstStepModel(){}

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
    
    
}
