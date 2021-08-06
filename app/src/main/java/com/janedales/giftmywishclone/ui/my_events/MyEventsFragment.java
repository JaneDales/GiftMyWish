package com.janedales.giftmywishclone.ui.my_events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;


import java.util.List;

public class MyEventsFragment extends Fragment implements MyEventsContract {

    private MyEventsPresenter presenter = new MyEventsPresenter(this);
    private RecyclerView recyclerView;
    private MyEventsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_events, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        presenter.getMyEventsList();
    }

    @Override
    public void ovMyEvents(List<Event> list) {
        adapter = new MyEventsAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFail(Throwable t) {
        Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}