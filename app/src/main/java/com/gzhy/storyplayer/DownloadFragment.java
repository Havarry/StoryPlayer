package com.gzhy.storyplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator
 */

public class DownloadFragment extends Fragment{
    private static final String TAG = "DownloadFragment";

    private static final int divider_color = 0x00ffffff;

    private PagerSlidingTabStrip mTabs;
    private ViewPager mViewPager;
    private MyPagerAdapter mAdapter;

    private int mainListIndex = 0;
    private int mainNearbyIndex = 1;
    private int mainFollowingIndex = 2;

    private Fragment[] fragments = new Fragment[3];
    protected int current_item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_download, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mTabs = (PagerSlidingTabStrip) view.findViewById(R.id.mainpage_tabs);
        mTabs.setOnTabSingleTapListener(new PagerSlidingTabStrip.OnTabSingleTapListener() {
            @Override
            public void onTabSingleTap(int pos) {

            }
        });
        mTabs.setShouldExpand(true);
        mTabs.setBackgroundResource(R.color.white);
        mTabs.setTabPaddingLeftRight(10);
        mTabs.setAllCaps(false);
        mTabs.setIndicatorHeight(8);
        mTabs.setTextSize(15);
        mTabs.setDividerColor(divider_color);
        mTabs.setIndicatorColor(getResources().getColor(R.color.mainpage_indicator));
        mTabs.setUnderlineHeight(2);
        mTabs.setUnderlineColor(getResources().getColor(R.color.default_divider_color));
        mTabs.setTextColor(getResources().getColor(R.color.mainpage_tab_title));

        mViewPager = (ViewPager) view.findViewById(R.id.mainpage_pager);
        mViewPager.setOffscreenPageLimit(2);
        mAdapter = new MyPagerAdapter(getChildFragmentManager());

        mTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                mTabs.setTextColorAtIndex(getResources().getColor(R.color.mainpage_indicator), arg0);
                current_item = arg0;
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }
        });

        mViewPager.setAdapter(mAdapter);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(pageMargin);
        mViewPager.setCurrentItem(current_item);
        mTabs.setViewPager(mViewPager);
        mTabs.setTextColorAtIndex(getResources().getColor(R.color.mainpage_indicator), current_item);
    }


    class MyPagerAdapter extends FragmentStatePagerAdapter {

        private String[] titles;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            Log.d(TAG, "MyPagerAdapter");
            titles = getResources().getStringArray(R.array.mainpage_item);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(TAG, "getItem position" + position);
            if (position == mainFollowingIndex) {
                if (fragments[mainFollowingIndex] == null) {
                    fragments[mainFollowingIndex] = new ChildThreeFragment();
                }
                return fragments[mainFollowingIndex];
            } else if (position == mainNearbyIndex) {
                if (fragments[mainNearbyIndex] == null) {
                    fragments[mainNearbyIndex] = new ChildTwoFragment();
                }
                return fragments[mainNearbyIndex];
            } else if (position == mainListIndex) {
                if (fragments[mainListIndex] == null) {
                    fragments[mainListIndex] = new ChildOneFragment();
                }
                return fragments[mainListIndex];
            } else {
                return null;
            }
        }
    }

}
