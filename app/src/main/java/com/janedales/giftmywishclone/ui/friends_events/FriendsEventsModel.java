package com.janedales.giftmywishclone.ui.friends_events;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.response.EventsListResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsEventsModel {
  private FriendsEventsModelCallback callback;

    public FriendsEventsModel(FriendsEventsModelCallback callback){
        this.callback = callback;
    }
    public void getEvents(){
      /** Create handle for the RetrofitInstance interface*/
      UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

      /** Call the method with parameter in the interface to get the notice data*/
      Call<EventsListResponse> call = service.getFriendsEvents(1, 10);

      call.enqueue(new Callback<EventsListResponse>() {
        @Override
        public void onResponse(Call<EventsListResponse> call, Response<EventsListResponse> response) {
          callback.onSuccess(response.body().getEvents());
        }

        @Override
        public void onFailure(Call<EventsListResponse> call, Throwable t) {
          t.printStackTrace();
          callback.onFail(t);
        }
      });
    }
}
