package com.example.projetSEG;

/**public class User {

    public String username;
    public String password;
    public String type;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }*/

 public class User {

        public String username;
        public String password;

        public String prenom, nom;

        public String courriel;

        /*
        public User() {
            this.prenom=null;
            this.nom=null;
            this.courriel=null;
        }
        public User(String nom, String prenom, String _courriel){
            this.prenom=null;
            this.nom=null;
            this.courriel=null;
        }

         */

        public User(String username, String password, String nom, String prenom, String courriel){
            this.username = username;
            this.password = password;
            this.nom=nom;
            this.prenom=prenom;
            this.courriel=courriel;


        }
        public void setUsername(String username){
            this.username = username;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public void setFullName(String nom, String prenom){
            this.nom = nom;
            this.prenom = prenom;
        }
        public void setCourriel(String _courriel){
            this.courriel = _courriel;
        }

        //getter methods
    /*
        public String getUsername(){
            return this.username;
        }
        public String getPassword(){
            return this.password;
        }
        public String getNom(){
            return this.nom;
        }
        public String getPrenom(){
            return this.courriel;
        }

        public void printInfo(){
            System.out.println("Utilisateur: " + this.username);
            System.out.println("Mot De Passe: " + this.password);
            System.out.println("Nom: " + this.prenom + " " + this.nom);
            System.out.println("Courriel: " + this.courriel);
        }
*/
        public String stringInfo() {
            return username+" "+password+" "+prenom+" "+nom+" "+courriel;
        }

    }
