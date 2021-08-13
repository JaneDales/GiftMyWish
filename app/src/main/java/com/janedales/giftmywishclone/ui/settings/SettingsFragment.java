package com.janedales.giftmywishclone.ui.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.ui.base.BaseFragment;
import com.janedales.giftmywishclone.ui.entry.EntryActivity;

public class SettingsFragment extends BaseFragment implements SettingsContract {

    private SettingsPresenter presenter = new SettingsPresenter(this);

    private TextView btnLogOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogOut = view.findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logOut();
            }
        });
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogOut() {
        SharedPreferences preferences = SharedPreferencesHelper.getInstance(requireActivity());
        preferences.edit().remove("token").apply();
        startActivity(new Intent(requireActivity(), EntryActivity.class));
    }
}