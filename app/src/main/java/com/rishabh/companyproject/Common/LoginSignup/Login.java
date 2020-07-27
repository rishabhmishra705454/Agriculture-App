package com.rishabh.companyproject.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rishabh.companyproject.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabers_login);
    }

    //forget password

    public void callForgetPasswordScreen(View view){
        Intent intent=new Intent(getApplicationContext(),ForgetPassword.class);
        startActivity(intent);
    }
}
