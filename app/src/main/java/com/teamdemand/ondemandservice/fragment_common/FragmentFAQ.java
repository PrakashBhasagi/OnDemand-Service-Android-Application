package com.teamdemand.ondemandservice.fragment_common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentFAQ extends Fragment {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("FAQ");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        getActivity().setTitle("F A Q");
        ((WebView) view.findViewById(R.id.wv_faq)).loadData(getString(R.string.faq_text), "text/html; charset=utf-8", "utf-8");
        return view;
    }
}
