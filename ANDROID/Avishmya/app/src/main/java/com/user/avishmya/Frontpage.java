package com.user.avishmya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Frontpage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        getSupportActionBar().hide();
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Adv.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        }, 3000);
      // System.exit(0);
    }
}
