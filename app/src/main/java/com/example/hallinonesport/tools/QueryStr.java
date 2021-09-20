package com.example.hallinonesport.tools;

public class QueryStr {
    public static final String CREATETABLEEQUIPEMENT = "CREATE TABLE equipment (" +
            "   equipment_id INTEGER PRIMARY KEY," +
            "   name TEXT," +
            "   image TEXT," +
            "   is_selected NUMERIC" +
            ");";

    public static  final String CREATETABLETRAIN = "CREATE TABLE train (" +
            "    train_id INTEGER PRIMARY KEY," +
            "    equipment_id INTEGER," +
            "    gender NUMERIC,"+
            "    goal TEXT," +
            "    title TEXT," +
            "    description TEXT," +
            "    duration INTEGER," +
            "    image_icon TEXT," +
            "    image TEXT," +
            "    video TEXT" +
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

    public static final String INSERTTRAINING = "INSERT INTO train (train_id, equipment_id, gender, goal, title, description, duration, image_icon, image, video) VALUES " +
            "(1, 1, 0, \"perte\", \"La résistance progressive des élastiques 1\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image1\", \"@drawable/image1\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(2, 1, 0, \"masse\", \"La résistance progressive des élastiques 2\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image2\", \"@drawable/image2\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(3, 1, 1, \"perte\", \"La résistance progressive des élastiques 3\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image3\", \"@drawable/image1\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(4, 1, 1, \"masse\", \"La résistance progressive des élastiques 4\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image4\", \"@drawable/image2\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\");";
}
