package com.example.zee.Fragments;

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

import com.example.zee.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment {
    Button loginbtn;
    TextView registerbtn;
    EditText emailtext;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Matcher m;
    TextView forgetbtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_login,container,
                false);
        emailtext=(EditText) view.findViewById(R.id.enteremailtext);
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
//                if (isValidEmail(getEmailId) || isValidPhone(getEmailId)) {
//                    Toast.makeText(getContext(),"thanks",Toast.LENGTH_LONG);
//                }
                Toast.makeText(getContext(), "invalid", Toast.LENGTH_LONG);
                if (isValidEmail(emailtext) || isValidPhone(emailtext)) {
                    Toast.makeText(getContext(), "valid email address", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Invalid email address or phone number", Toast.LENGTH_SHORT).show();


                }
            }
        });


        return view;
        }

        public Boolean isValidEmail(EditText e){

            if(emailtext.getText().toString().isEmpty()) {
                return false;
            }
            else {
                if (emailtext.getText().toString().trim().matches(emailPattern)) {
                    return true;
                } else {
                    return false;
                }
            }
    }
//
//
    public Boolean isValidPhone(EditText emailtext) {
        Pattern r = Pattern.compile(pattern);
        if (!emailtext.getText().toString().isEmpty()) {
            m = r.matcher(emailtext.getText().toString().trim());
        }
        if (m.find()) {
                   return true;        }
        else {
return false;        }
    }
//
//
//    }


}
