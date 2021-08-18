package com.janedales.giftmywishclone.data.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.janedales.giftmywishclone.data.entity.User;

public class SharedPreferencesHelper {

    private static SharedPreferences preferences;

    private SharedPreferencesHelper(){}

    public static SharedPreferences getInstance(Activity activity) {
        if (preferences == null)
            preferences = activity.getSharedPreferences("GiftMyWishApp", Context.MODE_PRIVATE);
        return preferences;
    }

    public static void saveUser(Activity activity, User user) {
        SharedPreferences sharedPreferences = SharedPreferencesHelper.getInstance(activity);
        sharedPreferences.edit().putString(Constants.TOKEN, user.getAuthenticationToken()).apply();
        sharedPreferences.edit().putInt(Constants.USER_ID, user.getId()).apply();
        sharedPreferences.edit().putString(Constants.USER_USERNAME, user.getUserName()).apply();
        sharedPreferences.edit().putString(Constants.USER_FIRST_NAME, user.getFirstName()).apply();
        sharedPreferences.edit().putString(Constants.USER_LAST_NAME, user.getLastName()).apply();
        sharedPreferences.edit().putInt(Constants.USER_EVENTS_COUNT, user.getEventsCount()).apply();
        sharedPreferences.edit().putInt(Constants.USER_FRIENDS_COUNT, user.getFriendsCount()).apply();
        sharedPreferences.edit().putString(Constants.USER_BIO, user.getBio()).apply();
        sharedPreferences.edit().putString(Constants.USER_AVATAR, user.getAvatar().getUrl()).apply();
        sharedPreferences.edit().putString(Constants.USER_COVER, user.getCover().getUrl()).apply();
    }

}
