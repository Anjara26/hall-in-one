package com.example.hallinonesport.controller;

import android.content.Context;

import com.example.hallinonesport.model.Setting;
import com.example.hallinonesport.tools.Serializer;

import java.io.Serializable;

public class SettingController {

    private static SettingController instance = null;
    private static Setting setting;
    private static String file = "saveSetting";

    private SettingController(){ super(); }

    public static final SettingController getInstance(Context context){
        if(SettingController.instance == null){
            SettingController.instance = new SettingController();
            recupSerialize(context);

        }
        return SettingController.instance;
    }

    public void createSetting(int gender, boolean weightgain, boolean weightloss, boolean notification, boolean darkmode, Context context){
        this.setting = new Setting(gender, weightgain, weightloss, notification, darkmode);
        Serializer.serialize(file, setting, context);
    }

    private static void recupSerialize(Context context){
        setting = (Setting)Serializer.deserialize(file, context);
    }

    public Integer getGender() {
        if(setting == null){
            return null;
        }else{
            return setting.getGender();
        }
    }

    public boolean isWeightgain() {
        if(setting == null){
            return false;
        }else{
            return setting.isWeightgain();
        }
    }

    public boolean isWeightloss() {
        if(setting == null){
            return false;
        }else{
            return setting.isWeightloss();
        }
    }

    public boolean isNotification() {
        if(setting == null){
            return false;
        }else{
            return setting.isNotification();
        }
    }

    public boolean isDarkmode() {
        if(setting == null){
            return false;
        }else{
            return setting.isDarkmode();
        }
    }

}
