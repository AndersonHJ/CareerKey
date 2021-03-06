package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
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
import java.util.List;

public class LecturerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    UserItem user;
//    static LecturerItem lecturer;

    private TextView mTextMessage;
    private ListView eventListView;

    ListItemAdapter eventAdapter;
    ListItemAdapter courseAdapter;
    LecturerListAdapter meetingAdapter;

    DataManager manager = null;

    private int itemNumber = 1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_event);
                    List<EventItem> list = manager.getEvents();
                    eventAdapter.clear();
                    eventAdapter.addAll(list);
                    eventListView.setAdapter(eventAdapter);
                    itemNumber = 1;
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_course);
                    List<EventItem> list2 = manager.getCourses();
                    courseAdapter.clear();
                    courseAdapter.addAll(list2);
                    eventListView.setAdapter(courseAdapter);
                    itemNumber = 2;
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_1v1meeting);
                    List<LecturerItem> list3 = manager.getLecturers();
                    meetingAdapter.clear();
                    meetingAdapter.addAll(list3);
                    eventListView.setAdapter(meetingAdapter);
                    itemNumber = 3;
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

        user = (UserItem) getIntent().getSerializableExtra("User");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LecturerActivity.this, PublishActivity.class);
                intent.putExtra("User", user);
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

        manager = new DataManager();
        List<EventItem> list = manager.getEvents();

        eventAdapter = new ListItemAdapter(this, R.layout.event_item, R.id.title_item, list);

        List<EventItem> list2 = manager.getCourses();

        courseAdapter = new ListItemAdapter(this, R.layout.event_item, R.id.title_item, list2);

        List<LecturerItem> list3 = manager.getLecturers();

        meetingAdapter = new LecturerListAdapter(this, R.layout.lecturer_item, R.id.title_item, list3);


        eventListView.setAdapter(eventAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemNumber<3){
                    Intent intent = new Intent(LecturerActivity.this, EventDetailActivity.class);
                    intent.putExtra("Event", (EventItem)adapterView.getItemAtPosition(i));
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(LecturerActivity.this, LecturerDetailActivity.class);
                    intent.putExtra("Lecturer", (LecturerItem)adapterView.getItemAtPosition(i));
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();

        if(itemNumber==1){
            mTextMessage.setText(R.string.title_event);
            List<EventItem> list = manager.getEvents();
            eventAdapter.clear();
            eventAdapter.addAll(list);
            eventListView.setAdapter(eventAdapter);
        }
        else if(itemNumber==2){
            mTextMessage.setText(R.string.title_course);
            List<EventItem> list2 = manager.getCourses();
            courseAdapter.clear();
            courseAdapter.addAll(list2);
            eventListView.setAdapter(courseAdapter);
        }
        else {
            mTextMessage.setText(R.string.title_1v1meeting);
            List<LecturerItem> list3 = manager.getLecturers();
            meetingAdapter.clear();
            meetingAdapter.addAll(list3);
            eventListView.setAdapter(meetingAdapter);
        }
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
            Intent intent = new Intent(LecturerActivity.this, UserProfileActivity.class);
            intent.putExtra("User", user);
            startActivity(intent);
        } else if (id == R.id.nav_schedule) {
            Intent intent = new Intent(LecturerActivity.this, ScheduleActivity.class);
            startActivity(intent);
            intent.putExtra("User", user);
            startActivity(intent);
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
