package com.example.zee.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zee.R;


import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phone;
    private EditText password;
    private EditText confirmPass;
    private EditText title;
    private EditText companyName;
    private Button registerButton;
    private OnFragmentInteractionListener mListener;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        firstName=view.findViewById(R.id.firstName);
        lastName=view.findViewById(R.id.lastName);
        email=view.findViewById(R.id.email);
        phone=view.findViewById(R.id.phone);
        password=view.findViewById(R.id.password);
        confirmPass=view.findViewById(R.id.confirmPass);
        companyName=view.findViewById(R.id.company);
        title=view.findViewById(R.id.title);
        registerButton=view.findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "toast", Toast.LENGTH_SHORT).show();
                RegisterFragment fragment = new RegisterFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                fragmentmanager.
                        beginTransaction().
                        replace(R.id.registerButton, fragment)
                        .addToBackStack("")
                        .show(fragment)
                        .commit();
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((com.example.zee.Util.TextUtil.isValid(firstName)) && (com.example.zee.Util.TextUtil.isValid(lastName)) &&
                        (com.example.zee.Util.TextUtil.isValid(email)) && (com.example.zee.Util.TextUtil.isValid(phone)) &&
                        (com.example.zee.Util.TextUtil.isValid(password)) && (com.example.zee.Util.TextUtil.isValid(confirmPass)) &&
                                (com.example.zee.Util.TextUtil.isValid(companyName)) && (com.example.zee.Util.TextUtil.isValid(title))){
                    request();
                }
            }
            public void request(){
                String URL="http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/register";
                RequestQueue mRequestQueue= Volley.newRequestQueue(getContext());
                StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(), "Registration done" + response.toString(), Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){
                    @Override
                    public Map getParams() {
                        Map parameters = new HashMap();
                        parameters.put("firstName", firstName.getText().toString());
                        parameters.put("lastName", lastName.getText().toString());
                        parameters.put("email", email.getText().toString());
                        parameters.put("phone", phone.getText().toString());
                        parameters.put("password", password.getText().toString());
                        parameters.put("confirmPass", confirmPass.getText().toString());
                        parameters.put("company", companyName.getText().toString());
                        parameters.put("title", title.getText().toString());
                        return parameters;
                    }
                };
                mRequestQueue.add(stringRequest);
            }
        });

return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void validateAll(){
        if((com.example.zee.Util.TextUtil.isString(firstName)==false)|| com.example.zee.Util.TextUtil.isEmpty(firstName)==false){
            firstName.setError("must be Alphabets");
        }
        if((com.example.zee.Util.TextUtil.isString(lastName)==false)|| com.example.zee.Util.TextUtil.isEmpty(lastName)==false){
            lastName.setError("must be Alphabets");
        }
        if((com.example.zee.Util.TextUtil.isValid(email)==false)|| com.example.zee.Util.TextUtil.isEmpty(email)==false){
            email.setError("invalid email");
        }
        if((com.example.zee.Util.TextUtil.isValid(phone)==false)|| com.example.zee.Util.TextUtil.isEmpty(phone)==false){
            phone.setError("invalid phone");
        }
        if((com.example.zee.Util.TextUtil.isString(title)==false)|| com.example.zee.Util.TextUtil.isEmpty(title)==false){
            title.setError("must be Alphabets");
        }
        if((com.example.zee.Util.TextUtil.isString(companyName)==false)|| com.example.zee.Util.TextUtil.isEmpty(companyName)==false){
            companyName.setError("must be Alphabets");
        }
        if ((password.getText().toString().equals(confirmPass.getText().toString()))) {
        } else {
            password.setError("doesnot match");
        }
    }
}
