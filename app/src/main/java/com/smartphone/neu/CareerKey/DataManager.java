package com.smartphone.neu.CareerKey;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
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

    class HTTPClientOpt{

        private String readStream(InputStream stream) throws IOException {
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            // Create temporary buffer to hold Stream data with specified max length.
            int maxLength = 1024;
            char[] buffer = new char[maxLength];
            String result = null;
            // Populate temporary buffer with Stream data.
            int numChars = 0;
            int readSize = 0;
            while (numChars < maxLength && readSize != -1) {
                numChars += readSize;
                readSize = reader.read(buffer, numChars, buffer.length - numChars);
            }
            if (numChars != -1) {
                // The stream was not empty.
                // Create String that is actual length of response body if actual length was less than
                // max length.
                numChars = Math.min(numChars, maxLength);
                result = new String(buffer, 0, numChars);
            }
            return result;
        }

        private String goRestfulAPI(String sql){
            URL url = null;
            try {
                url = new URL("http://35.161.114.43/test.php?sql="+sql);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            String result = null;
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(3000);
                conn.setConnectTimeout(4000);
                conn.setRequestMethod("GET");
                conn.connect();

                //Log.d("response", conn.getResponseCode()+"");

                if (conn.getResponseCode() == 200) {
                    InputStream in = conn.getInputStream();
                    result = readStream(in);
                    //Log.d("execute", result);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                conn.disconnect();
            }

            return result;

        }

        public String executeSQL(String sql){
            MyThread myThread = new MyThread(sql);
            new Thread(myThread).start();
            while(myThread.getResult()==null);
            return myThread.getResult();
        }

        class MyThread implements Runnable{
            String res = null;
            String sql = null;
            MyThread(String sql){
                this.sql = sql;
            }

            @Override
            public void run() {
                res = goRestfulAPI(sql);
                //Log.d("run", res==null?"no":res);
            }

            public String getResult(){
                return res;
            }
        }

    }


    public UserItem getUserItem(String email) {
        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        String sql = "select%20*%20from%20lecturer%20where%20email%20=%20'"+email+"'";

        String result = httpClientOpt.executeSQL(sql);

        String[] res = result.split("########");

        String[] items = res[0].split("#");
        Log.d(items.length+"", res[0]);
        return new UserItem(Integer.parseInt(items[0]),items[1], items[2], items[3], items[6].equals("1")?true:false, items[4], items[5]);
    }

    public void updateUserItem(UserItem userItem) {
        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        String sql = null;
        try{
          sql = "update lecturer set lecturer_firstName='"+ userItem.getFirstName()+
                    "', lecturer_lastName='"+userItem.getLastName()+"', email='"+userItem.getEmail()+
                    "', city='"+userItem.getCity()+"', school='"+userItem.getSchool()+"', type="+(userItem.getType()==true?"1":"0")+
                    " where email = '"+userItem.getEmail()+"'";
            sql = URLEncoder.encode(sql, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        httpClientOpt.executeSQL(sql);

    }


    public List<EventItem> getEvents(){
        ArrayList<EventItem> list = new ArrayList<>();
        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        String sql = "SELECT%20activity_name,%20activity_startTime,%20duration,%20description," +
                "%20activity.type,%20address,%20activity.city,%20activity.state,%20image," +
                "%20lecturer.lecturer_firstName,%20lecturer.lecturer_lastName%20FROM%20" +
                "`activity`%20JOIN%20lecturer%20ON%20activity.publisherID%20=%20" +
                "lecturer.lecturerID%20WHERE%20activity.type%20=%201";

        String result = httpClientOpt.executeSQL(sql);

        //Log.d("res", result);

        String[] rows = result.split("############");

        String format = "yyyy-mm-dd HH:mm:ss";
        SimpleDateFormat formater = new SimpleDateFormat(format);

        for(int i = 0; i<rows.length; i++){
            if(rows[i].length()<5) continue;
            String[] items = rows[i].split("#");
            Date parsed = null;
            try{
                parsed = formater.parse(items[1]);
            } catch(Exception e){
                e.getMessage();
            }

            list.add(new EventItem(items[0], parsed, Integer.parseInt(items[2]), items[3],
                    Integer.parseInt(items[4]), items[5], items[6], items[7], items[8], items[9], items[10]));
        }

        return list;
    }

    public List<EventItem> getCourses(){
        ArrayList<EventItem> list = new ArrayList<>();
        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        String sql = "SELECT%20activity_name,%20activity_startTime,%20duration,%20description," +
                "%20activity.type,%20address,%20activity.city,%20activity.state,%20image," +
                "%20lecturer.lecturer_firstName,%20lecturer.lecturer_lastName%20FROM%20`activity`" +
                "%20JOIN%20lecturer%20ON%20activity.publisherID%20=%20" +
                "lecturer.lecturerID%20WHERE%20activity.type%20=%202";

        String result = httpClientOpt.executeSQL(sql);

        //Log.d("res", result);

        String[] rows = result.split("############");

        String format = "yyyy-mm-dd HH:mm:ss";
        SimpleDateFormat formater = new SimpleDateFormat(format);

        for(int i = 0; i<rows.length; i++){
            if(rows[i].length()<5) continue;
            String[] items = rows[i].split("#");
            Date parsed = null;
            try{
                parsed = formater.parse(items[1]);
            } catch(Exception e){
                e.getMessage();
            }

            list.add(new EventItem(items[0], parsed, Integer.parseInt(items[2]), items[3],
                    Integer.parseInt(items[4]), items[5], items[6], items[7], items[8], items[9], items[10]));
        }

        return list;
    }

    public List<LecturerItem> getLecturers(){
        ArrayList<LecturerItem> list = new ArrayList<>();
        List<EventItem> lec = new ArrayList<>();

        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        String sql = "select%20*%20from%20lecturer%20where%20type%20=%201";

        String result = httpClientOpt.executeSQL(sql);

        //Log.d("res", result);

        String[] rows = result.split("########");

        for(int i = 0; i<rows.length; i++){
            if(rows[i].length()<5) continue;
            String[] items = rows[i].split("#");
            Log.d("id", items[0]);

            String sql2 = "SELECT%20activity_name,%20activity_startTime,%20duration,%20description," +
                    "%20activity.type,%20address,%20activity.city,%20activity.state,%20image," +
                    "%20lecturer.lecturer_firstName,%20lecturer.lecturer_lastName%20FROM%20`activity`" +
                    "%20JOIN%20lecturer%20ON%20activity.publisherID%20=%20" +
                    "lecturer.lecturerID%20WHERE%20activity.publisherID%20=%20"+items[0];

            String lecList = httpClientOpt.executeSQL(sql2);

            //Log.d("res", result);

            Log.d(items[0], sql2);

            String[] activities = lecList.split("############");

            String format = "yyyy-mm-dd HH:mm:ss";
            SimpleDateFormat formater = new SimpleDateFormat(format);

            lec = new ArrayList<>();

            for(int j = 0; j<activities.length; j++){
                if(activities[j].length()<5) continue;
                String[] items2 = activities[j].split("#");
                Date parsed = null;
                try{
                    parsed = formater.parse(items2[1]);
                } catch(Exception e){
                    e.getMessage();
                }
                lec.add(new EventItem(items2[0], parsed, Integer.parseInt(items2[2]), items2[3],
                        Integer.parseInt(items2[4]), items2[5], items2[6], items2[7], items2[8], items2[9], items2[10]));
            }

            list.add(new LecturerItem(new UserItem(Integer.parseInt(items[0]), items[1], items[2], items[3], true, items[4], items[5]), lec));

        }
        
        return list;
    }

    public void addActivity(EventItem activi, String id){
        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    // representation of a date with the defined format.
        String startTime = df.format(activi.getStartDateTime());

        String sql = "INSERT INTO `activity` (`activity_name`,`activity_startTime`," +
                "`duration`,`description`,`type`,`publisherID`,`address`,`city`," +
                "`state`,`image`) VALUES ('"+activi.getTitle()+"','"+startTime+"',"+activi.getDuration()+
                ",'"+activi.getDescription()+"',"+activi.getType()+","+id+",'"+activi.getAddress()+"','"+
                activi.getCity()+"','"+activi.getState()+"',NULL)";

        try {
            sql = URLEncoder.encode(sql, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpClientOpt.executeSQL(sql);


    }

    public void addUser(UserItem user){
        HTTPClientOpt httpClientOpt = new HTTPClientOpt();

        String sql = "INSERT INTO `lecturer` (`lecturer_firstName`, `lecturer_lastName`, `email`," +
                " `city`, `school`, `type`) VALUES ('"+user.getFirstName()+"','"+user.getLastName()+
                "','"+user.getEmail()+ "','"+user.getCity()+"','"+user.getSchool()+"',"+(user.getType()==true?"1":"0")+")";

        try {
            sql = URLEncoder.encode(sql, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpClientOpt.executeSQL(sql);
    }

    public List<EventItem> getActivityByLecturer(){
        return null;
    }

}
