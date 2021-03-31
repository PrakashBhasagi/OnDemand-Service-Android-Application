package com.teamdemand.ondemandservice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.teamdemand.ondemandservice.customer.CustomerHomeActivity;
import com.teamdemand.ondemandservice.customer.SignUpCustomerActivity;
import com.teamdemand.ondemandservice.service_provider.ServiceProviderHomeActivity;
import com.teamdemand.ondemandservice.service_provider.SignUpServiceProviderActivity;

public class LoginActivity extends AppCompatActivity {

    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userType = getIntent().getExtras().getString("user_type");
    }


    public void forgotPassword(View view) {
        if (this.userType.contentEquals("customer")) {
            Intent intent = new Intent(this, ForgotPasswordActivity.class);
            intent.putExtra("user_type", "customer");
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, ForgotPasswordActivity.class);
        intent2.putExtra("user_type", "provider");
        startActivity(intent2);
    }

    public void createAccount(View view) {
        if (this.userType.contentEquals("customer")) {
            Intent intent = new Intent(this, SignUpCustomerActivity.class);
            intent.putExtra("user_type", "customer");
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, SignUpServiceProviderActivity.class);
        intent2.putExtra("user_type", "provider");
        startActivity(intent2);
    }

    public void fbLogin(View view) {
    }

    public void loginMethod(View view) {
        if (this.userType.contentEquals("customer")) {
            Intent intent = new Intent(this, CustomerHomeActivity.class);
            intent.putExtra("user_type", "customer");
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, ServiceProviderHomeActivity.class);
        intent2.putExtra("user_type", "provider");
        startActivity(intent2);
    }
}