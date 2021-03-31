package com.teamdemand.ondemandservice.fragment_user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.teamdemand.ondemandservice.R;

public class FragmentUserHome extends Fragment {

    public static ImageView post_a_job;
    public static ImageView services;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        try {
            services = (ImageView) view.findViewById(R.id.iv_services);
            post_a_job = (ImageView) view.findViewById(R.id.iv_post_a_job);
            if (getArguments() != null) {
                services.setImageResource(R.mipmap.home_services_btn);
                post_a_job.setImageResource(R.mipmap.home_postjob_btn_selected);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentPostAJob()).commit();
            } else {
                services.setImageResource(R.mipmap.home_services_btn_selected);
                post_a_job.setImageResource(R.mipmap.home_postjob_btn);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentServices()).commit();
            }
            services.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FragmentUserHome.services.setImageResource(R.mipmap.home_services_btn_selected);
                    FragmentUserHome.post_a_job.setImageResource(R.mipmap.home_postjob_btn);
                    FragmentUserHome.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentServices()).commit();
                }
            });
            post_a_job.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FragmentUserHome.services.setImageResource(R.mipmap.home_services_btn);
                    FragmentUserHome.post_a_job.setImageResource(R.mipmap.home_postjob_btn_selected);
                    FragmentUserHome.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentPostAJob()).commit();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
    public void postAJobTabSelection() {
        services.setImageResource(R.mipmap.home_services_btn);
        post_a_job.setImageResource(R.mipmap.home_postjob_btn_selected);
    }
}