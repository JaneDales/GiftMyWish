package com.janedales.giftmywishclone.data.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.janedales.giftmywishclone.data.entity.Gift;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GiftConverter {

    @TypeConverter
    public static ArrayList<Gift> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Gift>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Gift> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
