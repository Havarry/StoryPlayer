package com.gzhy.storyplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.gzhy.storyplayer.fragment.TabFragment;


public class TabAdapter extends FragmentPagerAdapter {
    public static String[]titles = new String[]{"推荐","充电","问答","热门"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment fragment = new TabFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

}
