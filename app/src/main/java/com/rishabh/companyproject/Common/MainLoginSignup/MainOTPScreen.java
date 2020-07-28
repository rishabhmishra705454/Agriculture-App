package com.rishabh.companyproject.Common.MainLoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.rishabh.companyproject.Common.LocationPermission;
import com.rishabh.companyproject.Database.SessionManager;
import com.rishabh.companyproject.Profile.UserProfile;
import com.rishabh.companyproject.R;

import java.util.concurrent.TimeUnit;

public class MainOTPScreen extends AppCompatActivity {
    PinView pinFromUser;

    String codeBySystem;
    TextView otpDescription, changeNumber;
    Button verifyOtp;


    ProgressBar progressBar;
    String userPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_o_t_p_screen);

        //hooks
        pinFromUser = findViewById(R.id.main_pin_view);
        otpDescription = findViewById(R.id.main_text_description);
        verifyOtp = findViewById(R.id.main_verify_otp);
        progressBar = findViewById(R.id.otp_screen_progress_bar);
        changeNumber = findViewById(R.id.change_number);
        //calling login screen from change number
        changeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
                finish();
            }
        });

        progressBar.setVisibility(View.GONE);


        userPhoneNo = getIntent().getStringExtra("phoneNo");

        otpDescription.setText("Enter One Time Password Sent on " + userPhoneNo);

        //functions
        sendVerificationCodeToUser(userPhoneNo);

        verifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = pinFromUser.getText().toString();

                if (code.isEmpty() || code.length() < 6) {
                    pinFromUser.setError("Wrong Otp...");
                    pinFromUser.requestFocus();
                    return;
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    verifyCode(code);
                }
            }
        });
    }

    // firebase phone authentication codes
    private void sendVerificationCodeToUser(String phoneNo) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNo,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    if (code != null) {
                        progressBar.setVisibility(View.VISIBLE);
                        pinFromUser.setText(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(MainOTPScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };


    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            isUser();

                            //Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            //intent.putExtra("phoneNo", phoneNo);
                            //startActivity(intent);


                        } else {

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(MainOTPScreen.this, "Verification Not Completed! Try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    //Checking user already exists or not

    private void isUser() {


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUser = reference.orderByChild("phoneNo").equalTo(userPhoneNo);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    //geting user data from firebase database
                    String fullNameFromDB = snapshot.child(userPhoneNo).child("fullName").getValue(String.class);
                    String mobileNoFromDB = snapshot.child(userPhoneNo).child("phoneNo").getValue(String.class);
                    String emailFromDB = snapshot.child(userPhoneNo).child("email").getValue(String.class);
                    String pinCodeFromDB = snapshot.child(userPhoneNo).child("pinCode").getValue(String.class);
                    String addressFromDB = snapshot.child(userPhoneNo).child("address").getValue(String.class);

                    //creating sessions

                    SessionManager sessionManager = new SessionManager(MainOTPScreen.this);
                    sessionManager.createLoginSession(fullNameFromDB, mobileNoFromDB, emailFromDB, pinCodeFromDB, addressFromDB);


                    Intent intent = new Intent(getApplicationContext(), LocationPermission.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    //Intent intent= new Intent(getApplicationContext(), Dashboard.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //intent.putExtra("fullname",fullNameFromDB);
                    //startActivity(intent);
                    //finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("phoneNo", userPhoneNo);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    //storing data in firebase realtime database


}
