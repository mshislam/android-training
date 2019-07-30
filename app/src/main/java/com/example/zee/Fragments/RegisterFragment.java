package com.example.zee.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.zee.Networks.RegistrationNetwork;
import com.example.zee.R;
import java.util.Random;


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
    private static RegisterFragment newInstance(String param1, String param2) {
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        password = view.findViewById(R.id.password);
        confirmPass = view.findViewById(R.id.confirmPass);
        companyName = view.findViewById(R.id.company);
        title = view.findViewById(R.id.title);
        Button backArrow = view.findViewById(R.id.backArrow);
        Button registerButton = view.findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if ((com.example.zee.Util.TextUtil.isValid(firstName)) && (com.example.zee.Util.TextUtil.isValid(lastName)) &&
                        (com.example.zee.Util.TextUtil.isValid(email)) && (com.example.zee.Util.TextUtil.isValid(phone)) &&
                        (com.example.zee.Util.TextUtil.isValid(password)) && (com.example.zee.Util.TextUtil.isValid(confirmPass)) &&
                        (com.example.zee.Util.TextUtil.isValid(companyName)) && (com.example.zee.Util.TextUtil.isValid(title))) {
                    RegistrationNetwork.request(getContext(),firstName, lastName, email, phone, password, confirmPass, companyName, title);
                }*/
                if (validateAll()) {
                    RegistrationNetwork.request(getContext(), firstName.getText().toString(),
                            lastName.getText().toString(), email.getText().toString(),
                            phone.getText().toString(), password.getText().toString(),
                            confirmPass.getText().toString(), companyName.getText().toString(),
                            title.getText().toString());
                }
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        setRandomValues();
        return view;
    }
    private void setRandomValues() {
        firstName.setText("testFN");
        lastName.setText("testLN");
        email.setText(generateRandomEmail());
        phone.setText(generateRandomMobile());
        password.setText("123456");
        confirmPass.setText("123456");
        companyName.setText("MES");
        title.setText("Android Developer");
    }

    private String generateRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";

    }

    private String generateRandomMobile() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return "010" + saltStr;
    }
    /*private void request() {
        String URL = "http://eventi-do1.mideastsoft.com/fdc2019v1.0/api/v2/fdc/register";
        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Registration done" + response.toString(), Toast.LENGTH_LONG).show();
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
    }*/

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

    private boolean validateAll() {

        if (com.example.zee.util.TextUtil.isEmpty(firstName) == true) {
            firstName.setError("Required");
            return false;
        } else if ((com.example.zee.util.TextUtil.isString(firstName) == false) || com.example.zee.util.TextUtil.isEmpty(firstName) == true) {
            firstName.setError("Must be Alphabets");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(lastName) == true) {
            lastName.setError("Required");
            return false;
        } else if ((com.example.zee.util.TextUtil.isString(lastName) == false)) {
            lastName.setError("Must be Alphabets");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(email) == true) {
            email.setError("Required");
            return false;
        } else if ((com.example.zee.util.TextUtil.isValid(email) == false)) {
            email.setError("Invalid email");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(phone) == true) {
            phone.setError("Required");
            return false;
        } else if ((com.example.zee.util.TextUtil.isValid(phone) == false)) {
            phone.setError("Invalid phone");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(title) == true) {
            title.setError("Required");
            return false;
        } else if ((com.example.zee.util.TextUtil.isString(title) == false)) {
            title.setError("Must be Alphabets");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(companyName) == true) {
            companyName.setError("Required");
            return false;
        } else if ((com.example.zee.util.TextUtil.isString(companyName) == false)) {
            companyName.setError("Must be Alphabets");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(password) == true) {
            password.setError("Required");
            return false;
        } else if (com.example.zee.util.TextUtil.passIsValid(password) == false) {
            password.setError("At least 6 characters");
            return false;
        }
        if (com.example.zee.util.TextUtil.isEmpty(confirmPass) == true) {
            confirmPass.setError("Required");
            return false;
        } else if((password.getText().toString().equals(confirmPass.getText().toString()))) {
        } else {
            confirmPass.setError("Does not match");
            return false;
        }
        return true;
    }
}
