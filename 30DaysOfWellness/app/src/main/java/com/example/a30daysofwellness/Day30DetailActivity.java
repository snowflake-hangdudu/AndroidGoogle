package com.example.a30daysofwellness;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.VISIBLE;

public class Day30DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_day30);

        ImageView detailImage = findViewById(R.id.image);
        TextView detailName = findViewById(R.id.name);
        TextView detailDesc = findViewById(R.id.desc);
        TextView detailLongDesc = findViewById(R.id.long_desc);

        int imageId = getIntent().getIntExtra("imageId", 0);
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        String longDesc = getIntent().getStringExtra("longDesc");

        detailImage.setImageResource(imageId);
        detailName.setText(name);
        detailLongDesc.setText(longDesc);
        detailDesc.setText(desc);

        // 点击图片显示长描述
        detailImage.setOnClickListener(view -> {
            Log.d("Day30DetailActivity", "ImageView clicked");
            detailLongDesc.setVisibility(VISIBLE);
        });



    }
}

