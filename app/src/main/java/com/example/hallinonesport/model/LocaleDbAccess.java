package com.example.hallinonesport.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hallinonesport.tools.MySQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class LocaleDbAccess {
    private String dbName = "hallInOne.sqlite";
    private Integer dbVersion = 1;
    private MySQLiteOpenHelper dbAccess;
    private SQLiteDatabase database;

    public LocaleDbAccess(Context context) {
        this.dbAccess = new MySQLiteOpenHelper(context, this.dbName, null, this.dbVersion);
    }

    /**
     *  get all equipments in database
     * @return equipments
     */
    public List<Equipment> getEquipments() {
        this.database = this.dbAccess.getReadableDatabase();
        List<Equipment> equipments = new ArrayList<>();

        String sql = "SELECT * FROM equipment ORDER BY name;";
        Cursor cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Equipment equipment = new Equipment()
                        .setId(cursor.getInt(0))
                        .setname(cursor.getString(1))
                        .setImage(cursor.getString(2))
                        .setSelected(cursor.getInt(3));
                equipments.add(equipment);
                cursor.moveToNext();
            }
        }

        cursor.close();
        this.database.close();

        return  equipments;
    }

    public List<Training> getTrainings () {
        this.database = this.dbAccess.getReadableDatabase();
        List<Training> trainings = new ArrayList<>();
        String sql = "SELECT * FROM train;";
        Cursor cursor = database.rawQuery(sql, null);
        
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Training training = new Training()
                        .setId(cursor.getInt(0))
                        .setName(cursor.getString(4))
                        .setDescription(cursor.getString(5))
                        .setDuration(cursor.getFloat(6))
                        .setImageIcon(cursor.getString(7))
                        .setImage(cursor.getString(8))
                        .setVideo(cursor.getString(9));
                cursor.moveToNext();
                trainings.add(training);
            }
        }

        this.dbAccess.close();
        cursor.close();
        return trainings;
    }

    public Training getTrainingById (int id) {
        this.database = this.dbAccess.getReadableDatabase();
        Training training = new Training();
        String sql = "SELECT * FROM train WHERE train_id = " +id;
        Cursor cursor = this.database.rawQuery(sql, null);

        if(cursor.moveToFirst()) {
            training = training.setId(cursor.getInt(0))
                    .setName(cursor.getString(4))
                    .setDescription(cursor.getString(5))
                    .setDuration(cursor.getFloat(6))
                    .setImageIcon(cursor.getString(7))
                    .setImage(cursor.getString(8))
                    .setVideo(cursor.getString(9));
        }

        return training;
    }

    public void updateEquipmentSelected (int id, boolean isSelected) {
        this.database = this.dbAccess.getWritableDatabase();
        int selected = isSelected ? 1 : 0;
        String sql = "UPDATE equipment SET is_selected = " + selected + " WHERE equipment_id = " + id;
        this.database.execSQL(sql);
    }
}
