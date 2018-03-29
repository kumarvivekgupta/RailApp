package com.test.naimish.railapp.Views;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.naimish.railapp.R;



import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Vivek on 3/30/2018.
 */

public class ImagePopupWindow {
    private Context context;

    private PopupWindow mPopupWindow;

    @BindView(R.id.linear_layout_enquiry_fragment)
    LinearLayout linear_layout_enquiry_fragment;


    public ImagePopupWindow(Context mContext) {
        this.context = mContext;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        View customView = inflater.inflate(R.layout.image_popup_window, null);
        mPopupWindow = new PopupWindow(
                customView,
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        );

        // Set an elevation value for popup window
        // Call requires API level 21
        if (Build.VERSION.SDK_INT >= 21) {
            mPopupWindow.setElevation(5.0f);
        }
        mPopupWindow.showAtLocation(customView, Gravity.CENTER, 0, 0);


    }


    @OnClick(R.id.take_a_pic)
    public void camera() {
        Toast.makeText(context, "Camera", Toast.LENGTH_SHORT).show();


    }

    @OnClick(R.id.gallery)
    public void gallery() {

    }
}
