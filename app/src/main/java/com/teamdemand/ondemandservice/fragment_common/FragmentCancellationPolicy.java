package com.teamdemand.ondemandservice.fragment_common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class FragmentCancellationPolicy extends Fragment {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Cancellation Policy");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cancellation_policy, container, false);
        getActivity().setTitle("Cancellation Policy");
        ((WebView) view.findViewById(R.id.wv_cancel_policy)).loadData(getString(R.string.cancellation_policy_text), "text/html; charset=utf-8", "utf-8");
        return view;
    }
}
