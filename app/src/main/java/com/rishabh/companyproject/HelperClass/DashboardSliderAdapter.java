package com.rishabh.companyproject.HelperClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.rishabh.companyproject.R;

public class DashboardSliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public DashboardSliderAdapter(Context context) {
        this.context = context;
    }


    int images[] = {

            R.drawable.payment_image,
            R.drawable.pay_money_image,
            R.drawable.map_tracking_image,
            R.drawable.earn_money_image
    };


    int headings[] = {

            R.string.slider_title1,
            R.string.slider_title2,
            R.string.slider_title3,
            R.string.slider_title4
    };


    int descriptions[] = {

            R.string.slider_description_1,
            R.string.slider_description_2,
            R.string.slider_description_3,
            R.string.slider_description_4
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.main_slide_layout, container, false);

        //hooks


        ImageView imageView = view.findViewById(R.id.main_slide_image);
        TextView heading = view.findViewById(R.id.main_slider_title);
        TextView desc = view.findViewById(R.id.main_slide_desc);


        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

}
