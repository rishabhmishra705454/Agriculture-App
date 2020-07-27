package com.rishabh.companyproject.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.companyproject.R;

public class AgrocabHistory extends AppCompatActivity {

    ImageView backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrocab_history);

        //hooks
        backPressed = findViewById(R.id.agrocab_back_pressed);

        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgrocabHistory.super.onBackPressed();
            }
        });
    }
}
