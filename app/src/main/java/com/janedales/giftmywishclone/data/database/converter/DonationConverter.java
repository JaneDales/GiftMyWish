package com.janedales.giftmywishclone.data.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.janedales.giftmywishclone.data.entity.Donation;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DonationConverter {

    @TypeConverter
    public static ArrayList<Donation> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Donation>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Donation> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
