package com.janedales.giftmywishclone.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Avatar implements Serializable {
    @SerializedName("url")
    @PrimaryKey
    @NonNull
    private String url = "";
    @SerializedName("thumb")
    @Embedded(prefix = "avatar_")
    private Thumb thumb = new Thumb();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    @Ignore
    public Avatar(@NonNull String url, Thumb thumb) {
        this.url = url;
        this.thumb = thumb;
    }

    public Avatar(){}
}
