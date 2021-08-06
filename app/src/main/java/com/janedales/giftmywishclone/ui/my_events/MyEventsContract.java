package com.janedales.giftmywishclone.ui.my_events;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public interface MyEventsContract {
    void ovMyEvents(List<Event> list);
    void onFail(Throwable t);
}
