package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.applligent.bagoapp.Adapter.TabsPagerAdapter;
import com.applligent.bagoapp.R;
import com.google.android.material.tabs.TabLayout;

public class Screen1 extends AppCompatActivity {
    TextView mTextView;
    LinearLayout l1,l2,l3,l4;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        mTextView=findViewById(R.id.text);
        linearLayout=findViewById(R.id.linear);

        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        l4=findViewById(R.id.l4);

        l1.setBackgroundResource(R.drawable.bg1);
        l2.setBackgroundResource(R.drawable.bg22);
        l3.setBackgroundResource(R.drawable.bg33);
        l4.setBackgroundResource(R.drawable.bg44);
        mTextView.setText("Tab1");
        mTextView.setTextColor(Color.parseColor("#9C27B0"));
        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());

        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(tabsPagerAdapter);


        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        int x = l1.getTop();
                        int y = l1.getBottom();

                        int startRadius = 0;
                        int endRadius = (int) Math.hypot(l1.getWidth(), l1.getHeight());

                        Animator anim = ViewAnimationUtils.createCircularReveal(l1, x, y, startRadius, endRadius);
                        anim.start();
                        l1.setBackgroundResource(R.drawable.bg1);
                        l2.setBackgroundResource(R.drawable.bg22);
                        l3.setBackgroundResource(R.drawable.bg33);
                        l4.setBackgroundResource(R.drawable.bg44);
                        mTextView.setText("Badges");
                        mTextView.setTextColor(Color.parseColor("#9C27B0"));
                        break;
                    case  1:
                        int x1 = l2.getRight();
                        int y1 = l2.getBottom();

                        int startRadius1 = 0;
                        int endRadius1 = (int) Math.hypot(l2.getWidth(), l2.getHeight());

                        Animator anim1 = ViewAnimationUtils.createCircularReveal(l2, x1, y1, startRadius1, endRadius1);
                        anim1.start();
                        l1.setBackgroundResource(R.drawable.bg11);
                        l2.setBackgroundResource(R.drawable.bg2);
                        l3.setBackgroundResource(R.drawable.bg33);
                        l4.setBackgroundResource(R.drawable.bg44);
                        mTextView.setText("Posts");
                        mTextView.setTextColor(Color.parseColor("#2196F3"));
                        break;
                    case 2:
                        int x2 = l3.getBottom();
                        int y2 = l3.getTop();

                        int startRadius2 = 0;
                        int endRadius2 = (int) Math.hypot(l3.getWidth(), l3.getHeight());

                        Animator anim2 = ViewAnimationUtils.createCircularReveal(l3, x2, y2, startRadius2, endRadius2);
                        anim2.start();
                        l1.setBackgroundResource(R.drawable.bg11);
                        l2.setBackgroundResource(R.drawable.bg22);
                        l3.setBackgroundResource(R.drawable.bg3);
                        l4.setBackgroundResource(R.drawable.bg44);
                        mTextView.setText("Friends");
                        mTextView.setTextColor(Color.parseColor("#E91E63"));
                        break;
                    case 3:
                        int x3 = l4.getTop();
                        int y3 = l4.getTop();

                        int startRadius3 = 0;
                        int endRadius3 = (int) Math.hypot(l4.getWidth(), l4.getHeight());

                        Animator anim3 = ViewAnimationUtils.createCircularReveal(l4, x3, y3, startRadius3, endRadius3);
                        anim3.start();
                        l1.setBackgroundResource(R.drawable.bg11);
                        l2.setBackgroundResource(R.drawable.bg22);
                        l3.setBackgroundResource(R.drawable.bg33);
                        l4.setBackgroundResource(R.drawable.bg4);
                        mTextView.setText("Coins");
                        mTextView.setTextColor(Color.parseColor("#4CAF50"));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = l1.getTop();
                int y = l1.getBottom();

                int startRadius = 0;
                int endRadius = (int) Math.hypot(l1.getWidth(), l1.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(l1, x, y, startRadius, endRadius);
                anim.start();
                l1.setBackgroundResource(R.drawable.bg1);
                l2.setBackgroundResource(R.drawable.bg22);
                l3.setBackgroundResource(R.drawable.bg33);
                l4.setBackgroundResource(R.drawable.bg44);
                viewPager.setCurrentItem(0);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = l2.getRight();
                int y = l2.getBottom();

                int startRadius = 0;
                int endRadius = (int) Math.hypot(l2.getWidth(), l2.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(l2, x, y, startRadius, endRadius);
                anim.start();
                l1.setBackgroundResource(R.drawable.bg11);
                l2.setBackgroundResource(R.drawable.bg2);
                l3.setBackgroundResource(R.drawable.bg33);
                l4.setBackgroundResource(R.drawable.bg44);
                viewPager.setCurrentItem(1);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = l3.getBottom();
                int y = l3.getTop();

                int startRadius = 0;
                int endRadius = (int) Math.hypot(l3.getWidth(), l3.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(l3, x, y, startRadius, endRadius);
                anim.start();
                l1.setBackgroundResource(R.drawable.bg11);
                l2.setBackgroundResource(R.drawable.bg22);
                l3.setBackgroundResource(R.drawable.bg3);
                l4.setBackgroundResource(R.drawable.bg44);
                viewPager.setCurrentItem(2);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = l4.getTop();
                int y = l4.getTop();

                int startRadius = 0;
                int endRadius = (int) Math.hypot(l4.getWidth(), l4.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(l4, x, y, startRadius, endRadius);
                anim.start();
                l1.setBackgroundResource(R.drawable.bg11);
                l2.setBackgroundResource(R.drawable.bg22);
                l3.setBackgroundResource(R.drawable.bg33);
                l4.setBackgroundResource(R.drawable.bg4);
                viewPager.setCurrentItem(3);
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
