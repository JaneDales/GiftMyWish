package com.janedales.giftmywishclone.ui.register;

import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.network.request.ConfirmCodeRequest;
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

    public void confirmCode(String username, String code) {
        model.confirmCode(new ConfirmCodeRequest(username, code));
    }

    @Override
    public void onFail(Throwable t) {
        contract.onFail(t);
    }

    @Override
    public void onSuccessRegister(User user) {
        contract.onUserRegistered(user);
    }

    @Override
    public void onSuccessCode(User user) {
        contract.onSuccessCode(user);
    }
}
