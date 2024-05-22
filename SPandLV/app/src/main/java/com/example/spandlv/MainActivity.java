package com.example.spandlv;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private TextView txvMainShow, txvSideShow, txvDrinkShow;
    private ArrayAdapter<String> spinnerAdapter;
    private ArrayAdapter<String> listViewAdapter;

    private String[][] listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化视图
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        txvMainShow = findViewById(R.id.txvMainShow);
        txvSideShow = findViewById(R.id.txvSideShow);
        txvDrinkShow = findViewById(R.id.txvDrinkShow);

        // 设置 Spinner 的适配器
        String[] spinnerItems = getResources().getStringArray(R.array.spinner_items);
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        // 加载 ListView 的选项数据
        listViewItems = new String[][]{
                getResources().getStringArray(R.array.list_items_option_1),
                getResources().getStringArray(R.array.list_items_option_2),
                getResources().getStringArray(R.array.list_items_option_3)
        };

        // 设置 ListView 的适配器
        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(listViewAdapter);

        // 监听 Spinner 的选择事件并更新 ListView
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateListView(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // 监听 ListView 的点击事件并更新 TextView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateTextView(spinner.getSelectedItemPosition(), listViewItems[spinner.getSelectedItemPosition()][position]);
            }
        });
    }

    // 更新 ListView 中的数据
    private void updateListView(int position) {
        listViewAdapter.clear();
        for (String item : listViewItems[position]) {
            listViewAdapter.add(item);
        }
        listViewAdapter.notifyDataSetChanged();
    }

    // 更新 TextView 中的数据
    private void updateTextView(int spinnerPosition, String selectedItem) {
        switch (spinnerPosition) {
            case 0:
                txvMainShow.setText(selectedItem);
                break;
            case 1:
                txvSideShow.setText(selectedItem);
                break;
            case 2:
                txvDrinkShow.setText(selectedItem);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 加载菜单资源文件
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String mainSelection;
        String sideSelection;
        String drinkSelection;

        mainSelection = txvMainShow.getText().toString();
        sideSelection = txvSideShow.getText().toString();
        drinkSelection = txvDrinkShow.getText().toString();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("mainSelection", mainSelection);
        intent.putExtra("sideSelection", sideSelection);
        intent.putExtra("drinkSelection", drinkSelection);
        startActivity(intent);

        return false;
    }
}


