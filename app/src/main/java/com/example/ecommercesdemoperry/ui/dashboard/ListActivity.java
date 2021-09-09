package com.example.ecommercesdemoperry.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommercesdemoperry.R;
import com.example.ecommercesdemoperry.databinding.ActivityListBinding;
import com.example.ecommercesdemoperry.databinding.FragmentDashboardBinding;

public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String price = intent.getStringExtra("price");
            int imageId = intent.getIntExtra("imageId", R.drawable.hot_image);


        }

    }
}
