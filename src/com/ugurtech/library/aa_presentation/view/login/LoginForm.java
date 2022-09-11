package com.ugurtech.library.aa_presentation.view.login;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;

public final class LoginForm extends JFrame {
    
    public static final LoginForm INSTANCE = new LoginForm();

    private LoginForm() {
        initComponents();
        this.getUserNameField().setText("admin");
        this.getUserPaswordField().setText("admin");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon iconBackPanel = new ImageIcon(getClass().getResource("/resources/images/back.jpg"));
        final Image imgBackPanel = iconBackPanel.getImage();
        mainPanel = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imgBackPanel, 0, 0, getWidth(),getHeight(),this);
            }};
            ImageIcon iconText2 = new ImageIcon(getClass().getResource("/resources/images/text.png"));
            final Image imgText2 = iconText2.getImage();
            passwordPanel = new javax.swing.JPanel(){
                public void paintComponent(Graphics g){
                    g.drawImage(imgText2, 0, 0, getWidth(),getHeight(),this);
                }};
                userPaswordField = new javax.swing.JPasswordField();
                ImageIcon iconText1 = new ImageIcon(getClass().getResource("/resources/images/text.png"));
                final Image imgText1 = iconText1.getImage();
                userNamePanel = new javax.swing.JPanel(){
                    public void paintComponent(Graphics g){
                        g.drawImage(imgText1, 0, 0, getWidth(),getHeight(),this);
                    }};
                    userNameField = new javax.swing.JTextField();
                    userNameLable = new javax.swing.JLabel();
                    passwordLable = new javax.swing.JLabel();
                    infolabel = new javax.swing.JLabel();
                    loginButton = new javax.swing.JButton();
                    closeButton = new javax.swing.JButton();

                    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    setUndecorated(true);
                    setSize(new java.awt.Dimension(400, 200));

                    mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

                    passwordPanel.setPreferredSize(new java.awt.Dimension(157, 37));

                    userPaswordField.setBackground(new Color(0,0,0,0));
                    userPaswordField.setBorder(null);

                    javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
                    passwordPanel.setLayout(passwordPanelLayout);
                    passwordPanelLayout.setHorizontalGroup(
                        passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(passwordPanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(userPaswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addGap(5, 5, 5))
                    );
                    passwordPanelLayout.setVerticalGroup(
                        passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(userPaswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGap(5, 5, 5))
                    );

                    userNamePanel.setPreferredSize(new java.awt.Dimension(157, 37));

                    userNameField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
                    userNameField.setBackground(new Color(0,0,0,0));
                    userNameField.setBorder(null);
                    userNameField.setPreferredSize(new java.awt.Dimension(50, 20));

                    javax.swing.GroupLayout userNamePanelLayout = new javax.swing.GroupLayout(userNamePanel);
                    userNamePanel.setLayout(userNamePanelLayout);
                    userNamePanelLayout.setHorizontalGroup(
                        userNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userNamePanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addGap(5, 5, 5))
                    );
                    userNamePanelLayout.setVerticalGroup(
                        userNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userNamePanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGap(5, 5, 5))
                    );

                    userNameLable.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
                    userNameLable.setForeground(new java.awt.Color(255, 255, 255));
                    userNameLable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    userNameLable.setText("User Name");

                    passwordLable.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
                    passwordLable.setForeground(new java.awt.Color(255, 255, 255));
                    passwordLable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    passwordLable.setText("Password");

                    infolabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
                    infolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    infolabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                    loginButton.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
                    loginButton.setForeground(new java.awt.Color(255, 255, 255));
                    loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/giris.png"))); // NOI18N
                    loginButton.setText("Login");
                    loginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                    loginButton.setBorderPainted(false);
                    loginButton.setFocusPainted(false);
                    loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                    loginButton.setRolloverEnabled(false);
                    loginButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/girisClick.png"))); // NOI18N

                    closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cikis.png"))); // NOI18N
                    closeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                    closeButton.setBorderPainted(false);
                    closeButton.setFocusPainted(false);
                    closeButton.setPreferredSize(new java.awt.Dimension(40, 40));
                    closeButton.setRolloverEnabled(false);
                    closeButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cikisClick.png"))); // NOI18N

                    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
                    mainPanel.setLayout(mainPanelLayout);
                    mainPanelLayout.setHorizontalGroup(
                        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addContainerGap(66, Short.MAX_VALUE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(passwordLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userNameLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userNamePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(infolabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(27, 27, 27)
                            .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );
                    mainPanelLayout.setVerticalGroup(
                        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userNameLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(infolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    );

                    pack();
                    setLocationRelativeTo(null);
                }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel infolabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLable;
    private javax.swing.JPanel userNamePanel;
    private javax.swing.JPasswordField userPaswordField;
    // End of variables declaration//GEN-END:variables

    public JButton getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(JButton closeButton) {
        this.closeButton = closeButton;
    }

    public JLabel getInfolabel() {
        return infolabel;
    }

    public void setInfolabel(JLabel infolabel) {
        this.infolabel = infolabel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getPasswordLable() {
        return passwordLable;
    }

    public void setPasswordLable(JLabel passwordLable) {
        this.passwordLable = passwordLable;
    }

    public JPanel getPasswordPanel() {
        return passwordPanel;
    }

    public void setPasswordPanel(JPanel passwordPanel) {
        this.passwordPanel = passwordPanel;
    }

    public JTextField getUserNameField() {
        return userNameField;
    }

    public void setUserNameField(JTextField userNameField) {
        this.userNameField = userNameField;
    }

    public JLabel getUserNameLable() {
        return userNameLable;
    }

    public void setUserNameLable(JLabel userNameLable) {
        this.userNameLable = userNameLable;
    }

    public JPanel getUserNamePanel() {
        return userNamePanel;
    }

    public void setUserNamePanel(JPanel userNamePanel) {
        this.userNamePanel = userNamePanel;
    }

    public JPasswordField getUserPaswordField() {
        return userPaswordField;
    }

    public void setUserPaswordField(JPasswordField userPaswordField) {
        this.userPaswordField = userPaswordField;
    }

}
