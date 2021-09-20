package com.example.hallinonesport.controller;

import android.content.Context;

import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.model.LocaleDbAccess;

import java.util.List;

public final class EquipmentController {
    private static EquipmentController instance = null;
    private LocaleDbAccess db;

    private EquipmentController(Context context) {
        super();
        this.db = new LocaleDbAccess(context);
    }

    public static final EquipmentController getInstance(Context context) {
        if(EquipmentController.instance == null) {
            EquipmentController.instance = new EquipmentController(context);
        }
        return EquipmentController.instance;
    }

    public List<Equipment> getListEquipment() {
        return db.getEquipments();
    }
}
