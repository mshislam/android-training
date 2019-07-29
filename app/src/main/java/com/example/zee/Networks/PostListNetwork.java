package com.example.zee.Networks;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class PostListNetwork {
    public static void requestPosts(Context con) {
        String URL = "http://eventi-do1.mideastsoft.com/staging/api/v2/fdc/login";
        RequestQueue mRequestQueue = Volley.newRequestQueue(con);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
}
