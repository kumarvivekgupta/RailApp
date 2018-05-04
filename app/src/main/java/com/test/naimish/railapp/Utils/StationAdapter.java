package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.naimish.railapp.Models.PassengerRecyclerModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 4/30/2018.
 */

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.MyViewHolder> {
    private StationAdapter.Clicklistener mClickListener;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mListItems;

    public StationAdapter(Context context, ArrayList<String> data) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<>();
        this.mListItems = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recycler_single_row_live_train, parent, false);
        StationAdapter.MyViewHolder holder = new StationAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.stationName.setText(mListItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        @BindView(R.id.station_name)
//        LightTextView stationName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.itemclicked(getAdapterPosition());

            }
        }
    }

    public interface Clicklistener {
         void itemclicked(int position);
    }

    public void setClicklistener(StationAdapter.Clicklistener clicklistener) {
        this.mClickListener = clicklistener;
    }
}
