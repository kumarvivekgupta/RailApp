package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.naimish.railapp.R;

import java.util.ArrayList;

/**
 * Created by Vivek on 3/23/2018.
 */

public class EnquiryAdapter extends RecyclerView.Adapter<EnquiryAdapter.MyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mListItems;
    private Context mContext;
    private Clicklistener mClickListener;

    public EnquiryAdapter(Context context, ArrayList<String> data) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<>();
        this.mListItems = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recycler_single_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTitle.setText(mListItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitle;
        private ImageView mImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.pnr_text);
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
        public void itemclicked(int position);
    }

    public void setClicklistener(Clicklistener clicklistener) {
        this.mClickListener = clicklistener;
    }
}
