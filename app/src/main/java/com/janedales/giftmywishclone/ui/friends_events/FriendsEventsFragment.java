package com.janedales.giftmywishclone.ui.friends_events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;


import java.util.List;


public class FriendsEventsFragment extends Fragment implements FriendsEventsContract, SwipeRefreshLayout.OnRefreshListener {

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
        adapter = new FriendsEventsAdapter(list);
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
}