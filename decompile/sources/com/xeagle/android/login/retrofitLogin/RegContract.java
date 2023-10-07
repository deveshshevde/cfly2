package com.xeagle.android.login.retrofitLogin;

import com.xeagle.android.login.beans.AvatarAcceptBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import java.util.HashMap;
import java.util.List;
import okhttp3.aa;
import okhttp3.w;

public interface RegContract {

    public interface lLoadView {
        void regError(int i2, String str);

        void regFailure(int i2);

        void regSuccess(int i2, Object obj);
    }

    public interface lLoadModel {
        void activeBattery(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void activeDevice(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void boundDroneWithUser(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void boundInsuranceWithDrone(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void downloadListener(String str, String str2, int i2, RequestCallBack requestCallBack);

        void getApkInfo(String str, String str2, RequestCallBack requestCallBack);

        void getBatteryInServer(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void getDeviceInServer(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void getDroneActivationInServer(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void getDroneFwInfo(String str, String str2, RequestCallBack requestCallBack);

        void getDroneInServer(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void getImageFwInfo(String str, String str2, RequestCallBack requestCallBack);

        void getRepeaterFwInfo(String str, String str2, RequestCallBack requestCallBack);

        void getUserInfo(String str, String str2, RequestCallBack requestCallBack);

        void getUserInfoResult(String str, List<w.b> list, UploadCallBack<UploadAcceptBeans> uploadCallBack);

        void login(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void regCart(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void regChangePwd(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void regCode(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void requestListenerList(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void serviceOnline(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void unboundDroneWithUser(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void updateDroneInfo(String str, HashMap<String, String> hashMap, RequestCallBack requestCallBack);

        void uploadAvatar(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<AvatarAcceptBeans> uploadCallBack);

        void uploadFile(String str, String str2, String str3, String str4, UploadCallBack<UploadAcceptBeans> uploadCallBack);

        void uploadFile(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<UploadAcceptBeans> uploadCallBack);
    }

    public static abstract class lLoadPresenter {
        public abstract void activeBattery(String str, HashMap<String, String> hashMap);

        public abstract void activeDevice(String str, HashMap<String, String> hashMap);

        public abstract void boundDroneWithUser(String str, HashMap<String, String> hashMap);

        public abstract void boundInsuranceWithUser(String str, HashMap<String, String> hashMap);

        public abstract void downloadListener(String str, String str2, int i2);

        public abstract void getApkInfo(String str, String str2);

        public abstract void getBatteryInServer(String str, HashMap<String, String> hashMap);

        public abstract void getDeviceInServer(String str, HashMap<String, String> hashMap);

        public abstract void getDroneActivationInServer(String str, HashMap<String, String> hashMap);

        public abstract void getDroneFwInfo(String str, String str2);

        public abstract void getDroneInServer(String str, HashMap<String, String> hashMap);

        public abstract void getImageFwInfo(String str, String str2);

        public abstract void getRepeaterFwInfo(String str, String str2);

        public abstract void getUserInfo(String str, String str2);

        public abstract void getUserInfoResult(String str, List<w.b> list, UploadCallBack<UploadAcceptBeans> uploadCallBack);

        public abstract void login(String str, HashMap<String, String> hashMap);

        public abstract void regCart(String str, HashMap<String, String> hashMap);

        public abstract void regChangePwd(String str, HashMap<String, String> hashMap);

        public abstract void regCode(String str, HashMap<String, String> hashMap);

        public abstract void requestListenerList(String str, HashMap<String, String> hashMap);

        public abstract void serviceOnline(String str, HashMap<String, String> hashMap);

        public abstract void unboundDroneWithUser(String str, HashMap<String, String> hashMap);

        public abstract void updateDroneInfo(String str, HashMap<String, String> hashMap);

        public abstract void uploadAvatar(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<AvatarAcceptBeans> uploadCallBack);

        public abstract void uploadFile(String str, String str2, String str3, String str4, UploadCallBack<UploadAcceptBeans> uploadCallBack);

        public abstract void uploadFile(String str, String str2, HashMap<String, aa> hashMap, UploadCallBack<UploadAcceptBeans> uploadCallBack);
    }
}
