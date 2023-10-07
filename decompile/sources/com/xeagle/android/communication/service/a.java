package com.xeagle.android.communication.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.a;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.communication.service.MAVLinkService;
import dx.b;
import java.util.concurrent.atomic.AtomicReference;

public class a implements a.C0089a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12367a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f12368b = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<String> f12369c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final b f12370d = new b() {

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f22486b = new Runnable() {
            public void run() {
                a.this.f12373g.a();
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f22487c = new Runnable() {
            public void run() {
                a.this.f12373g.b();
                a.this.g();
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f22488d = new Runnable() {
            public void run() {
                a.this.f12368b.removeCallbacks(this);
                String str = (String) a.this.f12369c.get();
            }
        };

        public void a() {
            a.this.f12368b.post(this.f22486b);
        }

        public void a(final MAVLinkMessage mAVLinkMessage) {
            a.this.f12368b.post(new Runnable() {
                public void run() {
                    a.this.f12373g.a(mAVLinkMessage);
                }
            });
        }

        public void a(String str) {
            a.this.f12369c.set(str);
            a.this.f12368b.post(this.f22488d);
        }

        public void b() {
            a.this.f12368b.post(this.f22487c);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final ServiceConnection f12371e = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("setStatus", "onServiceConnected: ");
            if (iBinder instanceof MAVLinkService.a) {
                MAVLinkService.a unused = a.this.f12375i = (MAVLinkService.a) iBinder;
                a.this.i();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            a.this.j();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final Context f12372f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final a.b f12373g;

    /* renamed from: h  reason: collision with root package name */
    private final String f12374h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public MAVLinkService.a f12375i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12376j;

    public a(Context context, a.b bVar) {
        this.f12372f = context;
        this.f12373g = bVar;
        this.f12374h = context.getString(R.string.MAVLinkError);
    }

    private void f() {
        Log.i("setStatus", "openConnection: " + this.f12376j);
        if (this.f12376j) {
            h();
        } else {
            this.f12372f.bindService(new Intent(this.f12372f, MAVLinkService.class), this.f12371e, 1);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f12376j) {
            if (this.f12375i.b() == 2) {
                System.out.print("Disconnecting...");
                j();
                this.f12372f.unbindService(this.f12371e);
                this.f12375i.d();
            }
            this.f12375i.a(f12367a);
        }
    }

    private void h() {
        this.f12375i.c();
        this.f12375i.a(f12367a, this.f12370d);
    }

    /* access modifiers changed from: private */
    public void i() {
        Log.i("setStatus", "onConnectedService: ");
        this.f12376j = true;
        h();
    }

    /* access modifiers changed from: private */
    public void j() {
        this.f12376j = false;
        this.f12373g.b();
    }

    public void a(int i2) {
        Log.i("setStatus", "toggleConnectionState: " + this.f12376j + " ,i: " + i2);
        Context context = this.f12372f;
        if ((context instanceof XEagleApp) && ((XEagleApp) context).c()) {
            g();
            f();
        } else if (this.f12376j) {
            g();
        } else {
            f();
        }
    }

    public void a(MAVLinkPacket mAVLinkPacket) {
        MAVLinkService.a aVar = this.f12375i;
        if (aVar != null) {
            aVar.a(mAVLinkPacket);
        }
    }

    public boolean a() {
        MAVLinkService.a aVar = this.f12375i;
        if (aVar != null) {
            return this.f12376j && aVar.b() == 2;
        }
        this.f12372f.bindService(new Intent(this.f12372f, MAVLinkService.class), this.f12371e, 1);
        return false;
    }

    public void b() {
        g();
    }

    public boolean c() {
        MAVLinkService.a aVar = this.f12375i;
        if (aVar != null) {
            return this.f12376j && aVar.b() == 2 && e();
        }
        this.f12372f.bindService(new Intent(this.f12372f, MAVLinkService.class), this.f12371e, 1);
        return false;
    }

    public void d() {
        if (a()) {
            Log.i("UDP", "queryConnectionState: ");
            this.f12373g.a();
            return;
        }
        this.f12373g.b();
    }

    public boolean e() {
        MAVLinkService.a aVar = this.f12375i;
        if (aVar != null) {
            return aVar.a();
        }
        Log.i(f12367a, "isLinked: mService == null");
        return false;
    }
}
