package com.example.zee.Networks;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

public class RegistrationNetwork {
    public static void request(final Context context, final String firstName, final String lastName, final String email, final String phone,
                               final String password, final String confirmPass, final String company, final String title) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebServiceConstants.Register.API_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    switch (jsonObject.getString("status")) {
                        case "success":
                            //new implementation
                            JSONObject ArrayFromString = null;
                            try {
                                ArrayFromString = new JSONObject(response);
                                if (ArrayFromString.has("status"))
                                    if (ArrayFromString.getString("status").equals("success")) {
                                        com.example.zee.util.SharedPrefUtil.getInstance(context)
                                                .write(Constants.apiToken, ArrayFromString.getJSONObject("user")
                                                        .getString("api_token"));
                                        Intent homeActivity = new Intent(context, HomeActivity.class);
                                        com.example.zee.util.SharedPrefUtil.getInstance(context).read(Constants.apiToken, "");
                                        Log.e("sharedPreference", "onResponse: " + com.example.zee.util.SharedPrefUtil.getInstance(context).read(Constants.apiToken, ""));
                                        context.startActivity(homeActivity);
                                        //finish context
                                    } else if (ArrayFromString.getString("status").equals("fail")) {
                                        Toast.makeText(context, "Invalid data!", Toast.LENGTH_SHORT).show();
                                    } else {
                                    Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "fail":
                            //TODO check for fail cases
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context, "Registration done." + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map getParams() {
                Map parameters = new HashMap();
                parameters.put(WebServiceConstants.Register.first_name, firstName);
                parameters.put(WebServiceConstants.Register.last_name, lastName);
                parameters.put(WebServiceConstants.Register.email, email);
                parameters.put(WebServiceConstants.Register.mobile, phone);
                parameters.put(WebServiceConstants.Register.password, password);
                parameters.put(WebServiceConstants.Register.confirm_password, confirmPass);
                parameters.put(WebServiceConstants.Register.company, company);
                parameters.put(WebServiceConstants.Register.title, title);
                return parameters;
            }
        };
        mRequestQueue.add(stringRequest);
    }
}