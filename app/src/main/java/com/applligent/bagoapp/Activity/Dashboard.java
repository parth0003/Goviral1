package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.applligent.bagoapp.Adapter.PostDataAdapter;
import com.applligent.bagoapp.R;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager linearLayoutManager;
    PostDataAdapter postDataAdapter;
    ArrayList<String> name,location,time,like,comment;
    ArrayList<Integer> profile,postdata;
    SpeedDialView speedDialView;
    LinearLayout lprofile;
    ImageView down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);

        lprofile = findViewById(R.id.profile);
        down=findViewById(R.id.down);
        mRecyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        speedDialView = findViewById(R.id.speedDial);
        speedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_action1, R.drawable.ic_user)
                .setTheme(R.style.AppTheme)
                .create());
        speedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_action2, R.drawable.ic_heart)
                .setTheme(R.style.AppTheme)
                .create());

        speedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_action4, R.drawable.ic_plus)
                .setTheme(R.style.AppTheme)
                .create());
        speedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_action5, R.drawable.ic_search)
                .setTheme(R.style.AppTheme)
                .create());
        speedDialView.addActionItem(new SpeedDialActionItem.Builder(R.id.fab_action3, R.drawable.ic_home)
                .setTheme(R.style.AppTheme)
                .create());


        speedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {
                switch (actionItem.getId()) {
                    case R.id.fab_action1:
                        startActivity(new Intent(Dashboard.this, ProfileActivity.class));
                        break;
                    case R.id.fab_action3:
                        startActivity(new Intent(Dashboard.this, Screen1.class));
                        break;
                    case R.id.fab_action5:
                        startActivity(new Intent(Dashboard.this, Screen2.class));
                        break;
                    case R.id.fab_action2:
                        startActivity(new Intent(Dashboard.this, Screen3.class));
                        break;
                    case R.id.fab_action4:
                        startActivity(new Intent(Dashboard.this, Screen4.class));
                        break;
                }
                return false;
            }
        });
        speedDialView.setOnChangeListener(new SpeedDialView.OnChangeListener() {
            @Override
            public boolean onMainActionSelected() {
                return false;
            }

            @Override
            public void onToggleChanged(boolean isOpen) {
                if (isOpen) {
                    speedDialView.setBackgroundResource(R.drawable.bottombg);
                } else {
                    speedDialView.setBackgroundResource(R.drawable.bottombg1);
                }
            }
        });

        name = new ArrayList<>();
        location = new ArrayList<>();
        time = new ArrayList<>();
        like = new ArrayList<>();
        comment = new ArrayList<>();
        profile = new ArrayList<>();
        postdata = new ArrayList<>();

        name.add("Name1");
        name.add("Name2");
        name.add("Name3");

        location.add("Location1");
        location.add("Location2");
        location.add("Location3");

        time.add("Time1");
        time.add("Time2");
        time.add("Time3");

        like.add("100");
        like.add("200");
        like.add("400");

        comment.add("100");
        comment.add("200");
        comment.add("300");

        profile.add(R.drawable.profile);
        profile.add(R.drawable.profile);
        profile.add(R.drawable.profile);

        postdata.add(R.drawable.profile);
        postdata.add(R.drawable.profile);
        postdata.add(R.drawable.profile);

        postDataAdapter = new PostDataAdapter(this, name, location, time, like, comment, profile, postdata,lprofile,down);

        mRecyclerView.setAdapter(postDataAdapter);
    }
}
