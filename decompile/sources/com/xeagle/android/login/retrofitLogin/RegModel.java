package com.xeagle.android.login.retrofitLogin;

import com.xeagle.android.login.beans.ApkVersion;
import com.xeagle.android.login.beans.AvatarAcceptBeans;
import com.xeagle.android.login.beans.BatteryInServerBeans;
import com.xeagle.android.login.beans.DeviceInServerBeans;
import com.xeagle.android.login.beans.DroneActivationInServerBeans;
import com.xeagle.android.login.beans.DroneFwInfo;
import com.xeagle.android.login.beans.DroneInServerBeans;
import com.xeagle.android.login.beans.ImageFwInfo;
import com.xeagle.android.login.beans.ListenerListBeans;
import com.xeagle.android.login.beans.LoginAcceptBeans;
import com.xeagle.android.login.beans.RegAcceptBeans;
import com.xeagle.android.login.beans.RepeaterFwInfo;
import com.xeagle.android.login.beans.ServiceBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.beans.UserInfoAcceptBeans;
import com.xeagle.android.login.retrofitLogin.RegContract;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ok.h;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.v;
import okhttp3.w;
import om.a;
import on.c;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegModel implements RegContract.lLoadModel {
    public void activeBattery(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).activeBattery(hashMap).a(a.a()).b(os.a.b()).b(new h<UploadAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(UploadAcceptBeans uploadAcceptBeans) {
                requestCallBack.onSuccess(uploadAcceptBeans);
            }
        });
    }

    public void activeDevice(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).activeDevice(hashMap).a(a.a()).b(os.a.b()).b(new h<UploadAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(UploadAcceptBeans uploadAcceptBeans) {
                requestCallBack.onSuccess(uploadAcceptBeans);
            }
        });
    }

    public void boundDroneWithUser(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).boundDroneWithUser(hashMap).a(a.a()).b(os.a.b()).b(new h<UploadAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(UploadAcceptBeans uploadAcceptBeans) {
                requestCallBack.onSuccess(uploadAcceptBeans);
            }
        });
    }

    public void boundInsuranceWithDrone(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).boundInsuranceWithDrone(hashMap).a(a.a()).b(os.a.b()).b(new h<UploadAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(UploadAcceptBeans uploadAcceptBeans) {
                requestCallBack.onSuccess(uploadAcceptBeans);
            }
        });
    }

    public void downloadListener(String str, String str2, int i2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).downloadListner(str2, i2).a(new c<ac, byte[]>() {
            public byte[] call(ac acVar) {
                try {
                    return acVar.bytes();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).a(a.a()).b(os.a.b()).b(new h<byte[]>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(byte[] bArr) {
                requestCallBack.onSuccess(bArr);
            }
        });
    }

    public void getApkInfo(String str, String str2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getApkInfo(str + str2).a(a.a()).b(os.a.b()).b(new h<ApkVersion>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(ApkVersion apkVersion) {
                requestCallBack.onSuccess(apkVersion);
            }
        });
    }

    public void getBatteryInServer(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getBatteryInServer(hashMap).a(a.a()).b(os.a.b()).b(new h<BatteryInServerBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(BatteryInServerBeans batteryInServerBeans) {
                requestCallBack.onSuccess(batteryInServerBeans);
            }
        });
    }

    public void getDeviceInServer(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getDeviceInServer(hashMap).a(a.a()).b(os.a.b()).b(new h<DeviceInServerBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(DeviceInServerBeans deviceInServerBeans) {
                requestCallBack.onSuccess(deviceInServerBeans);
            }
        });
    }

    public void getDroneActivationInServer(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getDroneActivationInServer(hashMap).a(a.a()).b(os.a.b()).b(new h<DroneActivationInServerBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(DroneActivationInServerBeans droneActivationInServerBeans) {
                requestCallBack.onSuccess(droneActivationInServerBeans);
            }
        });
    }

    public void getDroneFwInfo(String str, String str2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getDroneFwInfo(str + str2).a(a.a()).b(os.a.b()).b(new h<DroneFwInfo>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(DroneFwInfo droneFwInfo) {
                requestCallBack.onSuccess(droneFwInfo);
            }
        });
    }

    public void getDroneInServer(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getDroneInServer(hashMap).a(a.a()).b(os.a.b()).b(new h<DroneInServerBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(DroneInServerBeans droneInServerBeans) {
                requestCallBack.onSuccess(droneInServerBeans);
            }
        });
    }

    public void getImageFwInfo(String str, String str2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getImageFwInfo(str + str2).a(a.a()).b(os.a.b()).b(new h<ImageFwInfo>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(ImageFwInfo imageFwInfo) {
                requestCallBack.onSuccess(imageFwInfo);
            }
        });
    }

    public void getRepeaterFwInfo(String str, String str2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getRepeaterFwInfo(str + str2).a(a.a()).b(os.a.b()).b(new h<RepeaterFwInfo>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(RepeaterFwInfo repeaterFwInfo) {
                requestCallBack.onSuccess(repeaterFwInfo);
            }
        });
    }

    public void getUserInfo(String str, String str2, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getUserInfo(str2).enqueue(new Callback<UserInfoAcceptBeans>() {
            public void onFailure(Call<UserInfoAcceptBeans> call, Throwable th) {
                requestCallBack.onError(th);
            }

            public void onResponse(Call<UserInfoAcceptBeans> call, Response<UserInfoAcceptBeans> response) {
                requestCallBack.onSuccess(response.body());
            }
        });
    }

    public void getUserInfoResult(String str, List<w.b> list, UploadCallBack<UploadAcceptBeans> uploadCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getUserInfoResult(list).enqueue(uploadCallBack);
    }

    public void login(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getLogin(hashMap).a(a.a()).b(os.a.b()).b(new h<LoginAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(LoginAcceptBeans loginAcceptBeans) {
                if (loginAcceptBeans != null) {
                    requestCallBack.onSuccess(loginAcceptBeans);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void regCart(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getReg(hashMap).a(a.a()).b(os.a.b()).b(new h<RegAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(RegAcceptBeans regAcceptBeans) {
                if (regAcceptBeans != null) {
                    requestCallBack.onSuccess(regAcceptBeans);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void regChangePwd(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).resetPwdByPhone(hashMap).a(a.a()).b(os.a.b()).b(new h<RegAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(RegAcceptBeans regAcceptBeans) {
                if (regAcceptBeans != null) {
                    requestCallBack.onSuccess(regAcceptBeans);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void regCode(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getMsgCode(hashMap).a(a.a()).b(os.a.b()).b(new h<RegAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(RegAcceptBeans regAcceptBeans) {
                if (regAcceptBeans != null) {
                    requestCallBack.onSuccess(regAcceptBeans);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void requestListenerList(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getListenerList(hashMap).a(a.a()).b(os.a.b()).b(new h<ListenerListBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(ListenerListBeans listenerListBeans) {
                if (listenerListBeans != null) {
                    requestCallBack.onSuccess(listenerListBeans);
                } else {
                    requestCallBack.onFailure();
                }
            }
        });
    }

    public void serviceOnline(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).getServiceOnline(hashMap).a(a.a()).b(os.a.b()).b(new h<ServiceBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(ServiceBeans serviceBeans) {
                requestCallBack.onSuccess(serviceBeans);
            }
        });
    }

    public void unboundDroneWithUser(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).unboundDroneWithUser(hashMap).a(a.a()).b(os.a.b()).b(new h<UploadAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(UploadAcceptBeans uploadAcceptBeans) {
                requestCallBack.onSuccess(uploadAcceptBeans);
            }
        });
    }

    public void updateDroneInfo(String str, HashMap<String, String> hashMap, final RequestCallBack requestCallBack) {
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).updateDroneInfo(hashMap).a(a.a()).b(os.a.b()).b(new h<UploadAcceptBeans>() {
            public void onCompleted() {
            }

            public void onError(Throwable th) {
                requestCallBack.onError(th);
            }

            public void onNext(UploadAcceptBeans uploadAcceptBeans) {
                requestCallBack.onSuccess(uploadAcceptBeans);
            }
        });
    }

    public void uploadAvatar(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<AvatarAcceptBeans> uploadCallBack) {
        File file = new File(str2);
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).uploadAvatar(w.b.a("avatar", file.getName(), new FileRequestBody(aa.create(v.b("image/jpeg"), file), uploadCallBack)), hashMap).enqueue(uploadCallBack);
    }

    public void uploadFile(String str, String str2, String str3, String str4, UploadCallBack<UploadAcceptBeans> uploadCallBack) {
        File file = new File(str2);
        aa create = aa.create(v.b("multipart/form-data"), file);
        aa create2 = aa.create(v.b("text/plain"), "description");
        aa create3 = aa.create(v.b("text/plain"), "token");
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).uploadImg(w.b.a("image", file.getName(), new FileRequestBody(create, uploadCallBack)), create2, create3).enqueue(uploadCallBack);
    }

    public void uploadFile(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<UploadAcceptBeans> uploadCallBack) {
        File file = new File(str2);
        ((UserService) RetrofitUtils.getInstance(str).create(UserService.class)).uploadFile(w.b.a("file", file.getName(), new FileRequestBody(aa.create(v.b("multipart/form-data"), file), uploadCallBack)), (Map<String, aa>) hashMap).enqueue(uploadCallBack);
    }
}
