package com.example.hallinonesport.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {



    /**
     * Constructor
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * If database doesn't exist
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QueryStr.CREATETABLEEQUIPEMENT);
        sqLiteDatabase.execSQL(QueryStr.CREATETABLETRAIN);
        sqLiteDatabase.execSQL(QueryStr.CREATETABLEACCOMPLISHMENT);
        sqLiteDatabase.execSQL(QueryStr.INSERTEQUIPMENTS);
        sqLiteDatabase.execSQL(QueryStr.INSERTTRAINING);
    }

    /**
     * If database change
     * @param sqLiteDatabase
     * @param lastVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int lastVersion, int newVersion) {
        sqLiteDatabase.execSQL(QueryStr.DELETEALLTABLES);
        this.onCreate(sqLiteDatabase);
    }
}
