package com.teamdemand.ondemandservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button ButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonId = (Button) findViewById(R.id.ButtonGoId);

        ButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FrontActivity.class));
            }
        });

    }

    public void nextAction(View view) {

        //Intent i = new Intent(this,FrontActivity.class);



       startActivity(new Intent(MainActivity.this, FrontActivity.class));
    }
}