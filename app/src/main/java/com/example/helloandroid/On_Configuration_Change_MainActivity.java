package com.example.helloandroid;

import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class On_Configuration_Change_MainActivity extends AppCompatActivity {
    private final static String MA = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        modifyLayout(configuration);
//        SinglyLinkedList list = new SinglyLinkedList();
//        for (int i = 0; i < 1000000000; i++) {
//            list.insert(i);
//        }
//
//        list.print();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        modifyLayout(newConfig);
        Log.w("MainActivity", "Height: " + newConfig.screenHeightDp);
        Log.w(MA, "Width: " + newConfig.screenWidthDp);

        Log.w("MainActivity", "Orientation: " + newConfig.orientation);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Log.w("MainActivity", "Horizontal position");
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Log.w("MainActivity", "Vertical position");
        else
            Log.w("MainActivity", "Undetermined position");
    }

    private void modifyLayout(Configuration configuration) {
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.on_configuration_change_activity_main);
        }
        else {
            setContentView(R.layout.activity_main6_landscape);
        }
    }

/*
    class SinglyLinkedList {
        private Node first;
        private int size;

        public SinglyLinkedList() {
            first = null;
            size = 0;
        }

        public void insert(int data) {
            Node node = new Node(data);
            node.setLink(first);
            first = node;
            size++;
        }

        public void print() {
            Node current = first;
            while (current != null) {
                Log.w("MainActivity", "Data: " + current.getData());
                current = current.getLink();
            }
        }
    }*/
}