package com.janedales.giftmywishclone.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class ShippingAddress {
    @PrimaryKey
    @SerializedName("id")
    private int id = 0;
    @SerializedName("street")
    private String street = "";
    @SerializedName("apartment")
    private String apartment = "";
    @SerializedName("country")
    private String country = "";
    @SerializedName("city")
    private String city = "";
    @SerializedName("postal_code")
    private String postalCode = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Ignore
    public ShippingAddress(int id, String street, String apartment, String country, String city, String postalCode) {
        this.id = id;
        this.street = street;
        this.apartment = apartment;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }

    public ShippingAddress(){}
}
