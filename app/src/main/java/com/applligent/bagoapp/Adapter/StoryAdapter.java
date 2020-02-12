package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.Activity.Screen2;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter  extends RecyclerView.Adapter<StoryAdapter.myclass> {
    Context mContext;
    ArrayList<Integer> img;
    public StoryAdapter(Context screen2, ArrayList<Integer> img) {
        this.mContext=screen2;
        this.img=img;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.storyitem,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        public myclass(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.image);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
        holder.circleImageView.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return img.size();
    }
}
