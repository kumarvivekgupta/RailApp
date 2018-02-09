package com.test.naimish.railapp.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by naimish on 2/10/2018.
 */

public class LightTextView extends AppCompatTextView {
    private static final String LIGHT_TEXT = "Fonts/Ubuntu-Light.ttf";

    public LightTextView(Context context) {
        super(context);
    }

    public LightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf.createFromAsset(getContext().getAssets(), LIGHT_TEXT));
    }
}
