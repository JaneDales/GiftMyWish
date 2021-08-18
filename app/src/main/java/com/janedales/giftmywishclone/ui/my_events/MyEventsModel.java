package com.janedales.giftmywishclone.ui.my_events;

import com.janedales.giftmywishclone.App;
import com.janedales.giftmywishclone.data.database.AppDatabase;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.response.MyEventsListResponse;
import com.janedales.giftmywishclone.data.network.response.UserResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyEventsModel {
    private MyEventsModelCallback callback;

    public MyEventsModel(MyEventsModelCallback callback){
        this.callback = callback;
    }

    public void getMyEvents(){
        if (App.getInstance().isNetworkAvailable()) {
            getMyEventsFromApi();
        }
        else {
            getMyEventsFromDb();
        }
    }

    private void getMyEventsFromApi(){
        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<MyEventsListResponse> call = service.getMyEvents(1, 10);

        call.enqueue(new Callback<MyEventsListResponse>() {
            @Override
            public void onResponse(Call<MyEventsListResponse> call, Response<MyEventsListResponse> response) {
                List<Event> events = response.body().getMyEvents();
                saveMyEventsToDb(events);
                callback.onSuccess(events);
            }

            @Override
            public void onFailure(Call<MyEventsListResponse> call, Throwable t) {callback.onFail(t); }
        });
    }

    private void getMyEventsFromDb(){
        AppDatabase db = App.getInstance().getDatabase();
        List<Event> list = db.eventDao().getAll(true);
        callback.onSuccess(list);
    }

    private void saveMyEventsToDb(List<Event> events){
        AppDatabase db = App.getInstance().getDatabase();

        for (Event event : events){
            event.setMyEvent(true);
        }

        db.eventDao().insertAll(events);
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
