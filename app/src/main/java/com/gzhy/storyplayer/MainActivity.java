package com.gzhy.storyplayer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private View mNewUIBottom;
    private RelativeLayout mDiscoverTab;
    private ImageView mDiscoverIv;
    private TextView mDiscoverTv;
    private RelativeLayout mDownloadTab;
    private ImageView mDownloadIv;
    private TextView mDownloadTv;
    private LinearLayout mPlayerIcon;
    private DownloadFragment firstFragment;
    private DiscoverFragment discoverFragment;
    FragmentManager mFragmentManager = null;
    Fragment[] mFragments = new Fragment[2];
    private static final int TAB_DISCOVER = 0;
    private static final int TAB_DOWNLOAD = 1;
    private int currentTab = TAB_DISCOVER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMainBottom();
    }

    private void initMainBottom() {
        mNewUIBottom = findViewById(R.id.newui_bottom);
        mDiscoverTab = mNewUIBottom.findViewById(R.id.rl_main_tab_discover);
        mDiscoverIv = mNewUIBottom.findViewById(R.id.iv_main_tab_discover);
        mDiscoverTv = mNewUIBottom.findViewById(R.id.tv_main_tab_room);
        mDiscoverTab.setOnClickListener(this);
        mDownloadTab = mNewUIBottom.findViewById(R.id.rl_main_tab_download);
        mDownloadIv = mNewUIBottom.findViewById(R.id.iv_main_tab_download);
        mDownloadTv = mNewUIBottom.findViewById(R.id.tv_main_tab_message);
        mDownloadTab.setOnClickListener(this);
        mPlayerIcon = mNewUIBottom.findViewById(R.id.ll_center_player);
        mPlayerIcon.setOnClickListener(this);
        mFragmentManager = getSupportFragmentManager();
        switchTabFragment(TAB_DISCOVER);
    }

//    底部Tabs切换
    private void switchTabFragment(int index) {
        currentTab = index;
        refreshNewUIBottom(index);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (index) {
            case TAB_DISCOVER:
                if (mFragments[index] == null) {
                    discoverFragment = new DiscoverFragment();
                    mFragments[index] = discoverFragment;
                    transaction.add(R.id.content_frame, discoverFragment);
                }
                break;
            case TAB_DOWNLOAD:
                if (mFragments[index] == null) {
                    firstFragment = new DownloadFragment();
                    mFragments[index] = firstFragment;
                    transaction.add(R.id.content_frame, firstFragment);
                }
                break;
            default:
                break;
        }
        for (int i = 0 ; i < mFragments.length; i++) {
            if (mFragments[i] == null) {
                continue;
            }
            if (i == index) {
                transaction.show(mFragments[index]);
            } else {
                transaction.hide(mFragments[i]);
            }
        }
        transaction.commitAllowingStateLoss();
    }

//  底部导航栏切换时更细UI
    private void refreshNewUIBottom(int tabIndex) {
        mDiscoverIv.setImageResource(R.mipmap.btn_icon1);
        mDiscoverTv.setTextColor(ContextCompat.getColor(this, R.color.talk_text_hint_c3));
        mDownloadIv.setImageResource(R.mipmap.btn_icon2);
        mDownloadTv.setTextColor(ContextCompat.getColor(this, R.color.talk_text_hint_c3));
        switch (tabIndex) {
            case TAB_DISCOVER:
                mDiscoverIv.setImageResource(R.mipmap.btn_icon1);
                mDiscoverTv.setTextColor(ContextCompat.getColor(this, R.color.talk_main_btn_normal));
                break;
            case TAB_DOWNLOAD:
                mDownloadIv.setImageResource(R.mipmap.btn_icon2);
                mDownloadTv.setTextColor(ContextCompat.getColor(this, R.color.talk_main_btn_normal));
                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_main_tab_discover:
                switchTabFragment(TAB_DISCOVER);
                break;
            case R.id.ll_center_player:
                Toast.makeText(this,"you click center icon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_main_tab_download:
                switchTabFragment(TAB_DOWNLOAD);
                break;
            default:
                break;
        }
    }
}
