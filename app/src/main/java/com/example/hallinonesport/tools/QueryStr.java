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
            "(1, 1, 0, \"perte\", \"Exercice 1\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image1\", \"@drawable/image1\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(2, 1, 0, \"masse\", \"Exercice 2\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image1\", \"@drawable/image1\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscler%20Dos%20et%20Dorsaux.mp4.mp4.mp4?alt=media\")," +
            "(3, 1, 1, \"perte\", \"Exercice 3\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.17, \"@drawable/image1\", \"@drawable/image1\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscoli%20Pettorali%20Petto%20Esercizio%20Flessioni%20Esplosive.mp4.mp4.mp4?alt=media\")," +
            "(4, 1, 1, \"masse\", \"Exercice 4\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.31, \"@drawable/image1\", \"@drawable/image1\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/NEW%20Abs%20-%20Ab%20Gym%20exercise%20(female%20_%20%20male).mp4.mp4.mp4?alt=media\")," +
            "(5, 2, 0, \"perte\", \"Exercice 5\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image2\", \"@drawable/image2\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/One%20of%20the%20best%20legs%20exercise.mp4.mp4.mp4?alt=media\")," +
            "(6, 2, 0, \"masse\", \"Exercice 6\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image2\", \"@drawable/image2\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/PREPARATION%20PHYSIQUE_%20Fentes.mp4.mp4.mp4?alt=media\")," +
            "(7, 2, 1, \"perte\", \"Exercice 7\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image2\", \"@drawable/image2\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Pectoral%20Muscles%20Exercise_%20Burpees.mp4.mp4.mp4?alt=media\")," +
            "(8, 2, 1, \"masse\", \"Exercice 8\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image2\", \"@drawable/image2\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Remo%20al%20cuello%20con%20barra%20_%20mancuernas%20Trapecio%20Hombros.mp4.mp4.mp4?alt=media\")," +
            "(9, 3, 0, \"perte\", \"Exercice 9\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image3\", \"@drawable/image3\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Side%20bends%20-%20exercises%20for%20abdomen%20-%20abdomen%20flat.mp4.mp4.mp4?alt=media\")," +
            "(10, 3, 0, \"masse\", \"Exercice 10\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.51, \"@drawable/image3\", \"@drawable/image3\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Squat%20avec%20bande%20%C3%A9lastique%20loop%20_%20Sport%20Chez%20Soi.mp4?alt=media\")," +
            "(11, 3, 1, \"perte\", \"Exercice 11\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.22, \"@drawable/image3\", \"@drawable/image3\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/pancia%20e%20fianchi%20palestra%20(addome%20alto).mp4.mp4.mp4?alt=media\")," +
            "(12, 3, 1, \"masse\", \"Exercice 12\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image3\", \"@drawable/image3\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(13, 4, 0, \"perte\", \"Exercice 13\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image4\", \"@drawable/image4\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscler%20Dos%20et%20Dorsaux.mp4.mp4.mp4?alt=media\")," +
            "(14, 4, 0, \"masse\", \"Exercice 14\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.17, \"@drawable/image4\", \"@drawable/image4\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscoli%20Pettorali%20Petto%20Esercizio%20Flessioni%20Esplosive.mp4.mp4.mp4?alt=media\")," +
            "(15, 4, 1, \"perte\", \"Exercice 15\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.31, \"@drawable/image4\", \"@drawable/image4\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/NEW%20Abs%20-%20Ab%20Gym%20exercise%20(female%20_%20%20male).mp4.mp4.mp4?alt=media\")," +
            "(16, 4, 1, \"masse\", \"Exercice 16\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image4\", \"@drawable/image4\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/One%20of%20the%20best%20legs%20exercise.mp4.mp4.mp4?alt=media\")," +
            "(17, 5, 0, \"perte\", \"Exercice 17\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image5\", \"@drawable/image5\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/PREPARATION%20PHYSIQUE_%20Fentes.mp4.mp4.mp4?alt=media\")," +
            "(18, 5, 0, \"masse\", \"Exercice 18\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image5\", \"@drawable/image5\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Pectoral%20Muscles%20Exercise_%20Burpees.mp4.mp4.mp4?alt=media\")," +
            "(19, 5, 1, \"perte\", \"Exercice 19\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image5\", \"@drawable/image5\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Remo%20al%20cuello%20con%20barra%20_%20mancuernas%20Trapecio%20Hombros.mp4.mp4.mp4?alt=media\")," +
            "(20, 5, 1, \"masse\", \"Exercice 20\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image5\", \"@drawable/image5\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Side%20bends%20-%20exercises%20for%20abdomen%20-%20abdomen%20flat.mp4.mp4.mp4?alt=media\")," +
            "(21, 6, 0, \"perte\", \"Exercice 21\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.51, \"@drawable/image6\", \"@drawable/image6\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Squat%20avec%20bande%20%C3%A9lastique%20loop%20_%20Sport%20Chez%20Soi.mp4?alt=media\")," +
            "(22, 6, 0, \"masse\", \"Exercice 22\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.22, \"@drawable/image6\", \"@drawable/image6\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/pancia%20e%20fianchi%20palestra%20(addome%20alto).mp4.mp4.mp4?alt=media\")," +
            "(23, 6, 1, \"perte\", \"Exercice 23\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image6\", \"@drawable/image6\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(24, 6, 1, \"masse\", \"Exercice 24\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image6\", \"@drawable/image6\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscler%20Dos%20et%20Dorsaux.mp4.mp4.mp4?alt=media\")," +
            "(25, 7, 0, \"perte\", \"Exercice 25\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.17, \"@drawable/image7\", \"@drawable/image7\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscoli%20Pettorali%20Petto%20Esercizio%20Flessioni%20Esplosive.mp4.mp4.mp4?alt=media\")," +
            "(26, 7, 0, \"masse\", \"Exercice 26\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.31, \"@drawable/image7\", \"@drawable/image7\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/NEW%20Abs%20-%20Ab%20Gym%20exercise%20(female%20_%20%20male).mp4.mp4.mp4?alt=media\")," +
            "(27, 7, 1, \"perte\", \"Exercice 27\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image7\", \"@drawable/image7\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/One%20of%20the%20best%20legs%20exercise.mp4.mp4.mp4?alt=media\")," +
            "(28, 7, 1, \"masse\", \"Exercice 28\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image7\", \"@drawable/image7\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/PREPARATION%20PHYSIQUE_%20Fentes.mp4.mp4.mp4?alt=media\")," +
            "(29, 8, 0, \"perte\", \"Exercice 29\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image8\", \"@drawable/image8\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Pectoral%20Muscles%20Exercise_%20Burpees.mp4.mp4.mp4?alt=media\")," +
            "(30, 8, 0, \"masse\", \"Exercice 30\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image8\", \"@drawable/image8\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Remo%20al%20cuello%20con%20barra%20_%20mancuernas%20Trapecio%20Hombros.mp4.mp4.mp4?alt=media\")," +
            "(31, 8, 1, \"perte\", \"Exercice 31\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image8\", \"@drawable/image8\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Side%20bends%20-%20exercises%20for%20abdomen%20-%20abdomen%20flat.mp4.mp4.mp4?alt=media\")," +
            "(32, 8, 1, \"masse\", \"Exercice 32\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.51, \"@drawable/image8\", \"@drawable/image8\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Squat%20avec%20bande%20%C3%A9lastique%20loop%20_%20Sport%20Chez%20Soi.mp4?alt=media\")," +
            "(33, 9, 0, \"perte\", \"Exercice 33\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.22, \"@drawable/image9\", \"@drawable/image9\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/pancia%20e%20fianchi%20palestra%20(addome%20alto).mp4.mp4.mp4?alt=media\")," +
            "(34, 9, 0, \"masse\", \"Exercice 34\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image9\", \"@drawable/image9\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(35, 9, 1, \"perte\", \"Exercice 35\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image9\", \"@drawable/image9\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscler%20Dos%20et%20Dorsaux.mp4.mp4.mp4?alt=media\")," +
            "(36, 9, 1, \"masse\", \"Exercice 36\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.17, \"@drawable/image9\", \"@drawable/image9\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscoli%20Pettorali%20Petto%20Esercizio%20Flessioni%20Esplosive.mp4.mp4.mp4?alt=media\")," +
            "(37, 10, 0, \"perte\", \"Exercice 37\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.31, \"@drawable/image10\", \"@drawable/image10\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/NEW%20Abs%20-%20Ab%20Gym%20exercise%20(female%20_%20%20male).mp4.mp4.mp4?alt=media\")," +
            "(38, 10, 0, \"masse\", \"Exercice 38\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image10\", \"@drawable/image10\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/One%20of%20the%20best%20legs%20exercise.mp4.mp4.mp4?alt=media\")," +
            "(39, 10, 1, \"perte\", \"Exercice 39\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image10\", \"@drawable/image10\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/PREPARATION%20PHYSIQUE_%20Fentes.mp4.mp4.mp4?alt=media\")," +
            "(40, 10, 1, \"masse\", \"Exercice 40\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image10\", \"@drawable/image10\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Pectoral%20Muscles%20Exercise_%20Burpees.mp4.mp4.mp4?alt=media\")," +
            "(41, 11, 0, \"perte\", \"Exercice 41\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image11\", \"@drawable/image11\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Remo%20al%20cuello%20con%20barra%20_%20mancuernas%20Trapecio%20Hombros.mp4.mp4.mp4?alt=media\")," +
            "(42, 11, 0, \"masse\", \"Exercice 42\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image11\", \"@drawable/image11\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Side%20bends%20-%20exercises%20for%20abdomen%20-%20abdomen%20flat.mp4.mp4.mp4?alt=media\")," +
            "(43, 11, 1, \"perte\", \"Exercice 43\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.51, \"@drawable/image11\", \"@drawable/image11\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Squat%20avec%20bande%20%C3%A9lastique%20loop%20_%20Sport%20Chez%20Soi.mp4?alt=media\")," +
            "(44, 11, 1, \"masse\", \"Exercice 44\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.22, \"@drawable/image11\", \"@drawable/image11\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/pancia%20e%20fianchi%20palestra%20(addome%20alto).mp4.mp4.mp4?alt=media\")," +
            "(45, 12, 0, \"perte\", \"Exercice 45\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image12\", \"@drawable/image12\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(46, 12, 0, \"masse\", \"Exercice 46\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image12\", \"@drawable/image12\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscler%20Dos%20et%20Dorsaux.mp4.mp4.mp4?alt=media\")," +
            "(47, 12, 1, \"perte\", \"Exercice 47\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.17, \"@drawable/image12\", \"@drawable/image12\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscoli%20Pettorali%20Petto%20Esercizio%20Flessioni%20Esplosive.mp4.mp4.mp4?alt=media\")," +
            "(48, 12, 1, \"masse\", \"Exercice 48\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.31, \"@drawable/image12\", \"@drawable/image12\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/NEW%20Abs%20-%20Ab%20Gym%20exercise%20(female%20_%20%20male).mp4.mp4.mp4?alt=media\")," +
            "(49, 13, 0, \"perte\", \"Exercice 49\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image13\", \"@drawable/image13\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/One%20of%20the%20best%20legs%20exercise.mp4.mp4.mp4?alt=media\")," +
            "(50, 13, 0, \"masse\", \"Exercice 50\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image13\", \"@drawable/image13\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/PREPARATION%20PHYSIQUE_%20Fentes.mp4.mp4.mp4?alt=media\")," +
            "(51, 13, 1, \"perte\", \"Exercice 51\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image13\", \"@drawable/image13\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Pectoral%20Muscles%20Exercise_%20Burpees.mp4.mp4.mp4?alt=media\")," +
            "(52, 13, 1, \"masse\", \"Exercice 52\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image13\", \"@drawable/image13\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Remo%20al%20cuello%20con%20barra%20_%20mancuernas%20Trapecio%20Hombros.mp4.mp4.mp4?alt=media\")," +
            "(53, 14, 0, \"perte\", \"Exercice 53\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image14\", \"@drawable/image14\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Side%20bends%20-%20exercises%20for%20abdomen%20-%20abdomen%20flat.mp4.mp4.mp4?alt=media\")," +
            "(54, 14, 0, \"masse\", \"Exercice 54\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.51, \"@drawable/image14\", \"@drawable/image14\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Squat%20avec%20bande%20%C3%A9lastique%20loop%20_%20Sport%20Chez%20Soi.mp4?alt=media\")," +
            "(55, 14, 1, \"perte\", \"Exercice 55\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.22, \"@drawable/image14\", \"@drawable/image14\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/pancia%20e%20fianchi%20palestra%20(addome%20alto).mp4.mp4.mp4?alt=media\")," +
            "(56, 15, 1, \"masse\", \"Exercice 56\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 1.10, \"@drawable/image14\", \"@drawable/image14\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media\")," +
            "(57, 15, 0, \"perte\", \"Exercice 57\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image15\", \"@drawable/image15\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscler%20Dos%20et%20Dorsaux.mp4.mp4.mp4?alt=media\")," +
            "(58, 15, 0, \"masse\", \"Exercice 58\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.17, \"@drawable/image15\", \"@drawable/image15\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Muscoli%20Pettorali%20Petto%20Esercizio%20Flessioni%20Esplosive.mp4.mp4.mp4?alt=media\")," +
            "(59, 15, 1, \"perte\", \"Exercice 59\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.31, \"@drawable/image15\", \"@drawable/image15\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/NEW%20Abs%20-%20Ab%20Gym%20exercise%20(female%20_%20%20male).mp4.mp4.mp4?alt=media\")," +
            "(60, 16, 1, \"masse\", \"Exercice 60\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image15\", \"@drawable/image15\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/One%20of%20the%20best%20legs%20exercise.mp4.mp4.mp4?alt=media\")," +
            "(61, 16, 0, \"perte\", \"Exercice 61\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image16\", \"@drawable/image16\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/PREPARATION%20PHYSIQUE_%20Fentes.mp4.mp4.mp4?alt=media\")," +
            "(62, 16, 0, \"masse\", \"Exercice 62\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.32, \"@drawable/image16\", \"@drawable/image16\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Pectoral%20Muscles%20Exercise_%20Burpees.mp4.mp4.mp4?alt=media\")," +
            "(63, 16, 1, \"perte\", \"Exercice 63\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.26, \"@drawable/image16\", \"@drawable/image16\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Remo%20al%20cuello%20con%20barra%20_%20mancuernas%20Trapecio%20Hombros.mp4.mp4.mp4?alt=media\")," +
            "(64, 17, 1, \"masse\", \"Exercice 64\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.23, \"@drawable/image16\", \"@drawable/image16\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Side%20bends%20-%20exercises%20for%20abdomen%20-%20abdomen%20flat.mp4.mp4.mp4?alt=media\")," +
            "(65, 17, 0, \"perte\", \"Exercice 65\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.51, \"@drawable/image17\", \"@drawable/image17\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Squat%20avec%20bande%20%C3%A9lastique%20loop%20_%20Sport%20Chez%20Soi.mp4?alt=media\")," +
            "(66, 17, 0, \"masse\", \"Exercice 66\", \"Plus la tension augmente, plus vos muscles doivent forcer. Or, c’est parfait, puisque vos muscles sont justement en phase de contraction au moment où l’effort demandé est maximal. Comme la bande en latex tire pour revenir en position de départ, vous retenez la résistance pendant la phase descendante.\", 0.22, \"@drawable/image17\", \"@drawable/image17\", \"https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/pancia%20e%20fianchi%20palestra%20(addome%20alto).mp4.mp4.mp4?alt=media\")";
}
