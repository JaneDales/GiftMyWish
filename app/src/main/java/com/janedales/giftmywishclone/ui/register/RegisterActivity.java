package com.janedales.giftmywishclone.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.User;

public class RegisterActivity extends AppCompatActivity implements RegisterContract {

    private Button btnRegister;
    private EditText etFirstName, etLastName, etDateOfBirth, etEmail, etUserName, etPassword;
    private RegisterPresenter presenter = new RegisterPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etDateOfBirth = findViewById(R.id.etDateOfBirth);
        etEmail = findViewById(R.id.etEmail);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAll();
            }
        });
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

    @Override
    public void onUserRegistered(User user) {
        System.out.println("user = " + user.display());
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        System.out.println("error = " + t.getLocalizedMessage());
    }
}