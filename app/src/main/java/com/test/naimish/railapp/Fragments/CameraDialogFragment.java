package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.SharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by naimish on 3/30/2018.
 */

public class CameraDialogFragment extends DialogFragment {

    private static final int REQUEST_GALLERY_CODE = 1;
    private static final int REQUEST_CAMERA_CODE = 20;
    private static final String PROFILE_PIC_CONSTANT = "Profile picture uri";
    private Uri uri = null;

    //
    @OnClick(R.id.option_camera)
    public void cameraPic() {
        Toast.makeText(getActivity(), "CameraClickable", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.option_camera)
    public void gallery() {
        Toast.makeText(getActivity(), "Clickable", Toast.LENGTH_SHORT).show();
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUEST_GALLERY_CODE);

    }

    public static CameraDialogFragment newInsatance() {
        return new CameraDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera_popup, container, false);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_GALLERY_CODE) {
            uri = data.getData();
            getDialog().dismiss();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }
}
