package com.smartphone.neu.CareerKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by houjian on 4/15/17.
 */

public class DataManager {
    private ArrayList<EventItem> courses;
    private ArrayList<EventItem> events;
    private ArrayList<LecturerItem> lecturers;

    DataManager(){

    }

//    public LecturerItem getlecturer(String email){
//        return null;
//    }
//
//    public UserItem getStudent(String email){
//        return new UserItem("Mike", "Done", "mik.don@gmail.com", true, "Seattle", "Northeastern University");
//    }
    public UserItem getUserItem(String email) {
        return new UserItem("Mike", "Done", "mik.don@gmail.com", true, "Seattle", "Northeastern University");
    }

    public void setStudent(UserItem student){

    }

    public void setlecturer(LecturerItem lecturer){

    }

    public List<EventItem> getEvents(){
        ArrayList<EventItem> list = new ArrayList<>();

        list.add(new EventItem("/image/1.jpg", "Career fair", new Date(2017, 2, 14, 10, 0),
                "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));

        list.add(new EventItem("/image/1.jpg", "Company Introduction", new Date(2016, 12, 4, 13, 30),
                "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Interview talk", new Date(2017, 1, 16, 12, 0),
                "This activity is one of the best events in Seattle" +
                        "This activity is one of the best events in Seattle" +
                        "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Company introduction", new Date(2016, 5, 7, 17, 30),
                "Come and join us for your successful future", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Hiring", new Date(2016, 6, 13, 10, 20),
                "This activity is one of the best events in Seattle," +
                        "Come and join us for your successful future", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Career fair", new Date(2016, 2, 14, 10, 0),
                "Come and join us for your successful future," +
                        "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Career development", new Date(2017, 3, 1, 12, 0),
                "This activity is one of the best events in Seattle," +
                        "Come and join us for your successful future", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "How to interview", new Date(2016, 2, 14, 10, 20),
                "Come and join us for your successful future," +
                        "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Preparation", new Date(2017, 4, 17, 19, 40),
                "Come and join us for your successful future" +
                        ",This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Need you", new Date(2017, 1, 8, 8, 0),
                "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Career fair", new Date(2016, 7, 4, 19, 50),
                "This activity is one of the best events in Seattle", 1, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        return list;
    }

    public List<EventItem> getCourses(){
        ArrayList<EventItem> list = new ArrayList<>();

        list.add(new EventItem("/image/1.jpg", "Java class", new Date(2017, 2, 14, 10, 0),
                "This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));

        list.add(new EventItem("/image/1.jpg", "C++ class", new Date(2016, 12, 4, 13, 30),
                "This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "How to interview", new Date(2017, 1, 16, 12, 0),
                "This activity is one of the best events in Seattle" +
                        "This activity is one of the best events in Seattle" +
                        "This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Cloud Computing", new Date(2016, 5, 7, 17, 30),
                "Come and join us for your successful future", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Computer hardware introduction", new Date(2016, 6, 13, 10, 20),
                "This activity is one of the best events in Seattle," +
                        "Come and join us for your successful future", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "JavaEE class", new Date(2016, 2, 14, 10, 0),
                "Come and join us for your successful future," +
                        "This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Learn how to build web app", new Date(2017, 3, 1, 12, 0),
                "This activity is one of the best events in Seattle," +
                        "Come and join us for your successful future", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Java class", new Date(2016, 2, 14, 10, 20),
                "Come and join us for your successful future," +
                        "This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "Cloud computing", new Date(2017, 4, 17, 19, 40),
                "Come and join us for your successful future" +
                        ",This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));
        list.add(new EventItem("/image/1.jpg", "C programming language", new Date(2017, 1, 8, 8, 0),
                "This activity is one of the best events in Seattle", 2, "123 Terry Ave.",
                "Seattle", "WA", 2, "Luis", "Duke"));

        return list;
    }

    public List<LecturerItem> getLecturers(){
        ArrayList<LecturerItem> list = new ArrayList<>();
        List<EventItem> lec = new ArrayList<>();
        lec.add(this.getEvents().get(0));
        lec.add(this.getCourses().get(0));

        list.add(new LecturerItem(new UserItem("Mike", "Done", "mik.don@gmail.com", true, "Seattle", "Northeastern University"),lec));
        list.add(new LecturerItem(new UserItem("Anderson", "Hou", "mik.don@gmail.com", true, "Seattle", "Northeastern University"),lec));
        list.add(new LecturerItem(new UserItem("Anna", "Zhang", "mik.don@gmail.com", true, "Seattle", "Northeastern University"),lec));
        list.add(new LecturerItem(new UserItem("Jackson", "Yu", "mik.don@gmail.com", true, "Seattle", "Northeastern University"),lec));

        return list;
    }

    public void addActivity(EventItem activi){
        List<EventItem> list;
        if(activi.getType()==1)
            list = this.getEvents();
        else
            list = this.getCourses();

        list.add(activi);
    }

    public void addLecturer(LecturerItem lecturer){

    }

    public void addStudent(UserItem student){

    }

    public List<EventItem> getActivityByLecturer(){
        return null;
    }

}
