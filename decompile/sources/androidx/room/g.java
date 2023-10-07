package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.c;
import androidx.room.d;
import androidx.room.f;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class g {

    /* renamed from: a  reason: collision with root package name */
    final Context f4425a;

    /* renamed from: b  reason: collision with root package name */
    final String f4426b;

    /* renamed from: c  reason: collision with root package name */
    int f4427c;

    /* renamed from: d  reason: collision with root package name */
    final f f4428d;

    /* renamed from: e  reason: collision with root package name */
    final f.b f4429e;

    /* renamed from: f  reason: collision with root package name */
    d f4430f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f4431g;

    /* renamed from: h  reason: collision with root package name */
    final c f4432h = new c.a() {
        public void a(final String[] strArr) {
            g.this.f4431g.execute(new Runnable() {
                public void run() {
                    g.this.f4428d.a(strArr);
                }
            });
        }
    };

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f4433i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    final ServiceConnection f4434j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f4435k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f4436l;

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f4437m;

    g(Context context, String str, f fVar, Executor executor) {
        AnonymousClass2 r0 = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                g.this.f4430f = d.a.a(iBinder);
                g.this.f4431g.execute(g.this.f4435k);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                g.this.f4431g.execute(g.this.f4436l);
                g.this.f4430f = null;
            }
        };
        this.f4434j = r0;
        this.f4435k = new Runnable() {
            public void run() {
                try {
                    d dVar = g.this.f4430f;
                    if (dVar != null) {
                        g gVar = g.this;
                        gVar.f4427c = dVar.a(gVar.f4432h, g.this.f4426b);
                        g.this.f4428d.a(g.this.f4429e);
                    }
                } catch (RemoteException e2) {
                    Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
                }
            }
        };
        this.f4436l = new Runnable() {
            public void run() {
                g.this.f4428d.b(g.this.f4429e);
            }
        };
        this.f4437m = new Runnable() {
            public void run() {
                g.this.f4428d.b(g.this.f4429e);
                try {
                    d dVar = g.this.f4430f;
                    if (dVar != null) {
                        dVar.a(g.this.f4432h, g.this.f4427c);
                    }
                } catch (RemoteException e2) {
                    Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
                }
                g.this.f4425a.unbindService(g.this.f4434j);
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.f4425a = applicationContext;
        this.f4426b = str;
        this.f4428d = fVar;
        this.f4431g = executor;
        this.f4429e = new f.b((String[]) fVar.f4402a.keySet().toArray(new String[0])) {
            public void a(Set<String> set) {
                if (!g.this.f4433i.get()) {
                    try {
                        d dVar = g.this.f4430f;
                        if (dVar != null) {
                            dVar.a(g.this.f4427c, (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException e2) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e2);
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return true;
            }
        };
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), r0, 1);
    }
}
