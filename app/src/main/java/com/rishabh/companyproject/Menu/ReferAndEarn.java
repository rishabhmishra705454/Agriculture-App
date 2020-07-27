package com.rishabh.companyproject.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.companyproject.R;

public class ReferAndEarn extends AppCompatActivity {

    ImageView backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_and_earn);

        //hooks
        backPressed = findViewById(R.id.refer_back_pressed);
        //function for back pressed

        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReferAndEarn.super.onBackPressed();
            }
        });
    }
}
