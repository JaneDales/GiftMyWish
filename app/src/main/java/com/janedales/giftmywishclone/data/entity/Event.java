package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Event implements Serializable {

    @SerializedName("id") private int id;
    @SerializedName("public_id") private String publicId;
    @SerializedName("user_id") private String userId;
    @SerializedName("title") private String title;
    @SerializedName("start_date") private String startDate;
    @SerializedName("end_date") private String endDate;
    @SerializedName("description") private String description;
    @SerializedName("is_expired") private boolean isExpired;
    @SerializedName("total_likes_count") private int totalLikesCount;
    @SerializedName("total_comments_count") private int totalCommentCount;
    @SerializedName("user") private User user;
    @SerializedName("last_comments") private List<Comment> lastComments;
    @SerializedName("like_status") private boolean likeStatus;
    @SerializedName("photo") private Avatar photo;
    @SerializedName("gifts") private List<Gift> gifts;
    @SerializedName("hide_ids") private List<HideIds> hideIds;

    public int getId() {
        return id;
    }

    public String getPublicId() {
        return publicId;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public int getTotalLikesCount() {
        return totalLikesCount;
    }

    public int getTotalCommentCount() {
        return totalCommentCount;
    }

    public User getUser() {
        return user;
    }

    public List<Comment> getLastComments() {
        return lastComments;
    }

    public boolean isLikeStatus() {
        return likeStatus;
    }

    public Avatar getPhoto() {
        return photo;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public List<HideIds> getHideIds() {
        return hideIds;
    }
}
