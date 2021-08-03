package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.entity.User;

public interface RegisterModelCallback {

    void onFail(Throwable t);

    void onSuccess(User user);
}
