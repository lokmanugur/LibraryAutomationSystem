/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.date;

import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.view.MainForm;
import java.text.SimpleDateFormat;

/**
 *
 * @author Teacher
 */
public class SimpleDate extends Thread {

    private static SimpleDate simpleDate;
    private final String localDateFormat = Internationalization.getInstance().getLable("simple.date.format");
    private final String localTimeFormat = Internationalization.getInstance().getLable("simple.time.format");
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(localDateFormat);
    private final SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(localTimeFormat);
    private long startTime;
    private long sessionTime;
    private long currentTime;
    private long timeCount;
    private boolean loginWin = false;
    private String time;
    private String date;

    private SimpleDate() {
        this.startTime = System.currentTimeMillis();
        this.currentTime = System.currentTimeMillis();
    }

    public static SimpleDate getInstance() {
        if (simpleDate == null) {
            simpleDate = new SimpleDate();
            simpleDate.start();
            return simpleDate;
        } else {
            return simpleDate;
        }
    }

    @Override
    public void run() {
        while (!SimpleDate.currentThread().isInterrupted()) {
            try {
                currentTime = System.currentTimeMillis();
                time = simpleTimeFormat.format(currentTime);
                date = simpleDateFormat.format(currentTime);
                MainForm.getInstance().getDateLabel().setText(date);
                MainForm.getInstance().getTimeLabel().setText(time);
                SimpleDate.sleep(1000);
                if (currentTime - startTime >= sessionTime && !loginWin) {
                    MainForm.getInstance().returnLoginForm();
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
        this.sessionTime = sessionTime * 1000;
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
