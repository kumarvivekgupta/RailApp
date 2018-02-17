package com.test.naimish.railapp.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.info.MyProgress;
import com.test.naimish.railapp.info.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by naimish on 2/10/2018.
 */

public class LoginFragment extends Fragment {
    private String email;
    private String password;
    private String confirmpassword;
    private ProgressDialog progress;

    @BindView(R.id.login_email)
    TextView login_email;
    @BindView(R.id.login_password)
    TextView login_password;
    @BindView(R.id.login_button)
    Button login_button;
    @BindView(R.id.confirm_password)
    TextView confirm_password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }
    @OnClick(R.id.login_button)
    public void login_clicked()
    {        boolean killSwitch=false;
    View focusView=null;
    login_password.setError(null);
    login_email.setError(null);

        email=login_email.getText().toString();
        password=login_password.getText().toString();
        if(!Validations.checkEmail(email)||Validations.emptyEmail(email))
        {
            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
           login_email.setError(getActivity().getString(R.string.email_error));
           killSwitch=true;
           focusView=login_email;


        }
        if(Validations.checkEmail(password))
        {
            Toast.makeText(getContext(),"Password_Error",Toast.LENGTH_LONG).show();
            login_password.setError("Password Cannot be Empty");
            focusView=login_password;
            killSwitch=true;
        }
        if(Validations.checkPassword(password,confirmpassword)){
            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            login_password.setError(getActivity().getString(R.string.password_error));
            killSwitch=true;
            focusView=login_password;

        }
        if(killSwitch)
            focusView.requestFocus();
        else
        {
            progress= MyProgress.showProgress(getContext(),"Logging In...");
            login();
        }

    }
    private  void  login(){
        if(true)
        {

            startActivity(new Intent(getActivity(), EnquiryActivity.class));
            getActivity().finish();
            progress.dismiss();

        }
        else
        {
            MyProgress.showProgress(getContext(),"Something is wrong here");
            progress.dismiss();
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
