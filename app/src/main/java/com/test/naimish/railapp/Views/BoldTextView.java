package com.test.naimish.railapp.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by naimish on 2/10/2018.
 */

public class BoldTextView extends AppCompatTextView {
    private static final String BOLD_TEXT = "Fonts/Ubuntu-Bold.ttf";

    public BoldTextView(Context context) {
        super(context);
    }

    public BoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), BOLD_TEXT));

    }
}
