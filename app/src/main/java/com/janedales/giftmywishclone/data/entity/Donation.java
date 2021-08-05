package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

public class Donation {
    @SerializedName("id")
    private int id;
    @SerializedName("event_id")
    private int eventId;
    @SerializedName("event_title")
    private String eventTitle;
    @SerializedName("recipient_id")
    private int recipientId;
    @SerializedName("amount")
    private int amount;
    @SerializedName("percentage_of")
    private int percentageOf;
    @SerializedName("message")
    private String message;
    @SerializedName("user")
    private User user;
    @SerializedName("gift")
    private Gift gift;

    public int getId() {
        return id;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public int getAmount() {
        return amount;
    }

    public int getPercentageOf() {
        return percentageOf;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Gift getGift() {
        return gift;
    }
}