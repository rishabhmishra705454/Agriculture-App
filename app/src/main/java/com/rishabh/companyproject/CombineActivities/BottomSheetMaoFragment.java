package com.rishabh.companyproject.CombineActivities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.card.MaterialCardView;
import com.rishabh.companyproject.R;


public class BottomSheetMaoFragment extends Fragment {

    Button chooseServices;
    MaterialCardView sellingCrop;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_mao, container, false);
/*
        //hooks
        chooseServices = view.findViewById(R.id.choose_services_btn);
        sellingCrop = view.findViewById(R.id.selling_crop_btn);

        sellingCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SellingCropFragment sellingCropFragment = new SellingCropFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_bottom, sellingCropFragment);
                transaction.commit();
            }
        });


        chooseServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseServiceFragment chooseServiceFragment = new ChooseServiceFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_bottom, chooseServiceFragment);
                transaction.setReorderingAllowed(true);
                transaction.commit();
            }
        });

        return view;
    }

 */
    }
}