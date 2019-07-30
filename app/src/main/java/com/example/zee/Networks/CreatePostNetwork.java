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

public class CreatePostNetwork {
    public static void request(final Context context, final String text){
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebServiceConstants.createPost.API_CREATEPOST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    switch (jsonObject.getString("status")){
                        case "success":
                            JSONObject ArrayFromString = null;
                            try {
                                ArrayFromString = new JSONObject(response);
                                if (ArrayFromString.has("status")) {
                                    if (ArrayFromString.getString("status").equals("success")) {
                                        com.example.zee.Util.SharedPrefUtil.getInstance(context)
                                                .write(Constants.apiToken, ArrayFromString.getJSONObject("user")
                                                        .getString("api_token"));
                                        Intent homeActivity = new Intent(context, HomeActivity.class);
                                        com.example.zee.Util.SharedPrefUtil.getInstance(context).read(Constants.apiToken, "");
                                        Log.e("sharedPreference", "onResponse: " + com.example.zee.Util.SharedPrefUtil.getInstance(context)
                                                .read(Constants.apiToken, ""));
                                        context.startActivity(homeActivity);
                                    } else if (ArrayFromString.getString("status").equals("fail")) {
                                        Toast.makeText(context, "Failed to create a post!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            catch (JSONException e) {
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
                Toast.makeText(context, "post successful" + response, Toast.LENGTH_LONG).show();
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
                parameters.put(Constants.apiToken, com.example.zee.Util.SharedPrefUtil.getInstance(context).read("",""));
                parameters.put(WebServiceConstants.createPost.text, text);
                return parameters;
            }
        };
        mRequestQueue.add(stringRequest);
    }
}
