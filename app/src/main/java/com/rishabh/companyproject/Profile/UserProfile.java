package com.rishabh.companyproject.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.companyproject.Common.LocationPermission;
import com.rishabh.companyproject.Database.SessionManager;
import com.rishabh.companyproject.Database.UserHelperClass;
import com.rishabh.companyproject.R;

public class UserProfile extends AppCompatActivity {

    TextInputLayout profileFirstName, profilePhoneNo, profileEmail, profilePinCode, profileAddress;

    String fullName, phoneNo, email, pinCode, address;
    TextInputEditText phoneNumber;
    String userphoneNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileFirstName = findViewById(R.id.profile_full_name);
        profilePhoneNo = findViewById(R.id.profile_phone_no);
        profileEmail = findViewById(R.id.profile_email);
        profilePinCode = findViewById(R.id.profile_pincode);
        profileAddress = findViewById(R.id.profile_address);


        phoneNumber = findViewById(R.id.prodile_input_phoneno);

        userphoneNo = getIntent().getStringExtra("phoneNo");
        phoneNumber.setText(userphoneNo);



    }

    public void callProfileToDashboard(View view) {

        if (!validateFullName() | !validateEmail() | !validatePinCode() | !validateAddress()) {
            return;
        }

        fullName = profileFirstName.getEditText().getText().toString();
        phoneNo = profilePhoneNo.getEditText().getText().toString();
        email = profileEmail.getEditText().getText().toString().trim();
        pinCode = profilePinCode.getEditText().getText().toString().trim();
        address = profileAddress.getEditText().getText().toString().trim();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Users");

        UserHelperClass addData = new UserHelperClass(fullName, phoneNo, email, pinCode, address);

        reference.child(phoneNo).setValue(addData);

        //Intent intent = new Intent(getApplicationContext(), Dashboard.class);


        // Read from the database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String fullNameFromDB = snapshot.child(userphoneNo).child("fullName").getValue(String.class);
                String mobileNoFromDB = snapshot.child(userphoneNo).child("phoneNo").getValue(String.class);
                String emailFromDB = snapshot.child(userphoneNo).child("email").getValue(String.class);
                String pinCodeFromDB = snapshot.child(userphoneNo).child("pinCode").getValue(String.class);
                String addressFromDB = snapshot.child(userphoneNo).child("address").getValue(String.class);

                //creating sessions

                SessionManager sessionManager = new SessionManager(UserProfile.this);
                sessionManager.createLoginSession( fullNameFromDB , mobileNoFromDB , emailFromDB , pinCodeFromDB , addressFromDB );

                Intent intent = new Intent(getApplicationContext(), LocationPermission.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onCancelled(DatabaseError error) {

                // Failed to read value
                Toast.makeText(UserProfile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    //validation function
    private boolean validateFullName() {

        String val = profileFirstName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            profileFirstName.setError("Please enter full name");
            return false;
        } else {
            profileFirstName.setError(null);
            profileFirstName.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateEmail() {

        String val = profileEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            profileEmail.setError("Please enter email");
            return false;
        } else if (!val.matches(checkEmail)) {
            profileEmail.setError("Invalid email!");
            return false;
        } else {
            profileEmail.setError(null);
            profileEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePinCode() {
        String val = profilePinCode.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            profilePinCode.setError("Please enter pin code");
            return false;
        } else if (val.length() < 6) {
            profilePinCode.setError("Please enter correct pincode");
            return false;
        } else {
            profilePinCode.setError(null);
            profilePinCode.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateAddress() {

        String val = profileAddress.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            profileAddress.setError("Please enter your address");
            return false;
        } else {
            profileAddress.setError(null);
            profileAddress.setErrorEnabled(false);
            return true;
        }

    }

}
