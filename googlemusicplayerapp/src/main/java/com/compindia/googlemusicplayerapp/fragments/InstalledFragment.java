package com.compindia.googlemusicplayerapp.fragments;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.compindia.googlemusicplayerapp.R;
import com.compindia.googlemusicplayerapp.adapters.RecyclerAdapter;
import com.compindia.googlemusicplayerapp.utils.AppInfoClass;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstalledFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstalledFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstalledFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String TAG = InstalledFragment.class.getSimpleName();

    private RecyclerView rvInstalled;
    private List<AppInfoClass> listAppInfoClass;
    public InstalledFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstalledFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstalledFragment newInstance(String param1, String param2) {
        InstalledFragment fragment = new InstalledFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listAppInfoClass=new ArrayList<>();
        View view= inflater.inflate(R.layout.fragment_installed, container, false);
        rvInstalled = (RecyclerView) view.findViewById(R.id.rv_home_applist);
        rvInstalled.setLayoutManager(new LinearLayoutManager(getContext()));
        getListInstalledApps();
        rvInstalled.setAdapter(new RecyclerAdapter(getActivity().getApplicationContext(),listAppInfoClass));

        return view;
    }
    public void getListInstalledApps() {
        PackageManager packageManager = getActivity().getPackageManager();
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
}
