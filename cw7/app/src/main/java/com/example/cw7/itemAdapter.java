package com.example.cw7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class itemAdapter extends ArrayAdapter {
    List <Items> itemsList;
    public itemAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        itemsList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      View view = LayoutInflater.from(getContext()).inflate(R.layout.itemrow, parent, false);

      Items item =itemsList.get(position);

        TextView itemname = view.findViewById(R.id.itamename);
        TextView itemprice = view.findViewById(R.id.itemprice);
        ImageView itemimage = view.findViewById(R.id.itemimage);


        itemname.setText(item.getItemName());
        itemprice.setText(item.getItemPrice() + "");
        itemimage.setImageResource(item.getItemImage());


        ImageView deletebtn = view.findViewById(R.id.bin);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            Items removeditem = itemsList.get(position);
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setMessage("u sure u wanna delete that?:)")
                        .setTitle("CONFIRMATION").setPositiveButton("yes delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                itemsList.remove(removeditem);
                                notifyDataSetChanged();
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                builder.show();
            }
        });





        return view;
    }
}
