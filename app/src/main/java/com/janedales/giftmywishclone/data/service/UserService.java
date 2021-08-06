package com.janedales.giftmywishclone.data.service;

import com.janedales.giftmywishclone.data.network.request.ConfirmCodeRequest;
import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;
import com.janedales.giftmywishclone.data.network.response.EventsListResponse;
import com.janedales.giftmywishclone.data.network.response.MyEventsListResponse;
import com.janedales.giftmywishclone.data.network.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("api/v1/users/username_registration")
    Call<UserResponse> register(@Body RegisterUserRequest registerUserRequest);

    @POST("api/v1/users/username_login")
    Call<UserResponse> login(@Body LoginUserRequest loginUserRequest);

    @POST("api/v1/users/username_confirm_code")
    Call<UserResponse> confirmCode(@Body ConfirmCodeRequest confirmCodeRequest);

    @GET("api/v1/friend_events")
    Call<EventsListResponse> getFriendsEvents(
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    @GET("api/v1/events")
    Call<MyEventsListResponse> getMyEvents(
            @Query("page") int page,
            @Query("per_page") int perPage
    );
}
