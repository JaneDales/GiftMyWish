package com.janedales.giftmywishclone.ui.my_events;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.janedales.giftmywishclone.R;
import com.janedales.giftmywishclone.data.entity.Gift;

import java.util.List;

public class MyGiftsAdapter extends RecyclerView.Adapter<MyGiftsAdapter.ViewHolder> {

    private List<Gift> list;
    public MyGiftsAdapter(List<Gift> list) {this.list = list; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_events_gift, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Gift gift = list.get(position);

        holder.tvTitle.setText(gift.getName());
        loadImage(gift.getPhoto().getUrl(), holder.ivCover);
        holder.sbSeekBar.setProgress(gift.getTotalFundPercentage());
        holder.sbSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void loadImage(String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(20));
        Glide.with(imageView.getContext())
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivCover, btnDelete;
        public TextView tvTitle;
        public SeekBar sbSeekBar;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            ivCover = itemView.findViewById(R.id.ivCover);
            sbSeekBar = itemView.findViewById(R.id.sbSeekBar);
        }
    }
}
