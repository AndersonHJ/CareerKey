package com.smartphone.neu.CareerKey;

import java.io.Serializable;
import java.util.List;

/**
 * Created by houjian on 4/17/17.
 */

public class LecturerItem implements Serializable {
    private UserItem user;
    private List<EventItem> posted;

    LecturerItem(UserItem user, List<EventItem> posted){
        this.user = user;
        this.posted = posted;
    }




}
