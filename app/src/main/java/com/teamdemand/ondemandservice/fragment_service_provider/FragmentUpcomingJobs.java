package com.teamdemand.ondemandservice.fragment_service_provider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamdemand.ondemandservice.R;
import com.teamdemand.ondemandservice.service_provider.JobDetailSPActivity;

public class FragmentUpcomingJobs extends Fragment {
    
    public ImageView ivNoRecordFound;
    public ProgressBar progressBar;
    public RecyclerView recyclerView;
    private String sp_id;

    public class UpcomingJobsAdapter extends RecyclerView.Adapter<UpcomingJobsAdapter.UpcomingJobsHolder> {

        private int lastPosition = -1;

        @NonNull
        @Override
        public UpcomingJobsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull UpcomingJobsHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class UpcomingJobsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            /* access modifiers changed from: private */
            public TextView date;
            private ImageView iv_profile_image;
            /* access modifiers changed from: private */
            public TextView name;
            /* access modifiers changed from: private */
            public TextView time;
            /* access modifiers changed from: private */
            public TextView title;

            public UpcomingJobsHolder(View view) {
                super(view);
                view.setOnClickListener(this);
                this.iv_profile_image = (ImageView) view.findViewById(R.id.iv_profile_image);
                this.name = (TextView) view.findViewById(R.id.tv_profile_name);
                this.title = (TextView) view.findViewById(R.id.tv_job_description);
                this.date = (TextView) view.findViewById(R.id.tv_job_date);
                this.time = (TextView) view.findViewById(R.id.tv_job_date_time);
            }

            public void onClick(View view) {
                try {
                    Intent intent = new Intent(FragmentUpcomingJobs.this.getActivity(), JobDetailSPActivity.class);
                   // intent.putExtra("job_data", UpcomingJobsAdapter.this.jsonArray.getJSONObject(getLayoutPosition()).toString());
                    FragmentUpcomingJobs.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_jobs, container, false);
        try {
            this.ivNoRecordFound = (ImageView) view.findViewById(R.id.iv_no_record_found);
            this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}

