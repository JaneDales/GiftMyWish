package com.janedales.giftmywishclone.ui.entry;

import com.janedales.giftmywishclone.data.entity.User;

public interface EntryModelCallback {
    void onSuccess(User user);

    void onFail(Throwable t);
}
