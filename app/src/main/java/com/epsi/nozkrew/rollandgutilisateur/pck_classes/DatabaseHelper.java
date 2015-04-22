package com.epsi.nozkrew.rollandgutilisateur.pck_classes;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.epsi.nozkrew.rollandgutilisateur.R;

/**
 * Created by Nozkrew on 25/02/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //Constrtucteur
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Version de la BDD
    private static final int DATABASE_VERSION = 1;

    //Nom de la BDD
    private static final String DATABASE_NAME = "rollandGarros";

    //Nom des tables
    private static final String TABLE_MATCH = "match";
    private static final String TABLE_SCORE = "score";

    //Colonnes communes
    private static final String COL_ID = "id";

    // MATCH Table - nom des colonnes
    private static final String MATCH_NOM_JOUEUR_1 = "nom_joueur_1";
    private static final String MATCH_PRENOM_JOUEUR_1 = "prenom_joueur_1";
    private static final String MATCH_ID_JOUEUR_1 = "id_joueur_1";
    private static final String MATCH_NOM_JOUEUR_2 = "nom_joueur_2";
    private static final String MATCH_PRENOM_JOUEUR_2 = "prenom_joueur_2";
    private static final String MATCH_ID_JOUEUR_2 = "id_joueur_2";
    private static final String MATCH_NOM_TERRAIN = "nom_terrain";
    private static final String MATCH_TERMINE = "termine";
    private static final String MATCH_MAJ = "maj_match";

    //SCORE Table - nom des colonnes
    private static final String SCORE_POINT = "point_score";
    private static final String SCORE_JEU = "jeu_score";
    private static final String SCORE_SET = "set_score";
    private static final String SCORE_MAJ = "maj_score";
    private static final String SCORE_ID_MATCH = "id_match";
    private static final String SCORE_ID_JOUEUR = "id_joueur";

    //Variable de création de la table MATCH
    private static final String MATCH_TABLE_CREATE = "create table " + TABLE_MATCH
            + " (" + COL_ID + " integer primary key autoincrement, "
            + MATCH_ID_JOUEUR_1 + " integer not null, "
            + MATCH_NOM_JOUEUR_1 + " text not null, "
            + MATCH_PRENOM_JOUEUR_1 + " text not null,"
            + MATCH_ID_JOUEUR_2 + " integer not null,"
            + MATCH_NOM_JOUEUR_2 + " text not null,"
            + MATCH_PRENOM_JOUEUR_2 + " text not null,"
            + MATCH_NOM_TERRAIN + " text not null,"
            + MATCH_TERMINE + " integer not null,"
            + MATCH_MAJ + " text not null);";

    //Varible de création de la table SCORE
    private static final String SCORE_TABLE_CREATE = "create table " + TABLE_SCORE
            + " (" + COL_ID + " integer primary key autoincrement, "
            + SCORE_POINT + " integer not null, "
            + SCORE_JEU + " integer not null, "
            + SCORE_SET + " integer not null, "
            + SCORE_MAJ + " text not null, "
            + SCORE_ID_JOUEUR + " integer not null,"
            + SCORE_ID_MATCH + " integer not null,"
            +" FOREIGN KEY ("+SCORE_ID_MATCH+") REFERENCES "+ TABLE_MATCH +" ("+ COL_ID +"));";

    public void onCreate(SQLiteDatabase db){
        db.execSQL(MATCH_TABLE_CREATE);
        db.execSQL(SCORE_TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.i("RGUser", "Update database");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }
}
