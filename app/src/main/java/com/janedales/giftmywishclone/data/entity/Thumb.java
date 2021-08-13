package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thumb implements Serializable {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }
}
