package com.rishabh.companyproject.User.MachineOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.companyproject.R;

public class PartnerStartupPage extends AppCompatActivity {

    ImageView backPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_startup_page);
    }
    public void callMachineOwnerApplyPage1(View view){
        Intent intent = new Intent(getApplicationContext(),MachineOwnerApplyPage1.class);
        startActivity(intent);

        backPressed = findViewById(R.id.partner_back_btn);

        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PartnerStartupPage.super.onBackPressed();
            }
        });
    }
}
