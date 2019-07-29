package com.example.zee.Networks;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrationNetwork {
    public static void request(final Context context, final EditText firstName, final EditText lastName, final EditText email, final EditText phone,
                               final EditText password, final EditText confirmPass, final EditText company, final EditText title)
    {
        String url ="http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/register";
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Registration done." + response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            public Map getParams(){
                Map parameters = new HashMap();
                parameters.put("firstName", firstName.getText().toString());
                parameters.put("lastName", lastName.getText().toString());
                parameters.put("email", email.getText().toString());
                parameters.put("phone", phone.getText().toString());
                parameters.put("password", password.getText().toString());
                parameters.put("confirmPass", confirmPass.getText().toString());
                parameters.put("company", company.getText().toString());
                parameters.put("title", title.getText().toString());

                return parameters;
            }
        };
        mRequestQueue.add(stringRequest);
    }
}


/*    public static String name = "name";
    public static String first_name = "first_name";
    public static String last_name = "last_name";
    public static String mobile = "mobile";
    public static String email = "email";
    public static String company = "company";
    public static String password = "password";
    public static String confirm_password = "confirm_password";
    public static String title = "title";*/
