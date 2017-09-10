package com.user.avishmya;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class seat extends AppCompatActivity {
Spinner seatt;
    TextView status,showseat,itemno;
    EditText name;
    Button  ok;
    ImageView plase,sub;
    static String code;
    static String sss;

    String arr[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_seat);
        name=(EditText)findViewById(R.id.editText2);
        status=(TextView)findViewById(R.id.textView25);
        ok=(Button)findViewById(R.id.button12);
        code=Data.code2;
        ////////////////////////////////////
        plase=(ImageView)findViewById(R.id.pluse);
        sub=(ImageView)findViewById(R.id.subb);
        itemno=(TextView)findViewById(R.id.number);

        plase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no=Integer.parseInt(itemno.getText().toString());
                no=no+1;
                itemno.setText(""+no);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no=Integer.parseInt(itemno.getText().toString());
                if(no!=0){
                    no=no-1;
                    itemno.setText(""+no);
                }
            }
        });

        showseat=(TextView)findViewById(R.id.showseatt);
        showseat.setText(selectseat.st);
        showseat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(itemno.getText().toString())>0) {
                    Intent i = new Intent(getApplicationContext(), selectseat.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.putExtra("no", itemno.getText().toString());
                    startActivity(i);
                }
                else Toast.makeText(seat.this, "Plz update number of person.", Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////////////
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //status.setText(sss);
                if(name.getText().toString().toCharArray().length!=0){

                    /////////////////////////////

                    StringRequest stringRequest1 = new StringRequest
                            (Request.Method.POST, Data.URL + "updateadmin.jsp",
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            //Toast.makeText(Lgin.this,"plz select ur items"+response, Toast.LENGTH_LONG).show();
                                            if(response.trim().equals("1")) {
                                                status.setText("Succesefully inserted");
                                                Intent i = new Intent(getApplicationContext(), mainpage.class);
                                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                i.putExtra("code", code);
                                                startActivity(i);

                                                Data.name=name.getText().toString().trim();
                                                name.setText("");
                                                finish();
                                            }
                                            else status.setText(response.toString().trim());
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(getApplicationContext(), "error to connect", Toast.LENGTH_LONG).show();
                                        }
                                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("code", code);
                            params.put("seat", showseat.getText().toString().trim());
                            params.put("name", name.getText().toString().trim());

                            return params;
                        }
                    };

                    RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                    requestQueue1.add(stringRequest1);


                    ///////////////

                }
                else status.setText("Plz enter name");

            }
        });

    }
}
