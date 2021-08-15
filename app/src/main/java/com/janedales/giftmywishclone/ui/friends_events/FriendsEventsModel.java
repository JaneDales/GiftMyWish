package com.janedales.giftmywishclone.ui.friends_events;

import com.janedales.giftmywishclone.App;
import com.janedales.giftmywishclone.data.database.AppDatabase;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.response.EventsListResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsEventsModel {
  private FriendsEventsModelCallback callback;

    public FriendsEventsModel(FriendsEventsModelCallback callback){
        this.callback = callback;
    }

    public void getEvents(){
      if (App.getInstance().isNetworkAvailable()) {
        getEventsFromApi();
      }
      else {
        getEventsFromDb();
      }
    }

  public void getEventsFromApi() {
    System.out.println("AAAAA, getEventsFromApi");

      /** Create handle for the RetrofitInstance interface*/
      UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

      /** Call the method with parameter in the interface to get the notice data*/
      Call<EventsListResponse> call = service.getFriendsEvents(1, 10);

      call.enqueue(new Callback<EventsListResponse>() {
        @Override
        public void onResponse(Call<EventsListResponse> call, Response<EventsListResponse> response) {
          List<Event> events = response.body().getEvents();
          saveEventsInDb(events);
          callback.onSuccess(events);
        }

        @Override
        public void onFailure(Call<EventsListResponse> call, Throwable t) {
          t.printStackTrace();
          callback.onFail(t);
        }
      });
    }

  private void getEventsFromDb() {
    System.out.println("AAAAA, getEventsFromDb");

    AppDatabase db = App.getInstance().getDatabase();
    List<Event> events = db.eventDao().getAll();

    for (Event e : events) {
      System.out.println("Event = " + e.getTitle());
    }

    callback.onSuccess(events);
  }

  public void saveEventsInDb(List<Event> list) {
    AppDatabase db = App.getInstance().getDatabase();

    db.eventDao().insertAll(list);

    List<Event> events = db.eventDao().getAll();
    for (Event e : events) {
      System.out.println("Saved event = " + e.getTitle());
    }
  }
}
