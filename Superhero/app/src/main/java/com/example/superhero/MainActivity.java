package com.example.superhero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.superhero.adapter.SuperheroAdapter;
import com.example.superhero.model.Superhero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SuperheroAdapter adapter;
    private List<Superhero> superheroList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        superheroList = new ArrayList<>();
        superheroList.add(new Superhero(R.drawable.android_superhero1, "DC Comics", "Richard Batman"));
        superheroList.add(new Superhero(R.drawable.android_superhero2, "Marvel", "Wolverine"));
        superheroList.add(new Superhero(R.drawable.android_superhero3, "DC Comics", "Superman"));
        superheroList.add(new Superhero(R.drawable.android_superhero4, "Marvel", "Iron Man"));
        superheroList.add(new Superhero(R.drawable.android_superhero5, "DC Comics", "Batman"));
        superheroList.add(new Superhero(R.drawable.android_superhero6, "Marvel", "Hulk"));

        adapter = new SuperheroAdapter(superheroList);
        recyclerView.setAdapter(adapter);



    }
}