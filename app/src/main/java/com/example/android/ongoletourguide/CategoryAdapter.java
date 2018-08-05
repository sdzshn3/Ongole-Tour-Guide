package com.example.android.ongoletourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AboutOngoleFragment();
        } else if (position == 1) {
            return new TransportationFragment();
        } else if (position == 2) {
            return new TouristAttractionFragment();
        } else {
            return new HotelsFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tab_title_1);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_title_2);
        } else if (position == 2) {
            return mContext.getString(R.string.tab_title_3);
        } else {
            return mContext.getString(R.string.tab_title_4);
        }
    }
}
