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
        this.database = this.dbAccess.getWritableDatabase();
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
}
