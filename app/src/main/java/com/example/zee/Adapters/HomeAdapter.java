package com.example.zee.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.zee.Activities.CommentActivity;
import com.example.zee.Activities.HomeActivity;
import com.example.zee.Models.PostsList;
import com.example.zee.Models.User;
import com.example.zee.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
    private Activity activity;

    private ArrayList<PostsList> postsList;

    public HomeAdapter(Activity activity, ArrayList<PostsList> postsList) {
        this.activity = activity;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeHolder holder, int position) {
        Glide.with(activity).load(postsList.get(position).getUser().getImage()).into(holder.icon);
        if (postsList.get(position).getPost().getPhoto() != null && !postsList.get(position).getPost().getPhoto().equals(""))
            Glide.with(activity).load(postsList.get(position).getPost().getPhoto())
                    .apply(new RequestOptions().transform(new RoundedCorners(50))).into(holder.imagePost);
        else
            holder.imagePost.setVisibility(View.GONE);
        holder.content.setText(postsList.get(position).getPost().getText());
        holder.date.setText(postsList.get(position).getPost().getCreated_at());
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toComment;
                toComment = new Intent(activity, CommentActivity.class);
                activity.startActivity(toComment);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent shareToApps = new Intent();
                shareToApps.setAction(Intent.ACTION_SEND);*/
                if (!(holder.content.getText().toString().isEmpty())) {
                    Intent shareToApps = new Intent();
                    shareToApps.setAction(Intent.ACTION_SEND);
                    shareToApps.putExtra(Intent.EXTRA_TEXT, holder.content.getText());
                    shareToApps.setType("text/plain");
                    activity.startActivity(shareToApps);
                }
                if (!(holder.postImage.toString().isEmpty())) {
                  /* Uri imageUri = Uri.parse(String.valueOf(holder.imagePost));
                    shareToApps.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareToApps.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);*/
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}

