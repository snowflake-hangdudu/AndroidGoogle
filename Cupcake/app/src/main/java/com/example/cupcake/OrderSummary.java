package com.example.cupcake;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrderSummary extends AppCompatActivity {
    public String date;
    public String flavor;
    public String quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        date = getIntent().getStringExtra("date");
        flavor = getIntent().getStringExtra("flavor");
        quantity = getIntent().getStringExtra("quantity");

        // Set the text of the order summary
        EditText date = findViewById(R.id.date);
        EditText flavor = findViewById(R.id.flavor);
        EditText quantity = findViewById(R.id.quantity);

        date.setText(this.date);
        flavor.setText(this.flavor);
        quantity.setText(this.quantity);


        Button cancel = findViewById(R.id.cancel);

        cancel.setOnClickListener(v -> {
                    Intent intent = new Intent(OrderSummary.this, MainActivity.class);
                    startActivity(intent);
                }

        );

        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareApp();
            }
        });


    }

    private void shareApp() {
        String shareMessage = "Check out this amazing app: https://play.google.com/store/apps/details?id=com.example.yourapp";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Share App via"));
    }
}