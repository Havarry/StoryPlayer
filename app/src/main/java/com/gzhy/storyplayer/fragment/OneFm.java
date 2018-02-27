package com.gzhy.storyplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gzhy.storyplayer.R;
import com.gzhy.storyplayer.util.HTab;
import com.gzhy.storyplayer.util.HTabDb;

import java.util.ArrayList;
import java.util.List;

public class OneFm extends Fragment implements ViewPager.OnPageChangeListener{

    private View view;
    private RadioGroup rg_;
    private ViewPager vp_;
    private HorizontalScrollView hv_;
    private List<Fragment> newsList = new ArrayList<Fragment>();
    private OneFmAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view ==null) {
            view = inflater.inflate(R.layout.fragment_top_one, null);
            rg_ = (RadioGroup) view.findViewById(R.id.one_rg);
            vp_ = (ViewPager) view.findViewById(R.id.one_view);
            hv_ = (HorizontalScrollView) view.findViewById(R.id.one_hv);
            rg_.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    vp_.setCurrentItem(checkedId);
                }
            });
            //初始化顶部导航栏
            initTab(inflater);
            //初始化viewpager
            initView();
        }

        /*
         * 底部导航栏切换后 由于没有销毁顶部设置导致如果没有重新设置view
         * 导致底部切换后切回顶部页面数据会消失等bug
         * 以下设置每次重新创建view即可
        */
        ViewGroup parent = (ViewGroup) view.getParent();
        if(parent != null){
            parent.removeView(view);
        }
        return view;
    }

    //初始化viewpager
    private void initView() {

        List<HTab> hTabs = HTabDb.getSelected();
        for (int i = 0; i < hTabs.size(); i++){
            OneFm1 fm1 = new OneFm1();
            Bundle bundle = new Bundle();
            bundle.putString("name",hTabs.get(i).getName());
            fm1.setArguments(bundle);
            newsList.add(fm1);
        }
        //设置viewpager适配器
        adapter = new OneFmAdapter(getActivity().getSupportFragmentManager(),newsList);
        vp_.setAdapter(adapter);
        //两个viewpager切换不重新加载
        vp_.setOffscreenPageLimit(2);
        //设置默认
        vp_.setCurrentItem(0);
        //设置viewpager监听事件
        vp_.setOnPageChangeListener(this);


    }

    //初始化头部导航栏
    private void initTab(LayoutInflater inflater) {

        List<HTab> hTabs = HTabDb.getSelected();
        for (int i = 0; i < hTabs.size();i++){
            //设置头部项布局初始化数据
            RadioButton radioButton = (RadioButton) inflater.inflate(R.layout.tab_rb,null);
            radioButton.setId(i);
            radioButton.setText(hTabs.get(i).getName());
//            ViewPager.LayoutParams params = new ViewPager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
//            , ViewGroup.LayoutParams.WRAP_CONTENT);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            //加入RadioGroup
            rg_.addView(radioButton,params);
        }
        rg_.check(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        TabWidget widget =
        RadioButton radioButton = (RadioButton) rg_.getChildAt(position);
        radioButton.setChecked(true);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int left = radioButton.getLeft();
        int width = radioButton.getWidth();
        int x=(left+width/2)-screenWidth/2;
        hv_.smoothScrollTo(x,0);
//        setTab(position);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    private void setTab(int position) {

        RadioButton radioButton = (RadioButton) rg_.getChildAt(position);
        //设置标题被点击
        radioButton.setChecked(true);
        //偏移设置
        int left = radioButton.getLeft();
        int width = radioButton.getMeasuredWidth();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        //移动距离= 左边的位置 + button宽度的一半 - 屏幕宽度的一半
        int len = left + width / 2 - screenWidth / 2;

        //移动
        hv_.smoothScrollTo(len,0);


    }

}
