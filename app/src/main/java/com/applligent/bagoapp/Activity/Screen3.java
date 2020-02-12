package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.applligent.bagoapp.Adapter.tabAdapter;
import com.applligent.bagoapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Screen3 extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager viewPager;
    TabItem gallery,story;
    tabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        mTabLayout=findViewById(R.id.tabview);
        gallery=findViewById(R.id.gallery);
        story=findViewById(R.id.story);
        viewPager=findViewById(R.id.viewpager);

        tabAdapter=new tabAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        settabicon();

    }
    private void settabicon() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_bubbles);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_list_symbol_of_three_items_with_dots);
    }

    public void back(View view) {
        onBackPressed();
    }
}
