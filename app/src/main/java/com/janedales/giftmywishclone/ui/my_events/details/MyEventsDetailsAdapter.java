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

import java.util.List;

public class MyEventsDetailsAdapter extends RecyclerView.Adapter<MyEventsDetailsAdapter.ViewHolder> {

    private List<Gift> list;
    private ClickListenerGift clickListenerGift;
    public MyEventsDetailsAdapter(List<Gift> list, ClickListenerGift clickListenerGift) {
        this.list = list;
        this.clickListenerGift = clickListenerGift;
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCover;
        public TextView tvTitle, tvFunded, tvPrice, tvExpired, btnStatus;
        public SeekBar sbSeekBar;


        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvFunded = itemView.findViewById(R.id.tvFunded);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvExpired = itemView.findViewById(R.id.tvExpired);
            btnStatus = itemView.findViewById(R.id.btnStatus);
            sbSeekBar = itemView.findViewById(R.id.sbSeekBar);
        }
    }
}
