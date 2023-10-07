package com.xeagle.android.login.retrofitLogin;

import android.util.Log;
import com.xeagle.android.login.beans.AvatarAcceptBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.retrofitLogin.RegContract;
import java.util.HashMap;
import java.util.List;
import kw.c;
import okhttp3.aa;
import okhttp3.w;

public class RegPresenter extends RegContract.lLoadPresenter {
    /* access modifiers changed from: private */
    public RegContract.lLoadView lLoadView;
    private RegModel loadModel = new RegModel();

    public RegPresenter(RegContract.lLoadView lloadview) {
        this.lLoadView = lloadview;
    }

    public void activeBattery(String str, HashMap<String, String> hashMap) {
        this.loadModel.activeBattery(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(25, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(25);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(25, obj);
            }
        });
    }

    public void activeDevice(String str, HashMap<String, String> hashMap) {
        this.loadModel.activeDevice(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(20, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(20);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(20, obj);
            }
        });
    }

    public void boundDroneWithUser(String str, HashMap<String, String> hashMap) {
        this.loadModel.boundDroneWithUser(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(22, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(22);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(22, obj);
            }
        });
    }

    public void boundInsuranceWithUser(String str, HashMap<String, String> hashMap) {
        this.loadModel.boundInsuranceWithDrone(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(24, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(24);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(24, obj);
            }
        });
    }

    public void downloadListener(String str, String str2, int i2) {
        this.loadModel.downloadListener(str, str2, i2, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(8, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(8);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(8, obj);
            }
        });
    }

    public void getApkInfo(String str, String str2) {
        this.loadModel.getApkInfo(str, str2, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(13, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(13);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(13, obj);
            }
        });
    }

    public void getBatteryInServer(String str, HashMap<String, String> hashMap) {
        this.loadModel.getBatteryInServer(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(26, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(26);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(26, obj);
            }
        });
    }

    public void getDeviceInServer(String str, HashMap<String, String> hashMap) {
        this.loadModel.getDeviceInServer(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(18, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(18);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(18, obj);
            }
        });
    }

    public void getDroneActivationInServer(String str, HashMap<String, String> hashMap) {
        this.loadModel.getDroneActivationInServer(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(17, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(17);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(17, obj);
            }
        });
    }

    public void getDroneFwInfo(String str, String str2) {
        this.loadModel.getDroneFwInfo(str, str2, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(14, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(14);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(14, obj);
            }
        });
    }

    public void getDroneInServer(String str, HashMap<String, String> hashMap) {
        this.loadModel.getDroneInServer(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(19, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(19);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(19, obj);
            }
        });
    }

    public void getImageFwInfo(String str, String str2) {
        this.loadModel.getImageFwInfo(str, str2, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(15, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(15);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(15, obj);
            }
        });
    }

    public void getRepeaterFwInfo(String str, String str2) {
        this.loadModel.getRepeaterFwInfo(str, str2, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(21, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(21);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(21, obj);
            }
        });
    }

    public void getUserInfo(String str, String str2) {
        this.loadModel.getUserInfo(str, str2, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(9, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(9);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(9, obj);
            }
        });
    }

    public void getUserInfoResult(String str, List<w.b> list, UploadCallBack<UploadAcceptBeans> uploadCallBack) {
        this.loadModel.getUserInfoResult(str, list, uploadCallBack);
    }

    public void login(String str, HashMap<String, String> hashMap) {
        this.loadModel.login(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(2, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(2);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(2, obj);
            }
        });
    }

    public void regCart(String str, HashMap<String, String> hashMap) {
        String str2 = hashMap.get("phone");
        String str3 = hashMap.get("registerType");
        if (str3 == null || !str3.equals("1") || c.a(str2)) {
            this.loadModel.regCart(str, hashMap, new RequestCallBack() {
                public void onError(Throwable th) {
                    RegPresenter.this.lLoadView.regError(1, th.getMessage());
                }

                public void onFailure() {
                    RegPresenter.this.lLoadView.regFailure(1);
                }

                public void onSuccess(Object obj) {
                    RegPresenter.this.lLoadView.regSuccess(1, obj);
                }
            });
        } else {
            this.lLoadView.regError(1, "手机号码格式不对");
        }
    }

    public void regChangePwd(String str, HashMap<String, String> hashMap) {
        this.loadModel.regChangePwd(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(12, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(12);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(12, obj);
            }
        });
    }

    public void regCode(String str, HashMap<String, String> hashMap) {
        this.loadModel.regCode(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(0, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(0);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(0, obj);
            }
        });
    }

    public void requestListenerList(String str, HashMap<String, String> hashMap) {
        this.loadModel.requestListenerList(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                Log.i("Listener", "onError:---request- ");
                RegPresenter.this.lLoadView.regError(7, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(7);
            }

            public void onSuccess(Object obj) {
                Log.i("Listener", "onSuccess:---request- ");
                RegPresenter.this.lLoadView.regSuccess(7, obj);
            }
        });
    }

    public void serviceOnline(String str, HashMap<String, String> hashMap) {
        this.loadModel.serviceOnline(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(27, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(27);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(27, obj);
            }
        });
    }

    public void unboundDroneWithUser(String str, HashMap<String, String> hashMap) {
        this.loadModel.unboundDroneWithUser(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(23, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(23);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(23, obj);
            }
        });
    }

    public void updateDroneInfo(String str, HashMap<String, String> hashMap) {
        this.loadModel.updateDroneInfo(str, hashMap, new RequestCallBack() {
            public void onError(Throwable th) {
                RegPresenter.this.lLoadView.regError(16, th.getMessage());
            }

            public void onFailure() {
                RegPresenter.this.lLoadView.regFailure(16);
            }

            public void onSuccess(Object obj) {
                RegPresenter.this.lLoadView.regSuccess(16, obj);
            }
        });
    }

    public void uploadAvatar(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<AvatarAcceptBeans> uploadCallBack) {
        this.loadModel.uploadAvatar(str, str2, hashMap, uploadCallBack);
    }

    public void uploadFile(String str, String str2, String str3, String str4, UploadCallBack<UploadAcceptBeans> uploadCallBack) {
        this.loadModel.uploadFile(str, str2, str3, str4, uploadCallBack);
    }

    public void uploadFile(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<UploadAcceptBeans> uploadCallBack) {
        this.loadModel.uploadFile(str, str2, hashMap, uploadCallBack);
    }
}
