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
    private long endTime = 6000;
    private long currentTime;
    private long today;
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
        while (!Thread.currentThread().isInterrupted()) {
            try {
                currentTime = System.currentTimeMillis();
                today = System.currentTimeMillis();
                time = simpleTimeFormat.format(currentTime);
                date = simpleDateFormat.format(today);
                MainForm.getInstance().getDateLabel().setText(date);
                MainForm.getInstance().getTimeLabel().setText(time);
                Thread.sleep(1000);
                if (currentTime - startTime >= endTime && !loginWin) {
                    MainForm.getInstance().returnLoginForm();
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void setTimeStart() {
        startTime = System.currentTimeMillis();
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime * 1000;
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
}
