package com.janedales.giftmywishclone.ui.login;

import com.janedales.giftmywishclone.data.entity.User;

public interface LoginModelCallback {
    void onSuccess(User user);
    void onFail(Throwable t);
    void onFail(String s);
}
