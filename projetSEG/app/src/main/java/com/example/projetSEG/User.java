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

       protected String _username;
       protected String password;

       protected String prenom, nom;

       protected String _courriel;


        public User() {
            this.prenom=null;
            this.nom=null;
            this._courriel=null;
        }
        public User(String nom, String prenom, String _courriel){
            this.prenom=null;
            this.nom=null;
            this._courriel=null;
        }

        public User(String username, String password, String nom, String prenom, String _courriel){
            this._username = username;
            this.prenom=null;
            this.nom=null;
            this._courriel=null;

        }
        public void setUsername(String username){
            this._username = username;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public void setFullName(String nom, String prenom){
            this.nom = nom;
            this.prenom = prenom;
        }
        public void setCourriel(String _courriel){
            this._courriel = _courriel;
        }

        //getter methods
        public String getUsername(){
            return this._username;
        }
        public String getPassword(){
            return this.password;
        }
        public String getNom(){
            return this.nom;
        }
        public String getPrenom(){
            return this._courriel;
        }

        public void printInfo(){
            System.out.println("Utilisateur: " + this._username);
            System.out.println("Mot De Passe: " + this.password);
            System.out.println("Nom: " + this.prenom + " " + this.nom);
            System.out.println("Courriel: " + this._courriel);
        }

        public String stringInfo() {
            return _username+" "+password+" "+prenom+" "+nom+" "+_courriel;
        }

    }
