package com.example.dungngoc.appchat.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dungngoc.appchat.R;
import com.example.dungngoc.appchat.adapter.IntroAdapter;
import com.example.dungngoc.appchat.model.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newIntance(){
            MainFragment mainFragment = new MainFragment();
            return  mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        IntroFlagment javafragment = IntroFlagment.newInstance();
        IntroFlagment androidfragment =IntroFlagment.newInstance();
        IntroFlagment iosfragment =  IntroFlagment.newInstance();
        LoginRegisterFragment loginRegisterFragment = LoginRegisterFragment.newInstance();

        ArrayList<Fragment>arrayListFragment = new ArrayList<>();
        arrayListFragment.add(javafragment);
        arrayListFragment.add(androidfragment);
        arrayListFragment.add(iosfragment);
        arrayListFragment.add(loginRegisterFragment);

        ArrayList<Course>arrayListCourse = new ArrayList<>();
        Course javaCourse = new Course(getString(R.string.java_title), getString(R.string.java_decription), R.drawable.ic_2);
        Course androidCourse = new Course(getString(R.string.android_title).replace("java", "Android"), getString(R.string.android_decription).replace("java","Android"),R.drawable.ic_1);
        Course iosCourse = new Course(getString(R.string.ios_title).replace("java", "IOS"), getString(R.string.ios_decription).replace("java", "IOS"), R.drawable.ic_3);

        arrayListCourse.add(javaCourse);
        arrayListCourse.add(iosCourse);
        arrayListCourse.add(androidCourse);

        IntroAdapter adapter = new IntroAdapter(getFragmentManager(), arrayListFragment, arrayListCourse);
        viewPager.setAdapter(adapter);
        return view;
    }

}
