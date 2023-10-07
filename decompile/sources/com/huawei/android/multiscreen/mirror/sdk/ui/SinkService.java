package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.huawei.android.multiscreen.mirror.sdk.api.IMRSinkCallback;
import com.huawei.android.multiscreen.mirror.sdk.api.MRComponentManager;
import com.huawei.android.multiscreen.mirror.sdk.api.MRSink;
import com.huawei.android.multiscreen.mirror.sdk.api.b;
import com.huawei.android.multiscreen.mirror.sdk.structs.SDeviceDescription;
import com.huawei.android.multiscreen.mirror.sdk.structs.SSinkProperty;

public class SinkService extends Service {
    private final String TAG = "MIRROR_SDK";
    /* access modifiers changed from: private */
    public Context context;
    private b mHelper;
    private MRComponentManager mManager;
    private MRSink mSink;
    IMRSinkCallback mSinkCallback = new IMRSinkCallback() {
        public int Connected() {
            return 0;
        }

        public int Disconnected() {
            return 0;
        }

        public int DoesReceiveConnection(SDeviceDescription sDeviceDescription) {
            SinkService.this.context.startService(new Intent("android.power.dlna"));
            return 1;
        }

        public int Error(int i2, String str) {
            return 0;
        }

        public int MirrorClosedBySource() {
            return 0;
        }

        public int OnConnecting() {
            return 0;
        }

        public int Paused() {
            return 0;
        }

        public int Resumed() {
            return 0;
        }

        public int Started() {
            return 0;
        }

        public int Stopped() {
            return 0;
        }
    };

    public IBinder onBind(Intent intent) {
        Log.d("MIRROR_SDK", "SinkService onBind()");
        return this.mHelper.b();
    }

    public void onCreate() {
        super.onCreate();
        Log.d("MIRROR_SDK", "SinkService onCreate()");
        this.context = this;
        MRComponentManager mRComponentManager = new MRComponentManager(this);
        this.mManager = mRComponentManager;
        mRComponentManager.a("ICOS.MIRROR.SINK", false);
        this.mSink = this.mManager.b();
        IPManager iPManager = new IPManager(this);
        this.mSink.a(new SSinkProperty(true, true, 0, 0, iPManager.getIPAddress(), iPManager.getMacAddress(), "Sink"));
        b bVar = new b(this.mManager, LayoutActivity.class, this);
        this.mHelper = bVar;
        bVar.a(this.mSinkCallback);
        this.mSink.a();
        GrabDemoActivityTask.buildInstence(this).start();
    }

    public void onDestroy() {
        this.mHelper.a();
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        Log.d("MIRROR_SDK", "SinkService onUnbind()");
        return super.onUnbind(intent);
    }
}
