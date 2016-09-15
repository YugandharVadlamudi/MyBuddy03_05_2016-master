package com.compindia.clientapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.compindia.clientapp.fragment.AboutUsFragment;
import com.compindia.clientapp.fragment.EventFragment;
import com.compindia.clientapp.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView nvHome;
    private String TAG = HomeActivity.class.getSimpleName();
    private DrawerLayout dlHome;
    private FrameLayout flFragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d(TAG, "onOptionsItemSelected: home Click");
                if (dlHome.isDrawerOpen(nvHome)) {
                    dlHome.closeDrawer(nvHome);
                } else {
                    dlHome.openDrawer(nvHome);
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hamburg_64);
        setContentView(R.layout.activity_home);
        setUpViews();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home, homeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void setUpViews() {
        nvHome = (NavigationView) findViewById(R.id.nv_home);
        dlHome = (DrawerLayout) findViewById(R.id.dl_home);
        flFragment = (FrameLayout) findViewById(R.id.fl_home);
        setListeners();
    }

    private void setListeners() {
        nvHome.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                clearBackStack();
                Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                HomeFragment homeFragment = new HomeFragment();
                loadFragment(homeFragment);
                return true;
            case R.id.menu_aboutus:
                clearBackStack();
                Toast.makeText(HomeActivity.this, "aboutus", Toast.LENGTH_SHORT).show();
                AboutUsFragment aboutUsFragment = new AboutUsFragment();
                loadFragment(aboutUsFragment);
                return true;
            case R.id.menu_events:
                clearBackStack();
                Toast.makeText(HomeActivity.this, "events", Toast.LENGTH_SHORT).show();
                EventFragment eventFragment = new EventFragment();
                loadFragment(eventFragment);
                return true;
            case R.id.menu_logout:
                Toast.makeText(HomeActivity.this, "Log Out", Toast.LENGTH_SHORT).show();
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Logout");
                builder.setTitle("Are you sure you want to exit");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        clearBackStack();
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlHome.closeDrawers();
                    }
                });
                builder.show();
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        dlHome.closeDrawers();
    }

    private void clearBackStack() {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }

    @Override
    public void onBackPressed() {
        clearBackStack();
        Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
        HomeFragment homeFragment = new HomeFragment();
        loadFragment(homeFragment);
    }
}
