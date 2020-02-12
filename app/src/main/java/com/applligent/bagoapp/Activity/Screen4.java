package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.applligent.bagoapp.Adapter.PagerViewAdapter;
import com.applligent.bagoapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Screen4 extends AppCompatActivity {
    TabItem gallery,story;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;
    TabLayout tabs;
    private int[] icon = {R.drawable.ic_landscape,R.drawable.ic_user1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        gallery = findViewById(R.id.gallery);
        story = findViewById(R.id.story);
        viewPager = findViewById(R.id.pageView);
        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerViewAdapter);
        tabs = findViewById(R.id.tabview);
        tabs.setupWithViewPager(viewPager);
        settabicon();
    }
    private void settabicon() {
        tabs.getTabAt(0).setIcon(icon[0]);
        tabs.getTabAt(1).setIcon(icon[1]);
    }

    public void back(View view) {
        onBackPressed();
    }
}
