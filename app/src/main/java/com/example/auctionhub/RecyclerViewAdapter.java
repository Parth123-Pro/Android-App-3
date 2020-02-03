package com.example.auctionhub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

     Context mContext;
      List<Auction> mData;

    public RecyclerViewAdapter(Context mContext, List<Auction> mData) {
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


        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_price.setText(mData.get(position).getPrice());
        holder.aucimg.setImageResource(mData.get(position).getThumbnail());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, MotocActivity.class);
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                intent.putExtra("Price",mData.get(position).getPrice());
                intent.putExtra("Detail",mData.get(position).getDetail());
               // intent.putExtra("Button",mData.get(position).getButton());
            //    intent.putExtra("Button",mData.get(position).getButton());
               // intent.putExtras();
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title,tv_price;
        ImageView aucimg;
        CardView cv;

        public MyViewHolder(View view){
            super(view);

            tv_title=(TextView) view.findViewById(R.id.cvt1);
            tv_price=(TextView) view.findViewById(R.id.cvt2);
            aucimg=(ImageView)view.findViewById(R.id.cvimg1);
            cv=(CardView)view.findViewById(R.id.card123);

        }
    }



}
