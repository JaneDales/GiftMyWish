package com.janedales.giftmywishclone.data.network.request;

import com.google.gson.annotations.SerializedName;

public class LoginUserRequest {
    @SerializedName("username")
    String userName;

    @SerializedName("password")
    String password;

    public LoginUserRequest (String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
