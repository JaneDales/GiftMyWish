package com.janedales.giftmywishclone.ui.my_events.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.Gift;
import com.janedales.giftmywishclone.data.entity.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyEventsDetailsFragment extends Fragment implements ClickListenerGift {

    private static final String ARG_PARAM1 = "param1";

    private Event event;
    private MyEventsDetailsAdapter myEventsDetailsAdapter;
    private TextView tvTitle, tvDate, tvParticipants;
    private RecyclerView recyclerViewGifts, recyclerViewParticipants;

    public static MyEventsDetailsFragment newInstance(Event event) {
        MyEventsDetailsFragment fragment = new MyEventsDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, event);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            event = (Event) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_events_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tvTitle);
        tvDate = view.findViewById(R.id.tvDate);
        tvParticipants = view.findViewById(R.id.textParticipants);
        recyclerViewGifts = view.findViewById(R.id.recyclerView);
        recyclerViewParticipants = view.findViewById(R.id.recyclerViewParticipants);
        myEventsDetailsAdapter = new MyEventsDetailsAdapter(event.getGifts(), this);


        tvTitle.setText(event.getTitle());
        recyclerViewGifts.setAdapter(myEventsDetailsAdapter);
        String s = event.getEndDate().split("T")[0];
        tvDate.setText("Expiry: " + s);

        List<User> listUser = new ArrayList<>();
        boolean hasDonations = false;

        for(int k = 0; k < event.getGifts().size(); k++) {
            Gift gift = event.getGifts().get(k);

            if(!gift.getDonations().isEmpty()) {
                hasDonations = true;
                for (int i = 0; i < gift.getDonations().size(); i++){
                    User user = gift.getDonations().get(i).getUser();
                    listUser.add(user);
                }
                tvParticipants.setVisibility(View.GONE);
                ParticipantsAdapter participantsAdapter = new ParticipantsAdapter(listUser, new ClickListenerUser() {
                    @Override
                    public void onUserClick(User user) {
                        Toast.makeText(requireContext(), user.getUserName(), Toast.LENGTH_SHORT).show();
                    }
                });
                recyclerViewParticipants.setAdapter(participantsAdapter);
            }
        }
        if (!hasDonations) {
            tvParticipants.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onGiftClick(Gift gift) {
        // TODO: 10.08.2021 open image in full size
    }
}