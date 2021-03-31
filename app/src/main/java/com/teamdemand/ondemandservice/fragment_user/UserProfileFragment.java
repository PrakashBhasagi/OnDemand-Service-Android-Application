package com.teamdemand.ondemandservice.fragment_user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.teamdemand.ondemandservice.R;

public class UserProfileFragment extends Fragment {

    public String Address;
    public String City;
    public String Country;
    public String Email;
    public String Name;
    public String Phone;
    public String Pincode;
    public EditText address;
    public EditText c_new_password;
    public EditText city;
    public EditText country;
    public EditText email;
    public EditText new_password;
    public EditText old_password;
    public EditText phone;
    public EditText pincode;
    private ImageView profileImage;
    public TextView profile_city_country;
    public TextView profile_name;
    public ProgressBar progressBar;
 
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("My Profile");
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        this.profile_name = (TextView) view.findViewById(R.id.tv_profile_name);
        this.profile_city_country = (TextView) view.findViewById(R.id.tv_profile_city_country);
        this.email = (EditText) view.findViewById(R.id.et_email_address);
        this.phone = (EditText) view.findViewById(R.id.et_phone_number);
        this.address = (EditText) view.findViewById(R.id.et_address_line);
        this.city = (EditText) view.findViewById(R.id.et_city);
        this.pincode = (EditText) view.findViewById(R.id.et_pincode);
        this.country = (EditText) view.findViewById(R.id.et_country);
        this.old_password = (EditText) view.findViewById(R.id.et_existing_password);
        this.new_password = (EditText) view.findViewById(R.id.et_new_password);
        this.c_new_password = (EditText) view.findViewById(R.id.et_re_password);
        final View editLine = view.findViewById(R.id.edit_line_view);
        final View changePasswordLine = view.findViewById(R.id.change_password_line_view);
        final View addressLine = view.findViewById(R.id.address_line_view);
        final ScrollView editDetailLayout = (ScrollView) view.findViewById(R.id.edit_detail_layout);
        final ScrollView passwordDetailLayout = (ScrollView) view.findViewById(R.id.change_password_detail_layout);
        final ScrollView addressDetailLayout = (ScrollView) view.findViewById(R.id.address_detail_layout);
        view.findViewById(R.id.edit_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                editLine.setVisibility(0);
                changePasswordLine.setVisibility(8);
                addressLine.setVisibility(8);
                editDetailLayout.setVisibility(0);
                passwordDetailLayout.setVisibility(8);
                addressDetailLayout.setVisibility(8);
            }
        });
        view.findViewById(R.id.address_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!UserProfileFragment.this.phone.getText().toString().isEmpty() && UserProfileFragment.this.phone.getText().toString().length() == 10) {
                    editLine.setVisibility(8);
                    changePasswordLine.setVisibility(8);
                    addressLine.setVisibility(0);
                    editDetailLayout.setVisibility(8);
                    passwordDetailLayout.setVisibility(8);
                    addressDetailLayout.setVisibility(0);
                }
            }
        });
        view.findViewById(R.id.change_password_layout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                editLine.setVisibility(8);
                changePasswordLine.setVisibility(0);
                addressLine.setVisibility(8);
                editDetailLayout.setVisibility(8);
                passwordDetailLayout.setVisibility(0);
                addressDetailLayout.setVisibility(8);
            }
        });
        return view;
    }
}
