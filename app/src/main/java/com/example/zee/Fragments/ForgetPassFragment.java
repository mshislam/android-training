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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zee.EmailValidator;
import com.example.zee.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ForgetPassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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

    private OnFragmentInteractionListener mListener;

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

        final View v = inflater.inflate(R.layout.fragment_authenticate, container, false);

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
                    Toast.makeText(getActivity(), "passwords match", Toast.LENGTH_LONG).show();
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
                if (code.getText().length() == 0) {
                    code.setError("insert code");
                } else {
                    Toast.makeText(getActivity(), ":)", Toast.LENGTH_LONG).show();

                    showFragmentthree();
                }
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onClickValidate(View v) {
        Toast.makeText(getActivity(), "in", Toast.LENGTH_LONG).show();
        EditText fdt = v.findViewById(R.id.edt_email);
        EmailValidator e = new EmailValidator();
        if (e.testvalidity(fdt)) {
            Toast.makeText(getActivity(), ":)", Toast.LENGTH_LONG).show();
            showsecondlayout();
        } else {
            fdt.setError("invalid email");
        }
    }

    public void showsecondlayout() {
        first.setVisibility(View.GONE);
        second.setVisibility(View.VISIBLE);
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

    public void showFragmentthree() {
        second.setVisibility(View.GONE);
        third.setVisibility(View.VISIBLE);

    }
}
