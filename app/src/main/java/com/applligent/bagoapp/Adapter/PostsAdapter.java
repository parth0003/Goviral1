package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.myclass> {
    Context mContext;
    ArrayList<Integer> image;
    public PostsAdapter(Context context, ArrayList<Integer> image) {
        this.mContext=context;
        this.image=image;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.postitem,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public myclass(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.image);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(20));
        Glide.with(mContext)
                .load(image.get(position))
                .apply(requestOptions)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return image.size();
    }
}
