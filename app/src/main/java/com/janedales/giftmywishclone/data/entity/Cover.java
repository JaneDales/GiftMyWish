package com.janedales.giftmywishclone.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Cover implements Serializable {
    @PrimaryKey
    @SerializedName("url")
    @NonNull
    private String url;
    @SerializedName("thumb")
    @Embedded(prefix = "cover_")
    private Thumb thumb;

    public String getUrl() {
        return url;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
