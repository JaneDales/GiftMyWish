package com.janedales.giftmywishclone.ui.entry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.ui.login.LoginActivity;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        TextView tvLogin = findViewById(R.id.tvLogin);
        TextView btnGmail = findViewById(R.id.btnGmail);
        TextView btnFacebook = findViewById(R.id.btnFacebook);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntryActivity.this, LoginActivity.class));
            }
        });

    }

}