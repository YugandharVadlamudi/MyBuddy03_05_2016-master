package com.compindia.googlemusicplayerapp.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.compindia.googlemusicplayerapp.R;

/**
 * Created by Kiran on 01-09-2016.
 */
public class AppInfoClass {
    private String appName;
    private Drawable drawable;
    private String fontIcion = "&#xf16a;";
    private String TAG = AppInfoClass.class.getSimpleName();

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getAppName() {
        return appName;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String getFontIcion() {
        Resources resources=Resources.getSystem();
        Log.d(TAG, "getFontIcion: "+resources.getString(R.string.youtube));
        return resources.getString(R.string.youtube);
//        return fontIcion;
    }
}
