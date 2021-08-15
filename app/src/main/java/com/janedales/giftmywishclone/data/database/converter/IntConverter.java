package com.janedales.giftmywishclone.data.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class IntConverter {

    @TypeConverter
    public static ArrayList<Integer> stringToSomeObjectList(String data) {
        if (data == null) {
            return new ArrayList<>();//Collections.emptyList();
        }

        Gson gson = new Gson();

        Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(ArrayList<Integer> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

}
