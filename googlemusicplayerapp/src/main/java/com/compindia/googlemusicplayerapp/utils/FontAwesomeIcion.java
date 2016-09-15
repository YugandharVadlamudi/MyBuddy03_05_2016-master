package com.compindia.googlemusicplayerapp.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Kiran on 25-08-2016.
 */
public class FontAwesomeIcion extends TextView {
    public FontAwesomeIcion(Context context) {
        super(context);
        init(context);
    }

    public FontAwesomeIcion(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FontAwesomeIcion(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/fontawesome-webfont.ttf");
       /* Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/carmel.ttf");*/
        setTypeface(tf);
    }
}
