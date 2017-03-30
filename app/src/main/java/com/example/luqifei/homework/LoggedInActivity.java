package com.example.luqifei.homework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoggedInActivity extends AppCompatActivity {

    Button btnLogout;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;


    static int counter;
    TextView textView;

    private Button btnLogSignIn, btnRecycleView, btnUploadPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(LoggedInActivity.this, MainActivity.class));
                }
            }
        };

        textView = (TextView) findViewById(R.id.textViewTimeTick);
        counter = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private BroadcastReceiver timeTick = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(counter + " minutes after log in");
            counter++;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //registerReceiver(firstReceiver, filter);
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(timeTick, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //unregisterReceiver(firstReceiver); // when your app are not in frontpage, won't fire the action
        unregisterReceiver(timeTick);
    }
}
