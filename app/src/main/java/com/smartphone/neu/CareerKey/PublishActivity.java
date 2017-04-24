package com.smartphone.neu.CareerKey;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.Calendar;
import java.util.Date;

public class PublishActivity extends AppCompatActivity {

    private EditText date;
    private DatePickerDialog datePickerDialog;
    private Button submit;
    private EditText time;
    private EditText title;
    private EditText duration;
    private EditText description;
    private EditText address;
    private EditText city;
    private EditText state;
    private RadioButton course, event;
    private RadioGroup group;

    private UserItem user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        user = (UserItem) getIntent().getSerializableExtra("User");

        title = (EditText) findViewById(R.id.txtTitle);
        time = (EditText) findViewById(R.id.txtStartTime);
        duration = (EditText) findViewById(R.id.txtDuration);
        description = (EditText) findViewById(R.id.txtDescription);
        address = (EditText) findViewById(R.id.txtAddress);
        city = (EditText) findViewById(R.id.txtCity);
        state = (EditText) findViewById(R.id.txtState);
        group = (RadioGroup) findViewById(R.id.activityType);
        course = (RadioButton) findViewById(R.id.courseRB);
        event = (RadioButton) findViewById(R.id.eventRB);

        date = (EditText) findViewById(R.id.txtDatePicker);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(PublishActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        submit = (Button) findViewById(R.id.btnSubmitActivity);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] datetime = date.getText().toString().split("/");
                int year = Integer.parseInt(datetime[2]);
                int month = Integer.parseInt(datetime[1]);
                int day = Integer.parseInt(datetime[0]);
                String[] hourandminute = time.getText().toString().split(":");
                int hour = Integer.parseInt(hourandminute[0]);
                int minute = Integer.parseInt(hourandminute[1]);
                int selectId = group.getCheckedRadioButtonId();
                int type = 0;
                if(selectId == course.getId()){
                    type = 2;
                }
                else if(selectId == event.getId()){
                    type = 1;
                }

                DataManager dataManager = new DataManager();
                dataManager.addActivity(new EventItem(title.getText().toString(), new Date(year, month, day, hour, minute),
                        Integer.parseInt(duration.getText().toString()), description.getText().toString(),
                        type, address.getText().toString(), city.getText().toString(), state.getText().toString(), "",
                        user.getFirstName(), user.getLastName()), user.getId()+"");
                finish();
            }
        });

    }
}
