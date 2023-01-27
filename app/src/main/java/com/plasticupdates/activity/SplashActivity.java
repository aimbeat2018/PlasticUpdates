package com.plasticupdates.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.plasticupdates.R;
import com.plasticupdates.activity.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        init();
    }
    private void init() {


        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(2000);

                    //  if(SharedPrefrence.getBol(SplashPageActivity.this, SharedPrefrence.isLogin)){

                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                     /*   finish();
                    }else{

                        gotonext();
                    }*/

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();

    }

}