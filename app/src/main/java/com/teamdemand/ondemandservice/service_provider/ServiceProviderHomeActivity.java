package com.teamdemand.ondemandservice.service_provider;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.teamdemand.ondemandservice.FrontActivity;
import com.teamdemand.ondemandservice.R;
import com.teamdemand.ondemandservice.SelectLocationActivity;
import com.teamdemand.ondemandservice.fragment_common.FragmentAboutUs;
import com.teamdemand.ondemandservice.fragment_common.FragmentCancellationPolicy;
import com.teamdemand.ondemandservice.fragment_common.FragmentContactUs;
import com.teamdemand.ondemandservice.fragment_common.FragmentFAQ;
import com.teamdemand.ondemandservice.fragment_service_provider.FragmentMyRatings;
import com.teamdemand.ondemandservice.fragment_service_provider.FragmentServiceProviderHome;
import com.teamdemand.ondemandservice.fragment_service_provider.FragmentSettings;
import com.teamdemand.ondemandservice.fragment_service_provider.SPProfileFragment;

public class ServiceProviderHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen((int) GravityCompat.START)) {
            drawer.closeDrawer((int) GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() != 1) {
            super.onBackPressed();
            String fragName = null;
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
                fragName = getSupportFragmentManager().getBackStackEntryAt(i).getName();
            }
            Log.e("ClassName: ", fragName + "");
            setTitle(fragName);
        } else if (this.doubleBackToExitPressedOnce) {
            finish();
            super.onBackPressed();
        } else {
            this.doubleBackToExitPressedOnce = true;
            Snackbar.make(findViewById(R.id.nav_home), (CharSequence) "Please click BACK again to exit", BaseTransientBottomBar.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ServiceProviderHomeActivity.this.doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.service_provider_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != R.id.action_settings) {
            return super.onOptionsItemSelected(item);
        }
        Fragment fragment3 = new FragmentSettings();
        FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
        ft5.addToBackStack("Setting");
        ft5.add((int) R.id.mainFrameLayout, fragment3).commit();
        return true;
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Fragment mFragment = new FragmentServiceProviderHome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack("Home");
            ft.replace(R.id.mainFrameLayout, mFragment).commit();
        } else if (id == R.id.nav_past_job) {
            Fragment mFragment2 = new FragmentServiceProviderHome();
            Bundle bundle = new Bundle();
            bundle.putBoolean("past_job", true);
            mFragment2.setArguments(bundle);
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.addToBackStack("Home");
            ft2.replace(R.id.mainFrameLayout, mFragment2).commit();
        } else if (id == R.id.nav_my_ratings) {
            Fragment fragment = new FragmentMyRatings();
            FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
            ft3.addToBackStack("My Ratings");
            ft3.add((int) R.id.mainFrameLayout, fragment).commit();
        } else if (id == R.id.nav_notification) {
            Intent intent = new Intent(this, SPNotificationActivity.class);

            startActivity(intent);
        } else if (id == R.id.nav_my_profile) {
            Fragment fragment2 = new SPProfileFragment();
            FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
            ft4.addToBackStack("Profile");
            ft4.add((int) R.id.mainFrameLayout, fragment2).commit();
        } else if (id == R.id.nav_settings) {
            Fragment fragment3 = new FragmentSettings();
            FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
            ft5.addToBackStack("Setting");
            ft5.add((int) R.id.mainFrameLayout, fragment3).commit();
        } else if (id == R.id.nav_contact_us) {
            Fragment fragment4 = new FragmentContactUs();
            FragmentTransaction ft6 = getSupportFragmentManager().beginTransaction();
            ft6.addToBackStack("Contact Us");
            ft6.add((int) R.id.mainFrameLayout, fragment4).commit();
        } else if (id == R.id.nav_about_us) {
            Fragment fragment5 = new FragmentAboutUs();
            FragmentTransaction ft7 = getSupportFragmentManager().beginTransaction();
            ft7.addToBackStack("About Us");
            ft7.add((int) R.id.mainFrameLayout, fragment5).commit();
        } else if (id == R.id.nav_cancellation_policy) {
            Fragment fragment6 = new FragmentCancellationPolicy();
            FragmentTransaction ft8 = getSupportFragmentManager().beginTransaction();
            ft8.addToBackStack("Cancellation Policy");
            ft8.add((int) R.id.mainFrameLayout, fragment6).commit();
        } else if (id == R.id.nav_FAQ) {
            Fragment fragment7 = new FragmentFAQ();
            FragmentTransaction ft9 = getSupportFragmentManager().beginTransaction();
            ft9.addToBackStack("FAQ");
            ft9.add((int) R.id.mainFrameLayout, fragment7).commit();
        } else if (id == R.id.nav_logout) {
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.logout_popup_dialog);
            dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            dialog.show();
            TextView no = (TextView) dialog.findViewById(R.id.tv_no);
            ((TextView) dialog.findViewById(R.id.tv_yes)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                    Intent intent = new Intent(ServiceProviderHomeActivity.this, FrontActivity.class);
                    ServiceProviderHomeActivity.this.startActivity(intent);
                    ServiceProviderHomeActivity.this.finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }
}