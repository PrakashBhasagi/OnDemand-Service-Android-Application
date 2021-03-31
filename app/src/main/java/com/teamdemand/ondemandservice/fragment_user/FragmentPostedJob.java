package com.teamdemand.ondemandservice.fragment_user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentPostedJob extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posted_job, container, false);
        getActivity().setTitle("Jobs Posted");
        return view;
    }


}
