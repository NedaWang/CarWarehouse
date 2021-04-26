package com.neda.carwarehouse.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.neda.carwarehouse.R;
import com.neda.carwarehouse.entity.Car;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private List<Car> cars;

    public RecyclerAdapter() {
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_recycler_view,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.makerTv.setText(cars.get(position).getMaker());
        holder.modelTv.setText(cars.get(position).getModel());
        holder.colerTv.setText(cars.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        if (cars == null)
            return 0;
        else
            return cars.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public TextView makerTv;
        public TextView modelTv;
        public TextView colerTv;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            makerTv = itemView.findViewById(R.id.card_tv_maker);
            modelTv = itemView.findViewById(R.id.card_tv_model);
            colerTv = itemView.findViewById(R.id.card_tv_color);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
