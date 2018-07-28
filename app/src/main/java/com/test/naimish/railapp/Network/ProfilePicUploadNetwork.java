package com.test.naimish.railapp.Network;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.SharedPreference;

public class ProfilePicUploadNetwork implements OnCompleteListener<Uri> {
    private FirebaseStorage mStorage;
    private StorageReference mStorageReference;
    private StorageReference mUserRef;
    private String mEmail;
    private UploadPicResponse mResponse;

    public ProfilePicUploadNetwork(Context context) {
        this.mStorage = FirebaseStorage.getInstance();
        this.mStorageReference = mStorage.getReference();
        mEmail = SharedPreference.getPreference(context, RailAppConstants.EMAIL_CONSTANT);
        mUserRef = mStorageReference.child("profile-pic/" + mEmail + ".jpeg");
    }

    public void setInstance(UploadPicResponse response) {
        this.mResponse = response;
    }

    public void uploadPic(Uri uri) {
        if (uri == null) {
            return;
        }
        mUserRef.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        mUserRef.getDownloadUrl().addOnCompleteListener(ProfilePicUploadNetwork.this);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        mResponse.onFailure();
                    }
                });
    }

    @Override
    public void onComplete(@NonNull Task<Uri> task) {
        if (task.isSuccessful()) {
            mResponse.onSuccess(task.getResult().toString());
        }
    }

    public interface UploadPicResponse {
        void onSuccess(String url);

        void onFailure();
    }

}

