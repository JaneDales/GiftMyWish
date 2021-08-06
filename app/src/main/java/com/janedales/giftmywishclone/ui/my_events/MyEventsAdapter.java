package com.janedales.giftmywishclone.ui.my_events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Event;


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

        holder.tvDaysLeft.setText(event.getEndDate());
        holder.tvUserName.setText(event.getUser().getUserName());
        holder.tvTitle.setText(event.getTitle());
        Glide.with(holder.tvDaysLeft.getContext())
                .load(event.getPhoto().getUrl())
                .into(holder.ivCover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCover;
        public TextView tvDaysLeft, tvUserName, tvTitle;


        public ViewHolder(View itemView) {
            super(itemView);

            tvDaysLeft = (TextView) itemView.findViewById(R.id.tvDaysLeft);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}
