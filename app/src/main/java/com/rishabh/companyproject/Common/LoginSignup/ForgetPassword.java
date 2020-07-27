package com.rishabh.companyproject.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rishabh.companyproject.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public void callForgetPasswordMakeSelection(View view){
        Intent intent=new Intent(getApplicationContext(),FPMakeSelection.class);
        startActivity(intent);
    }
}
