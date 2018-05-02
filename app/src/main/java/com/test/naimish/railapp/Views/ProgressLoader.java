package com.test.naimish.railapp.Views;

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.test.naimish.railapp.Activities.SingleFragmentActivity;

public class ProgressLoader {
    private Context activity;
    KProgressHUD kProgressHUD;

    public ProgressLoader(Context activity) {
        this.activity = activity;
    }


    public void showLoader() {
        kProgressHUD = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

    public void dismissLoader() {
        kProgressHUD.dismiss();
    }

}
