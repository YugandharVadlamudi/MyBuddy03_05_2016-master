package com.compindia.clientapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.compindia.clientapp.utils.Utils;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btSignupsigninSignUP;
    private Button btSignupsigninSignIn;
    private ImageView ivLoginLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpViews();
    }

    private void setUpViews() {
        btSignupsigninSignUP = (Button) findViewById(R.id.bt_signupsignin_singup);
        btSignupsigninSignIn = (Button) findViewById(R.id.bt_singupsignin_signin);
        ivLoginLogo = (ImageView) findViewById(R.id.iv_login_logo);
        ivLoginLogo.setImageBitmap(Utils.drawableToBitMap(getResources().getDrawable(R.drawable.ic_art)));
        Picasso.with(this).load(R.drawable.ic_art).into((ImageView)findViewById(R.id.iv_login_logo));
        setListeners();

    }

    private void setListeners() {
        btSignupsigninSignUP.setOnClickListener(this);
        btSignupsigninSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_signupsignin_singup:
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
                finish();
                break;
            case R.id.bt_singupsignin_signin:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
                break;
        }
    }
}
