package com.example.projetSEG;


 public class User {

        public String username;
        public String password;
        public String prenom, nom;
        public String courriel;
        public Clinic clinique;

        public User(String username, String password, String nom, String prenom, String courriel){
            this.username = username;
            this.password = password;
            this.nom=nom;
            this.prenom=prenom;
            this.courriel=courriel;
        }

        public void setClinic(Clinic clinique) {
            this.clinique =  clinique;
        }



    }
