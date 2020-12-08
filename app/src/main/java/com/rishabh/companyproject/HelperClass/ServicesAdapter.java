package com.rishabh.companyproject.HelperClass;

import android.bluetooth.BluetoothProfile;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.rishabh.companyproject.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.servicesViewHolder>{


    private List<Services> services;
    private ServiceListnerInterface serviceListner;

    public ServicesAdapter(List<Services> services, ServiceListnerInterface serviceListner) {
        this.services = services;
        this.serviceListner = serviceListner;
    }

    @NonNull
    @Override
    public servicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new servicesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_service_type,
                        parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull servicesViewHolder holder, int position) {

        holder.bindServices(services.get(position));
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public List<Services>getSelectedServices(){
        List<Services> selectedServices = new ArrayList<>();
        for (Services services : services){
            if (services.isSelected){
                selectedServices.add(services);

            }
        }
        return selectedServices;
    }

    class servicesViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout LayoutServices;
        View viewBackgraound;
        RoundedImageView imageServices;
        TextView textName;
        ImageView imageSelected;



        servicesViewHolder(@NonNull View itemView) {
            super(itemView);

            LayoutServices = itemView.findViewById(R.id.layout_service_item);
            imageServices = itemView.findViewById(R.id.serviceItemView);
            textName = itemView.findViewById(R.id.serviceTextName);
            imageSelected = itemView.findViewById(R.id.imageSelected);
            viewBackgraound = itemView.findViewById(R.id.viewBackground);

        }

        void bindServices(final Services services) {
            imageServices.setImageResource(services.image);
            textName.setText(services.name);
            if (services.isSelected) {
                viewBackgraound.setBackgroundResource(R.drawable.border_background);
                imageSelected.setVisibility(View.VISIBLE);
            }else {
                viewBackgraound.setBackgroundResource(R.drawable.black_border);
                imageSelected.setVisibility(View.GONE);
            }

            LayoutServices.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (services.isSelected){
                        viewBackgraound.setBackgroundResource(R.drawable.black_border);
                        imageSelected.setVisibility(View.GONE);
                        services.isSelected = false;
                        if (getSelectedServices().size() ==0) {
                            serviceListner.selectserviceAction(false);
                        }
                    }else {
                        viewBackgraound.setBackgroundResource(R.drawable.border_background);
                        imageSelected.setVisibility(View.VISIBLE);
                        serviceListner.selectserviceAction(true);
                    }
                }
            });
        }
    }
}
