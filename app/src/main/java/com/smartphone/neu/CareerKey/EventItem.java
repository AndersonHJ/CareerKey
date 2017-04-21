package com.smartphone.neu.CareerKey;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by houjian on 3/31/17.
 */

public class EventItem implements Serializable {
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

    EventItem(String title, Date startTime, int duration, String description, int type,
              String address, String city, String state, String image, String firstName, String lastName){
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

    public Date getStartDateTime(){
        return startTime;
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
