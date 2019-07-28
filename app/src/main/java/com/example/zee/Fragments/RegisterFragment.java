package com.example.zee.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zee.R;
import com.example.zee.Util.TextUtil;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
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
                validateAll();
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
        if((TextUtil.isString(firstName)==false)|| TextUtil.isEmpty(firstName)==false){
            firstName.setError("must be Alphabets");
        }
        if((TextUtil.isString(lastName)==false)|| TextUtil.isEmpty(lastName)==false){
            lastName.setError("must be Alphabets");
        }
        if((TextUtil.isValid(email)==false)|| TextUtil.isEmpty(email)==false){
            email.setError("invalid email");
        }
        if((TextUtil.isValid(phone)==false)|| TextUtil.isEmpty(phone)==false){
            phone.setError("invalid phone");
        }
        if((TextUtil.isString(title)==false)|| TextUtil.isEmpty(title)==false){
            title.setError("must be Alphabets");
        }
        if((TextUtil.isString(companyName)==false)|| TextUtil.isEmpty(companyName)==false){
            companyName.setError("must be Alphabets");
        }
        if ((password.getText().toString().equals(confirmPass.getText().toString()))) {
        } else {
            password.setError("doesnot match");
        }
    }
}
