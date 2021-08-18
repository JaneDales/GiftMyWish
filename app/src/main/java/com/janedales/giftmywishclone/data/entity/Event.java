package com.janedales.giftmywishclone.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Event implements Serializable {

    @SerializedName("id")
    @PrimaryKey
    private int id = 0;
    @SerializedName("public_id")
    private String publicId = "";
    @SerializedName("user_id")
    private String userId = "";
    @SerializedName("title") private String title = "";
    @SerializedName("start_date")
    private String startDate = "";
    @SerializedName("end_date")
    private String endDate = "";
    @SerializedName("description") private String description = "";
    @SerializedName("is_expired")
    private boolean isExpired = false;
    @SerializedName("total_likes_count")
    private int totalLikesCount = 0;
    @SerializedName("total_comments_count")
    private int totalCommentCount = 0;
    @SerializedName("user")
    @Embedded(prefix = "event_")
    private User user = new User();
    @SerializedName("last_comments")
    private ArrayList<Comment> lastComments = new ArrayList<>();
    @SerializedName("like_status")
    private boolean likeStatus = false;
    @SerializedName("photo")
    @Embedded(prefix = "event_")
    private Avatar photo = new Avatar();
    @SerializedName("gifts")
    private ArrayList<Gift> gifts = new ArrayList<>();
    @SerializedName("hide_ids")
    @ColumnInfo(name = "hide_ids")
    private ArrayList<Integer> hideIds = new ArrayList<>();

    private boolean isMyEvent = false;

    public boolean isMyEvent() {
        return isMyEvent;
    }

    public void setMyEvent(boolean myEvent) {
        isMyEvent = myEvent;
    }

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

    public ArrayList<Comment> getLastComments() {
        return lastComments;
    }

    public boolean isLikeStatus() {
        return likeStatus;
    }

    public Avatar getPhoto() {
        return photo;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public ArrayList<Integer> getHideIds() {
        return hideIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public void setTotalLikesCount(int totalLikesCount) {
        this.totalLikesCount = totalLikesCount;
    }

    public void setTotalCommentCount(int totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLastComments(ArrayList<Comment> lastComments) {
        this.lastComments = lastComments;
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public void setPhoto(Avatar photo) {
        this.photo = photo;
    }

    public void setGifts(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    public void setHideIds(ArrayList<Integer> hideIds) {
        this.hideIds = hideIds;
    }

    @Ignore
    public Event(int id, String publicId, String userId, String title, String startDate, String endDate, String description, boolean isExpired, int totalLikesCount, int totalCommentCount, User user, ArrayList<Comment> lastComments, boolean likeStatus, Avatar photo, ArrayList<Gift> gifts, ArrayList<Integer> hideIds, boolean isMyEvent) {
        this.id = id;
        this.publicId = publicId;
        this.userId = userId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.isExpired = isExpired;
        this.totalLikesCount = totalLikesCount;
        this.totalCommentCount = totalCommentCount;
        this.user = user;
        this.lastComments = lastComments;
        this.likeStatus = likeStatus;
        this.photo = photo;
        this.gifts = gifts;
        this.hideIds = hideIds;
        this.isMyEvent = isMyEvent;
    }

    public Event(){}
}
