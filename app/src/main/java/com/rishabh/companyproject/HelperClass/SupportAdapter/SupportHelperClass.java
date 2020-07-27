package com.rishabh.companyproject.HelperClass.SupportAdapter;

import android.graphics.drawable.Drawable;

public class SupportHelperClass {
     int image;
    String title;
    Drawable gradient;

    public SupportHelperClass(int image,Drawable gradient, String title) {
        this.image = image;
        this.gradient = gradient;
        this.title = title;
    }

    public  int getImage() {
        return image;
    }

    public Drawable getGradient() {
        return gradient;
    }

    public String getTitle() {
        return title;
    }
}
