package com.gzhy.storyplayer.util;

import com.gzhy.storyplayer.R;
import com.gzhy.storyplayer.fragment.NewOneFm;
import com.gzhy.storyplayer.fragment.TwoFm;

public class TabDB {

    //获取底部所有项
    public static String[] getTabsTxt(){

        String[] tabs = {"发现","下载"};
        return tabs;
    }

    //获得所有碎片
    public static Class[] getFragment(){

        Class[] cls = { TwoFm.class, NewOneFm.class};
        return cls;

    }

    //获得所有点击前的图片
    public static int [] getTabsImg(){
        int [] img = {R.drawable.btn_icon1,R.drawable.btn_icon2};
        return img;
    }

    //获得所有点击后的图片
    public static int[] getTabsImgLight(){

        int [] img ={R.drawable.btn_icon1,R.drawable.btn_icon2};
        return img;

    }

}
