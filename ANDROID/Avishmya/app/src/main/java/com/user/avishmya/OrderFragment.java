package com.user.avishmya;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    Button rice, nonveg, veg, strt, dest, done;
    ListView listView;
    View view;
    TextView textView;
    LinearLayout l1,l2;
    /////////////
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapter adapter;
    ///////////////////
    static String id[],name[],price[],imgurl[];
    static String id_str="",output="",s="";
    static String name_str="";
    static String price_str="";
    static String imgurl_str="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order, container, false);
        strt = (Button) view.findViewById(R.id.button3);
        rice = (Button) view.findViewById(R.id.button7);
        nonveg = (Button) view.findViewById(R.id.button4);
        veg = (Button) view.findViewById(R.id.button5);
        done = (Button) view.findViewById(R.id.button8);
        dest = (Button) view.findViewById(R.id.button6);
        textView = (TextView) view.findViewById(R.id.textView22);
        l1=(LinearLayout)view.findViewById(R.id.l1);
        l2=(LinearLayout)view.findViewById(R.id.l2);
        /////////////////////////////////////////////
       /* done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getContext(),Data.orderid[0] , Toast.LENGTH_LONG).show();

                Intent i = new Intent(getContext(), orderlist.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });*/
        strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk();
                //strt.setBackground();
                textView.setText("Avishmya Starter Menu");
                id_str=name_str=price_str=imgurl_str=output="";
                StringRequest jsonObjectRequest = new StringRequest
                        (Request.Method.POST, Data.URL+"menuarr.jsp",
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
                                                        id_str = id_str + "=";
                                                        name_str = name_str + "=";
                                                        price_str = price_str + "=";
                                                        imgurl_str = imgurl_str + "=";
                                                    }
                                                    JSONObject jsonObject = new JSONObject(si[i]);
                                                    id_str = id_str + jsonObject.getString("id");
                                                    name_str = name_str + jsonObject.getString("name");
                                                    price_str = price_str + jsonObject.getString("price");
                                                    imgurl_str = imgurl_str + jsonObject.getString("image");
                                                    k = true;
                                                }
                                                id = id_str.trim().split("=");
                                                name = name_str.trim().split("=");
                                                price = price_str.trim().split("=");
                                                imgurl = imgurl_str.trim().split("=");
                                                fun();
                                            } catch (Exception e) {}
                                        }
                                        else {
                                            Toast.makeText(getContext(), "Slow Internet", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener()
                                {
                                    @Override
                                    public void onErrorResponse(VolleyError error)
                                    {
                                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("type", "1");
                        return params;
                    }


                };

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk();
                textView.setText("Avishmya Rice Menu");
                id_str=name_str=price_str=imgurl_str=output="";
                StringRequest jsonObjectRequest = new StringRequest
                        (Request.Method.POST, Data.URL+"menuarr.jsp",
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
                                                        id_str = id_str + "=";
                                                        name_str = name_str + "=";
                                                        price_str = price_str + "=";
                                                        imgurl_str = imgurl_str + "=";
                                                    }
                                                    JSONObject jsonObject = new JSONObject(si[i]);
                                                    id_str = id_str + jsonObject.getString("id");
                                                    name_str = name_str + jsonObject.getString("name");
                                                    price_str = price_str + jsonObject.getString("price");
                                                    imgurl_str = imgurl_str + jsonObject.getString("image");
                                                    k = true;
                                                }
                                                id = id_str.trim().split("=");
                                                name = name_str.trim().split("=");
                                                price = price_str.trim().split("=");
                                                imgurl = imgurl_str.trim().split("=");
                                                fun();
                                            } catch (Exception e) {}
                                        }
                                        else {
                                            Toast.makeText(getContext(), "Slow Internet", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener()
                                {
                                    @Override
                                    public void onErrorResponse(VolleyError error)
                                    {
                                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("type", "2");
                        return params;
                    }


                };

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

        nonveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk();
                textView.setText("Avishmya Nonveg. Menu");
                id_str=name_str=price_str=imgurl_str=output="";
                StringRequest jsonObjectRequest = new StringRequest
                        (Request.Method.POST, Data.URL+"menuarr.jsp",
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
                                                        id_str = id_str + "=";
                                                        name_str = name_str + "=";
                                                        price_str = price_str + "=";
                                                        imgurl_str = imgurl_str + "=";
                                                    }
                                                    JSONObject jsonObject = new JSONObject(si[i]);
                                                    id_str = id_str + jsonObject.getString("id");
                                                    name_str = name_str + jsonObject.getString("name");
                                                    price_str = price_str + jsonObject.getString("price");
                                                    imgurl_str = imgurl_str + jsonObject.getString("image");
                                                    k = true;
                                                }
                                                id = id_str.trim().split("=");
                                                name = name_str.trim().split("=");
                                                price = price_str.trim().split("=");
                                                imgurl = imgurl_str.trim().split("=");
                                                fun();
                                            } catch (Exception e) {}
                                        }
                                        else {
                                            Toast.makeText(getContext(), "Slow Internet", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener()
                                {
                                    @Override
                                    public void onErrorResponse(VolleyError error)
                                    {
                                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("type", "3");
                        return params;
                    }


                };

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk();
                textView.setText("Avishmya Veg. Menu");
                id_str=name_str=price_str=imgurl_str=output="";
                StringRequest jsonObjectRequest = new StringRequest
                        (Request.Method.POST, Data.URL+"menuarr.jsp",
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
                                                        id_str = id_str + "=";
                                                        name_str = name_str + "=";
                                                        price_str = price_str + "=";
                                                        imgurl_str = imgurl_str + "=";
                                                    }
                                                    JSONObject jsonObject = new JSONObject(si[i]);
                                                    id_str = id_str + jsonObject.getString("id");
                                                    name_str = name_str + jsonObject.getString("name");
                                                    price_str = price_str + jsonObject.getString("price");
                                                    imgurl_str = imgurl_str + jsonObject.getString("image");
                                                    k = true;
                                                }
                                                id = id_str.trim().split("=");
                                                name = name_str.trim().split("=");
                                                price = price_str.trim().split("=");
                                                imgurl = imgurl_str.trim().split("=");
                                                fun();
                                            } catch (Exception e) {}
                                        }
                                        else {
                                            Toast.makeText(getContext(), "Slow Internet", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener()
                                {
                                    @Override
                                    public void onErrorResponse(VolleyError error)
                                    {
                                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("type", "4");
                        return params;
                    }


                };

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

        dest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk();
                textView.setText("Avishmya Desert Menu");
                id_str=name_str=price_str=imgurl_str=output="";
                StringRequest jsonObjectRequest = new StringRequest
                        (Request.Method.POST, Data.URL+"menuarr.jsp",
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
                                                        id_str = id_str + "=";
                                                        name_str = name_str + "=";
                                                        price_str = price_str + "=";
                                                        imgurl_str = imgurl_str + "=";
                                                    }
                                                    JSONObject jsonObject = new JSONObject(si[i]);
                                                    id_str = id_str + jsonObject.getString("id");
                                                    name_str = name_str + jsonObject.getString("name");
                                                    price_str = price_str + jsonObject.getString("price");
                                                    imgurl_str = imgurl_str + jsonObject.getString("image");
                                                    k = true;
                                                }
                                                id = id_str.trim().split("=");
                                                name = name_str.trim().split("=");
                                                price = price_str.trim().split("=");
                                                imgurl = imgurl_str.trim().split("=");
                                                fun();
                                            } catch (Exception e) {}
                                        }
                                        else {
                                            Toast.makeText(getContext(), "Slow Internet", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener()
                                {
                                    @Override
                                    public void onErrorResponse(VolleyError error)
                                    {
                                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                })
                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("type", "5");
                        return params;
                    }


                };

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(jsonObjectRequest);

            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(getContext(),Pop_up_showorder.class));
                }
        });
        /////////////////////////////////////////////////////////////////////
        return view;
    }

    private void chk() {
        if(Data.show){
            l1.setVisibility(View.GONE);
            l2.setVisibility(View.VISIBLE);
            Data.show=false;
        }

    }

    public void fun(){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_viewjk);
        gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new CustomAdapter(getContext(),id,name,price,imgurl);
        recyclerView.setAdapter(adapter);
    }

}
