package com.teamdemand.ondemandservice.service_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.teamdemand.ondemandservice.LoginActivity;
import com.teamdemand.ondemandservice.R;

public class SignUpServiceProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_service_provider);
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("user_type", "provider");
        startActivity(intent);
    }

    public void signupMethod(View view) {
        startActivity(new Intent(this,ServiceProviderHomeActivity.class));
    }
}