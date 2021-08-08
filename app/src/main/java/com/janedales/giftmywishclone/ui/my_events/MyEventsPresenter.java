package com.janedales.giftmywishclone.ui.my_events;

import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.User;

import java.util.List;

public class MyEventsPresenter implements MyEventsModelCallback {

    MyEventsContract contract;
    MyEventsModel model = new MyEventsModel(this);

    public MyEventsPresenter(MyEventsContract contract){
        this.contract = contract;
    }

    public void getMyEventsList (){
        model.getMyEvents();
    }

    public void getUser(int id){
        model.getUserProfile(id);
    }

    @Override
    public void onSuccess(List<Event> list) {
        contract.ovMyEvents(list);
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }

    @Override
    public void onUser(User user) {
        contract.onUser(user);
    }
}
