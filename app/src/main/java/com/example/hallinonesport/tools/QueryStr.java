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
            "    equipment_id INTEGER," +
            "    gender NUMERIC"+
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

    public static final String DELETEALLTABLES = "DROP TABLE IF EXISTS accomplishment, train, equipment";

    public static final String INSERTEQUIPMENTS = "INSERT INTO equipment (equipment_id, name, image, is_selected) VALUES" +
            " (1, \"Bande élastique\", \"@drawable/image1\", 0)," +
            " (2, \"Poulie à tirage vertical guidée\", \"@drawable/image2\", 0)," +
            " (3, \"Vélo elliptique\", \"@drawable/image3\", 0)," +
            " (4, \"Swiss ball\", \"@drawable/image4\", 0)," +
            " (5, \"Tapis yoga\", \"@drawable/image5\", 0)," +
            " (6, \"Poids\", \"@drawable/image6\", 0)," +
            " (7, \"Stepper\", \"@drawable/image7\", 0)," +
            " (8, \"Sac de sable\", \"@drawable/image8\", 0)," +
            " (9, \"Bande élastique\", \"@drawable/image9\", 0)," +
            " (10, \"Presse cuisse\", \"@drawable/image10\", 0)," +
            " (11, \"Pince de musculation\", \"@drawable/image11\", 0)," +
            " (12, \"Haltère\", \"@drawable/image12\", 0)," +
            " (13, \"Poulies vis à vis\", \"@drawable/image13\", 0)," +
            " (14, \"Barre fixe\", \"@drawable/image14\", 0)," +
            " (15, \"Pec deck\", \"@drawable/image15\", 0)," +
            " (16, \"Tapis de marche\", \"@drawable/image16\", 0)," +
            " (17, \"Corde à sauter\", \"@drawable/image17\", 0)," +
            " (18, \"Appareil d'abdominaux\", \"@drawable/image18\", 0);";
}
