package com.teamdemand.ondemandservice.fragment_user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentPostAJob extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_ajob, container, false);
        getActivity().setTitle("Post a Job");
        return view;
    }
}
