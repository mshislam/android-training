package com.example.zee.Networks;

import android.content.Context;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zee.CallBack;
import com.example.zee.Models.ResponseList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.zee.Activities.*;
import com.example.zee.Adapters.*;

public class Comments {
    static com.example.zee.Activities.CommentsActivity commentsActivity;

    public static void listComments(final Context context, final String api_token, final String post_id, final CallBack callBack) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                WebServiceConstants.Comments.API_LIST_COMMENTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    if (jsonObject.has("status")) {
                        if (jsonObject.getString("status").equals("success")) {
                            callBack.onComplete(response, null);
                        } else if (jsonObject.getString("success").equals("fail")) {
                            Toast.makeText(context, "something went wrong", Toast.LENGTH_LONG);
                        }
                    }

                } catch (JSONException e) {
//                    Toast.makeText(context, "" + response, Toast.LENGTH_LONG);
//                    Type type = new TypeToken<ArrayList<com.example.zee.Models.ResponseList>>() {
//                    }.getType();
//                    Gson gson = new Gson();
//                    ArrayList<com.example.zee.Models.ResponseList> responseArray = gson.fromJson(response, type);

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
            public Map<String, String> getParams() {
                Map params = new HashMap();
                params.put(WebServiceConstants.API_TOKEN, api_token);
                params.put("limit", "10");
                params.put("page", "1");
                params.put(WebServiceConstants.Comments.post_id, post_id);
                Log.e("paramaters", "getParams: " + params.toString());
                return params;
            }
        };

        mRequestQueue.add(stringRequest);
    }

//    public static ArrayList<ResponseList> getCommentsList(){
//        Type type =new TypeToken<ArrayList<com.example.zee.Models.ResponseList>>(){}.getType();
//        Gson gson=new Gson();
//        ArrayList<com.example.zee.Models.ResponseList>responseArray=gson.fromJson(response,type);
//    return responseArray;}

    public static void createComments() {


    }
}
