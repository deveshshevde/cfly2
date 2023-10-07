package ak;

import al.c;
import al.d;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo;
import androidx.work.a;
import androidx.work.impl.e;
import androidx.work.impl.utils.f;
import androidx.work.j;
import ao.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b implements c, androidx.work.impl.b, e {

    /* renamed from: b  reason: collision with root package name */
    private static final String f229b = j.a("GreedyScheduler");

    /* renamed from: a  reason: collision with root package name */
    Boolean f230a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f231c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.j f232d;

    /* renamed from: e  reason: collision with root package name */
    private final d f233e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<p> f234f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private a f235g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f236h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f237i;

    public b(Context context, a aVar, ap.a aVar2, androidx.work.impl.j jVar) {
        this.f231c = context;
        this.f232d = jVar;
        this.f233e = new d(context, aVar2, this);
        this.f235g = new a(this, aVar.e());
        this.f237i = new Object();
    }

    private void b() {
        this.f230a = Boolean.valueOf(f.a(this.f231c, this.f232d.d()));
    }

    private void b(String str) {
        synchronized (this.f237i) {
            Iterator<p> it2 = this.f234f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                p next = it2.next();
                if (next.f5495a.equals(str)) {
                    j.a().b(f229b, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                    this.f234f.remove(next);
                    this.f233e.a((Iterable<p>) this.f234f);
                    break;
                }
            }
        }
    }

    private void c() {
        if (!this.f236h) {
            this.f232d.f().a((androidx.work.impl.b) this);
            this.f236h = true;
        }
    }

    public void a(String str) {
        if (this.f230a == null) {
            b();
        }
        if (!this.f230a.booleanValue()) {
            j.a().c(f229b, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        c();
        j.a().b(f229b, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        a aVar = this.f235g;
        if (aVar != null) {
            aVar.a(str);
        }
        this.f232d.b(str);
    }

    public void a(String str, boolean z2) {
        b(str);
    }

    public void a(List<String> list) {
        for (String next : list) {
            j.a().b(f229b, String.format("Constraints met: Scheduling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f232d.a(next);
        }
    }

    public void a(p... pVarArr) {
        if (this.f230a == null) {
            b();
        }
        if (!this.f230a.booleanValue()) {
            j.a().c(f229b, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        c();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long c2 = pVar.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f5496b == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < c2) {
                    a aVar = this.f235g;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (!pVar.d()) {
                    j.a().b(f229b, String.format("Starting work for %s", new Object[]{pVar.f5495a}), new Throwable[0]);
                    this.f232d.a(pVar.f5495a);
                } else if (Build.VERSION.SDK_INT >= 23 && pVar.f5504j.c()) {
                    j.a().b(f229b, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{pVar}), new Throwable[0]);
                } else if (Build.VERSION.SDK_INT < 24 || !pVar.f5504j.i()) {
                    hashSet.add(pVar);
                    hashSet2.add(pVar.f5495a);
                } else {
                    j.a().b(f229b, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{pVar}), new Throwable[0]);
                }
            }
        }
        synchronized (this.f237i) {
            if (!hashSet.isEmpty()) {
                j.a().b(f229b, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)}), new Throwable[0]);
                this.f234f.addAll(hashSet);
                this.f233e.a((Iterable<p>) this.f234f);
            }
        }
    }

    public boolean a() {
        return false;
    }

    public void b(List<String> list) {
        for (String next : list) {
            j.a().b(f229b, String.format("Constraints not met: Cancelling work ID %s", new Object[]{next}), new Throwable[0]);
            this.f232d.b(next);
        }
    }
}
