package com.janedales.giftmywishclone.ui.register;

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
import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.ui.views.CollapsedHintTextInputLayout;

public class RegisterActivity extends AppCompatActivity implements RegisterContract {

    private Button btnRegister;
    private EditText etFirstName, etLastName, etDateOfBirth, etEmail, etUserName, etPassword, etEnterCode;
    private CollapsedHintTextInputLayout tilFirstName, tilLastName, tilDateOfBirth,
            tilEmail, tilUserName, tilPassword, tilEnterCode;
    private TextView tvEnterCode;
    private RegisterPresenter presenter = new RegisterPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUI();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tilEnterCode.getVisibility() == View.VISIBLE) {
                    validateCode();
                }
                else {
                    validateAll();
                }
            }
        });
    }

    private void initUI(){
        btnRegister = findViewById(R.id.btnRegister);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etDateOfBirth = findViewById(R.id.etDateOfBirth);
        etEmail = findViewById(R.id.etEmail);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etEnterCode = findViewById(R.id.etEnterCode);
        tvEnterCode = findViewById(R.id.tvEnterCode);

        tilFirstName = findViewById(R.id.tilFirstName);
        tilLastName = findViewById(R.id.tilLastName);
        tilDateOfBirth = findViewById(R.id.tilDateOfBirth);
        tilFirstName = findViewById(R.id.tilFirstName);
        tilEmail = findViewById(R.id.tilEmail);
        tilUserName = findViewById(R.id.tilUserName);
        tilPassword = findViewById(R.id.tilPassword);
        tilEnterCode = findViewById(R.id.tilEnterCode);
    }

    private void validateCode(){
        String code = etEnterCode.getText().toString().trim();
        String userName = etUserName.getText().toString().trim();
        if (code.length() < 4 ) {
            Toast.makeText(this, "Please enter 4 digit code", Toast.LENGTH_SHORT).show();
            return;
        }

        presenter.confirmCode(userName, code);
    }

    private void validateAll(){
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String dateOfBirth = etDateOfBirth.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String userName = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (firstName.isEmpty()) {
            Toast.makeText(this, "Please enter First Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (lastName.isEmpty()){
            Toast.makeText(this, "Please enter Last Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (dateOfBirth.isEmpty()){
            Toast.makeText(this, "Please enter Date of birth", Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.isEmpty()){
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userName.isEmpty()){
            Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.isEmpty()){
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        presenter.register(firstName, lastName, dateOfBirth, email, userName, password);
    }

    private void hideFieldsForRegister() {
        tilFirstName.setVisibility(View.GONE);
        tilDateOfBirth.setVisibility(View.GONE);
        tilEmail.setVisibility(View.GONE);
        tilLastName.setVisibility(View.GONE);
        tilPassword.setVisibility(View.GONE);
        tilUserName.setVisibility(View.GONE);
    }

    private void showFieldsForCode() {
        tvEnterCode.setVisibility(View.VISIBLE);
        tilEnterCode.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUserRegistered(User user) {
        System.out.println("user = " + user.display());
        hideFieldsForRegister();
        showFieldsForCode();
        btnRegister.setText("Next");
    }

    @Override
    public void onSuccessCode(User user) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        System.out.println("error = " + t.getLocalizedMessage());
    }
}