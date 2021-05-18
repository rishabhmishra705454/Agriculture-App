package com.rishabh.companyproject.Services.Combine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.rishabh.companyproject.Database.SessionManager;
import com.rishabh.companyproject.Home.Notification;
import com.rishabh.companyproject.R;
import com.rishabh.companyproject.Services.MapActivity;

import java.util.HashMap;

public class CombineActivity extends AppCompatActivity {

    TextView text1 , text2 , text3 , text4 , text5;

    Button  mContinue;

    RelativeLayout mBackBtn;

    LottieAnimationView lodingAnimation;

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine);

        mBackBtn = findViewById(R.id.notification_back_btn);
        mContinue = findViewById(R.id.bookNowBtn);

       // lodingAnimation = findViewById(R.id.animationView);
       // final ProgressDialog pd = new ProgressDialog(CombineActivity.this);
        //pd.setMessage("loading");
        //lodingAnimation.setVisibility(View.VISIBLE);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CombineActivity.super.onBackPressed();
            }
        });

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CombineActivity.this , CombineDetailsActivity.class);
                startActivity(intent);
            }

        });



        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSession();
        //geting user detail from session
        String userPhoneno = userDetails.get(SessionManager.KEY_PHONENO);


        /*
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users").child(userPhoneno);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                    String name = dataSnapshot.child("fullName").getValue().toString();
                    String address = dataSnapshot.child("address").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();

                    text1.setText(name);
                    text2.setText(address);
                    text3.setText(email);

                     //Toast.makeText(CombineActivity.this, "DATA FETCHED", Toast.LENGTH_SHORT).show();
                    //UserDetails user = postSnapshot.getValue(UserDetails.class);
                   //String name = user.getFullName();

                    //text1.setText(name);


               pd.dismiss();


                //lodingAnimation.setVisibility(View.INVISIBLE);

                }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


         */
    }

  //  String name = dataSnapshot.child("fullName").getValue(String.class);

   // User user = dataSnapshot.getValue(User.class);
}