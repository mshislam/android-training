package com.example.zee.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zee.R;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsHolder> {
private Context mContext;
private ArrayList<Object>arrayList;
public CommentsAdapter(Context mContext,ArrayList arrayList){
    this.mContext=mContext;
    this.arrayList=arrayList;

}

    @Override
    public void onBindViewHolder(@NonNull CommentsHolder holder, int position) {

    }

    @NonNull
@Override
public CommentsHolder onCreateViewHolder(ViewGroup parent,int viewType){
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_adapter,parent,false);
    return new CommentsHolder(view);



}
    public int getItemCount() {
        return 10;
    }
}



     class CommentsHolder extends RecyclerView.ViewHolder {
         TextView myName;
         TextView myDate;
         TextView myComments;
         ImageView myImage;

         public CommentsHolder(View itemView) {
             super(itemView);
             myName=itemView.findViewById(R.id.commentsname);
             myDate=itemView.findViewById(R.id.commentsdate);
             myComments=itemView.findViewById(R.id.commentsspace);
             myImage=itemView.findViewById(R.id.commentsimage);

         }}


