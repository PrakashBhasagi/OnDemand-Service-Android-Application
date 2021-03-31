package com.teamdemand.ondemandservice.fragment_common;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.teamdemand.ondemandservice.R;

import org.json.JSONObject;

public class FragmentContactUs extends Fragment {




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        getActivity().setTitle("Contact Us");
        return view;
    }
}
