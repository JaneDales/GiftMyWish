package com.janedales.giftmywishclone.data.entity;

import com.google.gson.annotations.SerializedName;

public class ShippingAddress {
    @SerializedName("id")
    private int id;
    @SerializedName("street")
    private String street;
    @SerializedName("apartment")
    private String apartment;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("postal_code")
    private String postalCode;
}
