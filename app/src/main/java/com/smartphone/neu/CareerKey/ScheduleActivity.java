package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.*;

public class ScheduleActivity extends AppCompatActivity {
    private static final String TAG = "ScheduleActivity";
    CalendarView cv;
    ListView listView ;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        final TextView text = (TextView) findViewById(R.id.textViewactivity);
        final Button add = (Button) findViewById(R.id.buttonadd);
        cv=(CalendarView)findViewById(R.id.calendarView);
        final long[] date1 = {cv.getDate()};
        Log.i(TAG, "get date of calendar" + Long.toString(date1[0]));

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listschedule);

        // Defined Array values to show in ListView
        List<String> list = new ArrayList<String>();
        list.add("Android List View");
        list.add("Adapter implementation");
        list.add("Simple List View In Android");
        list.add("Create List View Android");
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        //adapter.notifyDataSetChanged();
        //为CalendarView组件的日期改变事件添加事件监听器
        cv.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                //Toast.makeText()
                /*if(cv.getDate() != date1[0]) {
                    date1[0] = cv.getDate();
                    Toast.makeText(calendarView.getContext(),
                            "你生日是" + year + "年" + month + "月" + dayOfMonth + "日"
                            , Toast.LENGTH_SHORT).show();
                }*/
                //Toast.makeText(calendarView.getContext(),
                //        "你生日是" + year + "年" + month + "月" + dayOfMonth + "日"
                //        , Toast.LENGTH_SHORT).show();
                text.setText("");
                int d = dayOfMonth;
                int m = month;
                int y = year;
                String cdate = d+"-"+m+"-"+y;
                text.setText(cdate);
                // Define a new Adapter
                // First parameter - Context
                // Second parameter - Layout for the row
                // Third parameter - ID of the TextView to which the data is written
                // Forth - the Array of data
                List<String> list1 = new ArrayList<String>();
                list1.add("10:00AM-11:00AM");
                list1.add("1:00AM-2:00AM");
                list1.add("4:00AM-5:00AM");
                //list.add("Create List View Android");
                adapter = new ArrayAdapter<String>(ScheduleActivity.this, android.R.layout.simple_list_item_1, list1);
                // Assign adapter to ListView
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v == add){
                    Intent intent = new Intent(ScheduleActivity.this, AddScheduleActivity.class);
                    String ss = text.getText().toString();
                    Log.i(TAG, "the current date is -> " + ss);
                    intent.putExtra("message", ss);
                    startActivity(intent);
                    //startActivity(new Intent(ScheduleActivity.this, AddScheduleActivity.class));

                }else if(v == cv){
                    text.setText("");
                }
            }
        });



    }


}
