package com.rishabh.companyproject.Common.MainLoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.rishabh.companyproject.R;

public class MainLogin extends AppCompatActivity {

    TextInputLayout phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        //hooks
        phoneNumber = findViewById(R.id.main_phone_no);
    }

    //calling next activity

    public void callVerifyOTPScreen(View view) {
        //validate field
        if (!validatePhoneNumber()){
            return;
        }  //Validation Succed and now move to verify phone number and save data




        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = _getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), MainOTPScreen.class);
        //pass all data to next activity
        intent.putExtra("phoneNo", _phoneNo);
        startActivity(intent);
    }


    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        }else if (val.length() < 10){
            phoneNumber.setError("Please enter correct number");
            return false;
        }
        else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }

}
