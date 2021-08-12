package com.janedales.giftmywishclone.ui.user_profile;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public interface UserProfileModelCallback {
    void onSuccess(List<Event> event);
    void onFail(Throwable t);
}
