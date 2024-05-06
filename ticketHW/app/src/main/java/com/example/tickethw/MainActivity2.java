package com.example.tickethw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String outputStr = getIntent().getStringExtra("output");


        TextView outputTextView = findViewById(R.id.lblOutput);
        outputTextView.setText(outputStr);
    }
}
