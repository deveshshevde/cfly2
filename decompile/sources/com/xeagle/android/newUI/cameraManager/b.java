package com.xeagle.android.newUI.cameraManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.retrofitLogin.sochip.SochipContract;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.cameraManager.CameraClientService;
import com.xeagle.android.newUI.cameraManager.a;
import com.xeagle.android.newUI.cameraManager.b;
import com.xeagle.android.newUI.cameraManager.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12718a = "b";

    /* renamed from: i  reason: collision with root package name */
    private static b f12719i;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final DroneInterfaces.b f12720b;

    /* renamed from: c  reason: collision with root package name */
    private IChannelListener f12721c = new IChannelListener() {
        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, Object obj, String[] strArr) {
            if (b.this.f12728k != null) {
                b.this.f12728k.a(1, i2, obj, strArr);
            }
        }

        public void onChannelEvent(int i2, Object obj, String... strArr) {
            b.this.f12720b.post(new Runnable(i2, obj, strArr) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ Object f$2;
                public final /* synthetic */ String[] f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    b.AnonymousClass1.this.a(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private SochipContract.loadView f12722d = new SochipContract.loadView() {
        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2) {
            if (b.this.f12729l != null) {
                b.this.f12729l.a(2, i2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, Object obj) {
            if (b.this.f12729l != null) {
                b.this.f12729l.a(2, i2, obj);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, String str) {
            if (b.this.f12729l != null) {
                b.this.f12729l.a(2, i2, str);
            }
        }

        public void socError(int i2, String str) {
            b.this.f12720b.post(new Runnable(i2, str) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    b.AnonymousClass2.this.a(this.f$1, this.f$2);
                }
            });
        }

        public void socFailure(int i2) {
            b.this.f12720b.post(new Runnable(i2) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    b.AnonymousClass2.this.a(this.f$1);
                }
            });
        }

        public void socSuccess(int i2, Object obj) {
            b.this.f12720b.post(new Runnable(i2, obj) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ Object f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    b.AnonymousClass2.this.a(this.f$1, this.f$2);
                }
            });
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private SochipPresenter.SochipTcpListener f12723e = new SochipPresenter.SochipTcpListener() {
        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, Object obj, String[] strArr) {
            if (b.this.f12728k != null) {
                b.this.f12728k.a(2, i2, obj, strArr);
            }
        }

        public void onTcpListener(int i2, Object obj, String... strArr) {
            b.this.f12720b.post(new Runnable(i2, obj, strArr) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ Object f$2;
                public final /* synthetic */ String[] f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    b.AnonymousClass3.this.a(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final a.b f12724f = new a.b() {
        /* access modifiers changed from: private */
        public /* synthetic */ void c(int i2) {
            b.this.f12727j.b(i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(int i2) {
            b.this.f12727j.a(i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(int i2, String str) {
            b.this.f12727j.a(i2, str);
        }

        public void a(int i2) {
            b.this.f12720b.post(new Runnable(i2) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    b.AnonymousClass4.this.d(this.f$1);
                }
            });
        }

        public void a(int i2, String str) {
            b.this.f12720b.post(new Runnable(i2, str) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    b.AnonymousClass4.this.d(this.f$1, this.f$2);
                }
            });
        }

        public void b(int i2) {
            b.this.f12720b.post(new Runnable(i2) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    b.AnonymousClass4.this.c(this.f$1);
                }
            });
        }

        public void b(int i2, String str) {
            b.this.f12727j.b(i2, str);
        }

        public void c(int i2, String str) {
            b.this.f12727j.c(i2, str);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final ServiceConnection f12725g = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CameraClientService.a unused = b.this.f12730m = (CameraClientService.a) iBinder;
            b bVar = b.this;
            bVar.c(bVar.f12732o);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            b.this.c();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private Context f12726h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public c.a f12727j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public c.C0090c f12728k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public c.b f12729l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public CameraClientService.a f12730m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12731n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f12732o = 1;

    public b(Context context, DroneInterfaces.b bVar, c.a aVar, c.C0090c cVar, c.b bVar2) {
        this.f12726h = context.getApplicationContext();
        this.f12720b = bVar;
        this.f12727j = aVar;
        this.f12728k = cVar;
        this.f12729l = bVar2;
    }

    public static b a(Context context, DroneInterfaces.b bVar, c.a aVar, c.C0090c cVar, c.b bVar2) {
        if (f12719i == null) {
            f12719i = new b(context, bVar, aVar, cVar, bVar2);
        }
        return f12719i;
    }

    private void b(int i2) {
        this.f12730m.a(i2, this.f12720b, this.f12721c, this.f12722d, this.f12723e);
        this.f12730m.a(f12718a, this.f12724f);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f12731n = false;
        this.f12727j.b(this.f12730m.a().cameraType());
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        this.f12731n = true;
        b(i2);
    }

    public void a() {
        if (this.f12731n) {
            if (this.f12730m.b() == 2) {
                this.f12726h.unbindService(this.f12725g);
                c();
            }
            this.f12730m.c();
            this.f12730m.a(f12718a);
            return;
        }
        CameraClientService.a aVar = this.f12730m;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void a(int i2) {
        this.f12732o = i2;
        String str = f12718a;
        Log.i(str, "openConnection: " + this.f12731n);
        if (this.f12731n) {
            b(i2);
        } else {
            this.f12726h.bindService(new Intent(this.f12726h, CameraClientService.class), this.f12725g, 1);
        }
    }

    public a b() {
        CameraClientService.a aVar = this.f12730m;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }
}
