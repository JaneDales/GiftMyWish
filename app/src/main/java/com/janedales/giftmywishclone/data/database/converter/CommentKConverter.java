package com.janedales.giftmywishclone.data.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.janedales.giftmywishclone.data.entity.CommentK;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CommentKConverter {

    @TypeConverter
    public static ArrayList<CommentK> fromString(String value) {
        Type listType = new TypeToken<ArrayList<CommentK>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<CommentK> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
