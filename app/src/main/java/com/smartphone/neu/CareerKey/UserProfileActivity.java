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
    private EditText userFirstName;
    private EditText userLastName;
    private EditText userSchool;
    private EditText userEmail;
    private EditText userCity;
//    private RadioGroup userTypeGroup;
//    private RadioButton userTypeStudent;
//    private RadioButton userTypeLecturer;
//    private boolean userType;   //false is student, true is lecturer
    private Button userProfileSubmit;
    private Intent userProfileIntent;
    private UserItem userItem;

    private  DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userFirstName = (EditText) findViewById(R.id.txtUserFirstName);
        userLastName = (EditText) findViewById(R.id.txtUserLastName);
        userEmail = (EditText) findViewById(R.id.txtUserEmail);
        userSchool = (EditText) findViewById(R.id.txtUserSchool);
        userCity = (EditText) findViewById(R.id.txtUserCity);

        dataManager = new DataManager();
//        userTypeGroup = (RadioGroup) findViewById(R.id.radiogroupUserType);
//        userTypeStudent = (RadioButton) findViewById(R.id.radiobtnUserStudent);
//        userTypeLecturer = (RadioButton) findViewById(R.id.radiobtnUserLecturer);
//
//        userTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                if (userTypeStudent.getId() == checkedId) {
//                    userType = false;
//                } else if (userTypeLecturer.getId() == checkedId) {
//                    userType = true;
//                }
//            }
//        });

        userProfileIntent = new Intent();
        userItem = getUserItem();

        userEmail.setText(userItem.getEmail());
        if (userItem.getFirstName() != null && userItem.getFirstName().length() != 0) {
            userFirstName.setText(userItem.getFirstName());
        }
        if (userItem.getLastName() != null && userItem.getLastName().length() != 0) {
            userLastName.setText(userItem.getLastName());
        }
        if (userItem.getSchool() != null && userItem.getSchool().length() != 0) {
            userSchool.setText(userItem.getSchool());
        }
        if (userItem.getCity() != null && userItem.getCity().length() != 0) {
            userCity.setText(userItem.getCity());
        }

        if ((userItem.getFirstName() == null || userItem.getFirstName().length() == 0) && userFirstName.toString().length() != 0){
            userItem.setFirstName(userFirstName.toString());
        }
        if ((userItem.getLastName() == null || userItem.getLastName().length() == 0) && userLastName.toString().length() != 0){
            userItem.setLastName(userLastName.toString());
        }
        if ((userItem.getCity() == null || userItem.getCity().length() == 0) && userCity.toString().length() != 0){
            userItem.setCity(userCity.toString());
        }
        if ((userItem.getSchool() == null || userItem.getSchool().length() == 0) && userSchool.toString().length() != 0){
            userItem.setSchool(userSchool.toString());
        }
//        if (userItem.getType() == null){
//            userItem.setType(userType);
//        }

        userProfileSubmit = (Button) findViewById(R.id.btnUserProfileSubmit);
        userProfileSubmit.setOnClickListener(new uploadUserProfileListener());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
//        setSupportActionBar(toolbar);
//
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private UserItem getUserItem() {
        Intent intent = getIntent();
        return (UserItem) intent.getSerializableExtra("User");
    }

    class uploadUserProfileListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (userItem.getLastName() == null || userItem.getFirstName() == null || userItem.getFirstName().length() == 0 || userItem.getLastName().length() == 0) {
                Toast.makeText(getApplicationContext(), "Please type in Your First Name and Your Last Name!", Toast.LENGTH_LONG).show();
                return;
            }
            userItem.setCity(userCity.getText().toString());
            userItem.setEmail(userEmail.getText().toString());
            userItem.setSchool(userSchool.getText().toString());
            userItem.setType(userItem.getType());
            userItem.setFirstName(userFirstName.getText().toString());
            userItem.setLastName(userLastName.getText().toString());

            dataManager.updateUserItem(userItem);

            Intent intent = new Intent(UserProfileActivity.this, LecturerActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Submit Successfully!", Toast.LENGTH_LONG).show();
        }
    }
}
