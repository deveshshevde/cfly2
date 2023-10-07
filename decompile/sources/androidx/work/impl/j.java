package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.R;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.e;
import androidx.work.impl.utils.h;
import androidx.work.impl.utils.i;
import androidx.work.j;
import androidx.work.l;
import androidx.work.p;
import androidx.work.q;
import ap.b;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class j extends p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5293a = androidx.work.j.a("WorkManagerImpl");

    /* renamed from: k  reason: collision with root package name */
    private static j f5294k = null;

    /* renamed from: l  reason: collision with root package name */
    private static j f5295l = null;

    /* renamed from: m  reason: collision with root package name */
    private static final Object f5296m = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Context f5297b;

    /* renamed from: c  reason: collision with root package name */
    private a f5298c;

    /* renamed from: d  reason: collision with root package name */
    private WorkDatabase f5299d;

    /* renamed from: e  reason: collision with root package name */
    private ap.a f5300e;

    /* renamed from: f  reason: collision with root package name */
    private List<e> f5301f;

    /* renamed from: g  reason: collision with root package name */
    private d f5302g;

    /* renamed from: h  reason: collision with root package name */
    private e f5303h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5304i;

    /* renamed from: j  reason: collision with root package name */
    private BroadcastReceiver.PendingResult f5305j;

    public j(Context context, a aVar, ap.a aVar2) {
        this(context, aVar, aVar2, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    public j(Context context, a aVar, ap.a aVar2, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        androidx.work.j.a((androidx.work.j) new j.a(aVar.f()));
        Context context2 = context;
        a aVar3 = aVar;
        ap.a aVar4 = aVar2;
        WorkDatabase workDatabase2 = workDatabase;
        List<e> a2 = a(applicationContext, aVar, aVar2);
        a(context2, aVar3, aVar4, workDatabase2, a2, new d(context2, aVar3, aVar4, workDatabase2, a2));
    }

    public j(Context context, a aVar, ap.a aVar2, boolean z2) {
        this(context, aVar, aVar2, WorkDatabase.a(context.getApplicationContext(), aVar2.b(), z2));
    }

    @Deprecated
    public static j a() {
        synchronized (f5296m) {
            j jVar = f5294k;
            if (jVar != null) {
                return jVar;
            }
            j jVar2 = f5295l;
            return jVar2;
        }
    }

    private void a(Context context, a aVar, ap.a aVar2, WorkDatabase workDatabase, List<e> list, d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5297b = applicationContext;
        this.f5298c = aVar;
        this.f5300e = aVar2;
        this.f5299d = workDatabase;
        this.f5301f = list;
        this.f5302g = dVar;
        this.f5303h = new e(workDatabase);
        this.f5304i = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext.isDeviceProtectedStorage()) {
            this.f5300e.a(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static j b(Context context) {
        j a2;
        synchronized (f5296m) {
            a2 = a();
            if (a2 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof a.b) {
                    b(applicationContext, ((a.b) applicationContext).a());
                    a2 = b(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return a2;
    }

    public static void b(Context context, a aVar) {
        synchronized (f5296m) {
            j jVar = f5294k;
            if (jVar != null) {
                if (f5295l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (jVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (f5295l == null) {
                    f5295l = new j(applicationContext, aVar, new b(aVar.b()));
                }
                f5294k = f5295l;
            }
        }
    }

    public l a(List<? extends q> list) {
        if (!list.isEmpty()) {
            return new g(this, list).i();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public l a(UUID uuid) {
        androidx.work.impl.utils.a a2 = androidx.work.impl.utils.a.a(uuid, this);
        this.f5300e.a(a2);
        return a2.a();
    }

    public List<e> a(Context context, a aVar, ap.a aVar2) {
        return Arrays.asList(new e[]{f.a(context, this), new ak.b(context, aVar, aVar2, this)});
    }

    public void a(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f5296m) {
            this.f5305j = pendingResult;
            if (this.f5304i) {
                pendingResult.finish();
                this.f5305j = null;
            }
        }
    }

    public void a(String str) {
        a(str, (WorkerParameters.a) null);
    }

    public void a(String str, WorkerParameters.a aVar) {
        this.f5300e.a(new h(this, str, aVar));
    }

    public Context b() {
        return this.f5297b;
    }

    public void b(String str) {
        this.f5300e.a(new i(this, str, false));
    }

    public WorkDatabase c() {
        return this.f5299d;
    }

    public void c(String str) {
        this.f5300e.a(new i(this, str, true));
    }

    public a d() {
        return this.f5298c;
    }

    public List<e> e() {
        return this.f5301f;
    }

    public d f() {
        return this.f5302g;
    }

    public ap.a g() {
        return this.f5300e;
    }

    public e h() {
        return this.f5303h;
    }

    public void i() {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.a(b());
        }
        c().o().b();
        f.a(d(), c(), e());
    }

    public void j() {
        synchronized (f5296m) {
            this.f5304i = true;
            BroadcastReceiver.PendingResult pendingResult = this.f5305j;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f5305j = null;
            }
        }
    }
}
