package com.rishabh.companyproject.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rishabh.companyproject.HelperClass.SupportAdapter.SupportAdapter;
import com.rishabh.companyproject.HelperClass.SupportAdapter.SupportHelperClass;
import com.rishabh.companyproject.R;

import java.util.ArrayList;

public class Support extends AppCompatActivity {

    RecyclerView supportRecycler;
    RecyclerView.Adapter adapter;

    ImageView backBtn;

    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_support);

        //hooks
        supportRecycler =findViewById(R.id.support_recycler);
        backBtn = findViewById(R.id.support_back_pressed);
        // support Back Button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Support.super.onBackPressed();
            }
        });
        //function
        supportRecycler();
    }
  //Support recycler view
    private void supportRecycler() {
        supportRecycler.setHasFixedSize(true);
        supportRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<SupportHelperClass> supportLocations = new ArrayList<>();
        supportLocations.add(new SupportHelperClass(R.drawable.rocket_icon,gradient1 ,"Billing and\n Payment"));
        supportLocations.add(new SupportHelperClass(R.drawable.rocket_icon,gradient2 ,"Refer and\n Earn"));
        supportLocations.add(new SupportHelperClass(R.drawable.rocket_icon, gradient3,"About\n Agrocabs"));

        adapter = new SupportAdapter(supportLocations);
        supportRecycler.setAdapter(adapter);


    }


}
