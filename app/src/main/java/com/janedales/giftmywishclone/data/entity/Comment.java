package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("id")
    private int id;
    @SerializedName("text")
    private String text;
    @SerializedName("user_picture")
    private Avatar userPicture;
    @SerializedName("username")
    private String username;
    @SerializedName("time_ago")
    private String timeAgo;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("event_id")
    private int eventId;
    @SerializedName("parent_id")
    private int parentId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("children")
    private Children children;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Avatar getUserPicture() {
        return userPicture;
    }

    public String getUsername() {
        return username;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getEventId() {
        return eventId;
    }

    public int getParentId() {
        return parentId;
    }

    public int getUserId() {
        return userId;
    }

    public Children getChildren() {
        return children;
    }
}
