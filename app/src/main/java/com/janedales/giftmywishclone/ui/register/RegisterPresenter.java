package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.network.request.RegisterUser;
import com.janedales.giftmywishclone.data.network.request.RegisterUserRequest;

public class RegisterPresenter implements RegisterModelCallback {

    private RegisterContract contract;
    private RegisterModel model = new RegisterModel(this);

    public RegisterPresenter(RegisterContract registerContract) {
        contract = registerContract;
    }

    public void register(String firstName, String lastName, String dateOfBirth,
                         String email, String userName, String password) {

        RegisterUser registerUser = new RegisterUser(
            firstName,
            lastName,
            userName,
            dateOfBirth,
            email,
            password
        );
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(registerUser);

        model.register(registerUserRequest);
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }

    @Override
    public void onSuccess(User user) {
        contract.onUserRegistered(user);
    }
}
