package com.example.zee.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zee.Adapters.HomeAdapter;
import com.example.zee.HomeInterface;
import com.example.zee.Models.ListPosts;
import com.example.zee.Networks.PostsNetwork;
import com.example.zee.R;
import com.example.zee.util.Constants;
import com.google.gson.Gson;

import static com.example.zee.Networks.WebServiceConstants.createPost.text;

public class HomeActivity extends AppCompatActivity implements HomeInterface {

    RecyclerView posts;

    ProgressDialog progressDialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        posts = findViewById(R.id.homeRecyclerView);
        Button postButton = findViewById(R.id.postbutton);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("create post please wait ...");
        progressDialog.setCancelable(false);
        final String apiToken = com.example.zee.Util.SharedPrefUtil
                .getInstance(HomeActivity.this).read(Constants.apiToken, "");
        PostsNetwork.listPosts(HomeActivity.this, apiToken, HomeActivity.this);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                PostsNetwork.request(HomeActivity.this, text, apiToken, HomeActivity.this);
            }
        });
    }

    @Override
    public void createPost(String response) {
        progressDialog.dismiss();
        //TODO call listPosts API
    }

    @Override
    public void listPosts(String response) {
        //TODO setData to adapter
        Toast.makeText(this, " " + response, Toast.LENGTH_SHORT).show();
        ListPosts listPosts = new Gson().fromJson(response, ListPosts.class);
        listPosts.getPostsList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        posts.setLayoutManager(layoutManager);
        posts.setItemAnimator(new DefaultItemAnimator());
        posts.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        HomeAdapter adaptermodel = new HomeAdapter(HomeActivity.this,listPosts.getPostsList());
        posts.setAdapter(adaptermodel);
        //TODO set adapter to recyclerview
        Log.d("response: ", " " + new Gson().fromJson(response, ListPosts.class));
    }

}
