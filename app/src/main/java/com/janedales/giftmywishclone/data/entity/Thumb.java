package com.janedales.giftmywishclone.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Thumb implements Serializable {
    @PrimaryKey
    @SerializedName("url")
    @NonNull
    private String url = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Ignore
    public Thumb(@NonNull String url) {
        this.url = url;
    }

    public Thumb(){}
}
