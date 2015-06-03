package com.epsi.nozkrew.rollandgutilisateur;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.epsi.nozkrew.rollandgutilisateur.pck_classes.Score;
import com.epsi.nozkrew.rollandgutilisateur.pck_classes.ScoreBDD;

import java.util.ArrayList;
import java.util.Date;


public class matchCurrent extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_current);

        Intent intent = getIntent();
        //Info match
        int id_match = intent.getIntExtra("match_id", 0);

        //Info j1
        String nom_j1 = intent.getStringExtra("nom_j1");
        int id_j1 = intent.getIntExtra("id_j1", 0);

        //Info j2
        String nom_j2 = intent.getStringExtra("nom_j2");
        int id_j2 = intent.getIntExtra("id_j2", 0);

        Log.i("RGUser", "matchCurrent");

        ScoreBDD scoreBDD = new ScoreBDD(this);
        scoreBDD.open();

        Score scoreMaxJ1 = scoreBDD.getMaxScore(id_j1, id_match);
        Score scoreMaxJ2 = scoreBDD.getMaxScore(id_j2, id_match);

        //Récupère les textView
        TextView tvNomJ1 = (TextView) findViewById(R.id.nomJ1);
        TextView tvNomJ2 = (TextView) findViewById(R.id.nomJ2);
        TextView tvPointsJ1 = (TextView) findViewById(R.id.pointsJ1);
        TextView tvPointsJ2 = (TextView) findViewById(R.id.pointsJ2);

        //Affecte les textview
        tvNomJ1.setText(nom_j1);
        tvNomJ2.setText(nom_j2);
        tvPointsJ1.setText(scoreMaxJ1.getPoint());
        tvPointsJ2.setText(scoreMaxJ2.getPoint());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_match_current, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
