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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zee.Adapters.CommentsAdapter;
import com.example.zee.CommentsInterface;
import com.example.zee.Models.ListComments;
import com.example.zee.Models.ResponseList;
import com.example.zee.Networks.Comments;
import com.example.zee.R;
import com.example.zee.util.Constants;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity implements CommentsInterface {
    ListComments listComments;
    private RecyclerView myComments;
    private RelativeLayout editComments;
    private EditText newComment;
    private Button postNewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        Comments.listComments(this,
                com.example.zee.util.SharedPrefUtil.getInstance(this).read(Constants.apiToken, ""),
                "96", this);
        myComments = findViewById(R.id.commentRecyclerActivity);
        myComments.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myComments.setLayoutManager(layoutManager);
        myComments.setItemAnimator(new DefaultItemAnimator());
        myComments.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        editComments = findViewById(R.id.activity_postcomment);
        newComment = editComments.findViewById(R.id.addComment);
        postNewComment = editComments.findViewById(R.id.CommentButton);
        postNewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comments.createComments(CommentActivity.this,
                        com.example.zee.util.SharedPrefUtil.getInstance(view.getContext()).read(Constants.apiToken, ""), "96",
                        newComment.getText().toString(),
                        CommentActivity.this);
            }
        });

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

    public void onComment(String response) {
        Gson gson = new Gson();
        com.example.zee.Models.Comment jsonComment = gson.fromJson(response, com.example.zee.Models.Comment.class);
    }
}
