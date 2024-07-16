package com.example.racetracker;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ProgressBar play1;
    private ProgressBar play2;
    private Handler handler = new Handler();
    private int currentProgress1 = 0;
    private int currentProgress2 = 0;
    private int maxProgress1 = 10000;
    private int maxProgress2 = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar play1 = findViewById(R.id.play1);
        ProgressBar play2 = findViewById(R.id.play2);
        //开始
        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgress1 = play1.getProgress();
                currentProgress2 = play2.getProgress();

            }
        });

    }

}