package com.janedales.giftmywishclone.ui.login;

public interface LoginContract {
    void onLoginSuccess();

    void onFail(Throwable t);

    void onFail(String s);
}
