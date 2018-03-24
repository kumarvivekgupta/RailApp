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

public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<String> data=new ArrayList<>();
    Context context;
    private Clicklistener clicklistener;

    public VivzAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>();
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_single_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView=View.f
            title = (TextView) itemView.findViewById(R.layout.fragment_enquiry);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            if (clicklistener != null) {
               (clicklistener.itemclicked(getAdapterPosition());

            }

        }
    }
    public interface Clicklistener {
        public void itemclicked(int position);


    }

    public void setClicklistener(Clicklistener clicklistener) {
        this.clicklistener = clicklistener;
    }


}
