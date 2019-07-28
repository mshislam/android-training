package com.example.zee.Networks;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zee.Activities.HomeActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginNetwork {
    public static void request(final Context con,final EditText emailtext, final EditText password){
        String URL="http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/login";
        RequestQueue mRequestQueue= Volley.newRequestQueue(con);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(con, "login " + response.toString(), Toast.LENGTH_LONG).show();
               /* if (response.toLowerCase().contains("success")){*/
                    Intent homeActivity =new Intent(con, HomeActivity.class);
                    con.startActivity(homeActivity);
                /*}*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }){
            @Override
            public Map getParams() {
                Map params = new HashMap();
                params.put("email", emailtext.getText().toString());
                params.put("password", password.getText().toString());
                params.put("notificationToken","gfcshc;usdfpi");
//                Toast.makeText(getApplicationContext(), " " + params.toString(), Toast.LENGTH_LONG).show();
                return params;
            }
        };


        mRequestQueue.add(stringRequest);
    }

}
