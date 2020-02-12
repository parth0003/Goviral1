package com.applligent.bagoapp.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.applligent.bagoapp.Fragment.Gallery;
import com.applligent.bagoapp.Fragment.Story;

public class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Story();
                break;
            case 1:
                fragment = new Gallery();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
