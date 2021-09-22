package com.example.hallinonesport.controller;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.hallinonesport.model.LocaleDbAccess;
import com.example.hallinonesport.model.Setting;
import com.example.hallinonesport.model.Training;

import java.util.List;

public final class TrainingController {
    private static TrainingController instance = null;
    private LocaleDbAccess db;

    private TrainingController(Context context, Setting setting) {
        super();
        this.db = new LocaleDbAccess(context);
    }

    public static final TrainingController getInstance(Context context, Setting setting) {
        if(TrainingController.instance == null) {
            TrainingController.instance = new TrainingController(context, setting);
        }
        return TrainingController.instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Training> getListTrain(SettingController setting) {
        return db.getTrainings(this.db.getSelectedIds(), setting);
    }

    public Training getTrainingById(int id) {
        return db.getTrainingById(id);
    }
}
