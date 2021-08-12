package com.janedales.giftmywishclone.ui.user_profile;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public interface UserProfileContract {
    void onMyEvents(List<Event> list);
    void onFail(Throwable t);
}
