package com.example.ceohp.andservice;

/**
 * Created by CeoHp on 14-06-2016.
 */
import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Myservice extends Service{
    private static Timer timer = new Timer();
    private Handler handler;
   String number;
    int d=0;
    private Context ctx;

    private static final String TAG = "Myservice";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
       // Log.i(TAG, "Service onCreate");
        Toast.makeText(this,
                "oncreate", Toast.LENGTH_LONG).show();
       isRunning = true;
        super.onCreate();
        ctx = this;
      //  progressBar = (ProgressBar) findViewById(R.id.progressBar1);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

       // Log.i(TAG, "Service onStartCommand");
       Toast.makeText(this,
                 "onstrat", Toast.LENGTH_LONG).show();

        final Calendar cal = Calendar.getInstance();
       cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR, 0);
       // final int interval = 1000; // 1 Second
        //Handler class in android
      /*  for (int i=0;i<=10;i++) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 2min

                    cal.add(Calendar.SECOND,1);
                    number = cal.getTime().toString();

                    Intent intent = new Intent();
                    intent.setAction(MainActivity.mBroadcastStringAction);
                    intent.putExtra("incoming", number);
                    sendBroadcast(intent);
                    Toast.makeText(ctx, "send", Toast.LENGTH_LONG).show();
                    // try {
                    //   Thread.sleep(1000);
                    // } catch (InterruptedException e) {
                    //e.printStackTrace();
                    // }


                    //cal.add(Calendar.SECOND,+1);
                    //number=cal.getTime().toString();

                    //Intent intent = new Intent();
                    //   ContentValues values = new ContentValues();


                }
            }, 3000);
        }
         /*////final Runnable runnable = new Runnable(){
           // public void run() {
             //   for (int i=0;i<=10;i++)
               // {
                 //   final int value =i;
               //     try {
                 //       Thread.sleep(2000);
                   // } catch (InterruptedException e) {
                     //   e.printStackTrace();
                    //}handler.post(new Runnable() {

                    //@Override

//                    public void run() {
//
  //                      progressBar.setProgress(value);
    //            }

             //   Toast.makeText(this,, Toast.LENGTH_SHORT).show();
                   // Log.i(TAG,"Service running");
      //      }
        //};

       //handler.postAtTime(runnable, System.currentTimeMillis()+interval);
       // handler.postDelayed(runnable, interval);

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
        new Thread(new Runnable() {
            @Override
            public void run() {


                //Your logic that service will perform will be placed here
                //In this example we are just looping and waits for 1000 milliseconds in each loop.
              for (int i = 0; i < 200; i++) {
                  cal.add(Calendar.SECOND,1);
                  number = cal.getTime().toString();
                 try {
                      Thread.sleep(1000);
                   } catch (Exception e) {
                    }

                 //   if(isRunning){
                   //   Log.i(TAG, "Service running");
                  Intent intent = new Intent();
                  intent.setAction(MainActivity.mBroadcastStringAction);
                  intent.putExtra("incoming", number);
                  sendBroadcast(intent);
//                  Toast.makeText(ctx, "send", Toast.LENGTH_LONG).show();

                    }
                }

                //Stop service once it finishes its task
              //  stopSelf();

        }).start();
              // stopSelf();
        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        //Log.i(TAG, "Service onBind");
        Toast.makeText(this,
                "onbind", Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public void onDestroy() {

        isRunning = false;
        Toast.makeText(this,
                "ondestroy", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "Service onDestroy");
    }
}

