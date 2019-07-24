package com.example.zee.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zee.Fragments.LoginFragment;
import com.example.zee.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragment();
    }
    public void fragment(){

        androidx.fragment.app.FragmentManager manager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_auth, new LoginFragment()).addToBackStack(null);
        transaction.commit();

    }
}
