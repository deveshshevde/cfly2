package com.xeagle.android.login.retrofitLogin;

public interface RequestCallBack {
    void onError(Throwable th);

    void onFailure();

    void onSuccess(Object obj);
}
