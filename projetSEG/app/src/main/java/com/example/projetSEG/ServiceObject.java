package com.example.projetSEG;

public class ServiceObject {

    private String id;
    private String service;
   // private String role;

    public ServiceObject() {
    }

    public ServiceObject(String id, String service ) {
        this.id = id;
        this.service = service;
       //this.role = role;
    }

    //public void setRole(String role){
      //  this.role=role;
    //}

    //public String getRole(){ return this.role; }
    public void setId(String id) { this.id = id; }

    public String getID() {
        return this.id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String toString(){
        return (this.id+" EFFECTUÉ PAR : "+this.service);
    }
}
