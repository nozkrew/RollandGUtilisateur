package com.epsi.nozkrew.rollandgutilisateur.pck_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.epsi.nozkrew.rollandgutilisateur.R;

import java.util.ArrayList;

/**
 * Created by Nozkrew on 26/02/2015.
 */
public class MatchAdapter extends ArrayAdapter<Match> {
    public MatchAdapter(Context context, ArrayList<Match> matchs) {
        super(context, 0, matchs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Match match = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_match, parent, false);
        }
        // Lookup view for data population
        TextView j1 = (TextView) convertView.findViewById(R.id.joueur1);
        TextView j2 = (TextView) convertView.findViewById(R.id.joueur2);
        TextView statut = (TextView) convertView.findViewById(R.id.textViewStatuts);
        // Populate the data into the template view using the data object
        j1.setText(match.getNom_joueur_1());
        j2.setText(match.getNom_joueur_2());
        if(match.isTermine()){
            statut.setText(R.string.statutTermine);
        }
        else{
            statut.setText(R.string.statutEnCours);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
