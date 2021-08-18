package com.janedales.giftmywishclone.ui.entry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.janedales.giftmywishclone.MainActivity;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.helpers.Constants;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.ui.base.BaseActivity;
import com.janedales.giftmywishclone.ui.login.LoginActivity;

public class EntryActivity extends BaseActivity implements EntryContract{

    private static int RC_SIGN_IN = 100;

    private EntryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        TextView tvLogin = findViewById(R.id.tvLogin);
        TextView btnGmail = findViewById(R.id.btnGmail);
        TextView btnFacebook = findViewById(R.id.btnFacebook);

        presenter = new EntryPresenter(this);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntryActivity.this, LoginActivity.class));
            }
        });

        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(Constants.GOOGLE_TOKEN_ID)
                        .requestEmail()
                        .build();
                GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(EntryActivity.this, gso);

                mGoogleSignInClient.signOut();

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            presenter.login(account.getIdToken());
        } catch (ApiException e) {
            System.out.println("Error = " + e.getLocalizedMessage());
        }
    }


    @Override
    public void onUserLogged(User user) {
        SharedPreferencesHelper.saveUser(this, user);
        RetrofitInstance.setmToken(user.getAuthenticationToken());

        Intent intent = new Intent(EntryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}