package com.gzhy.storyplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gzhy.storyplayer.R;

public class NewOneFm extends Fragment {

    private TabLayout tabLayout = null;
    private ViewPager viewPager;
    private Fragment[] mfragment = new Fragment[4];
    private String[] mTabTitles = new String[5];


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.tab_viewpager);
        initView();
        return view;
    }

    private void initView() {
        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
        mTabTitles[2] = "科技";
        mTabTitles[3] = "体育";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20)
        mfragment [0] = new OneFm1();
        mfragment [1] = new OneFm2();
        mfragment [2] = new OneFm3();
        mfragment [3] = new OneFm4();

        PagerAdapter pagerAdapter1 = new MyViewPagerAdapter(getFragmentManager());
//        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter1);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragment[position];
        }


        @Override
        public int getCount() {
            return mfragment.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }
}
