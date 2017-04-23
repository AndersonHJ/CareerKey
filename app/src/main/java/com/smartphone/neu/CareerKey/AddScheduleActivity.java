package com.smartphone.neu.CareerKey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AddScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        String[] itemsam = new String[] {"One", "Two", "Three"};
        Spinner spinneram = (Spinner) findViewById(R.id.spinnertimeAM);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsam);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneram.setAdapter(adapter);
        String[] itemspm = new String[] {"One", "Two", "Three"};
        Spinner spinnerpm = (Spinner) findViewById(R.id.spinnertimePM);
        ArrayAdapter<String> adapterpm = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemspm);
        adapterpm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerpm.setAdapter(adapterpm);


        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        TextView txtView = (TextView) findViewById(R.id.textViewmessege);
        txtView.setText(message);
    }
}
