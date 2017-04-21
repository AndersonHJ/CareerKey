package com.smartphone.neu.CareerKey;

import java.io.Serializable;

/**
 * Created by houjian on 4/17/17.
 */

class UserItem implements Serializable{

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String school;
    private Boolean type;
    private String city;

    UserItem(int id, String firstName, String lastName, String email, boolean type, String city, String school){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.city = city;
        this.school = school;
    }

    public int getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getType() {
        return type;
    }

    public String getCity() {
        return city;
    }
    public String getSchool() {
        return school;
    }
}
