package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.R;

import java.util.ArrayList;

public class Coins2Adapter extends RecyclerView.Adapter<Coins2Adapter.myclass> {
    Context mContext;
    ArrayList<Integer> img;
    public Coins2Adapter(Context context, ArrayList<Integer> img) {
        this.mContext=context;
        this.img=img;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.coins2item,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public myclass(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.image1);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
        holder.mImageView.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return img.size();
    }
}
