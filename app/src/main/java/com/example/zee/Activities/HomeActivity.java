package com.example.zee.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.zee.Adapters.HomeAdapter;
import com.example.zee.R;

public class HomeActivity extends AppCompatActivity {
    RecyclerView posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        posts = findViewById(R.id.homeRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        posts.setLayoutManager(layoutManager);
        posts.setItemAnimator(new DefaultItemAnimator());
        posts.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        HomeAdapter adaptermodel = new HomeAdapter( HomeActivity.this);
        posts.setAdapter(adaptermodel);

    }
}
