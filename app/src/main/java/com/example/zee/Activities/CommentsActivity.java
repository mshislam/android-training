package com.example.zee.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.zee.R;
import com.example.zee.Adapters.CommentsAdapter;

import java.util.ArrayList;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        RecyclerView mRecyclerView=findViewById(R.id.commentRecyclerActivity);
        LinearLayoutManager mLinearLayoutManager=new LinearLayoutManager(CommentsActivity.this,RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        ArrayList commentsList=new ArrayList<Object>();
        CommentsAdapter commentsAdapter=new CommentsAdapter(CommentsActivity.this,commentsList);
        mRecyclerView.setAdapter(commentsAdapter);
    }
}
