package com.epsi.nozkrew.rollandgutilisateur.pck_classes;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.epsi.nozkrew.rollandgutilisateur.R;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;

/**
 * Created by Nozkrew on 25/02/2015.
 */
public class MatchBDD {

    private SQLiteDatabase bdd;
    private DatabaseHelper databaseHelper;

    //Nom des tables
    private static final String TABLE_MATCH = "match";

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

    public MatchBDD(Context context){
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

    public long AddMatch(Match p_match){

        int termine;
        String date_maj = p_match.getMaj_match().toString();
        if (p_match.isTermine()){
            termine = 1;
        }
        else{
            termine = 0;
        }

        ContentValues values = new ContentValues();
        values.put(MATCH_ID_JOUEUR_1, p_match.getId_joueur_1());
        values.put(MATCH_NOM_JOUEUR_1, p_match.getNom_joueur_1());
        values.put(MATCH_PRENOM_JOUEUR_1, p_match.getPrenom_joueur_1());
        values.put(MATCH_ID_JOUEUR_2, p_match.getId_joueur_2());
        values.put(MATCH_NOM_JOUEUR_2, p_match.getNom_joueur_2());
        values.put(MATCH_PRENOM_JOUEUR_2, p_match.getPrenom_joueur_2());
        values.put(MATCH_NOM_TERRAIN, p_match.getNom_terrain());
        values.put(MATCH_TERMINE, termine);
        values.put(MATCH_MAJ, date_maj);

        return bdd.insert(TABLE_MATCH, null, values);
    }

    //Récupère les liste des matchs
    public ArrayList<Match> getMatchEnCours(){
        ArrayList<Match> matchArrayList = new ArrayList<Match>();
        String query = "SELECT * FROM " + TABLE_MATCH;
        Cursor cursor = bdd.rawQuery(query, null);

        while(cursor.moveToNext()){
            Match match = new Match();
            //SET
            match.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));

            match.setNom_joueur_1(cursor.getString(cursor.getColumnIndex(MATCH_NOM_JOUEUR_1)));
            match.setPrenom_joueur_1(cursor.getString(cursor.getColumnIndex(MATCH_PRENOM_JOUEUR_1)));
            match.setId_joueur_1(cursor.getInt(cursor.getColumnIndex(MATCH_ID_JOUEUR_1)));

            match.setNom_joueur_2(cursor.getString(cursor.getColumnIndex(MATCH_NOM_JOUEUR_2)));
            match.setPrenom_joueur_2(cursor.getString(cursor.getColumnIndex(MATCH_PRENOM_JOUEUR_2)));
            match.setId_joueur_2(cursor.getInt(cursor.getColumnIndex(MATCH_ID_JOUEUR_2)));

            match.setNom_terrain(cursor.getString(cursor.getColumnIndex(MATCH_NOM_TERRAIN)));

            if(cursor.getInt(cursor.getColumnIndex(MATCH_TERMINE)) == 1){
                match.setTermine(true);
            }
            else{
                match.setTermine(false);
            }
            matchArrayList.add(match);
        }
        return matchArrayList;
    }

}
