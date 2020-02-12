package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.applligent.bagoapp.Adapter.PostAdapter1;
import com.applligent.bagoapp.Adapter.StoryAdapter;
import com.applligent.bagoapp.R;
import com.applligent.bagoapp.widget.GalleryRecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Screen2 extends AppCompatActivity {

    GalleryRecyclerView galleryRecyclerView;
    StoryAdapter storyAdapter;
    ArrayList<Integer> img;
    ImageView mImageView;
    RecyclerView mRecyclerView;
    GridLayoutManager  gridLayoutManager;
    PostAdapter1 postAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        mImageView=findViewById(R.id.image);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(30));
        Glide.with(this)
                .load(R.drawable.wave)
                .apply(requestOptions)
                .into(mImageView);

        galleryRecyclerView=findViewById(R.id.gallery);
        galleryRecyclerView.setCanAlpha(true);
        galleryRecyclerView.setCanScale(true);
        galleryRecyclerView.setBaseScale(0.3f);
        galleryRecyclerView.setBaseAlpha(0.95f);

        img=new ArrayList<>();
        img.add(R.drawable.p1);
        img.add(R.drawable.p2);
        img.add(R.drawable.p3);
        img.add(R.drawable.p4);
        img.add(R.drawable.p5);
        img.add(R.drawable.p6);
        img.add(R.drawable.p1);
        img.add(R.drawable.p2);
        img.add(R.drawable.p3);
        img.add(R.drawable.p4);
        img.add(R.drawable.p5);
        img.add(R.drawable.p6);
        img.add(R.drawable.p1);
        img.add(R.drawable.p2);
        img.add(R.drawable.p3);
        img.add(R.drawable.p4);
        img.add(R.drawable.p5);
        img.add(R.drawable.p6);
        img.add(R.drawable.p1);
        img.add(R.drawable.p2);
        img.add(R.drawable.p3);
        img.add(R.drawable.p4);
        img.add(R.drawable.p5);
        img.add(R.drawable.p6);
        storyAdapter=new StoryAdapter(this,img);
        galleryRecyclerView.setAdapter(storyAdapter);

        mRecyclerView=findViewById(R.id.recyclerview);
        gridLayoutManager=new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        postAdapter1=new PostAdapter1(this,img);
        mRecyclerView.setAdapter(postAdapter1);


        galleryRecyclerView.setOnViewSelectedListener(new GalleryRecyclerView.OnViewSelectedListener() {
            @Override
            public void onSelected(View view, int position) {

            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
