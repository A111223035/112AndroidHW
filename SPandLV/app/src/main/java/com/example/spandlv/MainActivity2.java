package com.example.spandlv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 获取传递的数据
        Intent intent = getIntent();
        String mainSelection = intent.getStringExtra("mainSelection");
        String sideSelection = intent.getStringExtra("sideSelection");
        String drinkSelection = intent.getStringExtra("drinkSelection");

        // 显示数据
        TextView txvMainShow = findViewById(R.id.txvMainShow);
        TextView txvSideShow = findViewById(R.id.txvSideShow);
        TextView txvDrinkShow = findViewById(R.id.txvDrinkShow);

        txvMainShow.setText(mainSelection);
        txvSideShow.setText(sideSelection);
        txvDrinkShow.setText(drinkSelection);
    }
}
