package com.teamdemand.ondemandservice.fragment_user;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.teamdemand.ondemandservice.R;

public class FragmentServices extends Fragment {

    private RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public String[] serviceIds = {"1", "4", "5", "6", "7", "9", "10", "11", "78", "92"};
    private int[] serviceImages = {R.mipmap.automative_repair, R.mipmap.legal, R.mipmap.household_services, R.mipmap.personal_services, R.mipmap.tutors, R.mipmap.real_estate_services, R.mipmap.business_services, R.mipmap.repair_maintenance, R.mipmap.lessions_hobbies, R.mipmap.event_wedding};
    /* access modifiers changed from: private */
    public String[] serviceNames = {"Automative Repair", "Legal", "Household Services", "Personal Services", "Tutors", "Real Estate Services", "Business Services", "Repair & Maintenance", "Lessons & Hobbies", "Events & Weddings"};

    public class ServiceListAdapter extends Adapter<ServiceListAdapter.ServiceListHolder> {
        private Context context;
        private int[] images;

        public class ServiceListHolder extends ViewHolder implements OnClickListener {
            /* access modifiers changed from: private */
            public ImageView imageView;

            public ServiceListHolder(View view) {
                super(view);
                view.setOnClickListener(this);
                this.imageView = (ImageView) view.findViewById(R.id.imageView);
            }

            public void onClick(View view) {
                Fragment mFragment = new FragmentSelectedCategory();
                Bundle bundle = new Bundle();
                bundle.putString("cat_id", FragmentServices.this.serviceIds[getLayoutPosition()]);
                bundle.putString("cat_name", FragmentServices.this.serviceNames[getLayoutPosition()]);
                bundle.putInt("cat_position", getLayoutPosition());
                mFragment.setArguments(bundle);
                FragmentServices.this.getActivity().getSupportFragmentManager().beginTransaction().add((int) R.id.frameLayout, mFragment).commit();
            }
        }

        public ServiceListAdapter(Context context2, int[] images2) {
            this.context = context2;
            this.images = images2;
        }

        public ServiceListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ServiceListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_layout, null));
        }

        public void onBindViewHolder(ServiceListHolder holder, int position) {
            holder.imageView.setImageResource(this.images[position]);
        }

        public int getItemCount() {
            return this.images.length;
        }

        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.app_name);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_services, container, false);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        this.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.recyclerView.setAdapter(new ServiceListAdapter(getActivity(), this.serviceImages));
        return view;
    }
}
