package com.applligent.bagoapp.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.applligent.bagoapp.Fragment.Badges;
import com.applligent.bagoapp.Fragment.Coins;
import com.applligent.bagoapp.Fragment.Friends;
import com.applligent.bagoapp.Fragment.Posts;
import com.applligent.bagoapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

  @StringRes
  private static final int[] TAB_TITLES =
      new int[] { R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_3 };
  private final Context mContext;

  public TabsPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        Badges badges=new Badges();
        return badges;
      case 1:
        Posts posts=new Posts();
        return posts;
      case 2:
        Friends friends=new Friends();
        return friends;
      case 3:
        Coins coins=new Coins();
        return coins;
      default:
        return null;
    }
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return mContext.getResources().getString(TAB_TITLES[position]);
  }

  @Override
  public int getCount() {
    // Show 3 total pages.
    return 4;
  }
}