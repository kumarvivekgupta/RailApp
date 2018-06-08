package com.test.naimish.railapp.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.naimish.railapp.Models.DateSeatModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 6/5/2018.
 */

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.MyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<DateSeatModel> mListItems;
    private Context mContext;


    public SeatAdapter(Context context, ArrayList<DateSeatModel> data) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<>();
        this.mListItems = data;
    }

    @Override
    public SeatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recycler_single_seat_display_row, parent, false);
        SeatAdapter.MyViewHolder holder = new SeatAdapter.MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(SeatAdapter.MyViewHolder holder, int position) {
        for (int i = 0; i < mListItems.size(); i++) {
            holder.trainRunningDate.setText(mListItems.get(i).getmDate());
            holder.trainSeatStatus.setText(mListItems.get(i).getmSeatStatus());
        }

//        holder.trainRunningDate.setText(mListItems.);
//        holder.mBookingStatus.setText(mListItems.get(position).getBookingStatus());


    }


    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.train_running_date)
        LightTextView trainRunningDate;

        @BindView(R.id.train_seat_status)
        LightTextView trainSeatStatus;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }


}

