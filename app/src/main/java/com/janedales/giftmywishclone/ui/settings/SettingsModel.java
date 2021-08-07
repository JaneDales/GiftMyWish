package com.janedales.giftmywishclone.ui.settings;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.service.UserService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingsModel {
    private SettingsModelCallback callback;

    public SettingsModel(SettingsModelCallback callback){this.callback = callback;}

    public void logOut(){

        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        /** Call the method with parameter in the interface to get the notice data*/
        Call<ResponseBody> call = service.logOut();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                callback.onSuccess();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
