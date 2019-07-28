package com.example.zee.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zee.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {
    private Activity activity;
public HomeAdapter (Activity activity){
    this.activity=activity;

}

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        Glide.with(activity).load("https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjCkqyUs9fjAhUPAmMBHeS7ChgQjRx6BAgBEAU&url=https%3A%2F%2Fwww.pngfind.com%2Fmpng%2FTomJxw_cara-mickey-mouse-png-rostro-de-mickey-mouse%2F&psig=AOvVaw12K11VnmegTb0wu18jtWjV&ust=1564395859300230").into(holder.icon);
        Glide.with(activity).load("https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwie8aX7stfjAhUQmxQKHdHoAcMQjRx6BAgBEAU&url=https%3A%2F%2Fwww.zajazdy.sk%2Fdovolenka-5-dnovy-zajazd-do-disneylandu-v-parizi-pariz-francuzsko-z731958%2F467161215%2F&psig=AOvVaw3XH6zwLRKYUAunksI4Rw1k&ust=1564395880481028").into(holder.imagePost);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

