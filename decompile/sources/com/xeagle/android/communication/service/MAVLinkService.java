package com.xeagle.android.communication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.MAVLink.MAVLinkPacket;
import com.xeagle.android.utils.Utils;
import dx.b;
import java.lang.ref.WeakReference;

public class MAVLinkService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22463a = "MAVLinkService";

    /* renamed from: b  reason: collision with root package name */
    private final a f22464b = new a(this);

    /* renamed from: c  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f22465c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ju.a f22466d;

    public static class a extends Binder {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<MAVLinkService> f22467a;

        a(MAVLinkService mAVLinkService) {
            this.f22467a = new WeakReference<>(mAVLinkService);
        }

        public void a(MAVLinkPacket mAVLinkPacket) {
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService != null && mAVLinkService.f22466d != null) {
                mAVLinkService.f22466d.a(mAVLinkPacket);
            }
        }

        public void a(String str) {
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService != null && mAVLinkService.f22466d != null) {
                mAVLinkService.f22466d.a(str);
            }
        }

        public void a(String str, b bVar) {
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService != null && mAVLinkService.f22466d != null) {
                mAVLinkService.f22466d.a(str, bVar);
            }
        }

        public boolean a() {
            String str;
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService == null) {
                str = "service == null";
            } else if (mAVLinkService.f22466d != null) {
                return mAVLinkService.f22466d.c();
            } else {
                str = "service.mavConnection";
            }
            Log.i("getDataLinkState", str);
            return false;
        }

        public int b() {
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService == null || mAVLinkService.f22466d == null) {
                return 0;
            }
            return mAVLinkService.f22466d.d();
        }

        public void c() {
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService == null) {
                Log.i("CONNECT_DB", "service == null: ");
                return;
            }
            Log.i("CONNECT_DB", "connectMavLink: ");
            mAVLinkService.a();
        }

        public void d() {
            MAVLinkService mAVLinkService = (MAVLinkService) this.f22467a.get();
            if (mAVLinkService != null) {
                mAVLinkService.b();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        Utils.ConnectionType valueOf = Utils.ConnectionType.valueOf(this.f22465c.L());
        ju.a aVar = this.f22466d;
        if (aVar == null || aVar.k() != valueOf.a()) {
            this.f22466d = valueOf.a(this);
        }
        if (this.f22466d.d() == 0) {
            this.f22466d.a();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        Log.d(f22463a, "Pre disconnect");
        ju.a aVar = this.f22466d;
        if (aVar != null && aVar.d() != 0) {
            this.f22466d.b();
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f22464b;
    }

    public void onCreate() {
        super.onCreate();
        this.f22465c = new com.xeagle.android.utils.prefs.a(getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
        b();
    }
}
