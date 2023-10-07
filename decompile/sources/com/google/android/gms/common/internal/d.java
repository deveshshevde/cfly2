package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class d<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zze = new Feature[0];
    private volatile String zzA;
    /* access modifiers changed from: private */
    public ConnectionResult zzB;
    /* access modifiers changed from: private */
    public boolean zzC;
    private volatile zzj zzD;
    bl zza;
    final Handler zzb;
    protected c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final g zzn;
    private final com.google.android.gms.common.d zzo;
    private final Object zzp;
    /* access modifiers changed from: private */
    public final Object zzq;
    /* access modifiers changed from: private */
    public k zzr;
    private T zzs;
    /* access modifiers changed from: private */
    public final ArrayList<au<?>> zzt;
    private aw zzu;
    private int zzv;
    /* access modifiers changed from: private */
    public final a zzw;
    /* access modifiers changed from: private */
    public final b zzx;
    private final int zzy;
    private final String zzz;

    public interface a {
        void a(int i2);

        void a(Bundle bundle);
    }

    public interface b {
        void a(ConnectionResult connectionResult);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.d$d  reason: collision with other inner class name */
    protected class C0122d implements c {
        public C0122d() {
        }

        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.e()) {
                d dVar = d.this;
                dVar.getRemoteService((h) null, dVar.getScopes());
            } else if (d.this.zzx != null) {
                d.this.zzx.a(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    protected d(Context context, Handler handler, g gVar, com.google.android.gms.common.d dVar, int i2, a aVar, b bVar) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        m.a(context, (Object) "Context must not be null");
        this.zzl = context;
        m.a(handler, (Object) "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        m.a(gVar, (Object) "Supervisor must not be null");
        this.zzn = gVar;
        m.a(dVar, (Object) "API availability must not be null");
        this.zzo = dVar;
        this.zzy = i2;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected d(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.d.a r13, com.google.android.gms.common.internal.d.b r14, java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.g r3 = com.google.android.gms.common.internal.g.a(r10)
            com.google.android.gms.common.d r4 = com.google.android.gms.common.d.b()
            com.google.android.gms.common.internal.m.a(r13)
            com.google.android.gms.common.internal.m.a(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.d.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.d$a, com.google.android.gms.common.internal.d$b, java.lang.String):void");
    }

    protected d(Context context, Looper looper, g gVar, com.google.android.gms.common.d dVar, int i2, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        m.a(context, (Object) "Context must not be null");
        this.zzl = context;
        m.a(looper, (Object) "Looper must not be null");
        this.zzm = looper;
        m.a(gVar, (Object) "Supervisor must not be null");
        this.zzn = gVar;
        m.a(dVar, (Object) "API availability must not be null");
        this.zzo = dVar;
        this.zzb = new at(this, looper);
        this.zzy = i2;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    static /* synthetic */ void zzj(d dVar, zzj zzj2) {
        dVar.zzD = zzj2;
        if (dVar.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzj2.f17883d;
            n.a().a(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.f());
        }
    }

    static /* synthetic */ void zzk(d dVar, int i2) {
        int i3;
        int i4;
        synchronized (dVar.zzp) {
            i3 = dVar.zzv;
        }
        if (i3 == 3) {
            dVar.zzC = true;
            i4 = 5;
        } else {
            i4 = 4;
        }
        Handler handler = dVar.zzb;
        handler.sendMessage(handler.obtainMessage(i4, dVar.zzd.get(), 16));
    }

    static /* synthetic */ boolean zzn(d dVar, int i2, int i3, IInterface iInterface) {
        synchronized (dVar.zzp) {
            if (dVar.zzv != i2) {
                return false;
            }
            dVar.zzp(i3, iInterface);
            return true;
        }
    }

    static /* synthetic */ boolean zzo(d dVar) {
        if (dVar.zzC || TextUtils.isEmpty(dVar.getServiceDescriptor()) || TextUtils.isEmpty(dVar.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(dVar.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzp(int i2, T t2) {
        bl blVar;
        boolean z2 = false;
        if ((i2 == 4) == (t2 != null)) {
            z2 = true;
        }
        m.a(z2);
        synchronized (this.zzp) {
            this.zzv = i2;
            this.zzs = t2;
            if (i2 == 1) {
                aw awVar = this.zzu;
                if (awVar != null) {
                    g gVar = this.zzn;
                    String c2 = this.zza.c();
                    m.a(c2);
                    gVar.a(c2, this.zza.b(), this.zza.a(), awVar, zze(), this.zza.d());
                    this.zzu = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                aw awVar2 = this.zzu;
                if (!(awVar2 == null || (blVar = this.zza) == null)) {
                    String c3 = blVar.c();
                    String b2 = blVar.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(c3).length() + 70 + String.valueOf(b2).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(c3);
                    sb.append(" on ");
                    sb.append(b2);
                    Log.e("GmsClient", sb.toString());
                    g gVar2 = this.zzn;
                    String c4 = this.zza.c();
                    m.a(c4);
                    gVar2.a(c4, this.zza.b(), this.zza.a(), awVar2, zze(), this.zza.d());
                    this.zzd.incrementAndGet();
                }
                aw awVar3 = new aw(this, this.zzd.get());
                this.zzu = awVar3;
                bl blVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new bl(getStartServicePackage(), getStartServiceAction(), false, g.a(), getUseDynamicLookup()) : new bl(getContext().getPackageName(), getLocalStartServiceAction(), true, g.a(), false);
                this.zza = blVar2;
                if (!blVar2.d() || getMinApkVersion() >= 17895000) {
                    g gVar3 = this.zzn;
                    String c5 = this.zza.c();
                    m.a(c5);
                    if (!gVar3.a(new be(c5, this.zza.b(), this.zza.a(), this.zza.d()), awVar3, zze(), getBindServiceExecutor())) {
                        String c6 = this.zza.c();
                        String b3 = this.zza.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c6).length() + 34 + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c6);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.w("GmsClient", sb2.toString());
                        zzl(16, (Bundle) null, this.zzd.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.zza.c());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i2 == 4) {
                m.a(t2);
                onConnectedLocked(t2);
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int a2 = this.zzo.a(this.zzl, getMinApkVersion());
        if (a2 != 0) {
            zzp(1, (IInterface) null);
            triggerNotAvailable(new C0122d(), a2, (PendingIntent) null);
            return;
        }
        connect(new C0122d());
    }

    /* access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(c cVar) {
        m.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        zzp(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.zzt.get(i2).d();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, (IInterface) null);
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        T t2;
        k kVar;
        synchronized (this.zzp) {
            i2 = this.zzv;
            t2 = this.zzs;
        }
        synchronized (this.zzq) {
            kVar = this.zzr;
        }
        printWriter.append(str).append("mConnectState=");
        printWriter.print(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (t2 == null) {
            printWriter.append("null");
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(t2.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (kVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(kVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j2 = this.zzh;
            String format = simpleDateFormat.format(new Date(j2));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j2);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzg > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i3 = this.zzf;
            printWriter.append(i3 != 1 ? i3 != 2 ? i3 != 3 ? String.valueOf(i3) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED");
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.zzg;
            String format2 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j3);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzj > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(com.google.android.gms.common.api.b.a(this.zzi));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.zzj;
            String format3 = simpleDateFormat.format(new Date(j4));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j4);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzj zzj2 = this.zzD;
        if (zzj2 == null) {
            return null;
        }
        return zzj2.f17881b;
    }

    /* access modifiers changed from: protected */
    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        bl blVar;
        if (isConnected() && (blVar = this.zza) != null) {
            return blVar.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return com.google.android.gms.common.d.f17673b;
    }

    public void getRemoteService(h hVar, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy, this.zzA);
        getServiceRequest.f17748d = this.zzl.getPackageName();
        getServiceRequest.f17751g = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.f17750f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            getServiceRequest.f17752h = account;
            if (hVar != null) {
                getServiceRequest.f17749e = hVar.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.f17752h = getAccount();
        }
        getServiceRequest.f17753i = zze;
        getServiceRequest.f17754j = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.f17757m = true;
        }
        try {
            synchronized (this.zzq) {
                k kVar = this.zzr;
                if (kVar != null) {
                    kVar.a(new av(this, this.zzd.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            triggerConnectionSuspended(3);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            onPostInitHandler(8, (IBinder) null, (Bundle) null, this.zzd.get());
        }
    }

    /* access modifiers changed from: protected */
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() throws DeadObjectException {
        T t2;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                t2 = this.zzs;
                m.a(t2, (Object) "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            k kVar = this.zzr;
            if (kVar == null) {
                return null;
            }
            IBinder asBinder = kVar.asBinder();
            return asBinder;
        }
    }

    /* access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzj zzj2 = this.zzD;
        if (zzj2 == null) {
            return null;
        }
        return zzj2.f17883d;
    }

    /* access modifiers changed from: protected */
    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    public boolean isConnected() {
        boolean z2;
        synchronized (this.zzp) {
            z2 = this.zzv == 4;
        }
        return z2;
    }

    public boolean isConnecting() {
        boolean z2;
        synchronized (this.zzp) {
            int i2 = this.zzv;
            z2 = true;
            if (i2 != 2) {
                if (i2 != 3) {
                    z2 = false;
                }
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public void onConnectedLocked(T t2) {
        this.zzh = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.a();
        this.zzj = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int i2) {
        this.zzf = i2;
        this.zzg = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new ax(this, i2, iBinder, bundle)));
    }

    public void onUserSignOut(e eVar) {
        eVar.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), i2));
    }

    /* access modifiers changed from: protected */
    public void triggerNotAvailable(c cVar, int i2, PendingIntent pendingIntent) {
        m.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        this.zzc = cVar;
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), i2, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    /* access modifiers changed from: protected */
    public final void zzl(int i2, Bundle bundle, int i3) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new ay(this, i2, (Bundle) null)));
    }
}
