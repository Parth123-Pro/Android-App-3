package com.example.auctionhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

     Context mContext;
      List<Fuel> mData;

    public RecyclerViewAdapter(Context mContext, List<Fuel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view1;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view1=layoutInflater.inflate(R.layout.cardview_item_auction,parent,false);


        return new MyViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        holder.DID.setText(mData.get(position).getDID());
        holder.date.setText(mData.get(position).getDate());
        holder.time.setText(mData.get(position).getTime());
        holder.odometer.setText(mData.get(position).getOdometer());
        holder.totalcost.setText(mData.get(position).getTotalcost());
        holder.liter.setText(mData.get(position).getLiter());




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView DID,date,time,odometer,totalcost,liter;

        CardView cv;

        public MyViewHolder(View view){
            super(view);

            DID=(TextView) view.findViewById(R.id.DID);
            date=(TextView) view.findViewById(R.id.date);
            time=(TextView) view.findViewById(R.id.time);
            odometer=(TextView) view.findViewById(R.id.odometer);
            totalcost=(TextView) view.findViewById(R.id.totalcost);
            liter=(TextView) view.findViewById(R.id.totalliter);


            cv=(CardView)view.findViewById(R.id.card123);


        }
    }



}
