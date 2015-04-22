package com.epsi.nozkrew.rollandgutilisateur;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.epsi.nozkrew.rollandgutilisateur.pck_classes.Score;
import com.epsi.nozkrew.rollandgutilisateur.pck_classes.ScoreBDD;

import java.util.ArrayList;


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

        Log.i("RGUser", "Debut BDD");
        ScoreBDD scoreBDD = new ScoreBDD(this);

        Log.i("RGUser", "Recup score");
        ArrayList<Score> scores = scoreBDD.getScoreMatch(id_match);
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
