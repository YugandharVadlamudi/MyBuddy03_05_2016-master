package com.compindia.googlemusicplayerapp.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Kiran on 25-08-2016.
 */
public class TextVIewRobotoLight extends TextView {
    public TextVIewRobotoLight(Context context) {
        super(context);
        init(context);
    }

    public TextVIewRobotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextVIewRobotoLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/Roboto-Regular.ttf");
        setTypeface(tf);
    }
}
