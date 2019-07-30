package com.example.zee.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zee.Adapters.HomeAdapter;
import com.example.zee.Networks.CreatePostNetwork;
import com.example.zee.R;

import static com.example.zee.Networks.WebServiceConstants.createPost.text;

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

        Button postButton = findViewById(R.id.postbutton);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatePostNetwork.request(HomeActivity.this, text);
            }

            /*private Context getContext() {
            }*/
        });
    }


}
