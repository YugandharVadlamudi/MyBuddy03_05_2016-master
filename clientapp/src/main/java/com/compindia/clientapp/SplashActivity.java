package com.compindia.clientapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.compindia.clientapp.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    private ImageView imgViewSet;
    private String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setUpViews();
//        setBitMap();
        threadStart();
    }

    private void setUpViews() {
        imgViewSet = (ImageView) findViewById(R.id.iv_splashscreen);
        Log.d(TAG, "setUpViews: ivHeight->" + imgViewSet.getHeight());

//        BitmapFactory.Options options = new BitmapFactory.Options();
//        imgViewSet.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.id.iv_splashscreen, options));
        imgViewSet.setImageBitmap(Utils.drawableToBitMap(getResources().getDrawable(R.drawable.ic_logo)));
    }

    private Bitmap drawableToBitMap(Drawable drawable) {
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
            if (drawable.getIntrinsicHeight() <= 0 || drawable.getIntrinsicWidth() <= 0) {
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth()
                        , drawable.getIntrinsicHeight()
                        , Bitmap.Config.ARGB_8888);
            }

        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }


    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int sampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / sampleSize) > reqHeight && (halfWidth / sampleSize) > reqWidth) {
                sampleSize *= 2;
            }
        }
        return sampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private void threadStart() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5 * 1000);
                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }

            }
        };
        thread.start();
    }
}
