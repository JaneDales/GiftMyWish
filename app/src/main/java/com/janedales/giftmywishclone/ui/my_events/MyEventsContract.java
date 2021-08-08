package com.janedales.giftmywishclone.ui.my_events;

import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.User;

import java.util.List;

public interface MyEventsContract {
    void ovMyEvents(List<Event> list);
    void onFail(Throwable t);

    void onUser(User user);
}
