package com.example.dungngoc.appchat.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dungngoc.appchat.model.Course;

import java.io.Serializable;
import java.util.ArrayList;

public class IntroAdapter extends FragmentStatePagerAdapter {

private ArrayList<Fragment>mListFrament;
private ArrayList<Course>mListCourse;

    public IntroAdapter(FragmentManager fm,ArrayList<Fragment> fragments, ArrayList<Course>mListCourse) {
        super(fm);
        this.mListFrament = fragments;
        this.mListCourse = mListCourse;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mListFrament.get(position);
        if(position< (mListFrament.size()-1)){
            Bundle bundle = new Bundle();
            bundle.putInt("position",position);
            bundle.putSerializable("course",(Serializable) mListCourse.get(position));
            fragment.setArguments(bundle);
        }


        return fragment;
    }

    @Override
    public int getCount() {
        return mListFrament.size();
    }
}
