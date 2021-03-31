package com.teamdemand.ondemandservice.fragment_common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentAboutUs extends Fragment {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("About Us");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        getActivity().setTitle("About Us");
        ((WebView) view.findViewById(R.id.wv_about_us)).loadData(getString(R.string.about_us_text), "text/html; charset=utf-8", "utf-8");
        return view;
    }
}
