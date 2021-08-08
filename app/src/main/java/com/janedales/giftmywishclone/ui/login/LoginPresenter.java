package com.janedales.giftmywishclone.ui.login;

import android.content.SharedPreferences;

import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;

public class LoginPresenter implements LoginModelCallback {

    private LoginContract contract;
    private LoginModel model = new LoginModel(this);
    private SharedPreferences preferencesHelper;

    public LoginPresenter(LoginContract contract, SharedPreferences preferencesHelper){
        this.contract = contract;
        this.preferencesHelper = preferencesHelper;
    }

    public void login (String userName, String password){
        contract.showProgress();
        model.login(new LoginUserRequest(userName, password));
    }

    @Override
    public void onSuccess(User user) {
        String token = user.getAuthenticationToken();
        preferencesHelper.edit().putString("token", token).apply();
        contract.hideProgress();
        contract.onLoginSuccess(user);
    }

    @Override
    public void onFail(Throwable t) {
        contract.hideProgress();
        contract.onFail(t);
    }

    @Override
    public void onFail(String s) {
        contract.hideProgress();
        contract.onFail(s);
    }
}
