package com.test.naimish.railapp.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 4/30/2018.
 */

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.MyViewHolder> {
    private StationNameClicklistener clicklistener;
    Context context;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mListItems;

    public StationAdapter(Context clicklistener, ArrayList<String> data) {
        this.context = clicklistener;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<>();
        this.mListItems = data;
    }
    public void setClicklistenerInstance(StationNameClicklistener clicklistener){
        this.clicklistener=clicklistener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recycler_single_row_live_train, parent, false);
        StationAdapter.MyViewHolder holder = new StationAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.stationName.setText(mListItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.station_name)
        LightTextView stationName;

        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clicklistener.itemclicked(getAdapterPosition());
                }
            });
        }

    }

    public interface StationNameClicklistener {
        void itemclicked(int position);
    }

}
