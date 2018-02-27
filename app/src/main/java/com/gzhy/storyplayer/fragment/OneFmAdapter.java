package com.gzhy.storyplayer.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class OneFmAdapter extends FragmentPagerAdapter {

    private List<Fragment> fmList;
    private FragmentManager fm;

    public OneFmAdapter(FragmentManager fm, List<Fragment> fmList) {
        super(fm);
        this.fm = fm;
        this.fmList = fmList;

    }

    @Override
    public Fragment getItem(int position) {
        return fmList.get(position%fmList.size());
    }

    @Override
    public int getCount() {
        return fmList.size();
    }

    public int getItemPosition(Object object){
        return POSITION_NONE;
    }
}
