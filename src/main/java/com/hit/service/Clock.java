package com.hit.service;

import java.util.concurrent.TimeUnit;

public class Clock implements Runnable {

    long year;
    long month;
    long day;
    long hour;
    long minute;
    long second;

    public void start() {
        new Thread(this).start();
    }

    public String getTime(){
        this.day = TimeUnit.SECONDS.toDays(this.second);
        this.hour = TimeUnit.SECONDS.toHours(this.second);
        this.minute = TimeUnit.SECONDS.toMinutes(this.minute);
        this.month = this.day / 30;
        this.year = this.day / 365;

        return String.valueOf(this);
    }

    @Override
    public String toString() {
        return year + ":" + month + ":" + day + ":" + hour + ":" + minute + ":" + second ;
    }

    @Override
    public void run() {
        year = 0;
        month = 0;
        day = 0;
        hour = 0;
        minute = 0;
        second = 0;
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            second++;
        }
    }
}