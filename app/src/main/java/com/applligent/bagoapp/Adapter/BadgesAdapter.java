package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BadgesAdapter extends RecyclerView.Adapter<BadgesAdapter.myclass> {
    Context mContext;
    ArrayList<Integer> image;
    ArrayList<String> text;
    public BadgesAdapter(Context context, ArrayList<Integer> image, ArrayList<String> text) {
        this.mContext=context;
        this.image=image;
        this.text=text;

    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.badgesitem,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        CircleImageView mImageView;
        TextView mTextView;
        public myclass(@NonNull View itemView) {
            super(itemView);

            mImageView=itemView.findViewById(R.id.image);
            mTextView=itemView.findViewById(R.id.text);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
        holder.mImageView.setImageResource(image.get(position));
        holder.mTextView.setText(text.get(position));
    }

    @Override
    public int getItemCount() {
        return image.size();
    }
}
