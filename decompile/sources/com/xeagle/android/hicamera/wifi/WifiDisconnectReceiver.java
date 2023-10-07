package com.xeagle.android.hicamera.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import com.xeagle.android.hicamera.unity.b;

public class WifiDisconnectReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public b f23778a = null;

    /* renamed from: b  reason: collision with root package name */
    Runnable f23779b = new Runnable() {
        public void run() {
            if (WifiDisconnectReceiver.a(WifiDisconnectReceiver.this) >= 250) {
                Log.d("WifiDisconnectReceiver", "runCheckConnectState:timeout");
            } else {
                WifiDisconnectReceiver.this.f23786i.postDelayed(this, 60);
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    Runnable f23780c = new Runnable() {
        public void run() {
            int a2 = WifiDisconnectReceiver.this.f23778a.a("\"" + WifiDisconnectReceiver.this.f23782e + "\"", "\"" + WifiDisconnectReceiver.this.f23781d + "\"");
            if (-1 == a2 || -2 == a2) {
                if (WifiDisconnectReceiver.a(WifiDisconnectReceiver.this) < 250) {
                    WifiDisconnectReceiver.this.f23786i.postDelayed(this, 60);
                }
            } else if (-3 != a2) {
                int unused = WifiDisconnectReceiver.this.f23783f = 0;
                WifiDisconnectReceiver.this.f23786i.postDelayed(WifiDisconnectReceiver.this.f23779b, 60);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f23781d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f23782e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f23783f = 0;

    /* renamed from: g  reason: collision with root package name */
    private NetworkInfo.DetailedState f23784g = null;

    /* renamed from: h  reason: collision with root package name */
    private a f23785h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Handler f23786i = new Handler();

    /* renamed from: com.xeagle.android.hicamera.wifi.WifiDisconnectReceiver$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23789a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.net.NetworkInfo$DetailedState[] r0 = android.net.NetworkInfo.DetailedState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23789a = r0
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23789a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.net.NetworkInfo$DetailedState r1 = android.net.NetworkInfo.DetailedState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.hicamera.wifi.WifiDisconnectReceiver.AnonymousClass3.<clinit>():void");
        }
    }

    public interface a {
        void a(NetworkInfo.DetailedState detailedState);
    }

    public WifiDisconnectReceiver(Context context) {
        this.f23778a = new b(context, true);
    }

    static /* synthetic */ int a(WifiDisconnectReceiver wifiDisconnectReceiver) {
        int i2 = wifiDisconnectReceiver.f23783f;
        wifiDisconnectReceiver.f23783f = i2 + 1;
        return i2;
    }

    public void a() {
        this.f23786i.removeCallbacks(this.f23779b);
        this.f23786i.removeCallbacks(this.f23780c);
    }

    public void onReceive(Context context, Intent intent) {
        Runnable runnable;
        Handler handler;
        String action = intent.getAction();
        Log.d("WifiDisconnectReceiver", "strAction:" + action);
        if (action.equals("android.net.wifi.STATE_CHANGE")) {
            NetworkInfo.DetailedState detailedState = ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getDetailedState();
            Log.d("WifiDisconnectReceiver", "info.state = " + detailedState);
            if (detailedState != this.f23784g) {
                this.f23784g = detailedState;
                a aVar = this.f23785h;
                if (aVar != null) {
                    aVar.a(detailedState);
                }
                int i2 = AnonymousClass3.f23789a[detailedState.ordinal()];
                if (i2 == 1) {
                    this.f23786i.removeCallbacks(this.f23779b);
                } else if (i2 == 2) {
                    Log.d(context.getClass().getSimpleName(), "Wifi DISCONNECTED");
                    String a2 = this.f23778a.a();
                    if (a2.equals("")) {
                        Log.d("WifiDisconnectReceiver", "DISCONNECTED");
                        return;
                    }
                    String a3 = this.f23778a.a(a2);
                    Log.d("WifiDisconnectReceiver", a2 + ":" + a3);
                    int a4 = this.f23778a.a("\"" + a2 + "\"", "\"" + a3 + "\"");
                    if (-1 == a4 || -2 == a4) {
                        this.f23781d = a3;
                        this.f23782e = a2;
                        this.f23783f = 0;
                        handler = this.f23786i;
                        runnable = this.f23780c;
                    } else if (-3 != a4) {
                        this.f23783f = 0;
                        handler = this.f23786i;
                        runnable = this.f23779b;
                    } else {
                        return;
                    }
                    handler.postDelayed(runnable, 60);
                }
            }
        } else if (action.equals("com.xeagle.DV_ISALIVE_ACTION")) {
            boolean booleanExtra = intent.getBooleanExtra("networkpast", true);
            Log.d(context.getClass().getSimpleName(), "WifiDisconnectReceiver bNetworkPast:" + booleanExtra);
        }
    }
}
