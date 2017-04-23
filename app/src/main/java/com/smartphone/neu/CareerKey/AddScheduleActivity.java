package com.smartphone.neu.CareerKey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class AddScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        String[] itemsam = new String[] {"9：00-10：00", "10：00-11：00", "11：00-12：00"};
        Spinner spinneram = (Spinner) findViewById(R.id.spinnertimeAM);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsam);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneram.setAdapter(adapter);
        String[] itemspm = new String[] {"1：00-2：00", "2：00-3：00", "3：00-4：00","4：00-5：00"};
        Spinner spinnerpm = (Spinner) findViewById(R.id.spinnertimePM);
        ArrayAdapter<String> adapterpm = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemspm);
        adapterpm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerpm.setAdapter(adapterpm);


        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        TextView txtView = (TextView) findViewById(R.id.textViewmessege);
        txtView.setText(message);

        Button submitButton = (Button) findViewById(R.id.buttonsub);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
