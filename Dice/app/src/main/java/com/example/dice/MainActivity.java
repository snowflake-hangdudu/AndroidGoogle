package com.example.dice;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //roll按钮实例
        Button roll = findViewById(R.id.roll);

        //结果显示实例
        TextView resultTextView = findViewById(R.id.result);

        //图片显示实例
        ImageView imageView = findViewById(R.id.img);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = (int) (Math.random() * 6 + 1);

                resultTextView.setText("骰子的结果是：" + result);
                resultTextView.setVisibility(View.VISIBLE);
                int resId = getResources().getIdentifier("dice_" + result, "drawable", getPackageName());
                imageView.setImageResource(resId);




            }


        });



    }
}