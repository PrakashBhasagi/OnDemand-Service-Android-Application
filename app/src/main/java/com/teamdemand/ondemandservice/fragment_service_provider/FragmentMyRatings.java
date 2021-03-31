package com.teamdemand.ondemandservice.fragment_service_provider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentMyRatings extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_ratings, container, false);
        getActivity().setTitle("My Ratings");
        return view;
    }
}
