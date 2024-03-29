package com.example.shoppinglist;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentMain fragmentMain = new FragmentMain();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, fragmentMain)
                .commit();

    }
}
