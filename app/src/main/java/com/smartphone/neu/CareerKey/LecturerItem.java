package com.smartphone.neu.CareerKey;

import java.io.Serializable;
import java.util.List;

/**
 * Created by houjian on 4/17/17.
 */

public class LecturerItem implements Serializable {
    public UserItem user;
    private List<EventItem> posted;

    LecturerItem(UserItem user, List<EventItem> posted){
        this.user = user;
        this.posted = posted;
    }

    public String getFirstName(){
        return this.user.getFirstName();
    }

    public String getLastName() {
        return this.user.getLastName();
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public Boolean getType() {
        return this.user.getType();
    }

    public String getCity() {
        return this.user.getCity();
    }
    public String getSchool() {
        return this.user.getSchool();
    }

    public String getClassName(){ return "LecturerItem"; }
}
