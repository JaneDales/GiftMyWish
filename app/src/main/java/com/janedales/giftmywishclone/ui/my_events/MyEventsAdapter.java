package com.janedales.giftmywishclone.ui.my_events;

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
import com.janedales.giftmywishclone.data.helpers.DateHelper;


import java.util.List;

public class MyEventsAdapter extends RecyclerView.Adapter<MyEventsAdapter.ViewHolder> {

    private List<Event> list;
    public MyEventsAdapter(List<Event> list) {this.list = list; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_events, parent, false);
        return new ViewHolder(view);
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

        if (event.getPhoto().getUrl() == null) {
            loadImage("https://www.giftmywish.io/logo_1024.jpg", holder.ivCover);
        }
        else {
            loadImage(event.getPhoto().getUrl(), holder.ivCover);
        }
        if (event.isLikeStatus()){
            holder.ivLike.setImageResource(R.drawable.ic_btn_yeay_color);
        }
        else{
            holder.ivLike.setImageResource(R.drawable.ic_btn_yeay_black);
        }
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


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCover, ivLike;
        public TextView tvDaysLeft, tvTitle, tvLikesCount, tvCommentsCount;


        public ViewHolder(View itemView) {
            super(itemView);

            tvDaysLeft = (TextView) itemView.findViewById(R.id.tvDaysLeft);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvLikesCount = (TextView) itemView.findViewById(R.id.tvLikesCount);
            tvCommentsCount = (TextView) itemView.findViewById(R.id.tvCommentsCount);
            ivLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
