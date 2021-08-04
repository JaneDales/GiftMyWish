package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.network.RetrofitInstance;
import com.janedales.giftmywishclone.data.network.request.ConfirmCodeRequest;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;
import com.janedales.giftmywishclone.data.network.response.UserResponse;
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
        Call<UserResponse> call = service.register(registerUserRequest);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                callback.onSuccessRegister(response.body().getUser());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }

    public void confirmCode(ConfirmCodeRequest confirmCodeRequest) {

        /** Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<UserResponse> call = service.confirmCode(confirmCodeRequest);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                callback.onSuccessCode(response.body().getUser());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
