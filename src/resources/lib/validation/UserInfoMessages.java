/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.lib.validation;

import resources.lib.localization.Internationalization;
import java.awt.Color;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ugur
 * 
 */
public class UserInfoMessages {

    private static UserInfoMessages validationOperration;

    private final String HEADER = "userinfomessage.message.information";

    public static UserInfoMessages getInstance() {
        return validationOperration == null ? validationOperration = new UserInfoMessages() : validationOperration;

    }
    private UserInfoMessages() {

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
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, 
                new String[]{Internationalization.setLanguage("swing.approve.yes"), 
                    Internationalization.setLanguage("swing.approve.no")}, "default");

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
