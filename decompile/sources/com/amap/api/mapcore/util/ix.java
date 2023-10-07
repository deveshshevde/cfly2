package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;

public final class ix extends Handler {

    /* renamed from: a  reason: collision with root package name */
    iw f9378a = null;

    public ix() {
    }

    public ix(Looper looper, iw iwVar) {
        super(looper);
        this.f9378a = iwVar;
    }

    public final void handleMessage(Message message) {
        String str;
        switch (message.what) {
            case 1001:
                try {
                    this.f9378a.a((Inner_3dMap_locationOption) message.obj);
                    return;
                } catch (Throwable th) {
                    th = th;
                    str = "ACTION_SET_OPTION";
                    break;
                }
            case 1002:
                try {
                    this.f9378a.a((Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    str = "ACTION_SET_LISTENER";
                    break;
                }
            case 1003:
                try {
                    this.f9378a.b((Inner_3dMap_locationListener) message.obj);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    str = "ACTION_REMOVE_LISTENER";
                    break;
                }
            case CameraGlobal.SET_VIDEO_EXPROTION /*1004*/:
                try {
                    this.f9378a.a();
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    str = "ACTION_START_LOCATION";
                    break;
                }
            case 1005:
                try {
                    this.f9378a.b();
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    str = "ACTION_GET_LOCATION";
                    break;
                }
            case Constants.RESULT_CODE_RECORD_VIDEO /*1006*/:
                try {
                    this.f9378a.c();
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    str = "ACTION_STOP_LOCATION";
                    break;
                }
            case Constants.RESULT_CODE_CHOOSE_VIDEO /*1007*/:
                try {
                    this.f9378a.d();
                    return;
                } catch (Throwable th7) {
                    io.a(th7, "ClientActionHandler", "ACTION_DESTROY");
                    return;
                }
            default:
                return;
        }
        io.a(th, "ClientActionHandler", str);
    }
}
