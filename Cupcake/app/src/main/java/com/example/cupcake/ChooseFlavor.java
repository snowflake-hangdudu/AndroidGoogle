package com.example.cupcake;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

public class ChooseFlavor extends AppCompatActivity {
    public String quantity;
    public String flavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_flavor);

        //接收数据
        quantity = getIntent().getStringExtra("quantity");
        flavor = "vanilla";


        Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flavor == null) {
                    System.out.println("flavor is null");
                    return;
                }
                Intent intent = new Intent(ChooseFlavor.this, ChoosePickupDate.class);
                intent.putExtra("flavor", flavor);
                intent.putExtra("quantity", quantity);
                startActivity(intent);

            }
        });


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        //监听单选按钮
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取选中的单选按钮的ID
                int selectedId = radioGroup.getCheckedRadioButtonId();
                //根据ID获取单选按钮
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                //设置按钮的值为true
                radioButton.setChecked(true);
                System.out.println("radioButton = " + radioButton.getText());
                flavor = radioButton.getText().toString();

            }

        });


    }
}