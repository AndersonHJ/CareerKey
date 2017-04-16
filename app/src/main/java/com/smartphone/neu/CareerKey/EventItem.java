package com.smartphone.neu.CareerKey;


import java.util.Date;

/**
 * Created by houjian on 3/31/17.
 */

public class EventItem {

    private String image;
    private String title;
    private Date time;
    private String description;

    EventItem(String image, String title, Date time, String description){
        this.image = image;
        this.title = title;
        this.time = time;
        this.description = description;
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

    public String getTime() {
        return time.toString();
    }
}
