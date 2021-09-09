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

        Item user = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView userName = convertView.findViewById(R.id.itemName);
        TextView lastMsg = convertView.findViewById(R.id.itemDesc);
        TextView time = convertView.findViewById(R.id.itemPrice);

        imageView.setImageResource(user.imageId);
        userName.setText(user.name);
        lastMsg.setText(user.description);
        time.setText(user.price);


        return convertView;
    }
}
