package com.janedales.giftmywishclone.ui.settings;

public class SettingsPresenter implements SettingsModelCallback{

    private SettingsContract contract;
    private SettingsModel model = new SettingsModel(this);

    public SettingsPresenter (SettingsContract contract){
        this.contract = contract;
    }

    public void logOut (){
        model.logOut();
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }

    @Override
    public void onSuccess() {
        contract.onLogOut();
    }
}
