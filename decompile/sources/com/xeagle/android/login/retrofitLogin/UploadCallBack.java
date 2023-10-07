package com.xeagle.android.login.retrofitLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class UploadCallBack<T> implements Callback<T> {
    public void onLoading(long j2, long j3) {
    }

    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(call, response);
        } else {
            onFailure(call, new Throwable(response.message()));
        }
    }

    public abstract void onSuccess(Call<T> call, Response<T> response);
}
