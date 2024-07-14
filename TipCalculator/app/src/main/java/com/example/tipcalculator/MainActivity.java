package com.example.tipcalculator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText bill;
    private EditText tip;
    private Switch round;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 账单金额输入框
        bill = findViewById(R.id.bill);

        // 小费比例输入框
        tip = findViewById(R.id.tip);

        // 是否四舍五入
        round = findViewById(R.id.round);

        // 结果显示框
        result = findViewById(R.id.result);

        // 当bill和tip输入框有输入时，计算小费金额并显示在result中
        bill.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                result.setText("Tip Amount: 计算中...");
            }
        });
        tip.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                result.setText("Tip Amount: 计算中...");
            }
        });

        // 添加文本变化监听器
        bill.addTextChangedListener(textWatcher);
        tip.addTextChangedListener(textWatcher);

        // 添加Switch状态变化监听器
        round.setOnCheckedChangeListener((buttonView, isChecked) -> calculateTip());
    }

    // 监听bill和tip和round的输入变化
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            calculateTip();
        }
    };

    private void calculateTip() {
        String billText = bill.getText().toString();
        String tipText = tip.getText().toString();

        if (!billText.isEmpty() && !tipText.isEmpty()) {
            try {
                double billAmount = Double.parseDouble(billText);
                double tipPercentage = Double.parseDouble(tipText);
                double tipAmount = billAmount * (tipPercentage / 100);

                // 判断是否需要四舍五入
                if (round.isChecked()) {
                    tipAmount = Math.round(tipAmount);
                    result.setText(String.format("Tip Amount:$ %.0f", tipAmount));  // 保留整数
                } else {
                    result.setText(String.format("Tip Amount:$ %.2f", tipAmount));  // 保留两位小数
                }
            } catch (NumberFormatException e) {
                result.setText("Invalid input");
            }
        }
    }
}
