package com.janedales.giftmywishclone.ui.friends_events.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.helpers.DateHelper;

public class FriendsEventsDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private FriendsEventsDetailsAdapter adapter;

    private Event event;
    private ImageView ivAvatar, btnLike;
    private TextView tvUserName, tvUserStatus, tvDate, tvTitle, tvDescription, tvComments, tvLike, tvWishList;
    private RecyclerView recyclerView;

    public static FriendsEventsDetailsFragment newInstance(Event event) {
        FriendsEventsDetailsFragment fragment = new FriendsEventsDetailsFragment();
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
        return inflater.inflate(R.layout.fragment_friends_events_details, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI(view);

        String name = event.getUser().getFirstName() + " " + event.getUser().getLastName();
        adapter = new FriendsEventsDetailsAdapter(event.getGifts(), name);
        recyclerView.setAdapter(adapter);
    }
    private void initUI(View view){

        tvUserName = view.findViewById(R.id.tvUserName);
        tvUserStatus = view.findViewById(R.id.tvUserStatus);
        tvDate = view.findViewById(R.id.tvDate);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvDescription = view.findViewById(R.id.tvDescription);
        tvComments = view.findViewById(R.id.tvComments);
        tvLike = view.findViewById(R.id.tvLike);
        ivAvatar = view.findViewById(R.id.ivAvatar);
        recyclerView = view.findViewById(R.id.recyclerView);
        btnLike = view.findViewById(R.id.btnLike);
        tvWishList = view.findViewById(R.id.tvWishList);

        String lastSeen = DateHelper.getLastSeen(event.getUser().getLastSeen());
        tvUserStatus.setText(lastSeen);

        String date = event.getEndDate().split("T")[0];
        tvDate.setText(getResources().getString(R.string.expiry_format, date));

        tvUserName.setText(event.getUser().getUserName());
        tvTitle.setText(event.getTitle());
        tvDescription.setText(event.getDescription());
        tvComments.setText(getResources().getString(R.string.comments_format, event.getTotalCommentCount()));
        tvLike.setText(getResources().getString(R.string.likes_format, event.getTotalLikesCount()));
        Glide.with(requireContext()).load(event.getPhoto().getUrl()).into(ivAvatar);

        if (event.isLikeStatus()){
            btnLike.setImageResource(R.drawable.ic_btn_yeay_color);
        }
        else{
            btnLike.setImageResource(R.drawable.ic_btn_yeay_black);
        }
        tvWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();
            }
        });
    }
}