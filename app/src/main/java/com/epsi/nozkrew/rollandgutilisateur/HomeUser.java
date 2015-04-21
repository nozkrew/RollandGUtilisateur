package com.epsi.nozkrew.rollandgutilisateur;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epsi.nozkrew.rollandgutilisateur.pck_classes.Match;
import com.epsi.nozkrew.rollandgutilisateur.pck_classes.MatchAdapter;
import com.epsi.nozkrew.rollandgutilisateur.pck_classes.MatchBDD;
import com.epsi.nozkrew.rollandgutilisateur.pck_classes.Score;
import com.epsi.nozkrew.rollandgutilisateur.pck_classes.ScoreBDD;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class HomeUser extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        MatchBDD matchBDD = new MatchBDD(this);
        ScoreBDD scoreBDD = new ScoreBDD(this);

        Match unMatch = new Match(1, "Nadal", "Raphael", 5, "Monfils", "Gael", 9, "Oui", false, new Date());

        Score unScore = new Score(1, "15", 1, 1, new Date(), 1, 1 );

        matchBDD.open();
        scoreBDD.open();

        //scoreBDD.addScore(unScore);

        Score scoreGet = scoreBDD.getScoreJoueur(1, 1);
        Log.i("Score :", scoreGet.getPoint());
        Log.i("Lancement", "Init");

        //matchBDD.AddMatch(unMatch);
        ArrayList<Match> listMatchs = matchBDD.getMatchEnCours();

    /*
        for(Match match : listMatchs){
            Log.i("match", match.getNom_joueur_1() + " " + match.getNom_joueur_2());
        }
    */
        //Recupère la liste view
        ListView listViewMatch = (ListView) findViewById(R.id.listViewMatch);

        MatchAdapter adapter = new MatchAdapter(this, listMatchs);
        listViewMatch.setAdapter(adapter);
    }
}
