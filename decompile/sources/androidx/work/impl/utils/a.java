package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.c;
import androidx.work.impl.e;
import androidx.work.impl.f;
import androidx.work.impl.j;
import androidx.work.l;
import ao.b;
import ao.q;
import java.util.LinkedList;
import java.util.UUID;

public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f5347a = new c();

    public static a a(final String str, final j jVar, final boolean z2) {
        return new a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public void b() {
                WorkDatabase c2 = j.this.c();
                c2.g();
                try {
                    for (String a2 : c2.o().h(str)) {
                        a(j.this, a2);
                    }
                    c2.j();
                    c2.h();
                    if (z2) {
                        a(j.this);
                    }
                } catch (Throwable th) {
                    c2.h();
                    throw th;
                }
            }
        };
    }

    public static a a(final UUID uuid, final j jVar) {
        return new a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public void b() {
                WorkDatabase c2 = j.this.c();
                c2.g();
                try {
                    a(j.this, uuid.toString());
                    c2.j();
                    c2.h();
                    a(j.this);
                } catch (Throwable th) {
                    c2.h();
                    throw th;
                }
            }
        };
    }

    private void a(WorkDatabase workDatabase, String str) {
        q o2 = workDatabase.o();
        b p2 = workDatabase.p();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State f2 = o2.f(str2);
            if (!(f2 == WorkInfo.State.SUCCEEDED || f2 == WorkInfo.State.FAILED)) {
                o2.a(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(p2.b(str2));
        }
    }

    public l a() {
        return this.f5347a;
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar) {
        f.a(jVar.d(), jVar.c(), jVar.e());
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar, String str) {
        a(jVar.c(), str);
        jVar.f().d(str);
        for (e a2 : jVar.e()) {
            a2.a(str);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void b();

    public void run() {
        try {
            b();
            this.f5347a.a(l.f5450a);
        } catch (Throwable th) {
            this.f5347a.a(new l.a.C0046a(th));
        }
    }
}
