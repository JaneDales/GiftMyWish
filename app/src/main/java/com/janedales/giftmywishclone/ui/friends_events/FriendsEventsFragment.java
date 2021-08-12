package com.janedales.giftmywishclone.ui.friends_events;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.ui.base.BaseFragment;
import com.janedales.giftmywishclone.ui.friends_events.details.FriendsEventsDetailsFragment;
import com.janedales.giftmywishclone.ui.user_profile.UserProfileFragment;


import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FriendsEventsFragment extends BaseFragment implements FriendsEventsContract,
        SwipeRefreshLayout.OnRefreshListener, ClickListenerFriendsEvents {

    private FriendsEventsPresenter presenter = new FriendsEventsPresenter(this);
    private RecyclerView recycler1;
    private FriendsEventsAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friends_events, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler1 = view.findViewById(R.id.recycler1);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(true);
        presenter.getEventsList();
    }

    @Override
    public void ovEventsLoaded(List<Event> list) {
        adapter = new FriendsEventsAdapter(list, this);
        recycler1.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        presenter.getEventsList();
    }

    @Override
    public void onEventClick(Event event) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.container, FriendsEventsDetailsFragment.newInstance(event));
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onUserClick(User user) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.container, UserProfileFragment.newInstance(user));
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        OnBackPressedCallback backCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Remove all fragments from the childFragmentManager,
                // but exclude the first added child fragment.
                // This child fragment will be deleted with its parent.
                if (getChildFragmentManager().getBackStackEntryCount() > 1) {
                    getChildFragmentManager().popBackStack();
                    return;
                }
                // Delete parent fragment
//                getParentFragmentManager().popBackStack();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, backCallback);
    }
}