package com.janedales.giftmywishclone.ui.user_profile;

import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public class UserProfilePresenter implements UserProfileModelCallback{
    UserProfileContract contract;
    UserProfileModel model = new UserProfileModel(this);

    public UserProfilePresenter(UserProfileContract contract){ this.contract = contract; }

    public void getEventsList(int id){
        model.getEvents(id);
    }

    @Override
    public void onSuccess(List<Event> event) {
        contract.onMyEvents(event);
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }
}
