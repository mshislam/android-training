package com.example.zee.Networks;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationNetwork {
    public static void request(final Context context, final String firstName, final String lastName, final String email, final String phone,
                               final String password, final String confirmPass, final String company, final String title) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebServiceConstants.registerKeys.API_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    switch (jsonObject.getString("status")) {
                        case "success":
                            //new implementation
                            //String stringObject = new String(response);
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
                parameters.put(WebServiceConstants.registerKeys.first_name, firstName);
                parameters.put(WebServiceConstants.registerKeys.last_name, lastName);
                parameters.put(WebServiceConstants.registerKeys.email, email);
                parameters.put(WebServiceConstants.registerKeys.mobile, phone);
                parameters.put(WebServiceConstants.registerKeys.password, password);
                parameters.put(WebServiceConstants.registerKeys.confirm_password, confirmPass);
                parameters.put(WebServiceConstants.registerKeys.company, company);
                parameters.put(WebServiceConstants.registerKeys.title, title);
                return parameters;
            }
        };
        mRequestQueue.add(stringRequest);
    }
}