package com.example.zee.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zee.R;

public class HomeHolder extends RecyclerView.ViewHolder {
    public ImageView icon;
    public ImageView imagePost;
    public TextView name;
    public TextView date;
    public TextView content;
    public TextView comment;
    public TextView share;
    public ImageView postImage;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);
        this.imagePost = itemView.findViewById(R.id.imgPost);
        this.icon = itemView.findViewById(R.id.IMG);
        this.name = itemView.findViewById(R.id.txtname);
        this.date = itemView.findViewById(R.id.txtdate);
        this.content = itemView.findViewById(R.id.txtPostContent);
        this.share = itemView.findViewById(R.id.txtShare);
        this.comment = itemView.findViewById(R.id.txtComment);
        this.postImage = itemView.findViewById(R.id.imgPost);
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public void setContent(TextView content) {
        this.content = content;
    }
}
