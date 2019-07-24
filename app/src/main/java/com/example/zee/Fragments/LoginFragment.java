package com.example.zee.Fragments;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zee.R;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.zee.Util.TextUtil;


public class LoginFragment extends Fragment {
    Button loginbtn;
    TextView registerbtn;
    EditText emailtext;
    EditText password;
    TextView forgetbtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_login,container,
                false);
        emailtext=(EditText) view.findViewById(R.id.enteremailtext);
        password=(EditText)view.findViewById(R.id.enterpassword);
        registerbtn=view.findViewById(R.id.registerbutton);

        loginbtn=view.findViewById(R.id.loginButton);
        forgetbtn=view.findViewById(R.id.forgotpasswordbutton);
        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgetPassFragment fragment = new ForgetPassFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                fragmentmanager.
                        beginTransaction().
                        add(R.id.fragment_auth,
                                fragment,
                                "myfrag").addToBackStack(null).show(fragment).commit();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtil.isValid(emailtext)){
                    Toast.makeText(getContext(),"valid phone number or emial",Toast.LENGTH_LONG).show();
                    request();

                }
                Toast.makeText(getContext(), "Invalid email address or phone number", Toast.LENGTH_SHORT).show();

////                if (isValidEmail(getEmailId) || isValidPhone(getEmailId)) {
////                    Toast.makeText(getContext(),"thanks",Toast.LENGTH_LONG);
////                }
//                Toast.makeText(getContext(), "invalid", Toast.LENGTH_LONG);
//                if (TextUtil.isValid(emailtext)) {
//                    Toast.makeText(getContext(), "valid email address", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getContext(), "Invalid email address or phone number", Toast.LENGTH_SHORT).show();
//
//
//                }
            }
            public void request(){
                String URL="http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/login";
                RequestQueue mRequestQueue= Volley.newRequestQueue(getContext());
                StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(), "login successful" + response.toString(), Toast.LENGTH_LONG).show();

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


        });


        return view;
        }

//        public Boolean isValidEmail(EditText e){
//
//            if(emailtext.getText().toString().isEmpty()) {
//                return false;
//            }
//            else {
//                if (emailtext.getText().toString().trim().matches(emailPattern)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//    }
////
////
//    public Boolean isValidPhone(EditText emailtext) {
//        Pattern r = Pattern.compile(pattern);
//        if (!emailtext.getText().toString().isEmpty()) {
//            m = r.matcher(emailtext.getText().toString().trim());
//        }
//        if (m.find()) {
//                   return true;        }
//        else {
//return false;        }
//
//
//    }
//
//
//    }


}
