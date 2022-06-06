package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;


public class On_Configuration_Change_2_MainActivity extends AppCompatActivity {
    private final static int SPACING_VERTICAL = 50;
    private final static int SPACING_HORIZONTAL = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_configuration_change_2_activity_main);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        modifyLayout(configuration);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        modifyLayout(newConfig);
    }

    public void modifyLayout(Configuration newConfig) {
        Button b2 = (Button) findViewById(R.id.button2);
        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams)b2.getLayoutParams();
        Button b3 = (Button)findViewById(R.id.button3);
        ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams)b3.getLayoutParams();

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            params2.setMargins(0, SPACING_HORIZONTAL, 0, 0);
            params3.setMargins(0, SPACING_HORIZONTAL, 0, 0);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            params2.setMargins(0, SPACING_VERTICAL, 0, 0);
            params3.setMargins(0, SPACING_VERTICAL, 0, 0);
        }
    }
}