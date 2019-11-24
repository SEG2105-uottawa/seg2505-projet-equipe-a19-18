package com.example.projetSEG;

//UN OBJECT USER POUR REPRESENTER UN PATIENT ET UN EMPLOYE
 public class User {

        public String username;
        public String password;
        public String prenom, nom;
        public String courriel;

        public User(String username, String password, String nom, String prenom, String courriel){
            this.username = username;
            this.password = password;
            this.nom=nom;
            this.prenom=prenom;
            this.courriel=courriel;
        }



    }
