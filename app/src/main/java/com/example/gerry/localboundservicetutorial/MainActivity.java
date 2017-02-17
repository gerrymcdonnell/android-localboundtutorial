package com.example.gerry.localboundservicetutorial;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
from youtube tutorial
https://www.youtube.com/watch?v=cJsqMisTaa8
 */
public class MainActivity extends AppCompatActivity {

    MyService myService;
    boolean isBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create intent for the service class
        Intent intent=new Intent(this,MyService.class);
        //bind the intent
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    //display the random number in the text box
    public void getRandomNumber(View view){
        TextView textView=(TextView) findViewById(R.id.textView3);

        textView.setText(Integer.toString(myService.getRandom()));
    }


    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyService.LocalBinder binder=(MyService.LocalBinder) service;
            myService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };//close
}
