package com.janedales.giftmywishclone.data.network.request;

import com.google.gson.annotations.SerializedName;

public class RegisterUserRequest {

    @SerializedName("user")
    RegisterUser user;

    public RegisterUserRequest(RegisterUser registerUser) {
        user = registerUser;
    }

}
