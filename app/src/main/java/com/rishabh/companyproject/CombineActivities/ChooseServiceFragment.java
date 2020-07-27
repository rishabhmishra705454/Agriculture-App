package com.rishabh.companyproject.CombineActivities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rishabh.companyproject.R;

public class ChooseServiceFragment extends Fragment {

    Button serviceContinueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_service, container, false);
/*
        serviceContinueBtn = view.findViewById(R.id.location_call_btn);

        serviceContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmLocationFragment confirmLocationFragment = new ConfirmLocationFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_bottom, confirmLocationFragment);
                transaction.commit();
            }
        });

        return view;
    }
    */
    }

}