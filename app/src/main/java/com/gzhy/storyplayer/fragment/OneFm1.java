package com.gzhy.storyplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzhy.storyplayer.R;

public class OneFm1 extends Fragment {

    private String name;

    public void setArguments(Bundle args){
        name = args.getString("name");
    }
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.one_fm,null);
//        return view;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigate_fm1,null);
        return view;
    }
}
