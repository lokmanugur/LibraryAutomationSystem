/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.application.lib.date;

import com.ugurtech.library.presentation.view.main.MainForm;
import java.text.SimpleDateFormat;

/**
 *
 * @author Teacher
 */
public final class SessionTimeCounter extends Thread {

    private static SessionTimeCounter INSTANCE;
    private SimpleDateFormat simpleDateFormat;
    private long sessionTime;
    private long startTime;
    private long currentTime;
    private static boolean loginWin = false;
    private String time;
    private String date;
    private static final int SECOND = 1000;
    private static final int MINUTE = 60;

    public static SessionTimeCounter getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new SessionTimeCounter();
        } else {
            return INSTANCE;
        }
    }

    private SessionTimeCounter() {
        this.startTime = System.currentTimeMillis();
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (!SessionTimeCounter.currentThread().isInterrupted()) {
            try {
                currentTime = System.currentTimeMillis();
                date = simpleDateFormat.format(currentTime);
                String str[] = date.split(" ");
                MainForm.getInstance().getDateLabel().setText(str[0]);
                MainForm.getInstance().getTimeLabel().setText(str[1]);
                SessionTimeCounter.sleep(1000);
                if (currentTime - startTime >= sessionTime && !loginWin) {
                    MainForm.getInstance().returnLoginForm();
                }
            } catch (InterruptedException ex) {
                SessionTimeCounter.currentThread().interrupt();
            }
        }
    }

    public void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    public void setSessionTime(long sessionTime) {
        this.sessionTime = sessionTime * SECOND * MINUTE;
    }

    public void setLoginWin(boolean loginWin) {
        SessionTimeCounter.loginWin = loginWin;
    }

    public void setSimpleDateFormat(String string) {
        if (this.simpleDateFormat == null) {
            this.simpleDateFormat = new SimpleDateFormat(string);
            this.start();
        } else {
            this.simpleDateFormat.applyPattern(string);
        }
    }
    
}
