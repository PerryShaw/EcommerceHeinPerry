package com.example.ecommercesdemoperry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.ecommercesdemoperry.ui.dashboard.DashboardFragment;
import com.example.ecommercesdemoperry.ui.dashboard.Item;
import com.example.ecommercesdemoperry.ui.dashboard.ListActivity;
import com.example.ecommercesdemoperry.ui.dashboard.ListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ecommercesdemoperry.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int[] imageId = {R.drawable.hot_image,R.drawable.hot_image_2png,R.drawable.hot_image};
        String[] name = {"Item 1","Item 2","Item 3"};
        String[] desc = {"Item description","Item description","Item description"};
        String[] price = {"8:45 pm","9:00 am","7:34 pm"};


        ArrayList<Item> itemArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            Item item = new Item(name[i],desc[i],price[i],imageId[i]);
            itemArrayList.add(item);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,itemArrayList);

        binding.itemListView.setAdapter(listAdapter);
        binding.itemListView.setClickable(true);
        binding.itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, ListActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("description",desc[position]);
                i.putExtra("price",price[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}