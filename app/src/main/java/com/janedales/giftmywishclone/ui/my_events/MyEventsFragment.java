package com.janedales.giftmywishclone.ui.my_events;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.helpers.Constants;
import com.janedales.giftmywishclone.data.helpers.SharedPreferencesHelper;
import com.janedales.giftmywishclone.ui.base.BaseFragment;
import com.janedales.giftmywishclone.ui.my_events.details.MyEventsDetailsFragment;

import java.util.List;

public class MyEventsFragment extends BaseFragment implements MyEventsContract,
        SwipeRefreshLayout.OnRefreshListener, ClickListenerEvent{

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyEventsPresenter presenter = new MyEventsPresenter(this);
    private RecyclerView recyclerView;
    private MyEventsAdapter adapter;
    private TextView tvName, tvStatus, tvNumberOfFriends,tvNumberOfEvents;
    private ImageView ivAvatar, ivCover;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_events, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
    }

    private void initUI(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        tvName = view.findViewById(R.id.tvName);
        tvStatus = view.findViewById(R.id.tvStatus);
        tvNumberOfFriends = view.findViewById(R.id.tvNumberOfFriends);
        tvNumberOfEvents = view.findViewById(R.id.tvNumberOfEvents);
        ivAvatar = view.findViewById(R.id.ivUser);
        ivCover = view.findViewById(R.id.ivCover);

        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setRefreshing(true);
        presenter.getMyEventsList();

        SharedPreferences sharedPreferences = SharedPreferencesHelper.getInstance(requireActivity());
        int id = sharedPreferences.getInt(Constants.USER_ID, 0);
        presenter.getUser(id);
    }

    @Override
    public void onUser(User user) {
        String name = getResources().getString(R.string.first_and_last_name, user.getLastName(), user.getFirstName());
        tvName.setText(name);
        tvNumberOfEvents.setText(String.valueOf(user.getEventsCount()));
        tvNumberOfFriends.setText(String.valueOf(user.getFriendsCount()));
        if (user.getBio().isEmpty()){
            tvStatus.setText(getResources().getString(R.string.welcome_to_my_profile));
        }
        else{
            tvStatus.setText(user.getBio());
        }
        Glide.with(requireContext()).load(user.getAvatar().getUrl()).into(ivAvatar);
        Glide.with(requireContext()).load(user.getCover().getUrl()).into(ivCover);
    }

    @Override
    public void ovMyEvents(List<Event> list) {
        adapter = new MyEventsAdapter(list, this);
        recyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        presenter.getMyEventsList();
    }

    @Override
    public void onEventClick(Event event) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.container, MyEventsDetailsFragment.newInstance(event));
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void showUserLocalDetails() {
        SharedPreferences sharedPreferences = SharedPreferencesHelper.getInstance(requireActivity());
        String firstName = sharedPreferences.getString(Constants.USER_FIRST_NAME, "");
        String lastName = sharedPreferences.getString(Constants.USER_LAST_NAME, "");
        String name = getResources().getString(R.string.first_and_last_name, lastName, firstName);

        String bio = sharedPreferences.getString(Constants.USER_BIO, "");
        int eventsCount = sharedPreferences.getInt(Constants.USER_EVENTS_COUNT, 0);
        int friendsCount = sharedPreferences.getInt(Constants.USER_FRIENDS_COUNT, 0);
        tvName.setText(name);
        tvNumberOfEvents.setText(String.valueOf(eventsCount));
        tvNumberOfFriends.setText(String.valueOf(friendsCount));

        if (bio.isEmpty()){
            tvStatus.setText(getResources().getString(R.string.welcome_to_my_profile));
        }
        else{
            tvStatus.setText(bio);
        }

        String avatar = sharedPreferences.getString(Constants.USER_AVATAR, "");
        String cover = sharedPreferences.getString(Constants.USER_COVER, "");

        Glide.with(requireContext()).load(avatar).into(ivAvatar);
        Glide.with(requireContext()).load(cover).into(ivCover);
    }
}