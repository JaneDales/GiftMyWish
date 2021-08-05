package com.janedales.giftmywishclone.ui.friends_events;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public interface FriendsEventsContract {
    void ovEventsLoaded(List<Event> list);
    void onFail(Throwable t);
}
