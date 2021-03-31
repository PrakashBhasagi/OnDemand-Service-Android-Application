package com.teamdemand.ondemandservice.fragment_service_provider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class SPProfileFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("My Profile");
        View view = inflater.inflate(R.layout.fragment_profile_sp, container, false);
        //  initView(view);
        final View editLine = view.findViewById(R.id.edit_line_view);
        final View changePasswordLine = view.findViewById(R.id.change_password_line_view);
        final ScrollView editDetailLayout = (ScrollView) view.findViewById(R.id.edit_detail_layout);
        final ScrollView passwordDetailLayout = (ScrollView) view.findViewById(R.id.change_password_detail_layout);

        view.findViewById(R.id.edit_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                editLine.setVisibility(0);
                changePasswordLine.setVisibility(8);
                editDetailLayout.setVisibility(0);
                passwordDetailLayout.setVisibility(8);
            }
        });
        view.findViewById(R.id.change_password_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                editLine.setVisibility(8);
                changePasswordLine.setVisibility(0);
                editDetailLayout.setVisibility(8);
                passwordDetailLayout.setVisibility(0);
            }
        });
        return view;
    }

}
