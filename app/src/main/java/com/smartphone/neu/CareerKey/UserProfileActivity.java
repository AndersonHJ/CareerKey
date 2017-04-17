package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userSchool;
    private EditText userCity;
    private RadioGroup userTypeGroup;
    private RadioButton userTypeStudent;
    private RadioButton userTypeLecturer;
    private boolean userType;   //false is student, true is lecturer
    private Button userProfileSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userName = (EditText) findViewById(R.id.txtUserName);
        userSchool = (EditText) findViewById(R.id.txtUserSchool);
        userCity = (EditText) findViewById(R.id.txtUserCity);

        userTypeGroup = (RadioGroup) findViewById(R.id.radiogroupUserType);
        userTypeStudent = (RadioButton) findViewById(R.id.radiobtnUserStudent);
        userTypeLecturer = (RadioButton) findViewById(R.id.radiobtnUserLecturer);

        userTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (userTypeStudent.getId() == checkedId) {
                    userType = false;
                } else if (userTypeLecturer.getId() == checkedId) {
                    userType = true;
                }
            }
        });

        Intent intent = new Intent();
        intent.putExtra("userName", userName.toString());
        intent.putExtra("userSchool", userSchool.toString());
        intent.putExtra("userCity", userCity.toString());
        intent.putExtra("userType", userType);

        userProfileSubmit = (Button) findViewById(R.id.btnUserProfileSubmit);
        userProfileSubmit.setOnClickListener(new uploadUserProfileListener());
    }

    class uploadUserProfileListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //upload intent
            Toast.makeText(getApplicationContext(), "Submit Successfully!", Toast.LENGTH_LONG).show();
        }
    }
}
