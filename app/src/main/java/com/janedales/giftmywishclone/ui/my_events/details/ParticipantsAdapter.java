package com.janedales.giftmywishclone.ui.my_events.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.User;
import com.janedales.giftmywishclone.data.helpers.DateHelper;
import com.janedales.giftmywishclone.ui.my_events.ClickListenerEvent;
import com.janedales.giftmywishclone.ui.my_events.MyGiftsAdapter;

import java.util.List;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ViewHolder> {

    private List<User> list;
    private ClickListenerUser clickListenerUser;
    public ParticipantsAdapter(List<User> list, ClickListenerUser clickListenerUser) {
        this.list = list;
        this.clickListenerUser = clickListenerUser;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_participant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = list.get(position);


        loadImage(user.getAvatar().getUrl(), holder.ivAvatar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListenerUser.onUserClick(user);
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


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivAvatar;
        public TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);

        }
    }
}
