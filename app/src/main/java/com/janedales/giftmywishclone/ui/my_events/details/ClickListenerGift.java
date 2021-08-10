package com.janedales.giftmywishclone.ui.my_events.details;

import com.janedales.giftmywishclone.data.entity.Gift;
import com.janedales.giftmywishclone.data.entity.User;

public interface ClickListenerGift {
    void onGiftClick(Gift gift);

    void onUserClick(User user);
}
