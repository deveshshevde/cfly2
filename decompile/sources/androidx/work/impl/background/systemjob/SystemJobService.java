package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.b;
import androidx.work.j;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5213a = j.a("SystemJobService");

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.impl.j f5214b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, JobParameters> f5215c = new HashMap();

    private static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void a(String str, boolean z2) {
        JobParameters remove;
        j.a().b(f5213a, String.format("%s executed on JobScheduler", new Object[]{str}), new Throwable[0]);
        synchronized (this.f5215c) {
            remove = this.f5215c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z2);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            androidx.work.impl.j b2 = androidx.work.impl.j.b(getApplicationContext());
            this.f5214b = b2;
            b2.f().a((b) this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                j.a().d(f5213a, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        androidx.work.impl.j jVar = this.f5214b;
        if (jVar != null) {
            jVar.f().b((b) this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r9.getTriggeredContentUris() == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r2.f5098b = java.util.Arrays.asList(r9.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r9.getTriggeredContentAuthorities() == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        r2.f5097a = java.util.Arrays.asList(r9.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        r2.f5099c = r9.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r8.f5214b.a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a9, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            androidx.work.impl.j r0 = r8.f5214b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            androidx.work.j r0 = androidx.work.j.a()
            java.lang.String r3 = f5213a
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.b(r3, r4, r5)
            r8.jobFinished(r9, r1)
            return r2
        L_0x0017:
            java.lang.String r0 = a(r9)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x002f
            androidx.work.j r9 = androidx.work.j.a()
            java.lang.String r0 = f5213a
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r9.e(r0, r1, r3)
            return r2
        L_0x002f:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r8.f5215c
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r8.f5215c     // Catch:{ all -> 0x00aa }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00aa }
            if (r4 == 0) goto L_0x0051
            androidx.work.j r9 = androidx.work.j.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = f5213a     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00aa }
            r1[r2] = r0     // Catch:{ all -> 0x00aa }
            java.lang.String r0 = java.lang.String.format(r5, r1)     // Catch:{ all -> 0x00aa }
            java.lang.Throwable[] r1 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00aa }
            r9.b(r4, r0, r1)     // Catch:{ all -> 0x00aa }
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            return r2
        L_0x0051:
            androidx.work.j r4 = androidx.work.j.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = f5213a     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = "onStartJob for %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00aa }
            r7[r2] = r0     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00aa }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00aa }
            r4.b(r5, r6, r2)     // Catch:{ all -> 0x00aa }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r8.f5215c     // Catch:{ all -> 0x00aa }
            r2.put(r0, r9)     // Catch:{ all -> 0x00aa }
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x00a4
            androidx.work.WorkerParameters$a r2 = new androidx.work.WorkerParameters$a
            r2.<init>()
            android.net.Uri[] r3 = r9.getTriggeredContentUris()
            if (r3 == 0) goto L_0x0088
            android.net.Uri[] r3 = r9.getTriggeredContentUris()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.f5098b = r3
        L_0x0088:
            java.lang.String[] r3 = r9.getTriggeredContentAuthorities()
            if (r3 == 0) goto L_0x0098
            java.lang.String[] r3 = r9.getTriggeredContentAuthorities()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.f5097a = r3
        L_0x0098:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 < r4) goto L_0x00a4
            android.net.Network r9 = r9.getNetwork()
            r2.f5099c = r9
        L_0x00a4:
            androidx.work.impl.j r9 = r8.f5214b
            r9.a(r0, r2)
            return r1
        L_0x00aa:
            r9 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f5214b == null) {
            j.a().b(f5213a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a2 = a(jobParameters);
        if (TextUtils.isEmpty(a2)) {
            j.a().e(f5213a, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        j.a().b(f5213a, String.format("onStopJob for %s", new Object[]{a2}), new Throwable[0]);
        synchronized (this.f5215c) {
            this.f5215c.remove(a2);
        }
        this.f5214b.b(a2);
        return !this.f5214b.f().f(a2);
    }
}
