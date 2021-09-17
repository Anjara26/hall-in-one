package com.example.hallinonesport.tools;

public class QueryStr {
    public static final String CREATETABLEEQUIPEMENT = "CREATE TABLE equipment (" +
            "   equipment_id INTEGER PRIMARY KEY," +
            "   name TEXT," +
            "   image INTEGER," +
            "   is_selected NUMERIC" +
            ");";

    public static  final String CREATETABLETRAIN = "CREATE TABLE train (" +
            "    train_id INTEGER PRIMARY KEY," +
            "    type TEXT," +
            "    title TEXT," +
            "    description TEXT," +
            "    duration INTEGER," +
            "    image_icon INTEGER," +
            "    image INTEGER," +
            "    video INTEGER" +
            ");";

    public static  final String CREATETABLEACCOMPLISHMENT = "CREATE TABLE accomplishment (" +
            "    accomplishment_id INTEGER PRIMARY KEY," +
            "    train_id INTEGER," +
            "    date TEXT," +
            "    duration INTEGER," +
            "    FOREIGN KEY (train_id)" +
            "        REFERENCES train (train_id)" +
            "            ON DELETE CASCADE" +
            "            ON UPDATE NO ACTION" +
            ");";
}
