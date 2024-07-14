package com.example.affirmations;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item(R.drawable.i1, "周一不摆烂"));
        itemList.add(new Item(R.drawable.i1, "周二不摆烂"));
        itemList.add(new Item(R.drawable.i1, "周三不摆烂"));
        itemList.add(new Item(R.drawable.i1, "周四不摆烂"));
        itemList.add(new Item(R.drawable.i1, "周五不摆烂"));
        itemList.add(new Item(R.drawable.i1, "周六不摆烂"));
        itemList.add(new Item(R.drawable.i1, "周日不摆烂"));


        MyAdapter adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}