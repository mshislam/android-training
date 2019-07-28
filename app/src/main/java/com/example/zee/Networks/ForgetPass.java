package com.example.zee.Networks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zee.Fragments.ForgetPassFragment;
import com.example.zee.Fragments.LoginFragment;
import com.example.zee.R;

import java.util.HashMap;
import java.util.Map;

public class ForgetPass {


    public static void sendVerificationCode(final Context context, final EditText emailtext, final ForgetPassFragment forgetPassFragment) {
        final ProgressDialog progressDialog = showProgressDialog(context);
        progressDialog.show();
        String URL = "http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/sendVerificationCode";
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.hide();
                Log.e("sendVerificationCode", "onResponse: " + response);
                if (response.toLowerCase().contains("success")) {
                    forgetPassFragment.showsecondlayout();
                } else
                    Toast.makeText(context, "verification code send" + response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                error.printStackTrace();

            }
        }) {
            @Override
            public Map getParams() {
                Map params = new HashMap();
                params.put("email", emailtext.getText().toString());
                params.put("notificationToken", "verification code send");
                return params;
            }
        };


        mRequestQueue.add(stringRequest);
    }

    public static void checkVerificationCodeExists(final Context context, final EditText code, final ForgetPassFragment forgetPassFragment) {
        final ProgressDialog progressDialog = showProgressDialog(context);
        progressDialog.show();
        String URL = "http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/checkVerificationCodeExists";
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Toast.makeText(context, " " + response, Toast.LENGTH_SHORT).show();
                if (response.toLowerCase().contains("success")) {
                    forgetPassFragment.showFragmentthree();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(context, " error", Toast.LENGTH_LONG).show();
                error.printStackTrace();

            }
        }) {
            @Override
            public Map getParams() {
                Map params = new HashMap();
                params.put("code", code.getText().toString());
                params.put("notificationToken", "verification code is valid");
                return params;
            }
        };


        mRequestQueue.add(stringRequest);
    }

    public static void forgetPassword(final Context context, final EditText password,final ForgetPassFragment forgetPassFragment) {
        final ProgressDialog progressDialog = showProgressDialog(context);
        progressDialog.show();
        String URL = "http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/forgetPassword";
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.toLowerCase().contains("success")) {
                    progressDialog.hide();
                    Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
/*
                    forgetPassFragment.showLogin();
*/
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                error.printStackTrace();

            }
        }) {
            @Override
            public Map getParams() {
                Map params = new HashMap();
                params.put("newPass", password.getText().toString());
                params.put("confirmPass", password.getText().toString());
                params.put("notificationToken", "new pass successfully set");
                return params;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    public static ProgressDialog showProgressDialog(Context context) {
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Please wait....");
        return progressDoalog;
    }


}
