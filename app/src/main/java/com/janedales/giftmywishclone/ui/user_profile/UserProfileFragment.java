package com.janedales.giftmywishclone.ui.user_profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

import java.util.List;

public class UserProfileFragment extends Fragment implements UserProfileContract, SwipeRefreshLayout.OnRefreshListener {

    private static final String ARG_PARAM1 = "param1";

    private User user;

    private UserProfileAdapter adapter;
    private UserProfilePresenter presenter = new UserProfilePresenter(this);
    private ImageView ivTitle, ivUser;
    private TextView tvName, tvNumberOfFriends, tvNumberOfEvents;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    public static UserProfileFragment newInstance(User user) {
        UserProfileFragment fragment = new UserProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1,user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);
        swipeRefreshLayout.setRefreshing(true);
        presenter.getEventsList(user.getId());
    }

    private void initUI(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        ivTitle = view.findViewById(R.id.ivTitle);
        ivUser = view.findViewById(R.id.ivUser);
        tvName = view.findViewById(R.id.tvName);
        tvNumberOfFriends = view.findViewById(R.id.tvNumberOfFriends);
        tvNumberOfEvents = view.findViewById(R.id.tvNumberOfEvents);
        recyclerView = view.findViewById(R.id.recyclerView);

        tvName.setText(user.getFirstName() + " " + user.getLastName());
        tvNumberOfFriends.setText(String.valueOf(user.getFriendsCount()));
        tvNumberOfEvents.setText(String.valueOf(user.getEventsCount()));

        swipeRefreshLayout.setOnRefreshListener(this);

        if (user.getAvatar().getUrl() == null){
            Glide.with(requireActivity()).load(Constants.AVATAR_PLACEHOLDER).into(ivUser);
        }
        else{
            Glide.with(requireActivity()).load(user.getAvatar().getUrl()).into(ivUser);
        }
        if (user.getCover().getUrl() == null){
            Glide.with(requireActivity()).load(Constants.AVATAR_PLACEHOLDER).into(ivTitle);
        }
        else{
            Glide.with(requireActivity()).load(user.getCover().getUrl()).into(ivTitle);
        }
    }

    @Override
    public void onMyEvents(List<Event> list) {
        swipeRefreshLayout.setRefreshing(false);
        adapter = new UserProfileAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFail(Throwable t) {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        presenter.getEventsList(user.getId());
    }
}