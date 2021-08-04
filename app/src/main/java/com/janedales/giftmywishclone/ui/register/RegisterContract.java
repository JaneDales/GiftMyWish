package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.entity.User;

public interface RegisterContract {
    void onUserRegistered(User user);

    void onFail(Throwable t);

    void onSuccessCode(User user);
}
