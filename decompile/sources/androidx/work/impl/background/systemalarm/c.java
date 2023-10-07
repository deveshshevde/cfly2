package androidx.work.impl.background.systemalarm;

import al.d;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.j;
import ao.p;
import java.util.ArrayList;
import java.util.List;

class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5180a = j.a("ConstraintsCmdHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5181b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5182c;

    /* renamed from: d  reason: collision with root package name */
    private final e f5183d;

    /* renamed from: e  reason: collision with root package name */
    private final d f5184e;

    c(Context context, int i2, e eVar) {
        this.f5181b = context;
        this.f5182c = i2;
        this.f5183d = eVar;
        this.f5184e = new d(context, eVar.e(), (al.c) null);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        List<p> c2 = this.f5183d.d().c().o().c();
        ConstraintProxy.a(this.f5181b, c2);
        this.f5184e.a((Iterable<p>) c2);
        ArrayList<p> arrayList = new ArrayList<>(c2.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (p next : c2) {
            String str = next.f5495a;
            if (currentTimeMillis >= next.c() && (!next.d() || this.f5184e.a(str))) {
                arrayList.add(next);
            }
        }
        for (p pVar : arrayList) {
            String str2 = pVar.f5495a;
            Intent b2 = b.b(this.f5181b, str2);
            j.a().b(f5180a, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            e eVar = this.f5183d;
            eVar.a((Runnable) new e.a(eVar, b2, this.f5182c));
        }
        this.f5184e.a();
    }
}
