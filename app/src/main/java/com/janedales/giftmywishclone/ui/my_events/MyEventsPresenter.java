package com.janedales.giftmywishclone.ui.my_events;

import com.janedales.giftmywishclone.data.entity.Event;

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

    @Override
    public void onSuccess(List<Event> list) {
        contract.ovMyEvents(list);
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }
}
