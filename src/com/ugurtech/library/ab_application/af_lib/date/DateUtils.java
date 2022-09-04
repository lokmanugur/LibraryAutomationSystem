/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.af_lib.date;

import com.ugurtech.library.ab_application.af_lib.localization.Internationalization;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class DateUtils {

    private static SimpleDateFormat simpleDateFormat;
    private static String timeFormatText;
    private static String dateFormatText;
    private static final String DEFAULT_DATE_FORMAT=Internationalization.setLanguage("simple.date.format");

    static{
       new DateUtils().getClass();
    }
    
    private DateUtils() {
        DateUtils.simpleDateFormat = new SimpleDateFormat();
        String str[]=DEFAULT_DATE_FORMAT.split(" ");
        dateFormatText = str[0];
        timeFormatText = str[1];
    }
    
    public static String longToDateForTable(long lng) {
        applyPattern(DEFAULT_DATE_FORMAT);
        return simpleDateFormat.format(lng);
    }

    public static String longToTime(long lng) {
        applyPattern(timeFormatText);
        return simpleDateFormat.format(lng);
    }

    public static String longToDate(long lng) {
        applyPattern(dateFormatText);
        return simpleDateFormat.format(lng);
    }
    
    private static void applyPattern(String pattern){
        simpleDateFormat.applyPattern(pattern);
    }
}
