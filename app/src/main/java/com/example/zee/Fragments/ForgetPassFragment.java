package com.example.zee.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.zee.Networks.ForgetPass;
import com.example.zee.R;
import com.example.zee.util.TextUtil;

public class ForgetPassFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button validate;
    RelativeLayout first;
    RelativeLayout second;
    RelativeLayout third;
    Button send;
    Button set;
    EditText passfirst;
    EditText passsec;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForgetPassFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgetPassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgetPassFragment newInstance(String param1, String param2) {
        ForgetPassFragment fragment = new ForgetPassFragment();
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

        final View v = inflater.inflate(R.layout.fragment_forget_password, container, false);

        first = v.findViewById(R.id.layout_first);
        second = v.findViewById(R.id.layout_second);
        third = v.findViewById(R.id.layout_third);
        validate = v.findViewById(R.id.btn_validate);
        final EditText code = v.findViewById(R.id.edt_code);
        send = v.findViewById(R.id.btn_send);
        set = v.findViewById(R.id.btn_set);
        passfirst = v.findViewById(R.id.edt_pss);
        passsec = v.findViewById(R.id.edt_con_pss);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((passfirst.getText().toString().equals(passsec.getText().toString()))) {
                   ForgetPass.forgetPassword(getContext(),passfirst,ForgetPassFragment.this);
                } else {
                    passsec.setError("doesnot match");
                }
            }
        });
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickValidate(v);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtil.isEmpty(code)) {
                    code.setError("insert code");
                } else {
                    ForgetPass.checkVerificationCodeExists(getContext(),code,ForgetPassFragment.this);
                }
            }
        });
        return v;
    }

    public void onClickValidate(View v) {
        EditText fdt = v.findViewById(R.id.edt_email);
        if (TextUtil.isValid(fdt)) {
            ForgetPass.sendVerificationCode(getContext(),fdt,ForgetPassFragment.this);
        } else {
            fdt.setError("invalid email");
        }
    }

    public void showsecondlayout() {
        first.setVisibility(View.GONE);
        second.setVisibility(View.VISIBLE);
    }

    public void showFragmentthree() {
        second.setVisibility(View.GONE);
        third.setVisibility(View.VISIBLE);

    }
    public void showLogin(){
        androidx.fragment.app.FragmentManager manager = getActivity().getSupportFragmentManager() ;
        androidx.fragment.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_auth, new LoginFragment());
        transaction.commit();
    }
}
