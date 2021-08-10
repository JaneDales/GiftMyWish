package com.janedales.giftmywishclone.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.janedales.giftmywishclone.MainActivity;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.ui.entry.EntryActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
            View.SYSTEM_UI_FLAG_FULLSCREEN|
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        loading();
    }

    private void loading() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences preferences = SharedPreferencesHelper.getInstance(SplashActivity.this);
                String token = preferences.getString("token", "");

                if (token.isEmpty()) {
                    Intent intent = new Intent(SplashActivity.this, EntryActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }
        }, 500);
    }
}