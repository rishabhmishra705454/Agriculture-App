package com.rishabh.companyproject.HelperClass.SupportAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabh.companyproject.HelperClass.SupportAdapter.SupportAdapter;
import com.rishabh.companyproject.R;

import java.util.ArrayList;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.SupportViewHolder> {

    ArrayList<SupportHelperClass> supportLocations;

    public SupportAdapter(ArrayList<SupportHelperClass> supportLocations) {
        this.supportLocations = supportLocations;
    }

    @NonNull
    @Override
    public SupportAdapter.SupportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.support_card_design, parent, false);
        SupportViewHolder supportViewHolder = new SupportViewHolder(view);
        return supportViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SupportViewHolder holder, int position) {

        SupportHelperClass supportHelperClass = supportLocations.get(position);
        holder.image.setImageResource(supportHelperClass.getImage());
        holder.title.setText(supportHelperClass.getTitle());
        holder.relativeLayout.setBackground(supportHelperClass.getGradient());


    }

    @Override
    public int getItemCount() {
        return supportLocations.size();
    }

    public static class SupportViewHolder extends RecyclerView.ViewHolder {


        RelativeLayout relativeLayout;
        ImageView image;
        TextView title;

        public SupportViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks

            relativeLayout=itemView.findViewById(R.id.support_relative);
            image = itemView.findViewById(R.id.support_image);
            title = itemView.findViewById(R.id.support_title);
        }
    }


}
