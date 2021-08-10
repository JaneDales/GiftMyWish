package com.janedales.giftmywishclone.ui.entry;

import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.network.request.LoginUserSocialRequest;

public class EntryPresenter implements EntryModelCallback {
    private EntryModel model = new EntryModel(this);
    private EntryContract contract;

    public EntryPresenter(EntryContract contract){
        this.contract = contract;
    }

    public void login(String token){
        LoginUserSocialRequest request = new LoginUserSocialRequest(
                token,
                "gmail",
                "0ec01e3f417e261a_АндрейШкатула",
                "android"
        );
        model.login(request);
    }

    @Override
    public void onSuccess(User user) {
        contract.onUserLogged(user);
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }
}
