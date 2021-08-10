package com.janedales.giftmywishclone.ui.entry;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.request.LoginUserSocialRequest;
import com.janedales.giftmywishclone.data.network.response.UserResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryModel {
    private EntryModelCallback callback;

    public EntryModel(EntryModelCallback callback){
        this.callback = callback;
    }

    public void login(LoginUserSocialRequest loginUserSocialRequest){
        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<UserResponse> call = service.login(loginUserSocialRequest);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                callback.onSuccess(response.body().getUser());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }


}
