package com.janedales.giftmywishclone.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Gift implements Serializable {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name = "gift_id")
    private int id = 0;
    @SerializedName("name")
    private String name = "";
    @SerializedName("link")
    private String link = "";
    @SerializedName("price")
    private int price = 0;
    @SerializedName("total_fund")
    private int totalFond = 0;
    @SerializedName("is_funded")
    private boolean isFunded = false;
    @SerializedName("status")
    private String status = "";
    @SerializedName("size")
    private String size = "";
    @SerializedName("color")
    private String color = "";
    @SerializedName("extra_description")
    private String extraDescription = "";
    @SerializedName("photo")
    @Embedded(prefix = "gift_")
    private Avatar photo = new Avatar();
    @SerializedName("total_fund_percentage")
    private int totalFundPercentage = 0;
    @SerializedName("donations")
    private ArrayList<Donation> donations = new ArrayList<>();

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

    public ArrayList<Donation> getDonations() {
        return donations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotalFond(int totalFond) {
        this.totalFond = totalFond;
    }

    public void setFunded(boolean funded) {
        isFunded = funded;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public void setPhoto(Avatar photo) {
        this.photo = photo;
    }

    public void setTotalFundPercentage(int totalFundPercentage) {
        this.totalFundPercentage = totalFundPercentage;
    }

    public void setDonations(ArrayList<Donation> donations) {
        this.donations = donations;
    }

    @Ignore
    public Gift(int id, String name, String link, int price, int totalFond, boolean isFunded, String status, String size, String color, String extraDescription, Avatar photo, int totalFundPercentage, ArrayList<Donation> donations) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.price = price;
        this.totalFond = totalFond;
        this.isFunded = isFunded;
        this.status = status;
        this.size = size;
        this.color = color;
        this.extraDescription = extraDescription;
        this.photo = photo;
        this.totalFundPercentage = totalFundPercentage;
        this.donations = donations;
    }

    public Gift(){}
}
