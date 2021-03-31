package com.teamdemand.ondemandservice.fragment_service_provider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentSettings extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("My Settings");
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
      //  initView(view);
        return view;
    }
}
