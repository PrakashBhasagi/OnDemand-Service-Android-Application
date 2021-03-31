package com.teamdemand.ondemandservice.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.teamdemand.ondemandservice.LoginActivity;
import com.teamdemand.ondemandservice.R;

public class SignUpCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_customer);
    }

    public void backToLogin(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("user_type", "customer");
        startActivity(intent);
    }

    public void signupMethod(View view) {
        startActivity(new Intent(SignUpCustomerActivity.this, CustomerHomeActivity.class));
    }
}