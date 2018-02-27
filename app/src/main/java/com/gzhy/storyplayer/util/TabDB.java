package com.gzhy.storyplayer.util;

import com.gzhy.storyplayer.R;
import com.gzhy.storyplayer.fragment.FourFm;
import com.gzhy.storyplayer.fragment.NewOneFm;
import com.gzhy.storyplayer.fragment.ThreeFm;
import com.gzhy.storyplayer.fragment.TwoFm;

public class TabDB {

    //获取底部所有项
    public static String[] getTabsTxt(){

        String[] tabs = {"首页","交易","地点","我的"};
        return tabs;
    }

    //获得所有碎片
    public static Class[] getFragment(){

        Class[] cls = {TwoFm.class, NewOneFm.class, ThreeFm.class, FourFm.class};
        return cls;

    }

    //获得所有点击前的图片
    public static int [] getTabsImg(){
        int [] img = {R.drawable.menu,R.drawable.breath,R.drawable.block_change,R.drawable.circle};
        return img;
    }

    //获得所有点击后的图片
    public static int[] getTabsImgLight(){

        int [] img ={R.drawable.meum_selected,R.drawable.breath_selected,R.drawable.block_change_selected,R.drawable.circle_selected};
        return img;

    }

}
