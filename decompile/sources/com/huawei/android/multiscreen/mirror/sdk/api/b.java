package com.huawei.android.multiscreen.mirror.sdk.api;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.huawei.android.multiscreen.mirror.sdk.structs.SSinkProperty;
import java.util.concurrent.Semaphore;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f20941a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public MRComponentManager f20942b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public MRSink f20943c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f20944d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f20945e;

    /* renamed from: f  reason: collision with root package name */
    private IMRSinkCallback f20946f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Semaphore f20947g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Semaphore f20948h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Object f20949i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f20950j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f20951k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f20952l;

    /* renamed from: m  reason: collision with root package name */
    private Context f20953m;

    /* renamed from: n  reason: collision with root package name */
    private Handler f20954n = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 100) {
                b.this.f20941a = false;
            }
            return false;
        }
    });

    /* renamed from: o  reason: collision with root package name */
    private IMRSinkCallback f20955o = new IMRSinkCallback() {
    };

    protected interface a {
    }

    /* renamed from: com.huawei.android.multiscreen.mirror.sdk.api.b$b  reason: collision with other inner class name */
    protected class C0137b extends Binder {
        protected C0137b() {
        }

        public void a() {
            Log.d("MIRROR_SDK", "SinkService refuseMirror()");
            b.this.f20952l = false;
            synchronized (b.this.f20947g) {
                Log.d("MIRROR_SDK", "sem.notify(); in");
                b.this.f20950j = false;
                b.this.f20947g.notifyAll();
                Log.d("MIRROR_SDK", "sem.notify(); out");
            }
        }

        public void a(a aVar) {
            synchronized (b.this.f20949i) {
                b.this.f20945e = aVar;
            }
        }

        public boolean a(Surface surface) {
            Log.d("MIRROR_SDK", "SinkService setSurface()");
            b.this.f20952l = true;
            b bVar = b.this;
            bVar.f20943c = bVar.f20942b.b();
            if (b.this.f20943c == null) {
                a();
                return false;
            }
            SSinkProperty d2 = b.this.f20943c.d();
            d2.a(surface);
            Log.d("MIRROR_SDK", "SinkService setProperty() in");
            b.this.f20943c.a(d2);
            Log.d("MIRROR_SDK", "SinkService setProperty() out");
            synchronized (b.this.f20947g) {
                Log.d("MIRROR_SDK", "sem.notify(); in");
                b.this.f20950j = false;
                b.this.f20947g.notifyAll();
                Log.d("MIRROR_SDK", "sem.notify(); out");
            }
            return true;
        }

        public void b() {
            synchronized (b.this.f20948h) {
                Log.d("MIRROR_SDK", "semConnected.wait(); in");
                while (b.this.f20951k) {
                    try {
                        b.this.f20948h.wait();
                    } catch (InterruptedException e2) {
                        Log.e("MIRROR_SDK", "semConnected.wait() Exception", e2);
                    }
                }
                Log.d("MIRROR_SDK", "semConnected.wait(); out");
            }
        }

        public boolean c() {
            b bVar = b.this;
            bVar.f20943c = bVar.f20942b.b();
            if (b.this.f20943c == null) {
                return false;
            }
            EMirrorStatus e2 = b.this.f20943c.e();
            return (e2 == EMirrorStatus.CONNECTED || e2 == EMirrorStatus.PAUSED) ? b.this.f20943c.c() == 0 : e2 == EMirrorStatus.DISCONNECTED;
        }

        public void d() {
            synchronized (b.this.f20949i) {
                b.this.f20945e = null;
            }
        }
    }

    public b(MRComponentManager mRComponentManager, Class<?> cls, Context context) {
        Log.d("MIRROR_SDK", "MRSinkServiceHelper Initial()");
        this.f20941a = false;
        this.f20953m = context;
        this.f20944d = cls;
        this.f20942b = mRComponentManager;
        MRSink b2 = mRComponentManager.b();
        this.f20943c = b2;
        b2.a(this.f20955o);
        this.f20947g = new Semaphore(0);
        this.f20948h = new Semaphore(0);
        this.f20949i = new Object();
    }

    public void a() {
        this.f20946f = null;
    }

    public void a(IMRSinkCallback iMRSinkCallback) {
        this.f20946f = iMRSinkCallback;
    }

    public IBinder b() {
        Log.d("MIRROR_SDK", "getBinder");
        return new C0137b();
    }
}
