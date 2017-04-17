package com.smartphone.neu.CareerKey;


import java.util.Date;

/**
 * Created by houjian on 3/31/17.
 */

public class EventItem {
    private String image;
    private String title;
    private Date startTime;
    private int duration;
    private String description;
    private int type;
    private String address;
    private String city;
    private String state;
    private String publisher;

    EventItem(String image, String title, Date startTime, String description, int type,
              String address, String city, String state, int duration, String firstName, String lastName){
        this.image = image;
        this.title = title;
        this.startTime = startTime;
        this.description = description;
        this.type = type;
        this.address = address;
        this.city = city;
        this.state = state;
        this.duration = duration;
        this.publisher = firstName+" "+lastName;
    }

    public String getImage(){
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime.toString();
    }

    public int getDuration(){
        return this.duration;
    }

    public int getType(){
        return this.type;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getPublisher(){
        return this.publisher;
    }
}
