package com.swaglabs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtils {

    public static void main(String[] args) {
        System.out.println(getCurrentTimestamp());
    }
    public static String getCurrentTimestamp() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return dateFormat.format(date);
    }
}

