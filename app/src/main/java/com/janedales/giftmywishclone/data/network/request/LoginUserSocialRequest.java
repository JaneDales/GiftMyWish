package com.janedales.giftmywishclone.data.network.request;

import com.google.gson.annotations.SerializedName;

public class LoginUserSocialRequest {
    @SerializedName("token") String token;
    @SerializedName("variant") String variant;
    @SerializedName("udid") String udid;
    @SerializedName("platform_name") String platformName;

    public LoginUserSocialRequest(String token, String variant, String udid, String platformName){
        this.token = token;
        this.variant = variant;
        this.udid = udid;
        this.platformName = platformName;
    }

    public String getToken() {
        return token;
    }

    public String getVariant() {
        return variant;
    }

    public String getUdid() {
        return udid;
    }

    public String getPlatformName() {
        return platformName;
    }
}
