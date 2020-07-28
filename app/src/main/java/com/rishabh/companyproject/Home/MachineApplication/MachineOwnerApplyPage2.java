package com.rishabh.companyproject.Home.MachineApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rishabh.companyproject.Database.MachineOwnerHelperClass;
import com.rishabh.companyproject.R;

public class MachineOwnerApplyPage2 extends AppCompatActivity {
    RelativeLayout topBar;

    TextInputLayout adharNumber,ownerMachineName;

    ImageView backPressed;

    String firstName,lastName,phoneNo,areaPinCode,address,adharNo,machineName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_owner_apply_page2);
        topBar = findViewById(R.id.page_top_bar);

        adharNumber = findViewById(R.id.detail_adhar_number);
        ownerMachineName = findViewById(R.id.detail_machinary);
        backPressed = findViewById(R.id.partner_page2_back_btn);

        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MachineOwnerApplyPage2.super.onBackPressed();
            }
        });


        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        phoneNo = getIntent().getStringExtra("phoneNumber");
        areaPinCode = getIntent().getStringExtra("pinCode");
        address = getIntent().getStringExtra("address");


    }

    public void callMachineOwnerApplySuccess(View view){

        if (!validateAdharNumber() | !validateMichinary()) {

            return;
        }

        adharNo = adharNumber.getEditText().getText().toString().trim();
        machineName = ownerMachineName.getEditText().getText().toString().trim();


        //reference.child(phoneNo).setValue(addNew);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("MachineApplication");

        MachineOwnerHelperClass addNew = new MachineOwnerHelperClass(firstName,lastName,phoneNo,areaPinCode,address,adharNo,machineName);
        reference.child(phoneNo).setValue(addNew);


        Intent intent = new Intent(getApplicationContext(),MachineOwnerApplySuccess.class);

        startActivity(intent);
        finish();

    }

    private boolean validateAdharNumber() {
        String val = adharNumber.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            adharNumber.setError("Please enter Aadhar number");
            return false;
        }else if (val.length() < 12){
            adharNumber.setError("Please enter Aadhar correct number");
            return false;
        }
        else {
            adharNumber.setError(null);
            adharNumber.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateMichinary() {

        String val = ownerMachineName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            ownerMachineName.setError("Please enter your Machine Name");
            return false;
        } else {
            ownerMachineName.setError(null);
            ownerMachineName.setErrorEnabled(false);
            return true;
        }

    }
}