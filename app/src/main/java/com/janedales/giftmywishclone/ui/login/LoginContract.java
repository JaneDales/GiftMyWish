package com.janedales.giftmywishclone.ui.login;

import com.janedales.giftmywishclone.data.entity.User;

public interface LoginContract {
    void onLoginSuccess(User user);

    void onFail(Throwable t);

    void onFail(String s);

    void showProgress();
    void hideProgress();
}
