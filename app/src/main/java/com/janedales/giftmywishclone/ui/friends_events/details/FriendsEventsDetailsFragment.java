package com.janedales.giftmywishclone.ui.friends_events.details;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.entity.Gift;
import com.janedales.giftmywishclone.data.helpers.Constants;
import com.janedales.giftmywishclone.data.helpers.DateHelper;
import com.janedales.giftmywishclone.ui.image_full_size.ImageFullSizeActivity;
import com.janedales.giftmywishclone.ui.my_events.details.ClickListenerGift;

public class FriendsEventsDetailsFragment extends Fragment implements ClickListenerGift {

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
        adapter = new FriendsEventsDetailsAdapter(event.getGifts(), name, this);
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

        String name = event.getUser().getFirstName() + " " + event.getUser().getLastName();
        tvUserName.setText(name);
        tvTitle.setText(event.getTitle());
        tvDescription.setText(event.getDescription());
        tvComments.setText(getResources().getString(R.string.comments_format, event.getTotalCommentCount()));
        tvLike.setText(getResources().getString(R.string.likes_format, event.getTotalLikesCount()));
        if (event.getUser().getAvatar().getUrl() == null){
            loadAvatar(Constants.AVATAR_PLACEHOLDER, ivAvatar);
        }
        else{
            loadAvatar(event.getUser().getAvatar().getUrl(), ivAvatar);
        }

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

    private void loadAvatar(String url, ImageView imageView){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.centerInside().transform(new CenterInside(), new GranularRoundedCorners(0, 0, 24, 0));
        Glide.with(requireContext())
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    @Override
    public void onGiftClick(Gift gift) {
        Intent intent = new Intent(requireContext(), ImageFullSizeActivity.class);
        intent.putExtra("image", gift.getPhoto().getUrl());
        startActivity(intent);
    }
}