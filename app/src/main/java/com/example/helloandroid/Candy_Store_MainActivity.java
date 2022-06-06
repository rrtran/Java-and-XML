package com.example.helloandroid;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Candy_Store_MainActivity extends AppCompatActivity {
    private DatabaseManager dbManager;
    private double total;
    private ScrollView scrollView;
    private int buttonWidth;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candy_store_activity_main); // Show the main layout for the CandyStore activity
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar); // Get a reference to toolbar
        setSupportActionBar(toolbar);  // Set the action bar to use the toolbar referenced by the toolbar reference
        dbManager = new DatabaseManager(this);
        total = 0.0;
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        buttonWidth = size.x / 2;
        updateView();
    }

    public void onResume() {
        super.onResume();
        updateView();
    }

    public void updateView() {
        ArrayList<Candy> candies = dbManager.selectAll();
        if (candies.size() > 0) {
            // remove subviews inside scrollView if necessary
            scrollView.removeAllViewsInLayout();

            // set up the grid layout
            GridLayout grid = new GridLayout(this);
            grid.setRowCount((candies.size() + 1) / 2);
            grid.setColumnCount(2);

            // create array buttons, 2 per row
            CandyButton[] buttons = new CandyButton[candies.size()];
            ButtonHandler buttonHandler = new ButtonHandler();

            // fill the grid
            int i = 0;
            for (Candy candy : candies) {

                // create the button
                buttons[i] = new CandyButton(this, candy);
                buttons[i].setText(candy.getName() + "\n" + candy.getPrice());

                // set up event handling
                buttons[i].setOnClickListener(buttonHandler);

                // add the button to grid
                grid.addView(buttons[i], buttonWidth, GridLayout.LayoutParams.WRAP_CONTENT);
                i++;
            }
            scrollView.addView(grid);
        }
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
            Intent intent = new Intent(this, InsertActivity.class);
            this.startActivity(intent);
            return true;
        }
        else if (id == R.id.action_delete) {
            Log.w("MainActivity", "Delete selected");
            Intent intent = new Intent(this, DeleteActivity.class);
            this.startActivity(intent);
            return true;
        }
        else if (id == R.id.action_update) {
            Log.w("MainActivity", "Update selected");
            Intent intent = new Intent(this, UpdateActivity.class);
            this.startActivity(intent);
            return true;
        }
        else if (id == R.id.action_reset) {
            total = 0.0;
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    private class ButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // retrieve price of the candy and add it to total
            total += ((CandyButton) v).getPrice();
            String pay = NumberFormat.getCurrencyInstance().format(total);
            Toast.makeText(Candy_Store_MainActivity.this, pay, Toast.LENGTH_LONG).show();
        }
    }
}