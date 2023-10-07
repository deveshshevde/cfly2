package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import com.huawei.android.multiscreen.R;
import com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel;
import com.huawei.android.multiscreen.mirror.sdk.api.IMRSinkCallback;
import com.huawei.android.multiscreen.mirror.sdk.api.MRComponentManager;
import com.huawei.android.multiscreen.mirror.sdk.api.MRSink;
import com.huawei.android.multiscreen.mirror.sdk.structs.SDeviceDescription;
import com.huawei.android.multiscreen.mirror.sdk.structs.SSinkProperty;
import java.util.concurrent.Semaphore;

public class MirrorReceiverActivity extends Activity {
    private static final int SINK_CLOSE_BY_SOURCE = 36;
    private static final int SINK_CONNECTED = 40;
    private static final int SINK_DISCONNECTED = 35;
    private static final int SINK_DOSE_RECEIVE_CONNECTION = 38;
    private static final int SINK_ERROR = 32;
    private static final int SINK_ON_CONNECTING = 37;
    private static final int SINK_PAUSED = 33;
    private static final int SINK_RESUMED = 34;
    private static final int SINK_STARTED = 30;
    private static final int SINK_STOPPED = 31;
    private static final int START_SINK = 39;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHander = new Handler(new Handler.Callback() {
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d0, code lost:
            r6 = android.widget.Toast.makeText(r6, r0, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d4, code lost:
            r6.show();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00d7, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                int r0 = r6.what
                r1 = 0
                switch(r0) {
                    case 30: goto L_0x00c8;
                    case 31: goto L_0x00bf;
                    case 32: goto L_0x0098;
                    case 33: goto L_0x008f;
                    case 34: goto L_0x0086;
                    case 35: goto L_0x007d;
                    case 36: goto L_0x0074;
                    case 37: goto L_0x006b;
                    case 38: goto L_0x001d;
                    case 39: goto L_0x0012;
                    case 40: goto L_0x0008;
                    default: goto L_0x0006;
                }
            L_0x0006:
                goto L_0x00d7
            L_0x0008:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "Connected"
                goto L_0x00d0
            L_0x0012:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                com.huawei.android.multiscreen.mirror.sdk.api.MRSink r6 = r6.mSink
                r6.a()
                goto L_0x00d7
            L_0x001d:
                java.lang.Object r6 = r6.obj
                com.huawei.android.multiscreen.mirror.sdk.structs.SDeviceDescription r6 = (com.huawei.android.multiscreen.mirror.sdk.structs.SDeviceDescription) r6
                android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r2 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r2 = r2.mContext
                r0.<init>(r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "是否接收来自"
                r2.<init>(r3)
                java.lang.String r6 = r6.a()
                r2.append(r6)
                java.lang.String r6 = "的镜像连接?"
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                android.app.AlertDialog$Builder r6 = r0.setMessage(r6)
                int r0 = com.huawei.android.multiscreen.R.drawable.ic_launcher
                android.app.AlertDialog$Builder r6 = r6.setIcon(r0)
                int r0 = com.huawei.android.multiscreen.R.string.not_allow
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity$1$1 r2 = new com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity$1$1
                r2.<init>()
                android.app.AlertDialog$Builder r6 = r6.setNegativeButton(r0, r2)
                int r0 = com.huawei.android.multiscreen.R.string.allow
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity$1$2 r2 = new com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity$1$2
                r2.<init>()
                android.app.AlertDialog$Builder r6 = r6.setPositiveButton(r0, r2)
                android.app.AlertDialog r6 = r6.create()
                r6.show()
                goto L_0x00d7
            L_0x006b:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "OnConnecting"
                goto L_0x00d0
            L_0x0074:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "MirrorClosedBySource"
                goto L_0x00d0
            L_0x007d:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "Disconnected"
                goto L_0x00d0
            L_0x0086:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "Resumed"
                goto L_0x00d0
            L_0x008f:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "Paused"
                goto L_0x00d0
            L_0x0098:
                int r0 = r6.arg1
                java.lang.Object r6 = r6.obj
                java.lang.String r6 = (java.lang.String) r6
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r2 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r2 = r2.mContext
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Error:code "
                r3.<init>(r4)
                r3.append(r0)
                java.lang.String r0 = ",msg "
                r3.append(r0)
                r3.append(r6)
                java.lang.String r6 = r3.toString()
                android.widget.Toast r6 = android.widget.Toast.makeText(r2, r6, r1)
                goto L_0x00d4
            L_0x00bf:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "Stopped"
                goto L_0x00d0
            L_0x00c8:
                com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity r6 = com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.this
                android.content.Context r6 = r6.mContext
                java.lang.String r0 = "Started"
            L_0x00d0:
                android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r1)
            L_0x00d4:
                r6.show()
            L_0x00d7:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.multiscreen.mirror.sdk.ui.MirrorReceiverActivity.AnonymousClass1.handleMessage(android.os.Message):boolean");
        }
    });
    private MRComponentManager mManager;
    /* access modifiers changed from: private */
    public MRSink mSink;
    /* access modifiers changed from: private */
    public int permission;
    /* access modifiers changed from: private */
    public Semaphore sem;
    /* access modifiers changed from: private */
    public Surface surface;

    private class MRSinkCallBackImpl implements IMRSinkCallback {
        private MRSinkCallBackImpl() {
        }

        /* synthetic */ MRSinkCallBackImpl(MirrorReceiverActivity mirrorReceiverActivity, MRSinkCallBackImpl mRSinkCallBackImpl) {
            this();
        }

        public int Connected() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(40);
            return 0;
        }

        public int Disconnected() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(35);
            return 0;
        }

        public int DoesReceiveConnection(SDeviceDescription sDeviceDescription) {
            MirrorReceiverActivity.this.sem = new Semaphore(0);
            Message obtainMessage = MirrorReceiverActivity.this.mHander.obtainMessage(38);
            obtainMessage.obj = sDeviceDescription;
            MirrorReceiverActivity.this.mHander.sendMessage(obtainMessage);
            try {
                MirrorReceiverActivity.this.sem.acquire();
            } catch (InterruptedException e2) {
                Log.e("MIRROR_SDK", "sem.acquire() Exception", e2);
            }
            return MirrorReceiverActivity.this.permission;
        }

        public int Error(int i2, String str) {
            Message obtainMessage = MirrorReceiverActivity.this.mHander.obtainMessage(32);
            obtainMessage.arg1 = i2;
            obtainMessage.obj = str;
            MirrorReceiverActivity.this.mHander.sendMessage(obtainMessage);
            return 0;
        }

        public int MirrorClosedBySource() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(36);
            return 0;
        }

        public int OnConnecting() {
            MirrorReceiverActivity.this.surface = ((SurfaceView) MirrorReceiverActivity.this.findViewById(R.id.sink_view)).getHolder().getSurface();
            SSinkProperty d2 = MirrorReceiverActivity.this.mSink.d();
            d2.a(MirrorReceiverActivity.this.surface);
            MirrorReceiverActivity.this.mSink.a(d2);
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(37);
            return 0;
        }

        public int Paused() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(33);
            return 0;
        }

        public int Resumed() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(34);
            return 0;
        }

        public int Started() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(30);
            return 0;
        }

        public int Stopped() {
            MirrorReceiverActivity.this.mHander.sendEmptyMessage(31);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sink_main);
        this.mContext = this;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.d("MIRROR_SDK", "Activity onDestroy()");
        this.mSink.b();
        this.mManager.a();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MRComponentManager mRComponentManager = new MRComponentManager(this);
        this.mManager = mRComponentManager;
        mRComponentManager.a(EMirrorLogLevel.DEBUG);
        this.mManager.a("ICOS.MIRROR.SINK", false);
        this.mSink = this.mManager.b();
        IPManager iPManager = new IPManager(this);
        SSinkProperty sSinkProperty = new SSinkProperty(false, true, 0, 0, iPManager.getIPAddress(), iPManager.getMacAddress(), "sink", (Surface) null);
        MRSinkCallBackImpl mRSinkCallBackImpl = new MRSinkCallBackImpl(this, (MRSinkCallBackImpl) null);
        this.mSink.a(sSinkProperty);
        this.mSink.a((IMRSinkCallback) mRSinkCallBackImpl);
        this.mHander.sendEmptyMessageDelayed(39, 1000);
    }
}
