package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Gift implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("link")
    private String link;
    @SerializedName("price")
    private int price;
    @SerializedName("total_fund")
    private int totalFond;
    @SerializedName("is_funded")
    private boolean isFunded;
    @SerializedName("status")
    private String status;
    @SerializedName("size")
    private String size;
    @SerializedName("color")
    private String color;
    @SerializedName("extra_description")
    private String extraDescription;
    @SerializedName("photo")
    private Avatar photo;
    @SerializedName("total_fund_percentage")
    private int totalFundPercentage;
    @SerializedName("donations")
    private List<Donation> donations;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalFond() {
        return totalFond;
    }

    public boolean isFunded() {
        return isFunded;
    }

    public String getStatus() {
        return status;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public Avatar getPhoto() {
        return photo;
    }

    public int getTotalFundPercentage() {
        return totalFundPercentage;
    }

    public List<Donation> getDonations() {
        return donations;
    }
}
