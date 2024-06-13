package com.example.bmi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView txvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        EditText edtHeight = findViewById(R.id.edtHeight);
        EditText edtWeight = findViewById(R.id.edtWeight);
        Button btnCalc = findViewById(R.id.btnCalc);
        Button btnClear = findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = edtHeight.getText().toString();
                String weightStr = edtWeight.getText().toString();

                if (isValidNumericInput(heightStr) && isValidNumericInput(weightStr)) {
                    double height = Double.parseDouble(heightStr);
                    double weight = Double.parseDouble(weightStr);

                    double bmi = weight / Math.pow(height / 100.0, 2);
                    if (bmi >= 24)
                        txvShow.setTextColor(Color.RED);
                    else if (bmi < 18.5)
                        txvShow.setTextColor(Color.BLUE);
                    else
                        txvShow.setTextColor(Color.GREEN);

                    txvShow.setText(String.format("%.2f", bmi));
                } else {
                    txvShow.setTextColor(Color.RED);
                    txvShow.setText("錯誤，請輸入數字");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText("0");
                edtWeight.setText("0");
                txvShow.setText("");
            }
        });
    }

    private boolean isValidNumericInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String regex = "^[0-9.]+$"; // 匹配數字和小數點
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
