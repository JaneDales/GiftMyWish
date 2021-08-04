package com.janedales.giftmywishclone.ui.login;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.request.LoginUserRequest;
import com.janedales.giftmywishclone.data.network.response.UserResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel {

    private LoginModelCallback callback;

    public LoginModel(LoginModelCallback callback){
        this.callback = callback;
    }

    public void login(LoginUserRequest loginUserRequest){
        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<UserResponse> call = service.login(loginUserRequest);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().getUser());
                }
                else {
                    try {
                        callback.onFail(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
