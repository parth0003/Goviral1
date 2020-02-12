package com.applligent.bagoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.applligent.bagoapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.myclass> {
    Context mContext;
    ArrayList<Integer> image;
    ArrayList<String> name,id,number;
    public FriendsAdapter(Context context, ArrayList<Integer> image, ArrayList<String> name, ArrayList<String> id, ArrayList<String> number) {
        this.mContext=context;
        this.image=image;
        this.id=id;
        this.name=name;
        this.number=number;
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.frienditem,parent,false);
        myclass myclass=new myclass(view);
        return myclass;
    }

    class myclass extends RecyclerView.ViewHolder {

        CircleImageView mImageView;
        TextView name,id,number;
        public myclass(@NonNull View itemView) {
            super(itemView);

            mImageView=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            id=itemView.findViewById(R.id.id);
            number=itemView.findViewById(R.id.number);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
        holder.mImageView.setImageResource(image.get(position));
        holder.name.setText(name.get(position));
        holder.id.setText(id.get(position));
        holder.number.setText(number.get(position));
    }

    @Override
    public int getItemCount() {
        return image.size();
    }
}
