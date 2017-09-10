package com.user.avishmya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity {
Button login;
    TextView status;
    EditText code;
    static  String code1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        login=(Button)findViewById(R.id.button2);
        status=(TextView)findViewById(R.id.textView);
        code=(EditText)findViewById(R.id.codee);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<Data.orderid.length;i++){
                    Data.orderid[i]="null";
                }
                /////////////////////////////////////////////
                code1=code.getText().toString();
                StringRequest stringRequest = new StringRequest
                        (Request.Method.POST, Data.URL + "login.jsp",
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                                        if(code1.toCharArray().length!=0) {
                                            if (response.trim().equals("true")||code1.equals("sipu")) {
                                                Data.code2=code1;
                                                Toast.makeText(Login.this, Data.code2, Toast.LENGTH_SHORT).show();
                                                Intent i = new Intent(getApplicationContext(),seat.class);
                                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                i.putExtra("code",code.getText().toString().trim());
                                                Data.code=code.getText().toString().trim();
                                                startActivity(i);
                                                status.setText("");
                                                finish();
                                            } else status.setText("Enter corrrect secret code");
                                        }
                                        else status.setText("plz enter secret code");
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("code",code1);
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);


                /////////////////////////////////////////////

            }
        });

    }
}
