package com.example.zee.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zee.Fragments.ForgetPassFragment;
import com.example.zee.Fragments.LoginFragment;
import com.example.zee.Fragments.RegisterFragment;
import com.example.zee.R;
import com.example.zee.util.Constants;

public class AuthenticationActivity extends AppCompatActivity implements RegisterFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_activity);
        Log.e("LogValue", "onCreate: ," + com.example.zee.Util.SharedPrefUtil.getInstance(this).read(Constants.apiToken, ""));
        if (com.example.zee.Util.SharedPrefUtil.getInstance(this).read(Constants.apiToken, "").equals("") ||
                com.example.zee.Util.SharedPrefUtil.getInstance(this).read(Constants.apiToken, "") == null) {
            fragment();
        } else {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void fragment() {
        androidx.fragment.app.FragmentManager manager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_auth, new LoginFragment());
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
