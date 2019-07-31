package com.example.zee.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.zee.Adapters.CommentsAdapter;
import com.example.zee.CallBack;
import com.example.zee.Models.ListComments;
import com.example.zee.Models.ResponseList;
import com.example.zee.Networks.Comments;
import com.example.zee.Networks.WebServiceConstants;
import com.example.zee.R;
import com.example.zee.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity implements CallBack {
    ListComments listComments;
    private RecyclerView myComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        Comments.listComments(this,
                com.example.zee.Util.SharedPrefUtil.getInstance(this).read(Constants.apiToken, ""),
                "96", this);
        myComments = findViewById(R.id.commentRecyclerActivity);
        myComments.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myComments.setLayoutManager(layoutManager);
        myComments.setItemAnimator(new DefaultItemAnimator());
        myComments.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public void onComplete(String response, Exception e) {
//        Toast.makeText(this, " " + response, Toast.LENGTH_SHORT).show();

        Log.d("CommentsResponse", " " + response);
        Gson gson = new Gson();
//        com.example.zee.Models.ListComments responseArray = gson.fromJson(response, com.example.zee.Models.ListComments.class);
        com.example.zee.Models.ListComments responseArray = gson.fromJson(response, com.example.zee.Models.ListComments.class);
        ArrayList<ResponseList> myArray = responseArray.getList();
        Toast.makeText(this, " " + response, Toast.LENGTH_SHORT).show();
        com.example.zee.Adapters.CommentsAdapter myAdapter = new CommentsAdapter(this, myArray);
        myComments.setAdapter(myAdapter);

    }
}
