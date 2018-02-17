package com.test.naimish.railapp.info;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Vivek on 2/17/2018.
 */

public class MyProgress {
    public static ProgressDialog  showProgress(Context context,String message)
    {
        ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
}
