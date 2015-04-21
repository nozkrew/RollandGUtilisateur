package com.epsi.nozkrew.rollandgutilisateur.pck_classes;

import java.util.Date;

/**
 * Created by Nozkrew on 25/02/2015.
 */
public class Score {

    private int id;
    private String point;
    private int jeu;
    private int set;
    private Date maj_score;
    //Clés étangères
    private int id_match;
    private int id_joueur;

    public Score(){

    }

    public Score(int id, String point, int jeu, int set, Date maj_score, int id_match, int id_joueur) {
        this.id = id;
        this.point = point;
        this.jeu = jeu;
        this.set = set;
        this.maj_score = maj_score;
        this.id_match = id_match;
        this.id_joueur = id_joueur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getJeu() {
        return jeu;
    }

    public void setJeu(int jeu) {
        this.jeu = jeu;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public Date getMaj_score() {
        return maj_score;
    }

    public void setMaj_score(Date maj_score) {
        this.maj_score = maj_score;
    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }
}
