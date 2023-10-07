package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.impl.utils.b;
import androidx.work.j;
import androidx.work.l;
import androidx.work.o;
import androidx.work.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5272a = j.a("WorkContinuationImpl");

    /* renamed from: b  reason: collision with root package name */
    private final j f5273b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5274c;

    /* renamed from: d  reason: collision with root package name */
    private final ExistingWorkPolicy f5275d;

    /* renamed from: e  reason: collision with root package name */
    private final List<? extends q> f5276e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f5277f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f5278g;

    /* renamed from: h  reason: collision with root package name */
    private final List<g> f5279h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5280i;

    /* renamed from: j  reason: collision with root package name */
    private l f5281j;

    public g(j jVar, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends q> list, List<g> list2) {
        this.f5273b = jVar;
        this.f5274c = str;
        this.f5275d = existingWorkPolicy;
        this.f5276e = list;
        this.f5279h = list2;
        this.f5277f = new ArrayList(list.size());
        this.f5278g = new ArrayList();
        if (list2 != null) {
            for (g gVar : list2) {
                this.f5278g.addAll(gVar.f5278g);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((q) list.get(i2)).a();
            this.f5277f.add(a2);
            this.f5278g.add(a2);
        }
    }

    public g(j jVar, List<? extends q> list) {
        this(jVar, (String) null, ExistingWorkPolicy.KEEP, list, (List<g>) null);
    }

    public static Set<String> a(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> h2 = gVar.h();
        if (h2 != null && !h2.isEmpty()) {
            for (g e2 : h2) {
                hashSet.addAll(e2.e());
            }
        }
        return hashSet;
    }

    private static boolean a(g gVar, Set<String> set) {
        set.addAll(gVar.e());
        Set<String> a2 = a(gVar);
        for (String contains : set) {
            if (a2.contains(contains)) {
                return true;
            }
        }
        List<g> h2 = gVar.h();
        if (h2 != null && !h2.isEmpty()) {
            for (g a3 : h2) {
                if (a(a3, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.e());
        return false;
    }

    public j a() {
        return this.f5273b;
    }

    public String b() {
        return this.f5274c;
    }

    public ExistingWorkPolicy c() {
        return this.f5275d;
    }

    public List<? extends q> d() {
        return this.f5276e;
    }

    public List<String> e() {
        return this.f5277f;
    }

    public boolean f() {
        return this.f5280i;
    }

    public void g() {
        this.f5280i = true;
    }

    public List<g> h() {
        return this.f5279h;
    }

    public l i() {
        if (!this.f5280i) {
            b bVar = new b(this);
            this.f5273b.g().a(bVar);
            this.f5281j = bVar.a();
        } else {
            j.a().d(f5272a, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.f5277f)}), new Throwable[0]);
        }
        return this.f5281j;
    }

    public boolean j() {
        return a(this, new HashSet());
    }
}
