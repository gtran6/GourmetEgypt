package com.example.gourmetegypt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gourmetegypt.databinding.ActivityMainTestBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView = null;
    ImageView barcode;

    Fragment fragment;

    NavController navController = null;

    ActivityMainTestBinding activityMainTestBinding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainTestBinding = ActivityMainTestBinding.inflate(getLayoutInflater());

        setContentView(activityMainTestBinding.getRoot());

       /* drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        barcode = findViewById(R.id.barcode);*/

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(activityMainTestBinding.bottomNavigationView, navController);

        setSupportActionBar(activityMainTestBinding.toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle
                (this, activityMainTestBinding.drawerLayout, activityMainTestBinding.toolbar,
                        R.string.navigation_open, R.string.navigation_close);

        actionBarDrawerToggle.syncState();

        activityMainTestBinding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        activityMainTestBinding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        activityMainTestBinding.navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupActionBarWithNavController(this, navController, activityMainTestBinding.drawerLayout);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.layout1:
                fragment = new Layout1Fragment();
                Toast.makeText(this, "xmas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout2:
                fragment = new Layout2Fragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
        activityMainTestBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }
}