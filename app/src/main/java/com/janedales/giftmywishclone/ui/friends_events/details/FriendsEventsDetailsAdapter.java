package com.janedales.giftmywishclone.ui.friends_events.details;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Gift;
import com.janedales.giftmywishclone.data.helpers.Constants;

import java.util.List;

public class FriendsEventsDetailsAdapter extends RecyclerView.Adapter<FriendsEventsDetailsAdapter.ViewHolder>{

    private List<Gift> list;
    private String userName;

    public FriendsEventsDetailsAdapter(List<Gift> list, String userName){
        this.list = list;
        this.userName = userName;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends_gift, parent, false);
        return new FriendsEventsDetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Gift gift = list.get(position);

        holder.tvTitle.setText(gift.getName());
        holder.tvUserName.setText(userName);
        holder.tvPrice.setText(holder.itemView.getContext().getResources().getString(R.string.total_funded_format,
                gift.getTotalFond(), gift.getPrice()));
//        holder.tvFunded.setText(holder.itemView.getContext().getResources().getString(R.string.funded_format,
//                gift.getTotalFundPercentage()));
        holder.tvFunded.setText(gift.getTotalFundPercentage() + "% Funded");

        holder.sbSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        if (gift.getPhoto().getUrl() == null) {
            loadImage(Constants.AVATAR_PLACEHOLDER, holder.ivCover);
        }
        else {
            loadImage(gift.getPhoto().getUrl(), holder.ivCover);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCover;
        TextView tvTitle, tvUserName, tvPrice, tvFunded;
        SeekBar sbSeekBar;

        public ViewHolder(View itemView) {
            super(itemView);

            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvFunded = itemView.findViewById(R.id.tvFunded);
            sbSeekBar = itemView.findViewById(R.id.sbSeekBar);
        }
    }
}
