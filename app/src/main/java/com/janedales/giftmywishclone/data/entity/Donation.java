package com.janedales.giftmywishclone.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Donation {
    @SerializedName("id")
    @ColumnInfo(name = "donation_id")
    @PrimaryKey
    private int id = 0;
    @SerializedName("event_id")
    private int eventId = 0;
    @SerializedName("event_title")
    private String eventTitle = "";
    @SerializedName("recipient_id")
    private int recipientId = 0;
    @SerializedName("amount")
    private double amount = 0.0;
    @SerializedName("percentage_of")
    private double percentageOf = 0.0;
    @SerializedName("message")
    private String message = "";
    @SerializedName("user")
    @Embedded(prefix = "donation_")
    private User user = new User();
    @SerializedName("gift")
    @Embedded(prefix = "donation_")
    private Gift gift = new Gift();

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

    public double getAmount() {
        return amount;
    }

    public double getPercentageOf() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPercentageOf(double percentageOf) {
        this.percentageOf = percentageOf;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    @Ignore
    public Donation(int id, int eventId, String eventTitle, int recipientId, double amount, double percentageOf, String message, User user, Gift gift) {
        this.id = id;
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.recipientId = recipientId;
        this.amount = amount;
        this.percentageOf = percentageOf;
        this.message = message;
        this.user = user;
        this.gift = gift;
    }

    public Donation(){}
}
