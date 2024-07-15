package com.example.cupcake;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = findViewById(R.id.one);

        Button six= findViewById(R.id.six);

        Button ten = findViewById(R.id.ten);

        one.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChooseFlavor.class);
            intent.putExtra("quantity", "1"); // 传递数量1
            startActivity(intent);
        });

        six.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChooseFlavor.class);
            intent.putExtra("quantity", "6"); // 传递数量6
            startActivity(intent);
        });

        ten.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChooseFlavor.class);
            intent.putExtra("quantity", "10"); // 传递数量10
            startActivity(intent);
        });





      


    }

    public   void main(){
        CompletableFuture.runAsync(() -> {

        });
    }


}