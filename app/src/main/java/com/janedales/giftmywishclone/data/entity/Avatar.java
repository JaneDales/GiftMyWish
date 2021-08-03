package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

public class Avatar {
    @SerializedName("url")
    private String url;
    @SerializedName("thumb")
    private Thumb thumb;
}
