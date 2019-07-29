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
import com.example.zee.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginNetwork {
    public static void request(final Context context, final String emailtext, final String password) {
        String URL = "http://eventi-do1.mideastsoft.com/staging/api/v2/fdc/login";
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(context, "login " + response.toString(), Toast.LENGTH_LONG).show();
                /* if (response.toLowerCase().contains("success")){*/
                JSONObject ArrayFromString = null;
                try {
                    ArrayFromString = new JSONObject(response);
                    if (ArrayFromString.has("status"))
                        if (ArrayFromString.getString("status").equals("success")) {
                            com.example.zee.Util.SharedPrefUtil.getInstance(context).write(Constants.apiToken,
                                    ArrayFromString.getJSONObject("user").getString("api_token"));
                            Intent homeActivity = new Intent(context, HomeActivity.class);
                            com.example.zee.Util.SharedPrefUtil.getInstance(context).read(Constants.apiToken, "");
                            Log.e("sharedPreference", "onResponse: " + com.example.zee.Util.SharedPrefUtil.getInstance(context).read(Constants.apiToken, ""));
                            context.startActivity(homeActivity);
                            //finish context
                        } else if (ArrayFromString.getString("status").equals("fail")) {
                            Toast.makeText(context, "Email or password are not correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                        }
                    else {
                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                /*}*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }) {
            @Override
            public Map getParams() {
                Map params = new HashMap();
                params.put("email", emailtext);
                params.put("password", password);
                params.put("notificationToken", "gfcshc;usddddfpi");
//                Toast.makeText(getApplicationContext(), " " + params.toString(), Toast.LENGTH_LONG).show();
                return params;
            }
        };


        mRequestQueue.add(stringRequest);
    }

}
