package com.test.naimish.railapp.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Views.LightTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SavedPnrHistoryAdapter extends RecyclerView.Adapter<SavedPnrHistoryAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private String[] pnr;
    private SavePnrResponse response;

    public SavedPnrHistoryAdapter(Context context, String pnr[]) {
        this.pnr = pnr;
        inflater = LayoutInflater.from(context);
    }

    public void setInstance(SavePnrResponse response) {
        this.response = response;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pnr_history_single_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.displayPnr.setText(pnr[position]);

    }

    @Override
    public int getItemCount() {
        return pnr.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.display_pnr)
        LightTextView displayPnr;

        @OnClick(R.id.display_pnr)
        public void displayPnr() {
            response.showStatus(displayPnr.getText().toString());
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface SavePnrResponse {
        void showStatus(String pnr);
    }
}
