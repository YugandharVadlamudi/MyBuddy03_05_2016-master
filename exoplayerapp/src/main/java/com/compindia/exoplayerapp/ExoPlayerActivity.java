package com.compindia.exoplayerapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;
import com.google.android.exoplayer.ExoPlayer;

public class ExoPlayerActivity extends AppCompatActivity implements OnPreparedListener {

    private ExoPlayer exoPlayer;
    private EMVideoView emVideoView;
    private String url = "http://www.sample-videos.com/video/mp4/480/big_buck_bunny_480p_5mb.mp4";
    String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:40.0) Gecko/20100101 Firefox/40.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);
        setUpExoMediaPlayer();
    }

    private void setUpExoMediaPlayer() {
        emVideoView = (EMVideoView) findViewById(R.id.emv_exoplayer);
        emVideoView.setOnPreparedListener(this);
        emVideoView.setVideoURI(Uri.parse("https://archive.org/download/Popeye_forPresident/Popeye_forPresident_512kb.mp4"));

    }

    @Override
    public void onPrepared() {
        emVideoView.start();
    }
}
