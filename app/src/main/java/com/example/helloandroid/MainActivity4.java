package com.example.helloandroid;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.helloandroid.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4); // Show the main layout for the CandyStore activity
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar); // Get a reference to toolbar
        setSupportActionBar(toolbar);  // Set the action bar to use the toolbar referenced by the toolbar reference
    }

    // onCreateOptionsMenu - initizliaes the menu with menu items from the menu layout
    // @param Menu - the menu to initizlize
    // @return boolean - true after the function completes
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu); // Initialize the menu items in this activity's menu
        return true;
    }

    // onOptionsItemSelected - Perform an action based on the menu selected
    // @param MenuItem - a reference to a menu item
    // @return boolean - true after a menu item is processed
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Log.w("MainActivity", "Add selected");
            return true;
        }
        else if (id == R.id.action_delete) {
            Log.w("MainActivity", "Delete selected");
            return true;
        }
        else if (id == R.id.action_update) {
            Log.w("MainActivity", "Update selected");
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}