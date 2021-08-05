package com.janedales.giftmywishclone.ui.friends_events;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public interface FriendsEventsModelCallback {
    void onSuccess(List<Event> list);
    void onFail(Throwable t);
}
