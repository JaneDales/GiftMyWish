package com.janedales.giftmywishclone.ui.my_events;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.response.MyEventsListResponse;
import com.janedales.giftmywishclone.data.network.response.UserResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyEventsModel {
    private MyEventsModelCallback callback;

    public MyEventsModel(MyEventsModelCallback callback){
        this.callback = callback;
    }
    public void getMyEvents(){
        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<MyEventsListResponse> call = service.getMyEvents(1, 10);

        call.enqueue(new Callback<MyEventsListResponse>() {
            @Override
            public void onResponse(Call<MyEventsListResponse> call, Response<MyEventsListResponse> response) {
                callback.onSuccess(response.body().getMyEvents());
            }

            @Override
            public void onFailure(Call<MyEventsListResponse> call, Throwable t) {callback.onFail(t); }
        });
    }
    public void getUserProfile(int id){
        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<UserResponse> call = service.getUserProfile(id);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                callback.onUser(response.body().getUser());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
