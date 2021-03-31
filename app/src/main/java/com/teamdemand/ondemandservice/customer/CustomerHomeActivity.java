package com.teamdemand.ondemandservice.customer;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.teamdemand.ondemandservice.FrontActivity;
import com.teamdemand.ondemandservice.R;
import com.teamdemand.ondemandservice.SelectLocationActivity;
import com.teamdemand.ondemandservice.fragment_common.FragmentAboutUs;
import com.teamdemand.ondemandservice.fragment_common.FragmentCancellationPolicy;
import com.teamdemand.ondemandservice.fragment_common.FragmentContactUs;
import com.teamdemand.ondemandservice.fragment_common.FragmentFAQ;
import com.teamdemand.ondemandservice.fragment_user.FragmentPostedJob;
import com.teamdemand.ondemandservice.fragment_user.FragmentUserHome;
import com.teamdemand.ondemandservice.fragment_user.UserProfileFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CustomerHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private String LOGIN_SHARED_PREFERENCE = "loginSharedPreference";
    boolean doubleBackToExitPressedOnce = false;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView((int) R.layout.activity_customer_home);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            Fragment mFragment = new FragmentUserHome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack("Home");
            ft.add((int) R.id.mainFrameLayout, mFragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != R.id.action_select_location) {
            return super.onOptionsItemSelected(item);
        }
        startActivity(new Intent(this, SelectLocationActivity.class));
        return true;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Fragment mFragment = new FragmentUserHome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack("Home");
            ft.replace(R.id.mainFrameLayout, mFragment).commit();
        } else if (id == R.id.nav_post_a_job) {
            Fragment mFragment2 = new FragmentUserHome();
            Bundle bundle = new Bundle();
            bundle.putBoolean("post_a_job", true);
            mFragment2.setArguments(bundle);
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.addToBackStack("Home");
            ft2.replace(R.id.mainFrameLayout, mFragment2).commit();
        } else if (id == R.id.nav_posted_job) {
            Fragment fragment = new FragmentPostedJob();
            FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
            ft3.addToBackStack("Posted Jobs");
            ft3.add((int) R.id.mainFrameLayout, fragment).commit();
        } else if (id == R.id.nav_notification) {
            Intent intent = new Intent(this, CNotificationActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_profile) {
            Fragment fragment2 = new UserProfileFragment();
            FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
            ft4.addToBackStack("Profile");
            ft4.add((int) R.id.mainFrameLayout, fragment2).commit();
        } else if (id == R.id.nav_contact_us) {
            Fragment fragment3 = new FragmentContactUs();
            FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
            ft5.addToBackStack("Contact Us");
            ft5.add((int) R.id.mainFrameLayout, fragment3).commit();
        } else if (id == R.id.nav_about_us) {
            Fragment fragment4 = new FragmentAboutUs();
            FragmentTransaction ft6 = getSupportFragmentManager().beginTransaction();
            ft6.addToBackStack("About Us");
            ft6.add((int) R.id.mainFrameLayout, fragment4).commit();
        } else if (id == R.id.nav_cancellation_policy) {
            Fragment fragment5 = new FragmentCancellationPolicy();
            FragmentTransaction ft7 = getSupportFragmentManager().beginTransaction();
            ft7.addToBackStack("Cancellation Policy");
            ft7.add((int) R.id.mainFrameLayout, fragment5).commit();
        } else if (id == R.id.nav_FAQ) {
            Fragment fragment6 = new FragmentFAQ();
            FragmentTransaction ft8 = getSupportFragmentManager().beginTransaction();
            ft8.addToBackStack("FAQ");
            ft8.add((int) R.id.mainFrameLayout, fragment6).commit();
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

                    Intent intent = new Intent(CustomerHomeActivity.this, FrontActivity.class);
                    CustomerHomeActivity.this.startActivity(intent);
                    CustomerHomeActivity.this.finish();
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