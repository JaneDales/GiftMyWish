package com.janedales.giftmywishclone.ui.settings;

public interface SettingsModelCallback {
    void onFail(Throwable t);

    void onSuccess();
}
