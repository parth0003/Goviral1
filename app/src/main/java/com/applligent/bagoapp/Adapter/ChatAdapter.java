package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.Activity.ChatActivity;
import com.applligent.bagoapp.R;

import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.myclass> {
    Context mContext;
    ArrayList<String> name;
    ArrayList<Integer> image;
    int lastPosition = -1;
    private Random mRandom = new Random();
    public ChatAdapter(Context activity, ArrayList<Integer> image, ArrayList<String> name) {
        this.mContext=activity;
        this.image=image;
        this.name=name;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.chatitem,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView mTextView;
        public myclass(@NonNull View itemView) {
            super(itemView);

            circleImageView=itemView.findViewById(R.id.image);
            mTextView=itemView.findViewById(R.id.name);
            circleImageView.getLayoutParams().height = getRandomIntInRange(250,100);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, final int position) {
        holder.circleImageView.setImageResource(image.get(position));
//        holder.circleImageView.getLayoutParams().height = getRandomIntInRange(250,100);
        holder.mTextView.setText(name.get(position));

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
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
    protected int getRandomIntInRange(int max, int min){
        return mRandom.nextInt((max-min)+min)+min;
    }

    // Custom method to generate random HSV color
    protected int getRandomHSVColor(){
        // Generate a random hue value between 0 to 360
        int hue = mRandom.nextInt(361);
        // We make the color depth full
        float saturation = 1.0f;
        // We make a full bright color
        float value = 1.0f;
        // We avoid color transparency
        int alpha = 255;
        // Finally, generate the color
        int color = Color.HSVToColor(alpha, new float[]{hue, saturation, value});
        // Return the color
        return color;
    }

}
