package com.janedales.giftmywishclone.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.janedales.giftmywishclone.data.entity.User;

public class UserRegisterResponse {

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }
}
