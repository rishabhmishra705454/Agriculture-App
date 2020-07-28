package com.rishabh.companyproject.Home.MachineApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.companyproject.Home.Dashboard;
import com.rishabh.companyproject.R;

public class MachineOwnerApplySuccess extends AppCompatActivity {

    ImageView callDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_owner_apply_success);

        callDashboard = findViewById(R.id.partner_success_close);

        callDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void callHomeFromPartnerSuccess(View view){
        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
        startActivity(intent);
        finish();
    }
}
