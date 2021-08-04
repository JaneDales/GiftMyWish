package com.janedales.giftmywishclone.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.janedales.giftmywishclone.MainActivity;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract {

    private LoginPresenter presenter = new LoginPresenter(this);
    private TextView tvRegister;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etUserName = findViewById(R.id.etUserName);
                EditText etPassword = findViewById(R.id.etPassword);
                String userName = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (userName.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Enter username and password", Toast.LENGTH_SHORT).show();
                }
                else {
                    presenter.login(userName, password);
                }
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}