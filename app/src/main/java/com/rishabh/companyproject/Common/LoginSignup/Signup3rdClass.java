package com.rishabh.companyproject.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rishabh.companyproject.R;

public class Signup3rdClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabers_signup3rd_class);
    }

    public void callOTPScreen(View view){
        Intent intent=new Intent(getApplicationContext(),VerifyOTP.class);
        startActivity(intent);
    }
}
