package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class LecturerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private ListView eventListView;

    ListItemAdapter eventAdapter;
    ListItemAdapter courseAdapter;
    ListItemAdapter meetingAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_event);
                    eventListView.setAdapter(eventAdapter);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_course);
                    eventListView.setAdapter(courseAdapter);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_1v1meeting);
                    eventListView.setAdapter(meetingAdapter);
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LecturerActivity.this, PublishActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        eventListView = (ListView) findViewById(R.id.event_list);

        ArrayList<EventItem> list = new ArrayList<>();
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));
//        list.add(new EventItem("first", "Java Dev", new Date(2016, 3, 12, 13, 0), "The java class for students"));


        eventAdapter = new ListItemAdapter(this, R.layout.event_item, R.id.title_item, list);

        ArrayList<EventItem> list2 = new ArrayList<>();
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));
//        list2.add(new EventItem("second", "C++ class", new Date(2017, 2, 24, 9, 0), "C++ class for job seekers"));

        courseAdapter = new ListItemAdapter(this, R.layout.event_item, R.id.title_item, list2);

        ArrayList<EventItem> list3 = new ArrayList<>();
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));
//        list3.add(new EventItem("third", "Database", new Date(2017, 1, 3, 12, 30), "sql language"));

        meetingAdapter = new ListItemAdapter(this, R.layout.event_item, R.id.title_item, list3);


        eventListView.setAdapter(eventAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lecturer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            startActivity(new Intent(LecturerActivity.this, UserProfileActivity.class));
        } else if (id == R.id.nav_schedule) {
            startActivity(new Intent(LecturerActivity.this, ScheduleActivity.class));
        } else if (id == R.id.nav_setting) {
           // startActivity(new Intent(LecturerActivity.this, SettingsActivity.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
