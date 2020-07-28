package com.rishabh.companyproject.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.rishabh.companyproject.Common.MainLoginSignup.MainLogin;
import com.rishabh.companyproject.Database.SessionManager;
import com.rishabh.companyproject.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER=5000;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime=onBoardingScreen.getBoolean("firstTime",true);

                if(isFirstTime){

                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent=new Intent(getApplicationContext(),OnBoardingScreen.class);
                    startActivity(intent);
                    finish();


                }

                else {

                    SessionManager sessionManager = new SessionManager(SplashScreen.this);
                    if (sessionManager.checkLogin() == true){

                        Intent intent=new Intent(getApplicationContext(), LocationPermission.class);
                        startActivity(intent);
                        finish();
                    } else {

                        Intent intent=new Intent(getApplicationContext(), MainLogin.class);
                        startActivity(intent);
                        finish();
                    }


                }

            }
        },SPLASH_TIMER);
    }
}
