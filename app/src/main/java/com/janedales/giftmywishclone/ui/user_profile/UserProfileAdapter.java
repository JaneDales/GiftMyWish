package com.janedales.giftmywishclone.ui.user_profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;
import com.janedales.giftmywishclone.data.helpers.Constants;
import com.janedales.giftmywishclone.data.helpers.DateHelper;


import java.util.List;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ViewHolder> {

    private List<Event> list;
    public UserProfileAdapter(List<Event> list){
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_profile, parent, false);
        return new UserProfileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event event = list.get(position);

        long days = DateHelper.getDaysLeft(event.getEndDate());
        holder.tvDaysLeft.setText(days + " DAYS LEFT");
        holder.tvTitle.setText(event.getTitle());
        holder.tvLikesCount.setText(event.getTotalLikesCount() + " Likes.");
        holder.tvCommentsCount.setText(event.getTotalCommentCount() + " Comments");
        if(days < 10){
            holder.tvDaysLeft.setBackgroundTintList(ContextCompat.getColorStateList(holder.tvDaysLeft.getContext(), R.color.red));
        }
        else {
            holder.tvDaysLeft.setBackgroundTintList(ContextCompat.getColorStateList(holder.tvDaysLeft.getContext(), R.color.gray));
        }
        if (event.isLikeStatus()){
            holder.btnLike.setImageResource(R.drawable.ic_btn_yeay_color);
        }
        else{
            holder.btnLike.setImageResource(R.drawable.ic_btn_yeay_black);
        }
        if (event.getPhoto().getUrl() == null){
            Glide.with(holder.itemView.getContext()).load(Constants.AVATAR_PLACEHOLDER).into(holder.ivCover);
        }
        else{
            Glide.with(holder.itemView.getContext()).load(event.getPhoto().getUrl()).into(holder.ivCover);
        }
    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivCover, btnLike, btnShare, btnComment;
        public TextView tvDaysLeft, tvTitle, tvLikesCount, tvCommentsCount;

        public ViewHolder(View itemView) {
            super(itemView);

            ivCover = itemView.findViewById(R.id.ivCover);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnShare = itemView.findViewById(R.id.btnShare);
            btnComment = itemView.findViewById(R.id.btnComment);
            tvDaysLeft = itemView.findViewById(R.id.tvDaysLeft);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvLikesCount = itemView.findViewById(R.id.tvLikesCount);
            tvCommentsCount = itemView.findViewById(R.id.tvCommentsCount);

        }
    }
}
