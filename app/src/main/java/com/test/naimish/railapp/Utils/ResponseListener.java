package com.test.naimish.railapp.Utils;

public interface ResponseListener<T> {

    void onSuccess(T response);

    void onFailure();

    void onNullResponse();
}
