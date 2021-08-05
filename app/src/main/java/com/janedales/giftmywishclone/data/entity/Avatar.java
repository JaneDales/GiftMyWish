package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

public class Avatar {
    @SerializedName("url")
    private String url;
    @SerializedName("thumb")
    private Thumb thumb;

    public String getUrl() {
        return url;
    }

    public Thumb getThumb() {
        return thumb;
    }
}
