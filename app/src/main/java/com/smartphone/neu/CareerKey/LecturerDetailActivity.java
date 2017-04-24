package com.smartphone.neu.CareerKey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class LecturerDetailActivity extends AppCompatActivity {
    TextView name = null;
    TextView email = null;
    TextView school = null;
    TextView city = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.Name);
        email = (TextView) findViewById(R.id.LecturerEmail);
        school = (TextView) findViewById(R.id.School);
        city = (TextView) findViewById(R.id.City);

        LecturerItem lecturerItem = (LecturerItem) getIntent().getSerializableExtra("Lecturer");

        name.setText(lecturerItem.getFirstName() +" "+ lecturerItem.getLastName());
        email.setText(lecturerItem.getEmail());
        school.setText(lecturerItem.getSchool());
        city.setText(lecturerItem.getCity());
    }
}
