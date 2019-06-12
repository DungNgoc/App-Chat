package com.example.dungngoc.appchat.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungngoc.appchat.R;
import com.example.dungngoc.appchat.model.Course;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFlagment extends Fragment {


    public IntroFlagment() {
        // Required empty public constructor
    }

    public static IntroFlagment newInstance(){
        IntroFlagment introFlagment = new IntroFlagment();
        return  introFlagment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intro_flagment, container, false);
        TextView tv_title = view.findViewById(R.id.tv_title);
        TextView tv_Description = view.findViewById(R.id.tv_description);
        ImageView imageView = view.findViewById(R.id.iv_background);

        Bundle bundle = getArguments();
        if(bundle!=null){
            int position = bundle.getInt("position");
            Log.d("IntroFlagment", "position="+position);

            Course course = (Course) bundle.getSerializable("course");
            tv_title.setText(course.getTitle());
            tv_Description.setText(course.getDescription());
            imageView.setImageResource(course.getImage());
        }
        return view;
    }


}
