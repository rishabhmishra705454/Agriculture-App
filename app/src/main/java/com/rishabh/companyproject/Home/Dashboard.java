package com.rishabh.companyproject.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rishabh.companyproject.HelperClass.DashboardSliderAdapter;
import com.rishabh.companyproject.HelperClass.SupportAdapter.SupportAdapter;
import com.rishabh.companyproject.HelperClass.SupportAdapter.SupportHelperClass;
import com.rishabh.companyproject.Services.MapActivity;
import com.rishabh.companyproject.Profile.MenuActivity;
import com.rishabh.companyproject.R;
import com.rishabh.companyproject.Home.MachineApplication.PartnerStartupPage;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ImageView notification;

    ViewPager viewPager;
    LinearLayout dotsLayout;

    DashboardSliderAdapter sliderAdapter;
    TextView[] dots;

    int currentPos;

    //recycler view
    RecyclerView supportRecycler;
    RecyclerView.Adapter adapter;

    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(Dashboard.this,R.color.white));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //hooks
        notification = findViewById(R.id.notification);


        viewPager=findViewById(R.id.dashboard_slider);
        dotsLayout=findViewById(R.id.slider_dots);

        //recycler view
        supportRecycler =findViewById(R.id.support_recycler);


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Notification.class);
                startActivity(intent);
            }
        });
        //call adapter
        sliderAdapter=new DashboardSliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);


        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);


        //Initialize and asign varialble

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Set home selected

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        //perform item selectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        return true;

                    case R.id.service:
                        startActivity(new Intent(getApplicationContext()
                                , MapActivity.class));
                        finish();
                        overridePendingTransition(0,0);

                        return true;

                    case R.id.menu:
                        startActivity(new Intent(getApplicationContext()
                                , MenuActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

        //function
        supportRecycler();

    }

    private void supportRecycler() {
        supportRecycler.setHasFixedSize(true);
        supportRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<SupportHelperClass> supportLocations = new ArrayList<>();
        supportLocations.add(new SupportHelperClass(R.drawable.payment_icon,gradient1 ,"Billing and\n Payment"));
        supportLocations.add(new SupportHelperClass(R.drawable.payment_icon,gradient2 ,"Refer and\n Earn"));
        supportLocations.add(new SupportHelperClass(R.drawable.payment_icon, gradient3,"About\n Agrocabs"));

        adapter = new SupportAdapter(supportLocations);
        supportRecycler.setAdapter(adapter);
    }


    private void addDots(int position){

        dots =new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);
            currentPos=position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    // calling startup screen

    public void callPartnerPage(View view){
        Intent intent  = new Intent(getApplicationContext(), PartnerStartupPage.class);
        startActivity(intent);
    }

    public void callServicePage(View view){
        Intent intent = new Intent(getApplicationContext(),MapActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }


}
