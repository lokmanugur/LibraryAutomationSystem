/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.view;

import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lokman Ugur
 */
public class MainFrame extends JFrame {

    private JInternalFrame[] allFrame;
    private JDesktopPane desktopPane;

    public void addDesktopPane(JInternalFrame jInternalFrame) {
        allFrame = desktopPane.getAllFrames();
        if (!Arrays.asList(allFrame).contains(jInternalFrame)) {
            desktopPane.add(jInternalFrame);
        } else {
            try {
                jInternalFrame.setSelected(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "JInternalFrame Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jInternalFrame.setVisible(true);
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

}
