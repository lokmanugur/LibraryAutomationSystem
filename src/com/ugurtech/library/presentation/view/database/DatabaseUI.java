/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.database;

import com.ugurtech.library.application.lib.ReadXML;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class DatabaseUI extends JInternalFrame {
    ReadXML readxml = new ReadXML();
    
    private static DatabaseUI dataBaseUI;
    
    private DatabaseUI() {
       initComponents();
       setLocation(getWidth()/2,getHeight()/10);
       getReadXml();
    }
    
    
    public static DatabaseUI getInstance(){
        if(dataBaseUI==null)
            return dataBaseUI=new DatabaseUI();
        else
            return dataBaseUI;
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUrl = new javax.swing.JLabel();
        sunucuAdresi = new javax.swing.JTextField();
        labelPort = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        textFieldDBName = new javax.swing.JTextField();
        labelDBName = new javax.swing.JLabel();
        kulaniciAdi = new javax.swing.JTextField();
        labelUserName = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        sifre = new javax.swing.JPasswordField();
        kaydet = new javax.swing.JButton();
        varsayilan = new javax.swing.JButton();
        verial = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Database");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Database Bağlantı Ayarları"));

        labelUrl.setText("Sunucu Adresi:");

        labelPort.setText("Port:");

        labelDBName.setText("Database Adı:");

        labelUserName.setText("Kulanıcı Adı:");

        labelPassword.setText("Şifre:");

        kaydet.setText("Kaydet");
        kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetActionPerformed(evt);
            }
        });

        varsayilan.setText("Varsayılan");
        varsayilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varsayilanActionPerformed(evt);
            }
        });

        verial.setText("Veri Al");
        verial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUrl)
                    .addComponent(labelPort, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDBName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sifre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kulaniciAdi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldDBName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sunucuAdresi)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(verial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varsayilan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kaydet)))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUrl)
                    .addComponent(sunucuAdresi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPort)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDBName)
                    .addComponent(textFieldDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName)
                    .addComponent(kulaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(sifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kaydet)
                    .addComponent(varsayilan)
                    .addComponent(verial))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetActionPerformed
        
    }//GEN-LAST:event_kaydetActionPerformed

    private void varsayilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varsayilanActionPerformed
       getVarsayilan(); // TODO add your handling code here:
    }//GEN-LAST:event_varsayilanActionPerformed

    private void verialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verialActionPerformed
     getReadXml();  // TODO add your handling code here:
    }//GEN-LAST:event_verialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kaydet;
    private javax.swing.JTextField kulaniciAdi;
    private javax.swing.JLabel labelDBName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPort;
    private javax.swing.JLabel labelUrl;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JTextField port;
    private javax.swing.JPasswordField sifre;
    private javax.swing.JTextField sunucuAdresi;
    private javax.swing.JTextField textFieldDBName;
    private javax.swing.JButton varsayilan;
    private javax.swing.JButton verial;
    // End of variables declaration//GEN-END:variables
   
    
    
    private void getVarsayilan(){
        sunucuAdresi.setText("localhost");
        port.setText("3306");
        textFieldDBName.setText("library");
        kulaniciAdi.setText("root");
        sifre.setText("");
    }
    private void getReadXml(){
        readxml.readXML(Paths.get("").toAbsolutePath().toString() +"/src/resources/SQLite/server.xml");
        if(!readxml.rolev.isEmpty()){
            sunucuAdresi.setText(readxml.rolev.get(0));
        if(!readxml.rolev.get(0).isEmpty())
            port.setText(readxml.rolev.get(1));
        if(!readxml.rolev.get(1).isEmpty())
            textFieldDBName.setText(readxml.rolev.get(2));
        if(!readxml.rolev.get(2).isEmpty())
            kulaniciAdi.setText(readxml.rolev.get(3));
        if(!readxml.rolev.get(3).isEmpty())
            sifre.setText(readxml.rolev.get(4));
        }
    }
    private void getSaveXml(){
        readxml.serverAdress = sunucuAdresi.getText();
        readxml.port = port.getText();
        readxml.databaseName = textFieldDBName.getText();
        readxml.userName = kulaniciAdi.getText();
        readxml.password = String.valueOf(sifre.getPassword());
        try{
            readxml.saveToXML(Paths.get("").toAbsolutePath().toString() +"/src/resources/SQLite/server.xml");
        }catch (FileNotFoundException ex){
            Logger.getLogger(DatabaseUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}