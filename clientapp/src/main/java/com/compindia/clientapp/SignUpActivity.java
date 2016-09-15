package com.compindia.clientapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.compindia.clientapp.fragment.FreeSignInFragment;
import com.compindia.clientapp.fragment.PaidSignUpFragment;

public class SignUpActivity extends AppCompatActivity {

    private ViewPager vpSignUp;
    private TabLayout tlSignUp;
    private String[] tabNames;
    private String TAG = SignUpActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUpViews();
    }

    private void setUpViews() {
        vpSignUp = (ViewPager) findViewById(R.id.vp_singup);
        tlSignUp = (TabLayout) findViewById(R.id.tl_signup);
        getTabNames();
        vpSignUp.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        tlSignUp.setupWithViewPager(vpSignUp);
    }
    public String[] getTabNames() {
        tabNames=getResources().getStringArray(R.array.Tab_names);
        Log.d(TAG, "getTabNames: tabNames[1]"+tabNames[1]);
        return tabNames;
    }


    class FragmentAdapter extends FragmentPagerAdapter {
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FreeSignInFragment();
                case 1:
                    return new PaidSignUpFragment();
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
            return  tabNames[position];
        }
    }
}
