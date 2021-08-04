package com.janedales.giftmywishclone.ui.login;

import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;

public class LoginPresenter implements LoginModelCallback {

    private LoginContract contract;
    private LoginModel model = new LoginModel(this);

    public LoginPresenter(LoginContract contract){
        this.contract = contract;
    }

    public void login (String userName, String password){
        model.login(new LoginUserRequest(userName, password));
    }

    @Override
    public void onSuccess(User user) {
        contract.onLoginSuccess();
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }

    @Override
    public void onFail(String s) {
        contract.onFail(s);
    }
}
