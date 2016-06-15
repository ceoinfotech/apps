package com.example.ceohp.andservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    TextView t1;
    public static final String mBroadcastStringAction = "broadcaststring";
    private IntentFilter mIntentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(mBroadcastStringAction);
        // Intent intent = new Intent(this, Myservice.class);
        //startService(intent);
        // startService(new Intent(this, Myservice1.class));

      //  this.registerReceiver(ReceivefromService, new IntentFilter("CUSTOMINTENT"));
        //

    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(ReceivefromService, mIntentFilter);
    }
   private BroadcastReceiver ReceivefromService = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //get the data using the keys you entered at the service

            t1 = (TextView) findViewById(R.id.ss);
            String num = intent.getStringExtra("incoming");

            t1.setText(num);

        }
    };




    @Override
    protected void onPause() {
        unregisterReceiver(ReceivefromService);
        super.onPause();
    }


    public void startService(View view) {
        startService(new Intent(getBaseContext(), Myservice.class));
        // Intent intent = new Intent(this, Myservice1.class);
        //startService(intent);
    }
}
