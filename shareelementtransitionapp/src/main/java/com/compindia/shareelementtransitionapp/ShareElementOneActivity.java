package com.compindia.shareelementtransitionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShareElementOneActivity extends AppCompatActivity {

    private ImageView ivShareElementOne;
    private Button btClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_one);
        setUpViews();
    }

    private void setUpViews() {
        ivShareElementOne = (ImageView) findViewById(R.id.ivProfile);
        btClick = (Button) findViewById(R.id.bt_shareelement);
        View view = findViewById(R.id.cv_one);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShareElementTwoActivity.class);
/*
                ActivityOptionsCompat activityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this, (View) ivShareElementOne,"profile" );
                                        startActivity(intent,activityOptionsCompat.toBundle());

*/
            }
        });
    }
}
