package com.example.list2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycleView = findViewById(R.id.recyclerView);
        recycleView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.architecture,"Architecture","1"));
        itemList.add(new Item(R.drawable.automotive,"Automotive","2"));
        itemList.add(new Item(R.drawable.biology,"biology","3"));
        itemList.add(new Item(R.drawable.business,"Business","4"));
        itemList.add(new Item(R.drawable.engineering,"Chemistry","5"));

        itemList.add(new Item(R.drawable.history,"History","10"));

        itemList.add(new Item(R.drawable.music,"Music","13"));

        itemList.add(new Item(R.drawable.physics,"Physics","15"));


        Adapter adapter = new Adapter(itemList);
        recycleView.setAdapter(adapter);
    }
}