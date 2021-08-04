package com.janedales.giftmywishclone.data.service;

import com.janedales.giftmywishclone.data.network.request.ConfirmCodeRequest;
import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;
import com.janedales.giftmywishclone.data.network.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/v1/users/username_registration")
    Call<UserResponse> register(@Body RegisterUserRequest registerUserRequest);

    @POST("api/v1/users/username_login")
    Call<UserResponse> login(@Body LoginUserRequest loginUserRequest);

    @POST("api/v1/users/username_confirm_code")
    Call<UserResponse> confirmCode(@Body ConfirmCodeRequest confirmCodeRequest);
}
