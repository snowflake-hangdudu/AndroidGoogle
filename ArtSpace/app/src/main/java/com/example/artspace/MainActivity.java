package com.example.artspace;

import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     Button previous = findViewById(R.id.previous);
     Button next = findViewById(R.id.next);

        ImageView art = findViewById(R.id.art);

     next.setOnClickListener(v -> {
         art.setImageResource(R.drawable.art2);
     });

     previous.setOnClickListener(v -> {
         art.setImageResource(R.drawable.art);
     });




    }
}