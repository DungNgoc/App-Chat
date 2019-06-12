package com.example.dungngoc.appchat.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungngoc.appchat.OnSkipNextListener;
import com.example.dungngoc.appchat.R;
import com.example.dungngoc.appchat.model.Course;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFlagment extends Fragment implements View.OnClickListener {

    private  int position;
    private static OnSkipNextListener callback;

    public IntroFlagment() {
        // Required empty public constructor
    }

    public static IntroFlagment newInstance(OnSkipNextListener mcallback){
        IntroFlagment introFlagment = new IntroFlagment();
        callback = mcallback;
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



        View indicator1 = view.findViewById(R.id.indicator1);
        View indicator2 = view.findViewById(R.id.indicator2);
        View indicator3 = view.findViewById(R.id.indicator3);

        TextView tv_skip = view.findViewById(R.id.tv_skip);
        TextView tv_next = view.findViewById(R.id.tv_next);

        tv_skip.setOnClickListener(this);
        tv_next.setOnClickListener(this);

        Bundle bundle = getArguments();
        if(bundle!=null){
             position = bundle.getInt("position");
            Log.d("IntroFlagment", "position="+position);

            Course course = (Course) bundle.getSerializable("course");
            tv_title.setText(course.getTitle());
            tv_Description.setText(course.getDescription());
            imageView.setImageResource(course.getImage());
            switch (position){
                case 0:
                    indicator1.setBackgroundResource(R.drawable.bg_indicator_active);
                    indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    break;
                case 1:
                    indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator2.setBackgroundResource(R.drawable.bg_indicator_active);
                    indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    break;
                case 2:
                    indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                    indicator3.setBackgroundResource(R.drawable.bg_indicator_active);
            }
        }

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_next:
                callback.onClickNext(position);
                break;
                case R.id.tv_skip:
                    callback.onClickSkip();
                    break;
        }
    }
}
