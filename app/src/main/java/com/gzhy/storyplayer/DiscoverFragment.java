package com.gzhy.storyplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by Administrator
 */

public class DiscoverFragment extends Fragment{
    EditText et_search;
    ImageView iv_search;
    ListView lv_hotspots_story;
    ListView lv_hotspots_websites;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        String[] hotspots_story = new String[]{"三国演义" , "白眉大侠" , "覆雨翻云", "回到明朝当王爷"};
        String[] hotspots_websites = {"听书网" , "我听评书网" , "中国评书网", "有声小说"};
        et_search = view.findViewById(R.id.et_search);
        iv_search = view.findViewById(R.id.iv_search);
        lv_hotspots_story = view.findViewById(R.id.lv_hotspots_story);
        lv_hotspots_websites = view.findViewById(R.id.lv_hotspots_websites);
    }

}
