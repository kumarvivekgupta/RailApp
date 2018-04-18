package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.naimish.railapp.Models.RecyclerModel;
import com.test.naimish.railapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 3/23/2018.
 */

public  class EnquiryAdapter extends RecyclerView.Adapter<EnquiryAdapter.MyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<RecyclerModel> mListItems;
    private Context mContext;
    private Clicklistener mClickListener;
    public static int layoutResource;

    public EnquiryAdapter(Context context, ArrayList<RecyclerModel> data) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<RecyclerModel>();
        this.mListItems = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(layoutResource, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTitle.setText(mListItems.get(position).getTitle());
        if(mListItems.get(position).getImageUrl() !=0){
            holder.mImage.setImageResource(mListItems.get(position).getImageUrl());
        }
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.enquiry_text)
         TextView mTitle;

        @BindView(R.id.icons)
         ImageView mImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
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
    public  static void   getLayoutResourseId(int layout) {
        layoutResource=layout;
    }


}
