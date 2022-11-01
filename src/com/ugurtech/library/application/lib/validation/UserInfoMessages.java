/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.application.lib.validation;

import com.ugurtech.library.application.lib.localization.Internationalization;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ugur
 * 
 */
public class UserInfoMessages {

    private static UserInfoMessages validationOperration;
    private static final Logger logger = Logger.getLogger("LibraryAutomationSystemLog");
    private FileHandler fh = null;
    SimpleFormatter formatter;
    private final String HEADER = "userinfomessage.message.information";

    public static UserInfoMessages getInstance() {
        return validationOperration == null ? validationOperration = new UserInfoMessages() : validationOperration;

    }

    private UserInfoMessages() {
        try {
            fh = new FileHandler(Paths.get("").toAbsolutePath().toString() + "/LogDirectory/LibraryLogFile.log",true);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(UserInfoMessages.class.getName()).log(Level.SEVERE, null, ex);
        }
        formatter = new SimpleFormatter();
    }

    /**
     *
     * @param message show info massage to user
     * @param title Set Frame Title
     * @return when the message confirms method return true value else return
     * false value
     */
    public boolean showApproveMessages(String message, String title) {
        return JOptionPane.OK_OPTION == JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{Internationalization.setLanguage("swing.approve.yes"), Internationalization.setLanguage("swing.approve.no")}, "default");

    }

    public void showInfoMessages(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     *
     * @param numberOfRow indicate effected number of row
     *
     */
    public void insertMessage(int numberOfRow) {
        JOptionPane.showMessageDialog(null, numberOfRow+" "+ Internationalization.setLanguage("userinfomessage.message.insert"),Internationalization.setLanguage(HEADER), JOptionPane.INFORMATION_MESSAGE);
    }

    public void deletedMessage(int numberOfRow) {
        JOptionPane.showMessageDialog(null, numberOfRow+" "+  Internationalization.setLanguage("userinfomessage.message.delete"),Internationalization.setLanguage(HEADER), JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateMessage(int numberOfRow) {
        JOptionPane.showMessageDialog(null, numberOfRow+" "+ Internationalization.setLanguage("userinfomessage.message.update"), Internationalization.setLanguage(HEADER), JOptionPane.INFORMATION_MESSAGE);
    }
    public void insertMessage() {
        JOptionPane.showMessageDialog(null, Internationalization.setLanguage("userinfomessage.message.insert"),Internationalization.setLanguage(HEADER), JOptionPane.INFORMATION_MESSAGE);
    }

    public void deletedMessage() {
        JOptionPane.showMessageDialog(null, Internationalization.setLanguage("userinfomessage.message.delete"),Internationalization.setLanguage(HEADER), JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateMessage() {
        JOptionPane.showMessageDialog(null, Internationalization.setLanguage("userinfomessage.message.update"), Internationalization.setLanguage(HEADER), JOptionPane.INFORMATION_MESSAGE);
    }    

    public void exceptionInfoMessages(Component parentComponent, String message, String title) {
        JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.ERROR_MESSAGE);
        addLoggerFile(parentComponent, message);
    }
    
    public void exceptionInfoMessages(String className, String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        addLoggerFile(className, message);
    }

    private void addLoggerFile(Component parentComponent, String message) {
        // This block configure the logger with handler and formatter  
        logger.addHandler(fh);

        fh.setFormatter(formatter);

        // the following statement is used to log any messages  
        logger.log(Level.INFO, "{0} {1}", new Object[]{parentComponent.getClass().getName(), message});
    }
    
    private void addLoggerFile(String className, String message) {
        // This block configure the logger with handler and formatter  
        logger.addHandler(fh);

        fh.setFormatter(formatter);

        // the following statement is used to log any messages  
        logger.log(Level.SEVERE, "{0} {1}", new Object[]{className, message});
    }    

    public String emptyField(String str, JLabel... label) {
        if (!str.equals("")) {
            label[0].setForeground(Color.black);
            return str;
        } else {
            label[0].setForeground(Color.red);
            setPassMatchLabel(label[1]);
            return "";
        }
    }

    public long emptyField(Date date, JLabel... label) {
        if (date != null) {
            label[0].setForeground(Color.black);
            return date.getTime();
        } else {
            label[0].setForeground(Color.red);
            setPassMatchLabel(label[1]);
            return 0;
        }
    }

    private void setPassMatchLabel(JLabel label) {
        label.setForeground(Color.RED);
        label.setText(Internationalization.setLanguage("message.for.blanck.fields"));
    }
}
