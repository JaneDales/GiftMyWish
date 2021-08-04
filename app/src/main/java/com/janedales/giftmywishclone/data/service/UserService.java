package com.janedales.giftmywishclone.data.service;

import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;
import com.janedales.giftmywishclone.data.network.response.UserRegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/v1/users/username_registration")
    Call<UserRegisterResponse> register(@Body RegisterUserRequest registerUserRequest);

    @POST("api/v1/users/username_login")
    Call<UserRegisterResponse> login(@Body LoginUserRequest loginUserRequest);
}
