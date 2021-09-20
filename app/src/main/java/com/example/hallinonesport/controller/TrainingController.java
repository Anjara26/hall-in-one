package com.example.hallinonesport.controller;

import android.content.Context;

import com.example.hallinonesport.model.LocaleDbAccess;
import com.example.hallinonesport.model.Training;

import java.util.List;

public final class TrainingController {
    private static TrainingController instance = null;
    private LocaleDbAccess db;

    private TrainingController(Context context) {
        super();
        this.db = new LocaleDbAccess(context);
    }

    public static final TrainingController getInstance(Context context) {
        if(TrainingController.instance == null) {
            TrainingController.instance = new TrainingController(context);
        }
        return TrainingController.instance;
    }

    public List<Training> getListTrain() {
        return db.getTrainings();
    }

    public Training getTrainingById(int id) {
        return db.getTrainingById(id);
    }
}
