package com.gzhy.storyplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gzhy.storyplayer.R;

public class TabFragment extends Fragment {

    private int position;
    public TabFragment(int position){
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fm,container,false);
        return view;
    }
}
