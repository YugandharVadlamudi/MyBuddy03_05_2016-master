package com.compindia.googlemusicplayerapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.compindia.googlemusicplayerapp.fragments.AllFragment;
import com.compindia.googlemusicplayerapp.fragments.InstalledFragment;
import com.compindia.googlemusicplayerapp.utils.AppInfoClass;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String TAG = HomeActivity.class.getSimpleName();
    private List<AppInfoClass> listAppInfoClass;
    private RecyclerView rvHomeAppList;
    private ViewPager vpFragments;
    private String[] tabNames;
    private TabLayout tabLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpViews();
        setUpActionBar();
    }

    private void setUpViews() {
        context = getApplicationContext();
        tabNames = getResources().getStringArray(R.array.TabNames);
        listAppInfoClass =new ArrayList<AppInfoClass>();
        toolbar = (Toolbar) findViewById(R.id.tb_home);
        tabLayout = (TabLayout) findViewById(R.id.tl_home);
//        rvHomeAppList = (RecyclerView) findViewById(R.id.rv_home_applist);
        getListInstalledApps();
        vpFragments = (ViewPager) findViewById(R.id.vp_one);
        vpFragments.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(vpFragments);
//        rvHomeAppList.setLayoutManager(new LinearLayoutManager(context));
//        rvHomeAppList.setAdapter(new RecyclerAdapter(listAppInfoClass));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchitem, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem menuItem = menu.findItem(R.id.menu_toolbarsearch);
        return super.onCreateOptionsMenu(menu);
    }

    private void setUpActionBar() {
        setSupportActionBar(toolbar);
    }

    public void getListInstalledApps() {
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> listApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        Log.d(TAG, "getListInstalledApps: listAppsSize->" + listApps.get(0));
        for (int i = 0; i < listApps.size(); i++) {
//            Log.d(TAG, "getListInstalledApps: listApps->"+listApps.get(i));
            AppInfoClass appInfoClass=new AppInfoClass();
            ApplicationInfo applicationInfo = listApps.get(i);
            appInfoClass.setAppName((String)packageManager.getApplicationLabel(applicationInfo));
            appInfoClass.setDrawable(packageManager.getApplicationIcon(applicationInfo));
            appInfoClass.setDrawable(packageManager.getApplicationIcon(applicationInfo));
            Log.d(TAG, "getListInstalledApps: process->"+packageManager.getApplicationLabel(applicationInfo));
            /*String appName = (String)packageManager.getApplicationLabel(applicationInfo);
            Drawable applicationIcon= packageManager.getApplicationIcon(applicationInfo);*/
            listAppInfoClass.add(appInfoClass);
        }
        Log.d(TAG, "getListInstalledApps: listAppNameSize->" + listAppInfoClass.size());
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    InstalledFragment installedFragment=new InstalledFragment();
                    return installedFragment;
                case 1:
                    AllFragment allFragment=new AllFragment();
                    return allFragment;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }
    }

}
