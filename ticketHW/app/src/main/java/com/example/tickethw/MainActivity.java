package com.example.tickethw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取对应的控件
        final TextView output = findViewById(R.id.lblOutput);
        Button btnChoose = findViewById(R.id.btnChoose);
        Button btnSure = findViewById(R.id.btnSure);

        // btnChoose 的点击事件处理
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户选择的性别
                RadioButton boy = findViewById(R.id.rdbBoy);
                RadioButton girl = findViewById(R.id.rdbGirl);
                String gender = "";
                if (boy.isChecked())
                    gender = getResources().getString(R.string.male);
                else if (girl.isChecked())
                    gender = getResources().getString(R.string.female);

                // 获取用户选择的票种
                RadioButton adultTicket = findViewById(R.id.rdbAldult);
                RadioButton childTicket = findViewById(R.id.rdbChild);
                RadioButton studentTicket = findViewById(R.id.rdbStudent);
                String ticketType = "";
                if (adultTicket.isChecked())
                    ticketType = getResources().getString(R.string.regularticket);
                else if (childTicket.isChecked())
                    ticketType = getResources().getString(R.string.childticket);
                else if (studentTicket.isChecked())
                    ticketType = getResources().getString(R.string.studentticket);

                // 获取用户输入的票数
                EditText txtName = findViewById(R.id.txtName);
                int ticketCount = Integer.parseInt(txtName.getText().toString());

                // 计算票价
                double price = 0;
                if (adultTicket.isChecked())
                    price = ticketCount * 100;
                else if (childTicket.isChecked())
                    price = ticketCount * 50;
                else if (studentTicket.isChecked())
                    price = ticketCount * 80;

                // 构建显示信息
                String outputStr = "性別：" + gender + "\n" +
                        "票種：" + ticketType + "\n" +
                        "張數：" + ticketCount + "\n" +
                        "價格：" + price + "元\n";

                // 在 lblOutput 中显示信息
                output.setText(outputStr);

                // 启动 MainActivity2，并传递信息
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("output", outputStr);
                startActivity(intent);
            }
        });

        // btnSure 的点击事件处理
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动 MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
