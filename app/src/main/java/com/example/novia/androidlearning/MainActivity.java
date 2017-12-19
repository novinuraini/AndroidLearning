package com.example.novia.androidlearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.novia.androidlearning.R;
import android.widget.TextView;

/**
 * Created by novia on 19/12/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        TextView tvUsername =  (TextView) findViewById(R.id.tvUsername);

        String username = getIntent().getStringExtra("username");
        tvUsername.setText("INI USERNAME");
    }
}
