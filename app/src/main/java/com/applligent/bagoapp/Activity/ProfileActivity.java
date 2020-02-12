package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.applligent.bagoapp.Adapter.PostAdapter;
import com.applligent.bagoapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    FloatingActionButton mFloatingActionButton,mFloatingActionButton1;
    LinearLayout profile;
    CardView mCardView;
    RecyclerView mRecyclerView;
    GridLayoutManager linearLayoutManager;
    ArrayList<Integer> post;
    PostAdapter postAdapter;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile=findViewById(R.id.profile);
        mCardView=findViewById(R.id.cardview);
        mFloatingActionButton=findViewById(R.id.fab);
        mFloatingActionButton1=findViewById(R.id.fab1);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardView.setVisibility(View.GONE);
                profile.setVisibility(View.VISIBLE);

            }
        });
        mFloatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardView.setVisibility(View.VISIBLE);
                profile.setVisibility(View.GONE);
            }
        });

        mRecyclerView=findViewById(R.id.recyclerview);
        linearLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        post=new ArrayList<>();
        post.add(R.drawable.p1);
        post.add(R.drawable.p2);
        post.add(R.drawable.p3);
        post.add(R.drawable.p4);
        post.add(R.drawable.p5);
        post.add(R.drawable.p6);
        post.add(R.drawable.p1);
        post.add(R.drawable.p2);
        post.add(R.drawable.p3);
        post.add(R.drawable.p4);
        post.add(R.drawable.p5);
        post.add(R.drawable.p6);

        postAdapter=new PostAdapter(this,post);

        mRecyclerView.setAdapter(postAdapter);

        mImageView=findViewById(R.id.imgprofile);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(20));
        Glide.with(this)
                .load(R.drawable.profile)
                .apply(requestOptions)
                .into(mImageView);

    }

    public void back(View view) {
        onBackPressed();
    }
}
