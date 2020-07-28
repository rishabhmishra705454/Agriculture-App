package com.rishabh.companyproject.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rishabh.companyproject.Database.SessionManager;
import com.rishabh.companyproject.Home.Dashboard;
import com.rishabh.companyproject.R;
import com.rishabh.companyproject.Services.MapActivity;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {

    TextView userFullName;
    RelativeLayout userOffer;

    EditText userPhoneNo,userEmail,userPincode,userAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this,R.color.white));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //hooks
        userFullName = findViewById(R.id.user_fullname);
        userPhoneNo =findViewById(R.id.user_phone_no);
        userEmail = findViewById(R.id._user_email);
        userPincode = findViewById(R.id.user_pincode);
        userAddress = findViewById(R.id.user_address);

        userOffer = findViewById(R.id.profile_offer);

        //calling userOffer Screen
        userOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReferAndEarn.class);
                startActivity(intent);
            }
        });



        //getting session
        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSession();

        String fullName = userDetails.get(SessionManager.KEY_FULLNAME);
        String phoneNo = userDetails.get(SessionManager.KEY_PHONENO);
        String email = userDetails.get(SessionManager.KEY_EMAIL);
        String pincode = userDetails.get(SessionManager.KEY_PINCODE);
        String address = userDetails.get(SessionManager.KEY_ADDRESS);


        userFullName.setText(fullName);
        userPhoneNo.setText(phoneNo);
        userEmail.setText(email);
        userPincode.setText(pincode);
        userAddress.setText(address);


        //Initialize and asign varialble

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Set home selected

        bottomNavigationView.setSelectedItemId(R.id.menu);

        //perform item selectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                , Dashboard.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.service:
                        startActivity(new Intent(getApplicationContext()
                                , MapActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu:
                        return true;


                }
                return false;
            }
        });
    }
}