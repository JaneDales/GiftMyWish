package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Children {
    @SerializedName("comments") private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }
}

