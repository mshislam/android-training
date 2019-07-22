package com.example.zee;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class AuthenticationActivity extends AppCompatActivity implements AuthenticateFragment.OnFragmentInteractionListener {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_activity);
        createfragment();

    }

    public void createfragment() {
        AuthenticateFragment fragment = new AuthenticateFragment();
        FragmentManager fragmentmanager = getSupportFragmentManager();
        fragmentmanager.
                beginTransaction().
                replace(R.id.layout_auth_main,
                        fragment,
                        "myfrag").addToBackStack(null).show(fragment).commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
