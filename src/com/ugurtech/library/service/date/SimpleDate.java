/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.date;

import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.view.MainForm;
import java.text.SimpleDateFormat;

/**
 *
 * @author Teacher
 */
public class SimpleDate extends Thread {

    public static final SimpleDate INSTANCE = new SimpleDate();
    private final String localDateFormat = Internationalization.INSTANCE.getLable("simple.date.format");
    private final String localTimeFormat = Internationalization.INSTANCE.getLable("simple.time.format");
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(localDateFormat);
    private final SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(localTimeFormat);
    private long sessionTime;
    private long startTime;
    private long currentTime;
    private boolean loginWin = false;
    private String time;
    private String date;
    private final int second = 1000;
    private final int minute = 60;
    
    private SimpleDate() {
        this.startTime = System.currentTimeMillis();
        this.currentTime = System.currentTimeMillis();
        this.start();
    }

    @Override
    public void run() {
        while (!SimpleDate.currentThread().isInterrupted()) {
            try {
                currentTime = System.currentTimeMillis();
                time = simpleTimeFormat.format(currentTime);
                date = simpleDateFormat.format(currentTime);
                MainForm.INSTANCE.getDateLabel().setText(date);
                MainForm.INSTANCE.getTimeLabel().setText(time);
                SimpleDate.sleep(1000);
                if (currentTime - startTime >= sessionTime && !loginWin) {
                    MainForm.INSTANCE.returnLoginForm();
                }
            } catch (InterruptedException ex) {
                SimpleDate.currentThread().interrupt();
            }
        }
    }

    public void setTimeStart() {
        startTime = System.currentTimeMillis();
    }

    public void setSessionTime(long sessionTime) {
        this.sessionTime = sessionTime*second*minute;
    }

    public void setLoginWin(boolean loginWin) {
        this.loginWin = loginWin;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
    public String longToDate(long value){
        return simpleDateFormat.format(value)+" "+simpleTimeFormat.format(value);
    }
}
