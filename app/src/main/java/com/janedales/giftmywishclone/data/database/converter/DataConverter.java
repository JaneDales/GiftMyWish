package com.janedales.giftmywishclone.data.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.janedales.giftmywishclone.data.entity.Comment;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataConverter {

    @TypeConverter
    public static ArrayList<Comment> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Comment>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Comment> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
