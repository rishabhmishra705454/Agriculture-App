package com.rishabh.companyproject.Home.MachineApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputLayout;
import com.rishabh.companyproject.R;

public class MachineOwnerApplyPage1 extends AppCompatActivity {

    RelativeLayout topBar;
    TextInputLayout firstName, lastName, phoneNumber, areaPinCode, address;

    ImageView backPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_owner_apply_page1);

        //hooks
        topBar = findViewById(R.id.page_top_bar);
        firstName = findViewById(R.id.detail_first_name);
        lastName = findViewById(R.id.detail_last_name);
        phoneNumber = findViewById(R.id.detail_phone_no);
        areaPinCode = findViewById(R.id.detail_pin_code);
        address = findViewById(R.id.detail_address);


        backPressed = findViewById(R.id.partner_page1_back_btn);

        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MachineOwnerApplyPage1.super.onBackPressed();
            }
        });
    }

    public void callMachineOwnerApplyPage2(View view) {

       // if(!isConnected(this)){
         //   showCustomDialog();
       // }

        if (!validateFirstName() | !validateLastName() | !validatePhoneNumber() | !validatePinCode() | !validateAddress() ){
            return;
        }

        String getFirstName = firstName.getEditText().getText().toString();
        String getLastName = lastName.getEditText().getText().toString();
        String ownerPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String getPinCode = areaPinCode.getEditText().getText().toString().trim();
        String getAddress = address.getEditText().getText().toString();

        String getPhoneNumber = "+91 " + ownerPhoneNumber;


        Intent intent = new Intent(getApplicationContext(), MachineOwnerApplyPage2.class);
        intent.putExtra("firstName", getFirstName);
        intent.putExtra("lastName", getLastName);
        intent.putExtra("phoneNumber", getPhoneNumber);
        intent.putExtra("pinCode", getPinCode);
        intent.putExtra("address", getAddress);

        //Add transition

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(topBar, "transition_top_bar");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MachineOwnerApplyPage1.this, pairs);
        startActivity(intent, options.toBundle());

    }

    // Checking internet Connection
    //private boolean isConnected(MachineOwnerApplyPage1 machineOwnerApplyPage1) {

       // ConnectivityManager connectivityManager = (ConnectivityManager) machineOwnerApplyPage1.getSystemService(Context.CONNECTIVITY_SERVICE);

      //  NetworkInfo activeNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    //}


    //validation function
    private boolean validateFirstName() {

        String val = firstName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            firstName.setError("Please enter first name");
            return false;
        } else {
            firstName.setError(null);
            firstName.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateLastName() {

        String val = lastName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            lastName.setError("Please enter last name");
            return false;
        } else {
            lastName.setError(null);
            lastName.setErrorEnabled(false);
            return true;
        }

    }


    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            phoneNumber.setError("Please enter phone number");
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

    private boolean validatePinCode() {
        String val = areaPinCode.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            areaPinCode.setError("Please enter pin code");
            return false;
        }else if (val.length() < 6){
            areaPinCode.setError("Please enter correct pincode");
            return false;
        }
        else {
            areaPinCode.setError(null);
            areaPinCode.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateAddress() {

        String val = address.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            address.setError("Please enter your address");
            return false;
        } else {
            address.setError(null);
            address.setErrorEnabled(false);
            return true;
        }

    }






}
