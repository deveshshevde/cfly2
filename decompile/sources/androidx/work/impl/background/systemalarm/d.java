package androidx.work.impl.background.systemalarm;

import al.c;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.b;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.utils.n;
import androidx.work.j;
import ao.p;
import java.util.Collections;
import java.util.List;

public class d implements c, b, n.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5185a = j.a("DelayMetCommandHandler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5186b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5187c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5188d;

    /* renamed from: e  reason: collision with root package name */
    private final e f5189e;

    /* renamed from: f  reason: collision with root package name */
    private final al.d f5190f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f5191g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private int f5192h = 0;

    /* renamed from: i  reason: collision with root package name */
    private PowerManager.WakeLock f5193i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5194j = false;

    d(Context context, int i2, String str, e eVar) {
        this.f5186b = context;
        this.f5187c = i2;
        this.f5189e = eVar;
        this.f5188d = str;
        this.f5190f = new al.d(context, eVar.e(), this);
    }

    private void b() {
        synchronized (this.f5191g) {
            if (this.f5192h < 2) {
                this.f5192h = 2;
                j a2 = j.a();
                String str = f5185a;
                a2.b(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.f5188d}), new Throwable[0]);
                Intent c2 = b.c(this.f5186b, this.f5188d);
                e eVar = this.f5189e;
                eVar.a((Runnable) new e.a(eVar, c2, this.f5187c));
                if (this.f5189e.b().g(this.f5188d)) {
                    j.a().b(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f5188d}), new Throwable[0]);
                    Intent a3 = b.a(this.f5186b, this.f5188d);
                    e eVar2 = this.f5189e;
                    eVar2.a((Runnable) new e.a(eVar2, a3, this.f5187c));
                } else {
                    j.a().b(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f5188d}), new Throwable[0]);
                }
            } else {
                j.a().b(f5185a, String.format("Already stopped work for %s", new Object[]{this.f5188d}), new Throwable[0]);
            }
        }
    }

    private void c() {
        synchronized (this.f5191g) {
            this.f5190f.a();
            this.f5189e.c().a(this.f5188d);
            PowerManager.WakeLock wakeLock = this.f5193i;
            if (wakeLock != null && wakeLock.isHeld()) {
                j.a().b(f5185a, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f5193i, this.f5188d}), new Throwable[0]);
                this.f5193i.release();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f5193i = androidx.work.impl.utils.j.a(this.f5186b, String.format("%s (%s)", new Object[]{this.f5188d, Integer.valueOf(this.f5187c)}));
        j a2 = j.a();
        String str = f5185a;
        a2.b(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f5193i, this.f5188d}), new Throwable[0]);
        this.f5193i.acquire();
        p b2 = this.f5189e.d().c().o().b(this.f5188d);
        if (b2 == null) {
            b();
            return;
        }
        boolean d2 = b2.d();
        this.f5194j = d2;
        if (!d2) {
            j.a().b(str, String.format("No constraints for %s", new Object[]{this.f5188d}), new Throwable[0]);
            a((List<String>) Collections.singletonList(this.f5188d));
            return;
        }
        this.f5190f.a((Iterable<p>) Collections.singletonList(b2));
    }

    public void a(String str) {
        j.a().b(f5185a, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        b();
    }

    public void a(String str, boolean z2) {
        j.a().b(f5185a, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z2)}), new Throwable[0]);
        c();
        if (z2) {
            Intent a2 = b.a(this.f5186b, this.f5188d);
            e eVar = this.f5189e;
            eVar.a((Runnable) new e.a(eVar, a2, this.f5187c));
        }
        if (this.f5194j) {
            Intent a3 = b.a(this.f5186b);
            e eVar2 = this.f5189e;
            eVar2.a((Runnable) new e.a(eVar2, a3, this.f5187c));
        }
    }

    public void a(List<String> list) {
        if (list.contains(this.f5188d)) {
            synchronized (this.f5191g) {
                if (this.f5192h == 0) {
                    this.f5192h = 1;
                    j.a().b(f5185a, String.format("onAllConstraintsMet for %s", new Object[]{this.f5188d}), new Throwable[0]);
                    if (this.f5189e.b().a(this.f5188d)) {
                        this.f5189e.c().a(this.f5188d, 600000, this);
                    } else {
                        c();
                    }
                } else {
                    j.a().b(f5185a, String.format("Already started work for %s", new Object[]{this.f5188d}), new Throwable[0]);
                }
            }
        }
    }

    public void b(List<String> list) {
        b();
    }
}
