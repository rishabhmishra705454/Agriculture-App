package com.rishabh.companyproject.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.companyproject.R;

public class PaymentsHistory extends AppCompatActivity {
    ImageView backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_history);

        //hooks
        backPressed = findViewById(R.id.payment_back_pressed);

        //back function
        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentsHistory.super.onBackPressed();
            }
        });
    }
}
