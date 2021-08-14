package com.janedales.giftmywishclone.data.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @SerializedName("id")
    @PrimaryKey
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("username")
    private String userName;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("platform_name")
    private String platformName;
    @SerializedName("avatar")
    @Embedded(prefix = "avatar_")
    private Avatar avatar;
    @SerializedName("last_seen")
    private String lastSeen;
    @SerializedName("birth_date")
    private String birthDate;
    @SerializedName("email")
    private String email;
    @SerializedName("friends_count")
    private int friendsCount;
    @SerializedName("events_count")
    private int eventsCount;
    @SerializedName("cover")
    @Embedded(prefix = "user_")
    private Cover cover;
    @SerializedName("shipping_address_")
    @Embedded(prefix = "shipping_address")
    private ShippingAddress shippingAddress;
    @SerializedName("is_friend")
    private boolean isFriend;
    @SerializedName("authentication_token")
    private String authenticationToken;
    @SerializedName("bio")
    private String bio;

    public String getBio() {
        return bio;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPlatformName() {
        return platformName;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public int getEventsCount() {
        return eventsCount;
    }

    public Cover getCover() {
        return cover;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public void setEventsCount(int eventsCount) {
        this.eventsCount = eventsCount;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(",");
        sb.append(firstName);
        sb.append(",");
        sb.append(lastName);
        sb.append(",");
        sb.append(userName);
        sb.append(",");
        sb.append(email);
        sb.append(",");
        sb.append(birthDate);
        return sb.toString();
    }
}
