package com.example.projetSEG;


// DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
public class ServiceObject {

    private String id;
    private String service;
   // private String role;
// DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    public ServiceObject() {
    }
    // DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    public ServiceObject(String id, String service ) {
        this.id = id;
        this.service = service;
       //this.role = role;
    }
// DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    //public void setRole(String role){
      //  this.role=role;
    //}
// DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    //public String getRole(){ return this.role; }
    public void setId(String id) { this.id = id; }

    public String getID() {
        return this.id;
    }
    // DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    public String getService() {
        return service;
    }
    // DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    public void setService(String service) {
        this.service = service;
    }
    // DONT REMOVE ANYTHING: ITS ONLY WORKS LIKE THAT!!!
    public String toString(){
        return (this.id+" EFFECTUÉ PAR : "+this.service);
    }
}
