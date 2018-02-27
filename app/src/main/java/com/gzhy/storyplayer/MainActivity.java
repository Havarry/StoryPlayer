package com.gzhy.storyplayer;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.gzhy.storyplayer.util.TabDB;

public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener{

    private LayoutInflater layoutInflater;
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //初始化FragmentTabHost
        initHost();
        //初始化底部导航栏
        initTab();
        //默认选中
        mTabHost.onTabChanged(TabDB.getTabsTxt()[0]);
    }

    private void initTab() {

        layoutInflater = LayoutInflater.from(this);
        String[] tabs = TabDB.getTabsTxt();
        for (int i = 0;i < tabs.length; i++){
            //新建TabSpec
            TabHost.TabSpec tabSpec1 = mTabHost.newTabSpec("explore").setIndicator("explore", Drawable.createFromPath(TabDB.getTabsTxt()[i]));
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(TabDB.getTabsTxt()[i]).setIndicator(getTabItemView(i));
            //设置view
//            View view = LayoutInflater.from(this).inflate(R.layout.tab_foot,null);

            //加入TabSpec
            mTabHost.addTab(tabSpec,TabDB.getFragment()[i],null);

        }

    }

    private View getTabItemView(int i) {
        View view = layoutInflater.inflate(R.layout.tab_foot, null);
        ((TextView)view.findViewById(R.id.foot_tv)).setText(TabDB.getTabsTxt()[i]);
        ((ImageView)view.findViewById(R.id.foot_iv)).setImageResource(TabDB.getTabsImg()[i]);
        return view;
    }

    private void initHost() {
        mTabHost = (FragmentTabHost) findViewById(R.id.main_tab);
        //调用setup方法 设置view
        mTabHost.setup(this,getSupportFragmentManager(),R.id.main_view);
        //去除分割线.
        mTabHost.getTabWidget().setDividerDrawable(null);
        //监听事件
        mTabHost.setOnTabChangedListener(this);

    }

    @Override
    public void onTabChanged(String tabId) {

        //从分割线中获得多少个切换界面
        TabWidget tabw = mTabHost.getTabWidget();
        for (int i = 0;i < tabw.getChildCount(); i++){
            View v = tabw.getChildAt(i);
            TextView tv = (TextView) v.findViewById(R.id.foot_tv);
            ImageView iv = (ImageView) v.findViewById(R.id.foot_iv);

//            修改当前的界面按钮颜色图片
            if (i == mTabHost.getCurrentTab()){
                tv.setTextColor(Color.rgb(255,0,0));
                iv.setImageResource(TabDB.getTabsImgLight()[i]);
            }else {
                tv.setTextColor(Color.rgb(0,0,255));
                iv.setImageResource(TabDB.getTabsImg()[i]);
            }

        }

    }
}
