package com.example.woof;

import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout imageView = findViewById(R.id.hobby);
        ImageView more = findViewById(R.id.icon_expand_more);

        more.setOnClickListener(v -> {
            if (imageView.getVisibility() == LinearLayout.VISIBLE) {
                imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));
                imageView.setVisibility(LinearLayout.GONE);
                more.setImageResource(R.drawable.ic_expand_more);
            } else {
                imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
                imageView.setVisibility(LinearLayout.VISIBLE);
                more.setImageResource(R.drawable.ic_expand_less);
            }
        });
    }
}