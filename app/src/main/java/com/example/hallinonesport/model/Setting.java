package com.example.hallinonesport.model;

import java.io.Serializable;

public class Setting implements Serializable {

    private static Setting instance = null;

    private Integer gender;
    private boolean weightgain;
    private boolean weightloss;
    private boolean notification;
    private boolean darkmode;

    public Setting(int gender, boolean weightgain, boolean weightloss, boolean notification, boolean darkmode) {
        this.gender = gender;
        this.weightgain = weightgain;
        this.weightloss = weightloss;
        this.notification = notification;
        this.darkmode = darkmode;
    }

    public static Setting getInstance() {
        return instance;
    }

    public static void setInstance(Setting instance) {
        Setting.instance = instance;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isWeightgain() {
        return weightgain;
    }

    public void setWeightgain(boolean weightgain) {
        this.weightgain = weightgain;
    }

    public boolean isWeightloss() {
        return weightloss;
    }

    public void setWeightloss(boolean weightloss) {
        this.weightloss = weightloss;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public boolean isDarkmode() {
        return darkmode;
    }

    public void setDarkmode(boolean darkmode) {
        this.darkmode = darkmode;
    }
}
