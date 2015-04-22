package com.epsi.nozkrew.rollandgutilisateur;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epsi.nozkrew.rollandgutilisateur.pck_classes.DatabaseHelper;
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

        Match unMatch = new Match(0, "Nadal", "Raphael", 5, "Monfils", "Gael", 9, "Oui", false, new Date());

        matchBDD.open();

        Log.i("Lancement", "Init");

        //matchBDD.AddMatch(unMatch);
        ArrayList<Match> listMatchs = matchBDD.getMatchEnCours();

        //Recupère la liste view
        final ListView listViewMatch = (ListView) findViewById(R.id.listViewMatch);

        //On ajoute les match a l'adapter
        MatchAdapter adapter = new MatchAdapter(this, listMatchs);
        listViewMatch.setAdapter(adapter);

        listViewMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View child, int position, long id) {
                Match match = (Match) listViewMatch.getItemAtPosition(position);
                Log.i("RGUser", "Match choisit " + match.getId());
                Intent intent = new Intent(HomeUser.this, matchCurrent.class);
                intent.putExtra("match_id", match.getId());
                intent.putExtra("nom_j1", match.getNom_joueur_1());
                intent.putExtra("id_j1", match.getId_joueur_1());
                intent.putExtra("nom_j2", match.getNom_joueur_2());
                intent.putExtra("id_j2", match.getId_joueur_2());

                startActivity(intent);
            }
        });
    }
}
