package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;
import com.janedales.giftmywishclone.data.network.response.UserRegisterResponse;
import com.janedales.giftmywishclone.data.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterModel {

    private RegisterModelCallback callback;

    public RegisterModel(RegisterModelCallback registerModelCallback){
        callback = registerModelCallback;
    }

    public void register(RegisterUserRequest registerUserRequest){

        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<UserRegisterResponse> call = service.register(registerUserRequest);

        call.enqueue(new Callback<UserRegisterResponse>() {
            @Override
            public void onResponse(Call<UserRegisterResponse> call, Response<UserRegisterResponse> response) {
                callback.onSuccess(response.body().getUser());
            }

            @Override
            public void onFailure(Call<UserRegisterResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
