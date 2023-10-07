package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.e;
import androidx.work.impl.foreground.b;
import androidx.work.impl.k;
import androidx.work.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class d implements b, androidx.work.impl.foreground.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5226a = j.a("Processor");

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f5227b;

    /* renamed from: c  reason: collision with root package name */
    private Context f5228c;

    /* renamed from: d  reason: collision with root package name */
    private androidx.work.a f5229d;

    /* renamed from: e  reason: collision with root package name */
    private ap.a f5230e;

    /* renamed from: f  reason: collision with root package name */
    private WorkDatabase f5231f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, k> f5232g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Map<String, k> f5233h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private List<e> f5234i;

    /* renamed from: j  reason: collision with root package name */
    private Set<String> f5235j;

    /* renamed from: k  reason: collision with root package name */
    private final List<b> f5236k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f5237l;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private b f5238a;

        /* renamed from: b  reason: collision with root package name */
        private String f5239b;

        /* renamed from: c  reason: collision with root package name */
        private gz.a<Boolean> f5240c;

        a(b bVar, String str, gz.a<Boolean> aVar) {
            this.f5238a = bVar;
            this.f5239b = str;
            this.f5240c = aVar;
        }

        public void run() {
            boolean z2;
            try {
                z2 = ((Boolean) this.f5240c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z2 = true;
            }
            this.f5238a.a(this.f5239b, z2);
        }
    }

    public d(Context context, androidx.work.a aVar, ap.a aVar2, WorkDatabase workDatabase, List<e> list) {
        this.f5228c = context;
        this.f5229d = aVar;
        this.f5230e = aVar2;
        this.f5231f = workDatabase;
        this.f5234i = list;
        this.f5235j = new HashSet();
        this.f5236k = new ArrayList();
        this.f5227b = null;
        this.f5237l = new Object();
    }

    private void a() {
        synchronized (this.f5237l) {
            if (!(!this.f5232g.isEmpty())) {
                try {
                    this.f5228c.startService(b.a(this.f5228c));
                } catch (Throwable th) {
                    j.a().e(f5226a, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.f5227b;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f5227b = null;
                }
            }
        }
    }

    private static boolean a(String str, k kVar) {
        if (kVar != null) {
            kVar.c();
            j.a().b(f5226a, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        j.a().b(f5226a, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    public void a(b bVar) {
        synchronized (this.f5237l) {
            this.f5236k.add(bVar);
        }
    }

    public void a(String str, e eVar) {
        synchronized (this.f5237l) {
            j.a().c(f5226a, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
            k remove = this.f5233h.remove(str);
            if (remove != null) {
                if (this.f5227b == null) {
                    PowerManager.WakeLock a2 = androidx.work.impl.utils.j.a(this.f5228c, "ProcessorForegroundLck");
                    this.f5227b = a2;
                    a2.acquire();
                }
                this.f5232g.put(str, remove);
                androidx.core.content.b.a(this.f5228c, b.a(this.f5228c, str, eVar));
            }
        }
    }

    public void a(String str, boolean z2) {
        synchronized (this.f5237l) {
            this.f5233h.remove(str);
            j.a().b(f5226a, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z2)}), new Throwable[0]);
            for (b a2 : this.f5236k) {
                a2.a(str, z2);
            }
        }
    }

    public boolean a(String str) {
        return a(str, (WorkerParameters.a) null);
    }

    public boolean a(String str, WorkerParameters.a aVar) {
        synchronized (this.f5237l) {
            if (g(str)) {
                j.a().b(f5226a, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            k a2 = new k.a(this.f5228c, this.f5229d, this.f5230e, this, this.f5231f, str).a(this.f5234i).a(aVar).a();
            gz.a<Boolean> a3 = a2.a();
            a3.a(new a(this, str, a3), this.f5230e.a());
            this.f5233h.put(str, a2);
            this.f5230e.b().execute(a2);
            j.a().b(f5226a, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }

    public void b(b bVar) {
        synchronized (this.f5237l) {
            this.f5236k.remove(bVar);
        }
    }

    public boolean b(String str) {
        boolean a2;
        synchronized (this.f5237l) {
            j.a().b(f5226a, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            a2 = a(str, this.f5232g.remove(str));
        }
        return a2;
    }

    public boolean c(String str) {
        boolean a2;
        synchronized (this.f5237l) {
            j.a().b(f5226a, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            a2 = a(str, this.f5233h.remove(str));
        }
        return a2;
    }

    public boolean d(String str) {
        boolean a2;
        synchronized (this.f5237l) {
            boolean z2 = true;
            j.a().b(f5226a, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
            this.f5235j.add(str);
            k remove = this.f5232g.remove(str);
            if (remove == null) {
                z2 = false;
            }
            if (remove == null) {
                remove = this.f5233h.remove(str);
            }
            a2 = a(str, remove);
            if (z2) {
                a();
            }
        }
        return a2;
    }

    public void e(String str) {
        synchronized (this.f5237l) {
            this.f5232g.remove(str);
            a();
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.f5237l) {
            contains = this.f5235j.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z2;
        synchronized (this.f5237l) {
            if (!this.f5233h.containsKey(str)) {
                if (!this.f5232g.containsKey(str)) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.f5237l) {
            containsKey = this.f5232g.containsKey(str);
        }
        return containsKey;
    }
}
