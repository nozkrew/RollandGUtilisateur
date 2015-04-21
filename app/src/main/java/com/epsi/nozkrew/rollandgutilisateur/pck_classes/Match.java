package com.epsi.nozkrew.rollandgutilisateur.pck_classes;

import java.util.Date;

/**
 * Created by Nozkrew on 25/02/2015.
 */
public class Match {
    private int id;
    private String nom_joueur_1;
    private String prenom_joueur_1;
    private int id_joueur_1;
    private String nom_joueur_2;
    private String prenom_joueur_2;
    private int id_joueur_2;
    private String nom_terrain;
    private boolean termine;
    private Date maj_match;

    public Match(){

    }

    public Match(int id, String nom_joueur_1, String prenom_joueur_1, int id_joueur_1, String nom_joueur_2, String prenom_joueur_2, int id_joueur_2, String nom_terrain, boolean termine, Date maj_match) {
        this.id = id;
        this.nom_joueur_1 = nom_joueur_1;
        this.prenom_joueur_1 = prenom_joueur_1;
        this.id_joueur_1 = id_joueur_1;
        this.nom_joueur_2 = nom_joueur_2;
        this.prenom_joueur_2 = prenom_joueur_2;
        this.id_joueur_2 = id_joueur_2;
        this.nom_terrain = nom_terrain;
        this.termine = termine;
        this.maj_match = maj_match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_joueur_1() {
        return nom_joueur_1;
    }

    public void setNom_joueur_1(String nom_joueur_1) {
        this.nom_joueur_1 = nom_joueur_1;
    }

    public String getPrenom_joueur_1() {
        return prenom_joueur_1;
    }

    public void setPrenom_joueur_1(String prenom_joueur_1) {
        this.prenom_joueur_1 = prenom_joueur_1;
    }

    public int getId_joueur_1() {
        return id_joueur_1;
    }

    public void setId_joueur_1(int id_joueur_1) {
        this.id_joueur_1 = id_joueur_1;
    }

    public String getNom_joueur_2() {
        return nom_joueur_2;
    }

    public void setNom_joueur_2(String nom_joueur_2) {
        this.nom_joueur_2 = nom_joueur_2;
    }

    public String getPrenom_joueur_2() {
        return prenom_joueur_2;
    }

    public void setPrenom_joueur_2(String prenom_joueur_2) {
        this.prenom_joueur_2 = prenom_joueur_2;
    }

    public int getId_joueur_2() {
        return id_joueur_2;
    }

    public void setId_joueur_2(int id_joueur_2) {
        this.id_joueur_2 = id_joueur_2;
    }

    public String getNom_terrain() {
        return nom_terrain;
    }

    public void setNom_terrain(String nom_terrain) {
        this.nom_terrain = nom_terrain;
    }

    public boolean isTermine() {
        return termine;
    }

    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    public Date getMaj_match() {
        return maj_match;
    }

    public void setMaj_match(Date maj_match) {
        this.maj_match = maj_match;
    }
}
