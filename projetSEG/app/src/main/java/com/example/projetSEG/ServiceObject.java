package com.example.projetSEG;

//UN OBJECT SERVICE POUR PRESENTER LES SERVICES OFFERTS
public class ServiceObject {

    private String id;
    private String service;

    public ServiceObject(String id, String service ) {
        this.id = id;
        this.service = service;

    }

    public String toString(){
        return (this.id+" EFFECTUÉ PAR : "+this.service);
    }
}
