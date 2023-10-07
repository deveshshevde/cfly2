package bw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import bw.c;
import cc.f;
import cc.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class s {

    /* renamed from: b  reason: collision with root package name */
    private static volatile s f6080b;

    /* renamed from: a  reason: collision with root package name */
    final Set<c.a> f6081a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final a f6082c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6083d;

    private interface a {
        boolean a();

        void b();
    }

    private static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        boolean f6087a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f6088b;

        /* renamed from: c  reason: collision with root package name */
        private final f.a<ConnectivityManager> f6089c;

        /* renamed from: d  reason: collision with root package name */
        private final ConnectivityManager.NetworkCallback f6090d = new ConnectivityManager.NetworkCallback() {
            private void b(final boolean z2) {
                l.a((Runnable) new Runnable() {
                    public void run() {
                        AnonymousClass1.this.a(z2);
                    }
                });
            }

            /* access modifiers changed from: package-private */
            public void a(boolean z2) {
                l.a();
                boolean z3 = b.this.f6087a;
                b.this.f6087a = z2;
                if (z3 != z2) {
                    b.this.f6088b.a(z2);
                }
            }

            public void onAvailable(Network network) {
                b(true);
            }

            public void onLost(Network network) {
                b(false);
            }
        };

        b(f.a<ConnectivityManager> aVar, c.a aVar2) {
            this.f6089c = aVar;
            this.f6088b = aVar2;
        }

        public boolean a() {
            this.f6087a = this.f6089c.b().getActiveNetwork() != null;
            try {
                this.f6089c.b().registerDefaultNetworkCallback(this.f6090d);
                return true;
            } catch (RuntimeException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e2);
                }
                return false;
            }
        }

        public void b() {
            this.f6089c.b().unregisterNetworkCallback(this.f6090d);
        }
    }

    private static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        final c.a f6094a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6095b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f6096c;

        /* renamed from: d  reason: collision with root package name */
        private final f.a<ConnectivityManager> f6097d;

        /* renamed from: e  reason: collision with root package name */
        private final BroadcastReceiver f6098e = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                boolean z2 = c.this.f6095b;
                c cVar = c.this;
                cVar.f6095b = cVar.c();
                if (z2 != c.this.f6095b) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + c.this.f6095b);
                    }
                    c.this.f6094a.a(c.this.f6095b);
                }
            }
        };

        c(Context context, f.a<ConnectivityManager> aVar, c.a aVar2) {
            this.f6096c = context.getApplicationContext();
            this.f6097d = aVar;
            this.f6094a = aVar2;
        }

        public boolean a() {
            this.f6095b = c();
            try {
                this.f6096c.registerReceiver(this.f6098e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                return true;
            } catch (SecurityException e2) {
                if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                    return false;
                }
                Log.w("ConnectivityMonitor", "Failed to register", e2);
                return false;
            }
        }

        public void b() {
            this.f6096c.unregisterReceiver(this.f6098e);
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            try {
                NetworkInfo activeNetworkInfo = this.f6097d.b().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
                }
                return true;
            }
        }
    }

    private s(final Context context) {
        f.a a2 = f.a(new f.a<ConnectivityManager>() {
            /* renamed from: a */
            public ConnectivityManager b() {
                return (ConnectivityManager) context.getSystemService("connectivity");
            }
        });
        AnonymousClass2 r1 = new c.a() {
            public void a(boolean z2) {
                ArrayList<c.a> arrayList;
                synchronized (s.this) {
                    arrayList = new ArrayList<>(s.this.f6081a);
                }
                for (c.a a2 : arrayList) {
                    a2.a(z2);
                }
            }
        };
        this.f6082c = Build.VERSION.SDK_INT >= 24 ? new b(a2, r1) : new c(context, a2, r1);
    }

    static s a(Context context) {
        if (f6080b == null) {
            synchronized (s.class) {
                if (f6080b == null) {
                    f6080b = new s(context.getApplicationContext());
                }
            }
        }
        return f6080b;
    }

    private void a() {
        if (!this.f6083d && !this.f6081a.isEmpty()) {
            this.f6083d = this.f6082c.a();
        }
    }

    private void b() {
        if (this.f6083d && this.f6081a.isEmpty()) {
            this.f6082c.b();
            this.f6083d = false;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(c.a aVar) {
        this.f6081a.add(aVar);
        a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b(c.a aVar) {
        this.f6081a.remove(aVar);
        b();
    }
}
