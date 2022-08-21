package com.example.cw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        Items deliveritem = (Items) bundle.getSerializable("item");


        TextView itemname = findViewById(R.id.itemtextview);
        ImageView itemphoto = findViewById(R.id.itemimageview);
        TextView itemprice = findViewById(R.id.itempricee);

        itemname.setText(deliveritem.getItemName());
        itemphoto.setImageResource(deliveritem.getItemImage());
        itemprice.setText(String.valueOf(deliveritem.getItemPrice()));
    }
}