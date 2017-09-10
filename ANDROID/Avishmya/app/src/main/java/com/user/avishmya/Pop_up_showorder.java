package com.user.avishmya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
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

public class Pop_up_showorder extends AppCompatActivity {
    /////////////
    private RecyclerView recyclerView;
    private LinearLayoutManager LayoutManager;
    private yourorderAdapter adapter;

    String sl[],name[],price[],imgurl[],qnty[];
    String sl_str="",output="",s="",qnty_str="";
    String name_str="";
    String price_str="";
    String imgurl_str="";
    LinearLayout confrom;
    ///////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_showorder);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        /////////////
        StringRequest jsonObjectRequest = new StringRequest
                (Request.Method.POST, Data.URL+"showorder.jsp",
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String output) {
                                if(!output.equals("false")) {
                                    String si[] = output.trim().split("&");
                                    try {
                                        boolean k = false;
                                        for (int i = 0; i < si.length; i++) {
                                            if (k) {
                                                sl_str = sl_str + "=";
                                                qnty_str=qnty_str+"=";
                                                name_str = name_str + "=";
                                                price_str = price_str + "=";
                                                imgurl_str = imgurl_str + "=";
                                            }
                                            JSONObject jsonObject = new JSONObject(si[i]);
                                            sl_str = sl_str + jsonObject.getString("sl");
                                            qnty_str=qnty_str+jsonObject.getString("quantity");
                                            name_str = name_str + jsonObject.getString("name");
                                            price_str = price_str + jsonObject.getString("price");
                                            imgurl_str = imgurl_str + jsonObject.getString("imageurl");
                                            k = true;
                                        }
                                        sl = sl_str.trim().split("=");
                                        qnty=qnty_str.trim().split("=");
                                        name = name_str.trim().split("=");
                                        price = price_str.trim().split("=");
                                        imgurl = imgurl_str.trim().split("=");
                                        recyclerView = (RecyclerView) findViewById(R.id.recycler_viewjkk);
                                        LayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
                                        recyclerView.setLayoutManager(LayoutManager);
                                        adapter=new yourorderAdapter(getApplicationContext(),sl,name,imgurl,qnty,price);
                                        recyclerView.setAdapter(adapter);
                                    } catch (Exception e) {}
                                }
                                else {
                                    Toast.makeText(Pop_up_showorder.this, "Slow Internet", Toast.LENGTH_SHORT).show();
                                }
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

            String kk="";
                boolean k=false;
                Map<String, String> params = new HashMap<String, String>();
                for (String na: Data.params.keySet()) {
                    if (!Data.params.get(na).toString().equals("0")) {
                        if (k) {
                            kk = kk + ",";
                        }
                        kk = kk + na.toString() + "=" + Data.params.get(na).toString();
                        k = true;
                    }
                }
                params.put("code", kk);
                return params;
            }



        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);
        //////////////

        confrom=(LinearLayout)findViewById(R.id.comfrom);
        confrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String name: Data.params.keySet()) {

                    final String key = name.toString();
                    final String value = Data.params.get(name).toString();
                   // Toast.makeText(getApplicationContext(), key + "--" + value, Toast.LENGTH_SHORT).show();

                    StringRequest jsonObjectRequest = new StringRequest
                            (Request.Method.POST, Data.URL + "itemorder.jsp",
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String output) {
                                            if(output.trim().toString().equals("ok")) {
                                                Toast.makeText(Pop_up_showorder.this, "your order Confromed\nthanks for ordering", Toast.LENGTH_SHORT).show();
                                                Intent i = new Intent(getApplicationContext(), orderlist.class);
                                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(i);
                                                finish();
                                            }
                                            else
                                                Toast.makeText(Pop_up_showorder.this, "There is somthing worng in network connection", Toast.LENGTH_SHORT).show();
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                        }
                                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("scode", Data.code2);
                            params.put("id", key);
                            params.put("no", value);
                            return params;
                        }


                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonObjectRequest);
                }


            }
        });

    }
}
