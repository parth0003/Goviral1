package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.Activity.ChatActivity;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatlistAdapter extends RecyclerView.Adapter<ChatlistAdapter.myclass> {
    Context mContext;
    ArrayList<String> name;
    ArrayList<Integer> image;
    public ChatlistAdapter(Context activity, ArrayList<Integer> image, ArrayList<String> name) {
        this.mContext=activity;
        this.image=image;
        this.name=name;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.chatlistitem,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView mTextView;
        LinearLayout linearLayout;
        public myclass(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.image);
            mTextView=itemView.findViewById(R.id.name);
            linearLayout=itemView.findViewById(R.id.linear);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, final int position) {
        holder.circleImageView.setImageResource(image.get(position));
        holder.mTextView.setText(name.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ChatActivity.class).putExtra("name",name.get(position)).putExtra("photo",image.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.size();
    }
}
