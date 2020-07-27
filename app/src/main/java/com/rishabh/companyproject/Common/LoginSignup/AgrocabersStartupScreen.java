package com.rishabh.companyproject.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.rishabh.companyproject.R;

public class AgrocabersStartupScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrocabers_startup_screen);


    }


    public void callLoginScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), Login.class);

        startActivity(intent);


    }

    public void callSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), SignUp.class);

        startActivity(intent);


    }

}
