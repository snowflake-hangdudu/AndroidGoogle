package com.example.a30daysofwellness;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a30daysofwellness.model.Day30;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Day30> day30List = new ArrayList<>();
        day30List.add(new Day30(R.drawable.p1, "Day 1", "desc", "hello,first day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p2, "Day 2", "desc", "hello,second day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p3, "Day 3", "desc", "hello,third day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p4, "Day 4", "desc", "hello,fourth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p5, "Day 5", "desc", "hello,fifth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p6, "Day 6", "desc", "hello,sixth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p7, "Day 7", "desc", "hello,seventh day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p8, "Day 8", "desc", "hello,eighth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p9, "Day 9", "desc", "hello,ninth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p10, "Day 10", "desc", "hello,tenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p11, "Day 11", "desc", "hello,eleventh day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p12, "Day 12", "desc", "hello,twelfth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p13, "Day 13", "desc", "hello,thirteenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p14, "Day 14", "desc", "hello,fourteenth day,nice to meet you,thank you for sharing"));


        day30List.add(new Day30(R.drawable.p15, "Day 15", "desc", "hello,fifteenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p16, "Day 16", "desc", "hello,sixteenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p17, "Day 17", "desc", "hello,seventeenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p18, "Day 18", "desc", "hello,eighteenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p19, "Day 19", "desc", "hello,nineteenth day,nice to meet you,thank you for sharing"));
        day30List.add(new Day30(R.drawable.p20, "Day 20", "desc", "hello,twentieth day,nice to meet you,thank you for sharing"));

        // 添加更多 Day30 项目

        com.example.a30daysofwellness.Day30Adapter adapter = new com.example.a30daysofwellness.Day30Adapter(this, day30List);
        recyclerView.setAdapter(adapter);



    }
}