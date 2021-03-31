package com.teamdemand.ondemandservice.customer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.teamdemand.ondemandservice.R;

public class CNotificationActivity extends AppCompatActivity {


    public ImageView ivNoRecordFound;
    public ProgressBar progressBar;
    public RecyclerView recyclerView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView((int) R.layout.activity_notification);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
            toolbar.setTitle((CharSequence) "Notifications");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
            this.ivNoRecordFound = (ImageView) findViewById(R.id.iv_no_record_found);
            this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            this.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
