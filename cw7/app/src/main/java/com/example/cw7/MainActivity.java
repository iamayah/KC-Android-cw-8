package com.example.cw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
      ArrayList<Items> itemsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items i1 = new Items("chocolate", R.drawable.chocolate , 1);
        Items i2 = new Items("coffee" , R.drawable.coffee, 1);
        Items i3 = new Items("donut", R.drawable.donut, 1);
        Items i4 = new Items("cheese" , R.drawable.cheese, 2);

        itemsArrayList.add(i1);
        itemsArrayList.add(i2);
        itemsArrayList.add(i3);
        itemsArrayList.add(i4);


        itemAdapter itemAdapter = new itemAdapter(this, 0 , itemsArrayList);

        ListView ListView = findViewById(R.id.ListView);
        ListView.setAdapter(itemAdapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Items currentitem = itemsArrayList.get(i);
                Intent intent = new Intent(MainActivity.this , DetailsActivity.class);
                intent.putExtra("item", currentitem);
                startActivity(intent);
            }
        });
    }
}