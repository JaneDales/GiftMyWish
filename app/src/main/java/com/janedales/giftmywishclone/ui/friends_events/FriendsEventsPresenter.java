package com.janedales.giftmywishclone.ui.friends_events;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;


public class FriendsEventsPresenter implements FriendsEventsModelCallback {

    private FriendsEventsContract contract;
    private FriendsEventsModel model = new FriendsEventsModel(this);

    public FriendsEventsPresenter(FriendsEventsContract contract){
        this.contract = contract;
    }

    public void getEventsList (){
        model.getEvents();
    }

    @Override
    public void onSuccess(List<Event> list) {
        contract.ovEventsLoaded(list);
    }


    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }
}
