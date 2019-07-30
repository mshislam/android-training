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

import com.example.zee.Networks.LoginNetwork;
import com.example.zee.R;
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
        final View view = inflater.inflate(R.layout.fragment_login, container,
                false);

        com.example.zee.Util.SharedPrefUtil.getInstance(getContext()).write("api_token", "");
        emailtext = (EditText) view.findViewById(R.id.enteremailtext);
        password = (EditText) view.findViewById(R.id.enterpassword);
        registerbtn = view.findViewById(R.id.registerbutton);

        loginbtn = view.findViewById(R.id.loginButton);
        forgetbtn = view.findViewById(R.id.forgotpasswordbutton);
        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "toast", Toast.LENGTH_SHORT).show();
                ForgetPassFragment fragment = new ForgetPassFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                fragmentmanager.
                        beginTransaction().
                        replace(R.id.fragment_auth, fragment)
                        .addToBackStack("")
                        .show(fragment)
                        .commit();
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterFragment fragment = new RegisterFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                fragmentmanager.
                        beginTransaction().
                        replace(R.id.fragment_auth,
                                fragment,
                                "myfrag").addToBackStack(null).show(fragment).commit();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                String u=emailtext.getText().toString();
//                String p=password.getText().toString();
                if (TextUtil.isValid(emailtext)) {
//                    Toast.makeText(getContext(), "valid phone number or emial", Toast.LENGTH_LONG).show();
                    LoginNetwork.request(getContext(), emailtext.getText().toString(), password.getText().toString());
//                    editor.putString("name",u);
//                    editor.putString("pass",p);
//                    editor.commit();

                }
//                Toast.makeText(getContext(), "Invalid email address or phone number", Toast.LENGTH_SHORT).show();

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
