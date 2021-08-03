package com.janedales.giftmywishclone.data.network.request;

import com.google.gson.annotations.SerializedName;

public class RegisterUser {
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("username")
    private String userName;
    @SerializedName("birth_date")
    private String birthDate;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public RegisterUser(String firstName, String lastName, String userName, String birthDate, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }
}
