package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {

    /* renamed from: h  reason: collision with root package name */
    static final Object f2779h = new Object();

    /* renamed from: i  reason: collision with root package name */
    static final HashMap<ComponentName, h> f2780i = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    b f2781a;

    /* renamed from: b  reason: collision with root package name */
    h f2782b;

    /* renamed from: c  reason: collision with root package name */
    a f2783c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2784d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2785e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f2786f = false;

    /* renamed from: g  reason: collision with root package name */
    final ArrayList<d> f2787g;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e d2 = JobIntentService.this.d();
                if (d2 == null) {
                    return null;
                }
                JobIntentService.this.a(d2.a());
                d2.b();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Void voidR) {
            JobIntentService.this.c();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.c();
        }
    }

    interface b {
        IBinder a();

        e b();
    }

    static final class c extends h {

        /* renamed from: a  reason: collision with root package name */
        boolean f2789a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2790b;

        /* renamed from: f  reason: collision with root package name */
        private final Context f2791f;

        /* renamed from: g  reason: collision with root package name */
        private final PowerManager.WakeLock f2792g;

        /* renamed from: h  reason: collision with root package name */
        private final PowerManager.WakeLock f2793h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f2791f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2792g = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2793h = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        public void a() {
            synchronized (this) {
                this.f2789a = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f2804c);
            if (this.f2791f.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f2789a) {
                        this.f2789a = true;
                        if (!this.f2790b) {
                            this.f2792g.acquire(60000);
                        }
                    }
                }
            }
        }

        public void b() {
            synchronized (this) {
                if (!this.f2790b) {
                    this.f2790b = true;
                    this.f2793h.acquire(600000);
                    this.f2792g.release();
                }
            }
        }

        public void c() {
            synchronized (this) {
                if (this.f2790b) {
                    if (this.f2789a) {
                        this.f2792g.acquire(60000);
                    }
                    this.f2790b = false;
                    this.f2793h.release();
                }
            }
        }
    }

    final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2794a;

        /* renamed from: b  reason: collision with root package name */
        final int f2795b;

        d(Intent intent, int i2) {
            this.f2794a = intent;
            this.f2795b = i2;
        }

        public Intent a() {
            return this.f2794a;
        }

        public void b() {
            JobIntentService.this.stopSelf(this.f2795b);
        }
    }

    interface e {
        Intent a();

        void b();
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f2797a;

        /* renamed from: b  reason: collision with root package name */
        final Object f2798b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f2799c;

        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f2800a;

            a(JobWorkItem jobWorkItem) {
                this.f2800a = jobWorkItem;
            }

            public Intent a() {
                return this.f2800a.getIntent();
            }

            public void b() {
                synchronized (f.this.f2798b) {
                    if (f.this.f2799c != null) {
                        f.this.f2799c.completeWork(this.f2800a);
                    }
                }
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2797a = jobIntentService;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f2797a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            return new androidx.core.app.JobIntentService.f.a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.e b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f2798b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f2799c     // Catch:{ all -> 0x0025 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x000a:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0025 }
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                if (r1 == 0) goto L_0x0024
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f2797a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$f$a r0 = new androidx.core.app.JobIntentService$f$a
                r0.<init>(r1)
                return r0
            L_0x0024:
                return r2
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.f.b():androidx.core.app.JobIntentService$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f2799c = jobParameters;
            this.f2797a.a(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f2797a.b();
            synchronized (this.f2798b) {
                this.f2799c = null;
            }
            return b2;
        }
    }

    static final class g extends h {

        /* renamed from: a  reason: collision with root package name */
        private final JobInfo f2802a;

        /* renamed from: b  reason: collision with root package name */
        private final JobScheduler f2803b;

        g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            a(i2);
            this.f2802a = new JobInfo.Builder(i2, this.f2804c).setOverrideDeadline(0).build();
            this.f2803b = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            this.f2803b.enqueue(this.f2802a, new JobWorkItem(intent));
        }
    }

    static abstract class h {

        /* renamed from: c  reason: collision with root package name */
        final ComponentName f2804c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2805d;

        /* renamed from: e  reason: collision with root package name */
        int f2806e;

        h(ComponentName componentName) {
            this.f2804c = componentName;
        }

        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (!this.f2805d) {
                this.f2805d = true;
                this.f2806e = i2;
            } else if (this.f2806e != i2) {
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f2806e);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }
    }

    public JobIntentService() {
        this.f2787g = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList<>();
    }

    static h a(Context context, ComponentName componentName, boolean z2, int i2) {
        h hVar;
        HashMap<ComponentName, h> hashMap = f2780i;
        h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z2) {
            hVar = new g(context, componentName, i2);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        hashMap.put(componentName, hVar3);
        return hVar3;
    }

    public static void a(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent != null) {
            synchronized (f2779h) {
                h a2 = a(context, componentName, true, i2);
                a2.a(i2);
                a2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static void a(Context context, Class<?> cls, int i2, Intent intent) {
        a(context, new ComponentName(context, cls), i2, intent);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Intent intent);

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.f2783c == null) {
            this.f2783c = new a();
            h hVar = this.f2782b;
            if (hVar != null && z2) {
                hVar.b();
            }
            this.f2783c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        a aVar = this.f2783c;
        if (aVar != null) {
            aVar.cancel(this.f2784d);
        }
        this.f2785e = true;
        return a();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        ArrayList<d> arrayList = this.f2787g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2783c = null;
                ArrayList<d> arrayList2 = this.f2787g;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    a(false);
                } else if (!this.f2786f) {
                    this.f2782b.c();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public e d() {
        b bVar = this.f2781a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f2787g) {
            if (this.f2787g.size() <= 0) {
                return null;
            }
            e remove = this.f2787g.remove(0);
            return remove;
        }
    }

    public IBinder onBind(Intent intent) {
        b bVar = this.f2781a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2781a = new f(this);
            this.f2782b = null;
            return;
        }
        this.f2781a = null;
        this.f2782b = a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f2787g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2786f = true;
                this.f2782b.c();
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.f2787g == null) {
            return 2;
        }
        this.f2782b.a();
        synchronized (this.f2787g) {
            ArrayList<d> arrayList = this.f2787g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            a(true);
        }
        return 3;
    }
}
