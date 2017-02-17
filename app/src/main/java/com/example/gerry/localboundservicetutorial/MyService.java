package com.example.gerry.localboundservicetutorial;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.Random;

public class MyService extends Service {

    public final IBinder iBinder = new LocalBinder();

    private final Random mGenerator=new Random();

    //added here
    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public int getRandom(){
        return mGenerator.nextInt(200);
    }
}

