package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.e;
import androidx.work.impl.utils.c;
import androidx.work.j;
import ao.g;
import ao.p;
import ao.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5219a = j.a("SystemJobScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5220b;

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f5221c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.j f5222d;

    /* renamed from: e  reason: collision with root package name */
    private final a f5223e;

    public b(Context context, androidx.work.impl.j jVar) {
        this(context, jVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public b(Context context, androidx.work.impl.j jVar, JobScheduler jobScheduler, a aVar) {
        this.f5220b = context;
        this.f5222d = jVar;
        this.f5221c = jobScheduler;
        this.f5223e = aVar;
    }

    private static String a(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    private static List<JobInfo> a(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            j.a().e(f5219a, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static List<Integer> a(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> a2 = a(context, jobScheduler);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : a2) {
            if (str.equals(a(next))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    private static void a(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            j.a().e(f5219a, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i2)}), th);
        }
    }

    public static void a(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (a2 = a(context, jobScheduler)) != null && !a2.isEmpty()) {
            for (JobInfo id2 : a2) {
                a(jobScheduler, id2.getId());
            }
        }
    }

    public static boolean a(Context context, androidx.work.impl.j jVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> a2 = a(context, jobScheduler);
        List<String> a3 = jVar.c().r().a();
        boolean z2 = false;
        HashSet hashSet = new HashSet(a2 != null ? a2.size() : 0);
        if (a2 != null && !a2.isEmpty()) {
            for (JobInfo next : a2) {
                String a4 = a(next);
                if (!TextUtils.isEmpty(a4)) {
                    hashSet.add(a4);
                } else {
                    a(jobScheduler, next.getId());
                }
            }
        }
        Iterator<String> it2 = a3.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (!hashSet.contains(it2.next())) {
                    j.a().b(f5219a, "Reconciling jobs", new Throwable[0]);
                    z2 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z2) {
            WorkDatabase c2 = jVar.c();
            c2.g();
            try {
                q o2 = c2.o();
                for (String b2 : a3) {
                    o2.b(b2, -1);
                }
                c2.j();
            } finally {
                c2.h();
            }
        }
        return z2;
    }

    public void a(p pVar, int i2) {
        JobInfo a2 = this.f5223e.a(pVar, i2);
        j a3 = j.a();
        String str = f5219a;
        a3.b(str, String.format("Scheduling work ID %s Job ID %s", new Object[]{pVar.f5495a, Integer.valueOf(i2)}), new Throwable[0]);
        try {
            if (this.f5221c.schedule(a2) == 0) {
                j.a().d(str, String.format("Unable to schedule work ID %s", new Object[]{pVar.f5495a}), new Throwable[0]);
                if (pVar.f5511q && pVar.f5512r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.f5511q = false;
                    j.a().b(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{pVar.f5495a}), new Throwable[0]);
                    a(pVar, i2);
                }
            }
        } catch (IllegalStateException e2) {
            List<JobInfo> a4 = a(this.f5220b, this.f5221c);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(a4 != null ? a4.size() : 0), Integer.valueOf(this.f5222d.c().o().c().size()), Integer.valueOf(this.f5222d.d().j())});
            j.a().e(f5219a, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            j.a().e(f5219a, String.format("Unable to schedule %s", new Object[]{pVar}), th);
        }
    }

    public void a(String str) {
        List<Integer> a2 = a(this.f5220b, this.f5221c, str);
        if (a2 != null && !a2.isEmpty()) {
            for (Integer intValue : a2) {
                a(this.f5221c, intValue.intValue());
            }
            this.f5222d.c().r().b(str);
        }
    }

    /* JADX INFO: finally extract failed */
    public void a(p... pVarArr) {
        List<Integer> a2;
        WorkDatabase c2 = this.f5222d.c();
        c cVar = new c(c2);
        int length = pVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            p pVar = pVarArr[i2];
            c2.g();
            try {
                p b2 = c2.o().b(pVar.f5495a);
                if (b2 == null) {
                    j a3 = j.a();
                    String str = f5219a;
                    a3.d(str, "Skipping scheduling " + pVar.f5495a + " because it's no longer in the DB", new Throwable[0]);
                } else if (b2.f5496b != WorkInfo.State.ENQUEUED) {
                    j a4 = j.a();
                    String str2 = f5219a;
                    a4.d(str2, "Skipping scheduling " + pVar.f5495a + " because it is no longer enqueued", new Throwable[0]);
                } else {
                    g a5 = c2.r().a(pVar.f5495a);
                    int a6 = a5 != null ? a5.f5473b : cVar.a(this.f5222d.d().g(), this.f5222d.d().h());
                    if (a5 == null) {
                        this.f5222d.c().r().a(new g(pVar.f5495a, a6));
                    }
                    a(pVar, a6);
                    if (Build.VERSION.SDK_INT == 23 && (a2 = a(this.f5220b, this.f5221c, pVar.f5495a)) != null) {
                        int indexOf = a2.indexOf(Integer.valueOf(a6));
                        if (indexOf >= 0) {
                            a2.remove(indexOf);
                        }
                        a(pVar, !a2.isEmpty() ? a2.get(0).intValue() : cVar.a(this.f5222d.d().g(), this.f5222d.d().h()));
                    }
                }
                c2.j();
                c2.h();
                i2++;
            } catch (Throwable th) {
                c2.h();
                throw th;
            }
        }
    }

    public boolean a() {
        return true;
    }
}
