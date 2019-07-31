package com.example.zee.Networks;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zee.HomeInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PostsNetwork {
    public static void request(final Context context, final String text, final String api_token, final HomeInterface homeInterface) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebServiceConstants.createPost.API_CREATEPOST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    switch (jsonObject.getString("status")) {
                        case "success":
                            JSONObject ArrayFromString;
                            try {
                                ArrayFromString = new JSONObject(response);
                                if (ArrayFromString.has("status")) {
                                    if (ArrayFromString.getString("status").equals("success")) {
                                        homeInterface.createPost(response);
                                    } else if (ArrayFromString.getString("status").equals("fail")) {
                                        Toast.makeText(context, "Failed to create a post!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
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
                parameters.put(WebServiceConstants.API_TOKEN, api_token);
                parameters.put(WebServiceConstants.createPost.text, text);
                return parameters;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    public static void listPosts(final Context context, final String api_token, final HomeInterface homeInterface) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebServiceConstants.Posts.LIST_POSTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    switch (jsonObject.getString("status")) {
                        case "success":
                            JSONObject ArrayFromString;
                            try {
                                ArrayFromString = new JSONObject(response);
                                if (ArrayFromString.has("status")) {
                                    if (ArrayFromString.getString("status").equals("success")) {
                                        homeInterface.listPosts(response);
                                    } else if (ArrayFromString.getString("status").equals("fail")) {
                                        Toast.makeText(context, "Failed to create a post!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
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
                parameters.put(WebServiceConstants.API_TOKEN, api_token);
                parameters.put(WebServiceConstants.LIMIT, "10");
                parameters.put(WebServiceConstants.PAGE, "1");
                return parameters;
            }
        };
        mRequestQueue.add(stringRequest);
    }
}
