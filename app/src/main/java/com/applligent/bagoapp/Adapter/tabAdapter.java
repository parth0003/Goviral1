package com.applligent.bagoapp.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.applligent.bagoapp.Fragment.Badges;
import com.applligent.bagoapp.Fragment.ChatFragment;
import com.applligent.bagoapp.Fragment.ChatlistFragment;
import com.applligent.bagoapp.Fragment.Coins;
import com.applligent.bagoapp.Fragment.Friends;
import com.applligent.bagoapp.Fragment.Posts;
import com.applligent.bagoapp.R;

public class tabAdapter extends FragmentPagerAdapter {


    private final Context mContext;

    public tabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ChatFragment badges=new ChatFragment();
                return badges;
            case 1:
                ChatlistFragment posts=new ChatlistFragment();
                return posts;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
}