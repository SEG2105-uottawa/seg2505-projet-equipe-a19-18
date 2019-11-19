package com.example.projetSEG;

public class ServiceObject {

    private Integer id;
    private String service;
    private String role;

    public ServiceObject() {
    }

    public ServiceObject(Integer id, String service,String role ) {
        this.id = id;
        this.service = service;
        this.role = role;
    }

    public void setRole(String role){
        this.role=role;
    }

    public String getRole(){
        return this.role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getID() {
        return this.id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
