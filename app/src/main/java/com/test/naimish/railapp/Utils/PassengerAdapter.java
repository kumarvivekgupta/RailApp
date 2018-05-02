package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.naimish.railapp.Models.PassengerRecyclerModel;
import com.test.naimish.railapp.Models.RecyclerModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 4/25/2018.
 */

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.MyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<PassengerRecyclerModel> mListItems;
    private Context mContext;
  //  private EnquiryAdapter.Clicklistener mClickListener;
  //  public static int layoutResource;

    public PassengerAdapter(Context context, ArrayList<PassengerRecyclerModel> data) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<>();
        this.mListItems = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.pnr_single_row_passenger, parent, false);
        PassengerAdapter.MyViewHolder holder = new PassengerAdapter.MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(PassengerAdapter.MyViewHolder holder, int position) {
        Log.i("mTitle",mListItems.get(position).getBookingStatus());
        holder.mTitle.setText(mListItems.get(position).getPassengerNo()+"");
        holder.mBookingStatus.setText(mListItems.get(position).getBookingStatus());
        holder.mCurrentStatus.setText(mListItems.get(position).getCurrentStatus());

    }


    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.passenger_no)
        LightTextView mTitle;

        @BindView(R.id.passenger_booking_status)
        LightTextView mBookingStatus;

        @BindView(R.id.passenger_current_status)
        LightTextView mCurrentStatus;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            if (mClickListener != null) {
//                mClickListener.itemclicked(getAdapterPosition());
//
//            }
        }


    }
}
