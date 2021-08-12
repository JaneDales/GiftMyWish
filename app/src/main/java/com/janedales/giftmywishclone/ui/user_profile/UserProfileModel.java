package com.janedales.giftmywishclone.ui.user_profile;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.response.EventsListResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileModel {
    private UserProfileModelCallback callback;

    public UserProfileModel(UserProfileModelCallback callback){ this.callback = callback; }

    public void getEvents (int id){

        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<EventsListResponse> call = service.getFriendEvent(id);

        call.enqueue(new Callback<EventsListResponse>() {
            @Override
            public void onResponse(Call<EventsListResponse> call, Response<EventsListResponse> response) {
                callback.onSuccess(response.body().getEvents());
            }

            @Override
            public void onFailure(Call<EventsListResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
