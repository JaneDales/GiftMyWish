package com.janedales.giftmywishclone.ui.friends_events;

import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.User;

public interface ClickListenerFriendsEvents {
   void onEventClick(Event event);
   void onUserClick(User user);
}
