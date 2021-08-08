package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
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
    private Cover cover;
    @SerializedName("shipping_address")
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
