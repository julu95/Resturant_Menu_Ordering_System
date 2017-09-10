package com.user.avishmya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;
import java.util.Map;

/**
 * Created by user on 11-02-2017.
 */
public class Server_Volley {
    static String sss="false";
    static JSONObject jsonobject;

    static String sever_string(String URL, final Context context, final Map params){
        StringRequest jsonObjectRequest = new StringRequest
                (Request.Method.POST, URL,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                sss = response;
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                               sss=error.toString();
                            }
                        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
        return sss;
    }

}
