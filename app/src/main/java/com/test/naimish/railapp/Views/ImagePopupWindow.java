package com.test.naimish.railapp.Views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.naimish.railapp.Activities.SingleFragmentActivity;
import com.test.naimish.railapp.Fragments.RailAppFragment;
import com.test.naimish.railapp.R;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 3/30/2018.
 */

public class ImagePopupWindow extends AppCompatActivity {
    private Context context;
    private Activity mActivity;
    private RelativeLayout mRelativeLayout;
//    @BindView(R.id.take_a_pic)
//    TextView take_a_pic;
//    @BindView(R.id.gallery)
//    TextView gallery;

    public ImagePopupWindow(Context mContext) {
        this.context = mContext;
        


    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        ButterKnife.bind(this, parent);
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_popup_window);


        // Get the application context
        this.context = getApplicationContext();

        // Get the activity
        mActivity = ImagePopupWindow.this;

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.popup_relative_layout);


    }

    @OnClick(R.id.take_a_pic)
    public void camera() {


    }

    @OnClick(R.id.gallery)
    public void gallery() {

    }
}
