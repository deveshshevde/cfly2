package com.xeagle.android.login.retrofitLogin.sochip;

import android.util.Log;
import com.xeagle.android.login.beans.sochipBeans.CmdListener;
import com.xeagle.android.login.beans.sochipBeans.SochipRecordStatusBean;
import com.xeagle.android.login.beans.sochipBeans.SochipRecordTimeBean;
import com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean;
import com.xeagle.android.login.beans.sochipBeans.SochipStatusBean;
import com.xeagle.android.login.beans.sochipBeans.SochipVersionBean;
import com.xeagle.android.login.retrofitLogin.RequestCallBack;
import com.xeagle.android.login.retrofitLogin.RetrofitUtils;
import com.xeagle.android.login.retrofitLogin.UserService;
import com.xeagle.android.login.retrofitLogin.sochip.SochipContract;
import ok.h;
import om.a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SochipModel implements SochipContract.loadModel {
    public void getCameraStatus(String str, int i2, int i3, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getCameraStatus(i2, i3).enqueue(new Callback<SochipStatusBean>() {
            public void onFailure(Call<SochipStatusBean> call, Throwable th) {
                requestCallBack.onError(th);
            }

            public void onResponse(Call<SochipStatusBean> call, Response<SochipStatusBean> response) {
                requestCallBack.onSuccess(response.body());
            }
        });
    }

    public void getFirmwareVersion(String str, int i2, int i3, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getFirmwareVersion(i2, i3).enqueue(new Callback<SochipVersionBean>() {
            public void onFailure(Call<SochipVersionBean> call, Throwable th) {
                requestCallBack.onError(th);
            }

            public void onResponse(Call<SochipVersionBean> call, Response<SochipVersionBean> response) {
                requestCallBack.onSuccess(response.body());
            }
        });
    }

    public void getRecordStatus(String str, int i2, int i3, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getRecordStatus(i2, i3).enqueue(new Callback<SochipRecordStatusBean>() {
            public void onFailure(Call<SochipRecordStatusBean> call, Throwable th) {
                requestCallBack.onError(th);
            }

            public void onResponse(Call<SochipRecordStatusBean> call, Response<SochipRecordStatusBean> response) {
                requestCallBack.onSuccess(response.body());
            }
        });
    }

    public void getRecordTime(String str, int i2, int i3, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getRecordTime(i2, i3).enqueue(new Callback<SochipRecordTimeBean>() {
            public void onFailure(Call<SochipRecordTimeBean> call, Throwable th) {
                requestCallBack.onError(th);
            }

            public void onResponse(Call<SochipRecordTimeBean> call, Response<SochipRecordTimeBean> response) {
                requestCallBack.onSuccess(response.body());
            }
        });
    }

    public void getSdcardStatus(String str, int i2, int i3, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getSdcardStatus(i2, i3).enqueue(new Callback<SochipSdcardBean>() {
            public void onFailure(Call<SochipSdcardBean> call, Throwable th) {
                requestCallBack.onError(th);
                Log.i("Sochip", "onFailure: -----" + th.getMessage());
            }

            public void onResponse(Call<SochipSdcardBean> call, Response<SochipSdcardBean> response) {
                Log.i("Sochip", "onResponse: ======");
                requestCallBack.onSuccess(response.body());
            }
        });
    }

    public void remoteRecord(String str, int i2, int i3, int i4, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).remoteRecord(i2, i3, i4).a(a.a()).b(os.a.b()).b(new h<CmdListener>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(CmdListener cmdListener) {
                if (cmdListener != null) {
                    requestCallBack.onSuccess(cmdListener);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void remoteTakePhoto(String str, int i2, int i3, int i4, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).remoteTakePhoto(i2, i3, i4).a(a.a()).b(os.a.b()).b(new h<CmdListener>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(CmdListener cmdListener) {
                if (cmdListener != null) {
                    requestCallBack.onSuccess(cmdListener);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void setCmdAndInt(String str, int i2, int i3, int i4, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).setCmdAndInt(i2, i3, i4).a(a.a()).b(os.a.b()).b(new h<CmdListener>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(CmdListener cmdListener) {
                if (cmdListener != null) {
                    requestCallBack.onSuccess(cmdListener);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void setCmdAndStr(String str, int i2, int i3, String str2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).setCmdAndStr(i2, i3, str2).a(a.a()).b(os.a.b()).b(new h<CmdListener>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(CmdListener cmdListener) {
                if (cmdListener != null) {
                    requestCallBack.onSuccess(cmdListener);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }
}
