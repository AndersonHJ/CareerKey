package com.smartphone.neu.CareerKey;

/**
 * Created by houjian on 4/17/17.
 */

class UserItem {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String birthday;
    private String highestDegree;
    private String city;
    private String state;

    UserItem(String firstName, String lastName, String email, String gender, String birthday,
             String highestDegree, String city, String state){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.highestDegree = highestDegree;
        this.city = city;
        this.state = state;
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

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
