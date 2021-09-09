package com.example.ecommercesdemoperry.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ecommercesdemoperry.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Item> {


    public ListAdapter(Context context, ArrayList<Item> userArrayList){

        super(context, R.layout.list_item ,userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Item item = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView userName = convertView.findViewById(R.id.itemName);
        TextView itemDesc = convertView.findViewById(R.id.itemDesc);
        TextView itemPrice = convertView.findViewById(R.id.itemPrice);

        imageView.setImageResource(item.imageId);
        userName.setText(item.name);
        itemDesc.setText(item.description);
        itemPrice.setText(item.price);


        return convertView;
    }
}
