package com.janedales.giftmywishclone.data.service;

import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.network.request.ConfirmCodeRequest;
import com.janedales.giftmywishclone.data.network.request.LoginUserSocialRequest;
import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;
import com.janedales.giftmywishclone.data.network.response.EventsListResponse;
import com.janedales.giftmywishclone.data.network.response.MyEventsListResponse;
import com.janedales.giftmywishclone.data.network.response.UserResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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

    @DELETE("api/v1/providers/logout")
    Call<ResponseBody> logOut();

    @GET("api/v1/profiles/{id}")
    Call<UserResponse> getUserProfile(
            @Path("id") int id
    );

    @POST("api/v1/providers/login")
    Call<UserResponse> login(@Body LoginUserSocialRequest loginUserSocialRequest);

    @GET("api/v1/friend_events/{id}")
    Call<EventsListResponse> getFriendEvent(
            @Path("id") int id
    );
}
