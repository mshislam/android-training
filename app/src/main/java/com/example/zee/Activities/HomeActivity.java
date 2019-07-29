package com.example.zee.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zee.Adapters.HomeAdapter;
import com.example.zee.R;

public class HomeActivity extends AppCompatActivity {
    RecyclerView posts;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        posts=findViewById(R.id.homeRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        posts.setLayoutManager(layoutManager);
        posts.setItemAnimator(new DefaultItemAnimator());
        posts.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        HomeAdapter adaptermodel = new HomeAdapter( HomeActivity.this);
        posts.setAdapter(adaptermodel);



    }
}
