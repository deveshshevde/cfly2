package com.afollestad.date.controllers;

import ar.a;
import java.util.Calendar;
import kotlin.jvm.internal.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private a f7396a;

    /* renamed from: b  reason: collision with root package name */
    private a f7397b;

    private final void c() {
        a aVar = this.f7396a;
        if (aVar != null && this.f7397b != null) {
            if (aVar == null) {
                h.a();
            }
            a aVar2 = this.f7397b;
            if (aVar2 == null) {
                h.a();
            }
            if (!(aVar.a(aVar2) < 0)) {
                throw new IllegalStateException("Min date must be less than max date.".toString());
            }
        }
    }

    public final Calendar a() {
        a aVar = this.f7396a;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public final void a(Calendar calendar) {
        h.c(calendar, "date");
        this.f7396a = ar.b.a(calendar);
        c();
    }

    public final boolean a(a aVar) {
        a aVar2;
        if (aVar == null || (aVar2 = this.f7396a) == null) {
            return false;
        }
        if (aVar2 == null) {
            h.a();
        }
        return aVar.a(aVar2) < 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r4 == r0.d()) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(ar.a r4) {
        /*
            r3 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.h.c(r4, r0)
            java.util.Calendar r0 = r4.a()
            int r1 = com.afollestad.date.a.c(r0)
            int r0 = com.afollestad.date.a.d(r0)
            r2 = 1
            if (r1 != r0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 == 0) goto L_0x001c
        L_0x0019:
            int r4 = com.afollestad.date.R.drawable.ic_tube_end
            goto L_0x005c
        L_0x001c:
            int r0 = r4.c()
            if (r0 != r2) goto L_0x0025
            int r4 = com.afollestad.date.R.drawable.ic_tube_start
            goto L_0x005c
        L_0x0025:
            int r0 = r4.c()
            ar.a r1 = r3.f7396a
            if (r1 != 0) goto L_0x0030
            kotlin.jvm.internal.h.a()
        L_0x0030:
            int r1 = r1.c()
            int r1 = r1 - r2
            if (r0 != r1) goto L_0x005a
            int r0 = r4.b()
            ar.a r1 = r3.f7396a
            if (r1 != 0) goto L_0x0042
            kotlin.jvm.internal.h.a()
        L_0x0042:
            int r1 = r1.b()
            if (r0 != r1) goto L_0x005a
            int r4 = r4.d()
            ar.a r0 = r3.f7396a
            if (r0 != 0) goto L_0x0053
            kotlin.jvm.internal.h.a()
        L_0x0053:
            int r0 = r0.d()
            if (r4 != r0) goto L_0x005a
            goto L_0x0019
        L_0x005a:
            int r4 = com.afollestad.date.R.drawable.ic_tube_middle
        L_0x005c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.date.controllers.b.b(ar.a):int");
    }

    public final Calendar b() {
        a aVar = this.f7397b;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public final void b(Calendar calendar) {
        h.c(calendar, "date");
        this.f7397b = ar.b.a(calendar);
        c();
    }

    public final boolean c(a aVar) {
        a aVar2;
        if (aVar == null || (aVar2 = this.f7397b) == null) {
            return false;
        }
        if (aVar2 == null) {
            h.a();
        }
        return aVar.a(aVar2) > 0;
    }

    public final boolean c(Calendar calendar) {
        h.c(calendar, "from");
        if (this.f7396a == null) {
            return true;
        }
        return !a(ar.b.a(com.afollestad.date.a.f(calendar)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r5 == r1.d()) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(ar.a r5) {
        /*
            r4 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.h.c(r5, r0)
            java.util.Calendar r0 = r5.a()
            int r1 = com.afollestad.date.a.c(r0)
            int r0 = com.afollestad.date.a.d(r0)
            r2 = 1
            if (r1 != r0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            int r1 = r5.c()
            if (r1 != r2) goto L_0x0020
        L_0x001d:
            int r5 = com.afollestad.date.R.drawable.ic_tube_start
            goto L_0x005c
        L_0x0020:
            int r1 = r5.c()
            ar.a r3 = r4.f7397b
            if (r3 != 0) goto L_0x002b
            kotlin.jvm.internal.h.a()
        L_0x002b:
            int r3 = r3.c()
            int r3 = r3 + r2
            if (r1 != r3) goto L_0x0055
            int r1 = r5.b()
            ar.a r2 = r4.f7397b
            if (r2 != 0) goto L_0x003d
            kotlin.jvm.internal.h.a()
        L_0x003d:
            int r2 = r2.b()
            if (r1 != r2) goto L_0x0055
            int r5 = r5.d()
            ar.a r1 = r4.f7397b
            if (r1 != 0) goto L_0x004e
            kotlin.jvm.internal.h.a()
        L_0x004e:
            int r1 = r1.d()
            if (r5 != r1) goto L_0x0055
            goto L_0x001d
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            int r5 = com.afollestad.date.R.drawable.ic_tube_end
            goto L_0x005c
        L_0x005a:
            int r5 = com.afollestad.date.R.drawable.ic_tube_middle
        L_0x005c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.date.controllers.b.d(ar.a):int");
    }

    public final boolean d(Calendar calendar) {
        h.c(calendar, "from");
        if (this.f7397b == null) {
            return true;
        }
        return !c(ar.b.a(com.afollestad.date.a.e(calendar)));
    }
}
