package com.xeagle.android.login.retrofitLogin.sochip;

import com.xeagle.android.login.retrofitLogin.RequestCallBack;
import com.xeagle.android.newUI.cameraManager.a;

public interface SochipContract {

    public static abstract class loadPresenter extends a {
        public abstract void getCameraStatus(String str, int i2, int i3);

        public abstract void getFirmwareVersion(String str, int i2, int i3);

        public abstract void getRecordStatus(String str, int i2, int i3);

        public abstract void getRecordTime(String str, int i2, int i3);

        public abstract void getSdcardStatus(String str, int i2, int i3);

        public abstract void regRemoteRecord(String str, int i2, int i3, int i4);

        public abstract void regRemoteTakePhoto(String str, int i2, int i3, int i4);

        public abstract void setCmdAndInt(String str, int i2, int i3, int i4);

        public abstract void setCmdAndStr(String str, int i2, int i3, String str2);
    }

    public interface loadModel {
        void getCameraStatus(String str, int i2, int i3, RequestCallBack requestCallBack);

        void getFirmwareVersion(String str, int i2, int i3, RequestCallBack requestCallBack);

        void getRecordStatus(String str, int i2, int i3, RequestCallBack requestCallBack);

        void getRecordTime(String str, int i2, int i3, RequestCallBack requestCallBack);

        void getSdcardStatus(String str, int i2, int i3, RequestCallBack requestCallBack);

        void remoteRecord(String str, int i2, int i3, int i4, RequestCallBack requestCallBack);

        void remoteTakePhoto(String str, int i2, int i3, int i4, RequestCallBack requestCallBack);

        void setCmdAndInt(String str, int i2, int i3, int i4, RequestCallBack requestCallBack);

        void setCmdAndStr(String str, int i2, int i3, String str2, RequestCallBack requestCallBack);
    }

    public interface loadView {
        void socError(int i2, String str);

        void socFailure(int i2);

        void socSuccess(int i2, Object obj);
    }
}
