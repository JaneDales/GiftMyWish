package com.janedales.giftmywishclone.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.janedales.giftmywishclone.data.entity.Event;

import java.util.List;

public class EventsListResponse {

    @SerializedName("events")
    private List<Event> events;

    public List <Event> getEvents() {
        return events;
    }
}
