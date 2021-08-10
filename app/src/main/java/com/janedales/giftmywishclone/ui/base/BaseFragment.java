package com.janedales.giftmywishclone.ui.base;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.janedales.giftmywishclone.data.helpers.Constants;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.data.network.RetrofitInstance;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = SharedPreferencesHelper.getInstance(requireActivity());
        String token = preferences.getString(Constants.TOKEN, "");
        RetrofitInstance.setmToken(token);
    }
}
