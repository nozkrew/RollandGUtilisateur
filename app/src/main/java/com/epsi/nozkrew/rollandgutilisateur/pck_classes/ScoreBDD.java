package com.epsi.nozkrew.rollandgutilisateur.pck_classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Nozkrew on 25/03/2015.
 */
public class ScoreBDD {
    private SQLiteDatabase bdd;
    private DatabaseHelper databaseHelper;

    //Nom des tables
    private static final String TABLE_SCORE = "score";

    //Colonnes communes
    private static final String COL_ID = "id";

    //SCORE Table - nom des colonnes
    private static final String SCORE_POINT = "point_score";
    private static final String SCORE_JEU = "jeu_score";
    private static final String SCORE_SET = "set_score";
    private static final String SCORE_MAJ = "maj_score";
    private static final String SCORE_ID_MATCH = "id_match";
    private static final String SCORE_ID_JOUEUR = "id_joueur";

    public ScoreBDD(Context context){
        databaseHelper = new DatabaseHelper(context);
    }
    public void open(){
        //on ouvre la BDD en écriture
        bdd = databaseHelper.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public Score getScoreJoueur(int p_idJoueur, int p_idMatch){
        String query = "SELECT * FROM " + TABLE_SCORE + " WHERE " + SCORE_ID_JOUEUR + " = " + p_idJoueur + " AND " + SCORE_ID_MATCH +" = " + p_idMatch ;
        Cursor cursor = bdd.rawQuery(query, null);
        Score score = new Score();
        if(cursor.moveToFirst()){

            //Gestion de la date
            //TODO

            //Set
            score.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
            score.setPoint(cursor.getString(cursor.getColumnIndex(SCORE_POINT)));
            score.setJeu(cursor.getInt(cursor.getColumnIndex(SCORE_JEU)));
            score.setSet(cursor.getInt(cursor.getColumnIndex(SCORE_SET)));
            score.setId_match(cursor.getInt(cursor.getColumnIndex(SCORE_ID_MATCH)));
            score.setId_joueur(cursor.getInt(cursor.getColumnIndex(SCORE_ID_JOUEUR)));
        }
        return score;
    }

    public long addScore(Score p_score){

        String date_maj = p_score.getMaj_score().toString();

        ContentValues values = new ContentValues();

        values.put(SCORE_POINT, p_score.getPoint());
        values.put(SCORE_JEU, p_score.getJeu());
        values.put(SCORE_SET, p_score.getSet());
        values.put(SCORE_MAJ, date_maj);
        values.put(SCORE_ID_MATCH, p_score.getId_match());
        values.put(SCORE_ID_JOUEUR, p_score.getId_joueur());

        return bdd.insert(TABLE_SCORE, null, values);
    }
}