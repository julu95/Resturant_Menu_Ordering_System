package com.user.avishmya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {
    ViewFlipper viewPager;
    LinearLayout b1,b2,b3,b4;
    TextView t1,t2,t3,t4;
    boolean bo1=true,bo2=true,bo3=true,bo4=true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_about, container, false);
        b1=(LinearLayout)view.findViewById(R.id.b1);
        t1=(TextView)view.findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bo1){
                    t1.setVisibility(View.VISIBLE);
                    b1.setBackgroundResource(R.drawable.home_page_button);
                    bo1=false;
                }
                else {
                    t1.setVisibility(View.GONE);
                    b1.setBackgroundResource(R.drawable.home_page_menu_bg);
                    bo1=true;
                }
            }
        });
        b2=(LinearLayout)view.findViewById(R.id.b2);
        t2=(TextView)view.findViewById(R.id.t2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bo2){
                    t2.setVisibility(View.VISIBLE);
                    b2.setBackgroundResource(R.drawable.home_page_button);
                    bo2=false;
                }
                else {
                    t2.setVisibility(View.GONE);
                    b2.setBackgroundResource(R.drawable.home_page_menu_bg);
                    bo2=true;
                }
            }
        });
        b3=(LinearLayout)view.findViewById(R.id.b3);
        t3=(TextView)view.findViewById(R.id.t3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bo3){
                    t3.setVisibility(View.VISIBLE);
                    b3.setBackgroundResource(R.drawable.home_page_button);
                    bo3=false;
                }
                else {
                    t3.setVisibility(View.GONE);
                    b3.setBackgroundResource(R.drawable.home_page_menu_bg);
                    bo3=true;
                }
            }
        });
        b4=(LinearLayout)view.findViewById(R.id.b4);
        t4=(TextView)view.findViewById(R.id.t4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bo4){
                    t4.setVisibility(View.VISIBLE);
                    b4.setBackgroundResource(R.drawable.home_page_button);
                    bo4=false;
                }
                else {
                    t4.setVisibility(View.GONE);
                    b4.setBackgroundResource(R.drawable.home_page_menu_bg);
                    bo4=true;
                }
            }
        });
        return view;
    }

}
