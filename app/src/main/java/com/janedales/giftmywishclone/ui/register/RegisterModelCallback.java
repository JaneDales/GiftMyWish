package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.entity.User;

public interface RegisterModelCallback {

    void onFail(Throwable t);

    void onSuccessRegister(User user);
    void onSuccessCode(User user);
}
