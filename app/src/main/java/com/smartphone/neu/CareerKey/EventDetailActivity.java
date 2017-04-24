package com.smartphone.neu.CareerKey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {
    private TextView startTime;
    private TextView title;
    private TextView description;
    private TextView address;
    private TextView startTimeTitle;
    private TextView descrTitle;
    private TextView addressTitle;
    private ImageView image;
    private EventItem eventItem;
    private TextView imgSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startTime = (TextView) findViewById(R.id.startTime);
        startTimeTitle = (TextView) findViewById(R.id.timeTitle);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        descrTitle = (TextView) findViewById(R.id.descTitle);
        address = (TextView) findViewById(R.id.address);
        addressTitle = (TextView) findViewById(R.id.addressTitle);
        image = (ImageView) findViewById(R.id.image);
        eventItem = getEventItem();
        startTime.setText(eventItem.getStartTime().toString());
        title.setText(eventItem.getTitle().toString());
        description.setText(eventItem.getDescription().toString());
        address.setText(eventItem.getAddress().toString());

        imgSrc = (TextView) findViewById(R.id.imgSrc);
        imgSrc.setText(eventItem.getImage().toString());
    }

    private EventItem getEventItem() {
        Intent intent = getIntent();
    return (EventItem) intent.getSerializableExtra("Event");}

}
