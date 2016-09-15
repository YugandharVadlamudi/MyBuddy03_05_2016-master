package com.example.kiran.mybuddy.activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiran.mybuddy.R;
import com.example.kiran.mybuddy.Utils.Utils;
import com.example.kiran.mybuddy.dbhelper.DataBaseHelper;

public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText etLoginEmailId;
    private EditText etLoginPassword;
    private Button btLoginSubmit;
    private ImageView ivTitleMenu;
    private ImageView ivTitleCreateContact;
    private TextView tvLoginTitle;
    private Toolbar toolbar;
    private FloatingActionButton fabLoingCreateUser;

//    private TextInputEditText tiet;
    private final String TAG = LoginActivity.class.getSimpleName();
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_login);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        initilization();
    }

    private void initilization() {
        etLoginEmailId = (EditText) findViewById(R.id.et_login_emailid);
        etLoginPassword = (EditText) findViewById(R.id.et_login_password);
        tilEmail = (TextInputLayout) findViewById(R.id.til_emailid);
        tilPassword = (TextInputLayout) findViewById(R.id.til_password);
        btLoginSubmit = (Button) findViewById(R.id.bt_login_submit);

        ivTitleMenu = (ImageView) findViewById(R.id.iv_windowtitle_menu);
        ivTitleCreateContact = (ImageView) findViewById(R.id.iv_windowtitle_createcontact);
        tvLoginTitle = (TextView) findViewById(R.id.tv_windowtitle_Title);
        fabLoingCreateUser = (FloatingActionButton) findViewById(R.id.fab_login_createuser);
        toolbar=(Toolbar)findViewById(R.id.tb_appbar);
        toolbar.setTitle("My Buddy");
        toolbar.setTitleTextColor(getResources().getColor(R.color.bg_login));
        toolbar.setTitleTextAppearance(getApplicationContext(),R.style.titletextstyle);
        Log.e(TAG, "initilization: toolbar->"+toolbar);
        /*if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle(getString(R.string.title_login));
        }*/
//        tiet=(TextInputEditText)findViewById(R.id.tit_login);
//        ivTitleMenu.setVisibility(View.GONE);
//        ivTitleCreateContact.setVisibility(View.GONE);
/*
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle("Login");
        }
*/
//        tvLoginTitle.setText(getResources().getString(R.string.login_tv_title));
        btLoginSubmit.setOnClickListener(this);
        fabLoingCreateUser.setOnClickListener(this);
//        Log.e(TAG, "initilization: TextInputEditText is->"+tiet.getText().toString());
//        btLoginSubmit.setVisibility(View.INVISIBLE);

    }

    private void fetchingData() {
        if (Utils.isEditTextEmpty(etLoginEmailId)) {
            tilPassword.setErrorEnabled(false);
            tilEmail.setErrorEnabled(true);
            tilEmail.setError("Enter Eamil id");
        } else if (Utils.isEditTextEmpty(etLoginPassword)) {
            tilEmail.setErrorEnabled(false);
            tilPassword.setErrorEnabled(true);
            tilPassword.setError("Enter Password");
        } else {

            DataBaseHelper dataBaseHelper = Utils.dataBaseHelper(getApplicationContext());
            Cursor cursor = dataBaseHelper.selectLogin(etLoginEmailId.getText().toString(), etLoginPassword.getText().toString());
            if (cursor != null && (cursor.getCount() == 1)) {

                cursor.moveToFirst();
                Log.e(TAG, "onClick: ROWCOUNT->" + cursor.getCount());
                Log.e(TAG, "onClick: USERID->" + cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID)));

//            startActivity(new Intent(getApplicationContext(),CreatecontactActivity.class));
                SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                SharedPreferences.Editor editorUserId=sharedPreferences.edit();
                editorUserId.putString(Utils.USERID,cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID)));
                editorUserId.commit();
                startActivity(new Intent(getApplicationContext(), ContactsActivity.class)
                        .putExtra(Utils.FROMSCREEN,"Login"));
//            .putExtra(Utils.USERID,cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID)))
            } else {
                Log.e(TAG, "onClick: cursor is null");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login_submit:
                fetchingData();
                break;
            case R.id.fab_login_createuser:
                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
                break;

        }
    }
}
