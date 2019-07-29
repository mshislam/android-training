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
import com.example.zee.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
    private Activity activity;

    public HomeAdapter(Activity activity) {
        this.activity = activity;

    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeHolder holder, int position) {
        Glide.with(activity).load("https://www.pngfind.com/pngs/m/59-593296_cara-mickey-mouse-png-rostro-de-mickey-mouse.png").into(holder.icon);
        Glide.with(activity).load("https://pmcdeadline2.files.wordpress.com/2014/05/disneyland-tickets__140518205906.jpg?w=681&h=383&crop=1")
                .apply(new RequestOptions().transform(new RoundedCorners(50))).into(holder.imagePost);
        holder.content.setText("Most Amazing Experience In the world!");
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
                if(!(holder.postImage.toString().isEmpty())){
                  /* Uri imageUri = Uri.parse(String.valueOf(holder.imagePost));
                    shareToApps.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareToApps.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
*/
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

