package com.janedales.giftmywishclone.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Comment {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private int id = 0;
    @SerializedName("text")
    private String text = "";
    @SerializedName("user_picture")
    @Embedded(prefix = "comment_")
    private Avatar userPicture = new Avatar();
    @SerializedName("username")
    private String username = "";
    @SerializedName("time_ago")
    private String timeAgo = "";
    @SerializedName("created_at")
    private String createdAt = "";
    @SerializedName("event_id")
    private int eventId = 0;
    @SerializedName("parent_id")
    private int parentId = 0;
    @SerializedName("user_id")
    private int userId = 0;
    @SerializedName("children")
    @Embedded(prefix = "comment_")
    private Children children = new Children();

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

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserPicture(Avatar userPicture) {
        this.userPicture = userPicture;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

//    @Ignore
    public Comment(int id, String text, Avatar userPicture, String username, String timeAgo, String createdAt, int eventId, int parentId, int userId, Children children) {
        this.id = id;
        this.text = text;
        this.userPicture = userPicture;
        this.username = username;
        this.timeAgo = timeAgo;
        this.createdAt = createdAt;
        this.eventId = eventId;
        this.parentId = parentId;
        this.userId = userId;
        this.children = children;
    }

    public Comment(){}
}
