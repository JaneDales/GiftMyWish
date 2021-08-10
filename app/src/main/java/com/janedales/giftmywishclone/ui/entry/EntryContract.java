package com.janedales.giftmywishclone.ui.entry;

import com.janedales.giftmywishclone.data.entity.User;

public interface EntryContract {
    void onUserLogged(User user);

    void onFail(Throwable t);
}
