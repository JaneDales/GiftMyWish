package com.janedales.giftmywishclone.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.janedales.giftmywishclone.MainActivity;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.ui.base.BaseActivity;
import com.janedales.giftmywishclone.ui.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements LoginContract {

    private LoginPresenter presenter;
    private TextView tvRegister;
    private Button btnLogin;
    private ProgressBar progressBar;
    private EditText etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, SharedPreferencesHelper.getInstance(this));

        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    public void onLoginSuccess(User user) {
        SharedPreferencesHelper.saveUser(this, user);
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

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}