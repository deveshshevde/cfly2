package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

public final class iy extends Handler {

    /* renamed from: a  reason: collision with root package name */
    iw f9379a = null;

    public iy(Looper looper, iw iwVar) {
        super(looper);
        this.f9379a = iwVar;
    }

    public iy(iw iwVar) {
        this.f9379a = iwVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            try {
                iw iwVar = this.f9379a;
                if (iwVar != null) {
                    iwVar.a((Inner_3dMap_location) message.obj);
                }
            } catch (Throwable th) {
                io.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
            }
        }
    }
}
