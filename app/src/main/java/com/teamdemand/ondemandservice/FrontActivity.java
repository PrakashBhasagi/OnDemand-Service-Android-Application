package com.teamdemand.ondemandservice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FrontActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
    }



    public void customer(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("user_type", "customer");
        startActivity(intent);
    }

    public void serviceProvider(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("user_type", "provider");
        startActivity(intent);
    }
}