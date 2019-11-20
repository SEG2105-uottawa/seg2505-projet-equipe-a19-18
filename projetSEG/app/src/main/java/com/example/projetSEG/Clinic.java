package com.example.projetSEG;

public class Clinic {

    public String adresse, nom, assurance, paiment;
    public int telephone;

    public Clinic (String adresse, int telephone, String nom, String assurance, String paiment) {
        this.adresse = adresse;
        this.telephone = telephone;
        this.nom = nom;
        this.assurance = assurance;
        this.paiment = paiment;
    }
}
