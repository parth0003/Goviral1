package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.applligent.bagoapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PostDataAdapter extends RecyclerView.Adapter<PostDataAdapter.myclass> {
    Context mContext;
    ArrayList<String> name,location,time,like,comment;
    ArrayList<Integer> profile,postdata;
    LinearLayout lprofile;
    ImageView down;
    public PostDataAdapter(Context dashboard, ArrayList<String> name, ArrayList<String> location, ArrayList<String> time, ArrayList<String> like, ArrayList<String> comment, ArrayList<Integer> profile, ArrayList<Integer> postdata, LinearLayout lprofile, ImageView down) {
        this.mContext=dashboard;
        this.name=name;
        this.location=location;
        this.time=time;
        this.like=like;
        this.comment=comment;
        this.profile=profile;
        this.postdata=postdata;
        this.lprofile=lprofile;
        this.down=down;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        ViewPager mViewPager;
        ImageView mImageView,more;
        LinearLayout like,comment,share,download;
        TextView txtlike,txtcomment,txtname,txttime,txtlocation;
        public myclass(@NonNull View itemView) {
            super(itemView);
            mViewPager=itemView.findViewById(R.id.viewpager);
            ImageAdapter adapter = new ImageAdapter(mContext);
            mViewPager.setAdapter(adapter);

            mImageView=itemView.findViewById(R.id.profileimage);
            more=itemView.findViewById(R.id.more);

            like=itemView.findViewById(R.id.imglike);
            comment=itemView.findViewById(R.id.imgcomment);
            share=itemView.findViewById(R.id.imgshare);
            download=itemView.findViewById(R.id.imgdownload);

            txtcomment=itemView.findViewById(R.id.comment);
            txtlike=itemView.findViewById(R.id.like);
            txtlocation=itemView.findViewById(R.id.location);
            txtname=itemView.findViewById(R.id.name);
            txttime=itemView.findViewById(R.id.time);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final myclass holder, int position) {

        holder.txtlike.setText(like.get(position));
        holder.txtcomment.setText(comment.get(position));
        holder.txtname.setText(name.get(position));
        holder.txtlocation.setText(location.get(position));
        holder.txttime.setText(time.get(position));

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(20));
        Glide.with(mContext)
                .load(profile.get(position))
                .apply(requestOptions)
                .into(holder.mImageView);
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(mContext, holder.more);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(mContext,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();
            }
        });
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lprofile.setVisibility(View.VISIBLE);
            }
        });
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lprofile.setVisibility(View.VISIBLE);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lprofile.setVisibility(View.VISIBLE);
            }
        });
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lprofile.setVisibility(View.VISIBLE);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lprofile.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
}
