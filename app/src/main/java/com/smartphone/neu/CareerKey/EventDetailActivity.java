package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {
    private TextView startTime;
    private TextView title;
    private TextView description;
    private TextView address;
    private ImageView image;
    private Intent eventDetailIntent;
    private EventItem eventItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startTime = (TextView) findViewById(R.id.startTime);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        address = (TextView) findViewById(R.id.address);
        image = (ImageView) findViewById(R.id.image);
        eventDetailIntent = new Intent();
        eventItem = getEventItem();
        startTime.setText(eventItem.getStartTime().toString());
        title.setText(eventItem.getTitle().toString());
        description.setText(eventItem.getDescription().toString());
        address.setText(eventItem.getAddress().toString());
    }

    private EventItem getEventItem() {
        Intent intent = getIntent();
    return (EventItem) intent.getSerializableExtra("Event");}

}
