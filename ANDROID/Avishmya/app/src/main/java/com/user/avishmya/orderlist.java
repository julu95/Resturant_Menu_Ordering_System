package com.user.avishmya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class orderlist extends AppCompatActivity {
TextView total,textView1,ssts;
    ListView order;
    Button pay,sts;
    static  String out;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    private RecyclerView recyclerView;
    private LinearLayoutManager LayoutManager;
    private yourorderAdapter adapter;
    String sl[],name[],price[],imgurl[],qnty[];
    String sl_str="",output="",s="",qnty_str="";
    String name_str="";
    String price_str="";
    String imgurl_str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderlist);
        total=(TextView)findViewById(R.id.total);
        textView1=(TextView)findViewById(R.id.textView30);
        pay=(Button)findViewById(R.id.button9);
        sts=(Button)findViewById(R.id.button10);
        listView=(ListView)findViewById(R.id.listView);


        getSupportActionBar().hide();

        StringRequest jsonObjectRequest = new StringRequest
                (Request.Method.POST, Data.URL+"orderlist.jsp",
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String output) {
                                    String si[] = output.trim().split("&");
                                    try {
                                        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,si);
                                        listView.setAdapter(arrayAdapter);

                                    } catch (Exception e) {}

                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("code", Data.code);
                return params;
            }


        };

       RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);

        //////////////////////////////////////////
        StringRequest jsonObjectRequestt = new StringRequest
                (Request.Method.POST, Data.URL+"total.jsp",
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String output) {
                                total.setText("Hi "+Data.name+" Your,s Total Bill is Rs "+output.trim().toString()+"/- only");
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("code", Data.code);
                return params;
            }


        };

        RequestQueue requestQueuejju = Volley.newRequestQueue(getApplicationContext());
        requestQueuejju.add(jsonObjectRequestt);
        //////////////////////////////////////////////////////////////////////////////////////////////////*/

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),Thank.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        sts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest
                        (Request.Method.POST, Data.URL + "status.jsp",
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                                        textView1.setText(response.trim());

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
                        params.put("code",Data.code);
                        return params;
                    }

                };

                RequestQueue requestQuejjue = Volley.newRequestQueue(getApplicationContext());
                requestQuejjue.add(stringRequest);

            }
        });


    }
}
