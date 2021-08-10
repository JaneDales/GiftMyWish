package com.janedales.giftmywishclone.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.janedales.giftmywishclone.data.helpers.Constants;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.data.network.RetrofitInstance;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = SharedPreferencesHelper.getInstance(this);
        String token = preferences.getString(Constants.TOKEN, "");
        RetrofitInstance.setmToken(token);
    }
}