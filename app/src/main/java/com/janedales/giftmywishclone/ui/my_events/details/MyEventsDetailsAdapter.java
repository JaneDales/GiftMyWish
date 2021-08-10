package com.janedales.giftmywishclone.ui.my_events.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Gift;
import com.janedales.giftmywishclone.data.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MyEventsDetailsAdapter extends RecyclerView.Adapter<MyEventsDetailsAdapter.ViewHolder> implements ClickListenerUser {

    private List<Gift> list;
    private List<User> listUser;
    private ClickListenerGift clickListenerGift;
    public MyEventsDetailsAdapter(List<Gift> list, ClickListenerGift clickListenerGift) {
        this.list = list;
        this.clickListenerGift = clickListenerGift;
        listUser = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_gift, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Gift gift = list.get(position);

        holder.tvTitle.setText(gift.getName());
        holder.tvFunded.setText(gift.getTotalFond() + "% Funded");
        holder.tvPrice.setText("$0/$" + gift.getPrice());
        holder.sbSeekBar.setProgress(gift.getTotalFundPercentage());

        if(gift.getDonations().isEmpty()){
            holder.tvParticipants.setVisibility(View.VISIBLE);
        }
        else {
            for (int i = 0; i < gift.getDonations().size(); i++){
                User user = gift.getDonations().get(i).getUser();
                listUser.add(user);
            }
            holder.tvParticipants.setVisibility(View.GONE);
            ParticipantsAdapter participantsAdapter = new ParticipantsAdapter(listUser, this);
            holder.recyclerViewParticipants.setAdapter(participantsAdapter);
        }

        loadImage(gift.getPhoto().getUrl(), holder.ivCover);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListenerGift.onGiftClick(gift);
            }
        });
    }

    private void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onUserClick(User user) {
        clickListenerGift.onUserClick(user);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCover;
        public TextView tvTitle, tvFunded, tvPrice, tvExpired, btnStatus, tvParticipants;
        public SeekBar sbSeekBar;
        public RecyclerView recyclerViewParticipants;


        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvFunded = itemView.findViewById(R.id.tvFunded);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvExpired = itemView.findViewById(R.id.tvExpired);
            btnStatus = itemView.findViewById(R.id.btnStatus);
            sbSeekBar = itemView.findViewById(R.id.sbSeekBar);
            tvParticipants = itemView.findViewById(R.id.textParticipants);
            recyclerViewParticipants = itemView.findViewById(R.id.recyclerViewParticipants);
        }
    }
}
