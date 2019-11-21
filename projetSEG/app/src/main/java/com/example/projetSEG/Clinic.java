package com.example.projetSEG;

//UN OBJECT CLINIC POUR LE LIER A UN EMPLOYE
public class Clinic {

    public String adresse, telephone, nom, assurance, paiment;

    public Clinic (String adresse, String telephone, String nom, String assurance, String paiment) {
        this.adresse = adresse;
        this.telephone = telephone;
        this.nom = nom;
        this.assurance = assurance;
        this.paiment = paiment;
    }
}
