package com.teamdemand.ondemandservice.fragment_service_provider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentServiceProviderHome extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle(R.string.app_name);
        View view = inflater.inflate(R.layout.fragment_service_provider_home, container, false);
        try {
            final TextView tv_upcoming_jobs = (TextView) view.findViewById(R.id.tv_upcoming_jobs);
            final TextView tv_past_jobs = (TextView) view.findViewById(R.id.tv_past_jobs);
            if (getArguments() != null) {
                tv_upcoming_jobs.setTextColor(getResources().getColor(R.color.blackColor));
                tv_upcoming_jobs.setBackground(getResources().getDrawable(R.drawable.left_unselected_tab_bg));
                tv_past_jobs.setTextColor(getResources().getColor(R.color.whiteColor));
                tv_past_jobs.setBackground(getResources().getDrawable(R.drawable.right_selected_tab_bg));
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentPastJobs()).commit();
            } else {
                tv_upcoming_jobs.setTextColor(getResources().getColor(R.color.whiteColor));
                tv_upcoming_jobs.setBackground(getResources().getDrawable(R.drawable.left_select_tab_bg));
                tv_past_jobs.setTextColor(getResources().getColor(R.color.blackColor));
                tv_past_jobs.setBackground(getResources().getDrawable(R.drawable.right_unselected_tab_bg));
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentUpcomingJobs()).commit();
            }
            tv_upcoming_jobs.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    tv_upcoming_jobs.setTextColor(FragmentServiceProviderHome.this.getResources().getColor(R.color.whiteColor));
                    tv_upcoming_jobs.setBackground(FragmentServiceProviderHome.this.getResources().getDrawable(R.drawable.left_select_tab_bg));
                    tv_past_jobs.setTextColor(FragmentServiceProviderHome.this.getResources().getColor(R.color.blackColor));
                    tv_past_jobs.setBackground(FragmentServiceProviderHome.this.getResources().getDrawable(R.drawable.right_unselected_tab_bg));
                    FragmentServiceProviderHome.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentUpcomingJobs()).commit();
                }
            });
            tv_past_jobs.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    tv_upcoming_jobs.setTextColor(FragmentServiceProviderHome.this.getResources().getColor(R.color.blackColor));
                    tv_upcoming_jobs.setBackground(FragmentServiceProviderHome.this.getResources().getDrawable(R.drawable.left_unselected_tab_bg));
                    tv_past_jobs.setTextColor(FragmentServiceProviderHome.this.getResources().getColor(R.color.whiteColor));
                    tv_past_jobs.setBackground(FragmentServiceProviderHome.this.getResources().getDrawable(R.drawable.right_selected_tab_bg));
                    FragmentServiceProviderHome.this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentPastJobs()).commit();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
