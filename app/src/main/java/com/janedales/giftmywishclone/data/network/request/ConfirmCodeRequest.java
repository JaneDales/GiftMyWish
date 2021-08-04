package com.janedales.giftmywishclone.data.network.request;

import com.google.gson.annotations.SerializedName;

public class ConfirmCodeRequest {

    @SerializedName("username")
    String username;
    @SerializedName("confirmation_code")
    String confirmationCode;

    public ConfirmCodeRequest(String username, String confirmationCode) {
        this.username = username;
        this.confirmationCode = confirmationCode;
    }
}
