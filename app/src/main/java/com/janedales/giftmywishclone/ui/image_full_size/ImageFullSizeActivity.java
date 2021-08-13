package com.janedales.giftmywishclone.ui.image_full_size;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.janedales.giftmywishclone.R;

public class ImageFullSizeActivity extends AppCompatActivity {

    private ImageView ivCover, btnCross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full_size);

        String image = getIntent().getStringExtra("image");

        ivCover = findViewById(R.id.ivCover);
        btnCross = findViewById(R.id.btnCross);

        Glide.with(this)
                .load(image)
                .into(ivCover);

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}