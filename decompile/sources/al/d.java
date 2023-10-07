package al;

import am.b;
import am.c;
import am.e;
import am.f;
import am.g;
import am.h;
import android.content.Context;
import androidx.work.j;
import ao.p;
import ap.a;
import java.util.ArrayList;
import java.util.List;

public class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f242a = j.a("WorkConstraintsTracker");

    /* renamed from: b  reason: collision with root package name */
    private final c f243b;

    /* renamed from: c  reason: collision with root package name */
    private final c<?>[] f244c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f245d = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f243b = cVar;
        this.f244c = new c[]{new am.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new am.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public void a() {
        synchronized (this.f245d) {
            for (c<?> a2 : this.f244c) {
                a2.a();
            }
        }
    }

    public void a(Iterable<p> iterable) {
        synchronized (this.f245d) {
            for (c<?> a2 : this.f244c) {
                a2.a((c.a) null);
            }
            for (c<?> a3 : this.f244c) {
                a3.a(iterable);
            }
            for (c<?> a4 : this.f244c) {
                a4.a((c.a) this);
            }
        }
    }

    public void a(List<String> list) {
        synchronized (this.f245d) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (a(next)) {
                    j.a().b(f242a, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                    arrayList.add(next);
                }
            }
            c cVar = this.f243b;
            if (cVar != null) {
                cVar.a(arrayList);
            }
        }
    }

    public boolean a(String str) {
        synchronized (this.f245d) {
            for (c<?> cVar : this.f244c) {
                if (cVar.a(str)) {
                    j.a().b(f242a, String.format("Work %s constrained by %s", new Object[]{str, cVar.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void b(List<String> list) {
        synchronized (this.f245d) {
            c cVar = this.f243b;
            if (cVar != null) {
                cVar.b(list);
            }
        }
    }
}
