package com.example.helloandroid;

import android.os.Bundle;

public class DataActivity extends androidx.appcompat.app.AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_data);
    }

    public void goBack(android.view.View v) {
        this.finish();
    }
}
