package com.user.avishmya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.Menu;

import java.util.Timer;
import java.util.TimerTask;

public class Adv extends AppCompatActivity {
    Button b1;
    private WebView wv1;
    private class WebClient extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);
        getSupportActionBar().hide();
        /*Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        }, 3000);*/
        b1=(Button)findViewById(R.id.button);

        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new WebClient());
        wv1.loadUrl(Data.URL+"adv.html");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
    }

}
