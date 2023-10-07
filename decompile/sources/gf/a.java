package gf;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.d;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import fg.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    com.google.android.gms.common.a f28484a;

    /* renamed from: b  reason: collision with root package name */
    zzf f28485b;

    /* renamed from: c  reason: collision with root package name */
    boolean f28486c;

    /* renamed from: d  reason: collision with root package name */
    final Object f28487d = new Object();

    /* renamed from: e  reason: collision with root package name */
    c f28488e;

    /* renamed from: f  reason: collision with root package name */
    final long f28489f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f28490g;

    /* renamed from: gf.a$a  reason: collision with other inner class name */
    public static final class C0184a {

        /* renamed from: a  reason: collision with root package name */
        private final String f28491a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28492b;

        @Deprecated
        public C0184a(String str, boolean z2) {
            this.f28491a = str;
            this.f28492b = z2;
        }

        public String a() {
            return this.f28491a;
        }

        public boolean b() {
            return this.f28492b;
        }

        public String toString() {
            String str = this.f28491a;
            boolean z2 = this.f28492b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z2);
            return sb.toString();
        }
    }

    public a(Context context, long j2, boolean z2, boolean z3) {
        Context applicationContext;
        m.a(context);
        if (z2 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f28490g = context;
        this.f28486c = false;
        this.f28489f = j2;
    }

    private final C0184a a(int i2) throws IOException {
        C0184a aVar;
        m.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f28486c) {
                synchronized (this.f28487d) {
                    c cVar = this.f28488e;
                    if (cVar == null || !cVar.f28495b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    a(false);
                    if (!this.f28486c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
            m.a(this.f28484a);
            m.a(this.f28485b);
            aVar = new C0184a(this.f28485b.zzc(), this.f28485b.zze(true));
        }
        b();
        return aVar;
    }

    public static C0184a a(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        a aVar = new a(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.a(false);
            C0184a a2 = aVar.a(-1);
            aVar.a(a2, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", (Throwable) null);
            aVar.a();
            return a2;
        } catch (Throwable th) {
            aVar.a();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f28487d
            monitor-enter(r0)
            gf.c r1 = r6.f28488e     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0011
            java.util.concurrent.CountDownLatch r1 = r1.f28494a     // Catch:{ all -> 0x0022 }
            r1.countDown()     // Catch:{ all -> 0x0022 }
            gf.c r1 = r6.f28488e     // Catch:{ InterruptedException -> 0x0011 }
            r1.join()     // Catch:{ InterruptedException -> 0x0011 }
        L_0x0011:
            long r1 = r6.f28489f     // Catch:{ all -> 0x0022 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            gf.c r3 = new gf.c     // Catch:{ all -> 0x0022 }
            r3.<init>(r6, r1)     // Catch:{ all -> 0x0022 }
            r6.f28488e = r3     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gf.a.b():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.m.c(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f28490g     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.common.a r0 = r3.f28484a     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0031
        L_0x000f:
            boolean r0 = r3.f28486c     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.common.stats.a r0 = com.google.android.gms.common.stats.a.a()     // Catch:{ all -> 0x001f }
            android.content.Context r1 = r3.f28490g     // Catch:{ all -> 0x001f }
            com.google.android.gms.common.a r2 = r3.f28484a     // Catch:{ all -> 0x001f }
            r0.a(r1, r2)     // Catch:{ all -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x0033 }
        L_0x0027:
            r0 = 0
            r3.f28486c = r0     // Catch:{ all -> 0x0033 }
            r0 = 0
            r3.f28485b = r0     // Catch:{ all -> 0x0033 }
            r3.f28484a = r0     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gf.a.a():void");
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z2) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        m.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f28486c) {
                a();
            }
            Context context = this.f28490g;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int a2 = d.b().a(context, (int) f.f17696b);
                if (a2 != 0) {
                    if (a2 != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (com.google.android.gms.common.stats.a.a().a(context, intent, aVar, 1)) {
                    this.f28484a = aVar;
                    this.f28485b = zze.zza(aVar.a(10000, TimeUnit.MILLISECONDS));
                    this.f28486c = true;
                    if (z2) {
                        b();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                throw new GooglePlayServicesNotAvailableException(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(C0184a aVar, boolean z2, float f2, long j2, String str, Throwable th) {
        if (Math.random() > i.f27244a) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", str2);
        if (aVar != null) {
            if (true != aVar.b()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
            String a2 = aVar.a();
            if (a2 != null) {
                hashMap.put("ad_id_size", Integer.toString(a2.length()));
            }
        }
        if (th != null) {
            hashMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, th.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j2));
        new b(this, hashMap).start();
        return true;
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        a();
        super.finalize();
    }
}
