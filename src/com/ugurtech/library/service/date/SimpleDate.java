/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.date;

import com.ugurtech.library.view.MainForm;
import java.text.SimpleDateFormat;

/**
 *
 * @author Teacher
 */
public final class SimpleDate extends Thread {

    private static SimpleDate INSTANCE;
    private SimpleDateFormat simpleDateFormat;
    private long sessionTime;
    private long startTime;
    private long currentTime;
    private static boolean loginWin = false;
    private String time;
    private String date;
    private static final int second = 1000;
    private static final int minute = 60;

    public static SimpleDate getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new SimpleDate();
        } else {
            return INSTANCE;
        }
    }

    private SimpleDate() {
        this.startTime = System.currentTimeMillis();
        this.currentTime = System.currentTimeMillis();

    }

    @Override
    public void run() {
        while (!SimpleDate.currentThread().isInterrupted()) {
            try {
                currentTime = System.currentTimeMillis();
                date = simpleDateFormat.format(currentTime);
                String str[] = date.split(" ");
                MainForm.getInstance().getDateLabel().setText(str[0]);
                MainForm.getInstance().getTimeLabel().setText(str[1]);
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
        this.sessionTime = sessionTime * second * minute;
    }

    public void setLoginWin(boolean loginWin) {
        SimpleDate.loginWin = loginWin;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String longToDate(long value) {
        return simpleDateFormat.format(value);
    }

    public void setSimpleDateFormat(String simpleDateFormat) {
        if (this.simpleDateFormat == null) {
            this.simpleDateFormat = new SimpleDateFormat(simpleDateFormat);
            this.start();
        } else {
            this.simpleDateFormat.applyPattern(simpleDateFormat);
        }
    }
}
