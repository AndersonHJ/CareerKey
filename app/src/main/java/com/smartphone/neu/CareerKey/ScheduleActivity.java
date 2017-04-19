package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ScheduleActivity extends AppCompatActivity {

    CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        final TextView text = (TextView) findViewById(R.id.textViewactivity);
        final Button add = (Button) findViewById(R.id.buttonadd);
        cv=(CalendarView)findViewById(R.id.calendarView);
        final long[] date1 = {cv.getDate()};
        //为CalendarView组件的日期改变事件添加事件监听器
        cv.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                //Toast.makeText()
                if(cv.getDate() != date1[0]) {
                    date1[0] = cv.getDate();
                    Toast.makeText(calendarView.getContext(),
                            "你生日是" + year + "年" + month + "月" + dayOfMonth + "日"
                            , Toast.LENGTH_SHORT).show();
                }
                text.setText("");
                text.setText("changable");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(v == add){
                    startActivity(new Intent(ScheduleActivity.this, AddScheduleActivity.class));
                }else if(v == cv){
                    text.setText("");
                }
            }
        });
    }


}
