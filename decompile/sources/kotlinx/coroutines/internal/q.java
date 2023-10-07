package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.f;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.j;

final class q extends bp implements ak {

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f30432b;

    /* renamed from: d  reason: collision with root package name */
    private final String f30433d;

    public q(Throwable th, String str) {
        this.f30432b = th;
        this.f30433d = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 != null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void c() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f30432b
            if (r0 == 0) goto L_0x0039
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f30433d
            if (r1 == 0) goto L_0x0026
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            java.lang.String r1 = ""
        L_0x0028:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f30432b
            r1.<init>(r0, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0039:
            kotlinx.coroutines.internal.p.a()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.q.c():java.lang.Void");
    }

    public bp a() {
        return this;
    }

    public boolean a(f fVar) {
        c();
        throw new KotlinNothingValueException();
    }

    /* renamed from: b */
    public Void a(long j2, j<? super l> jVar) {
        c();
        throw new KotlinNothingValueException();
    }

    /* renamed from: b */
    public Void a(f fVar, Runnable runnable) {
        c();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f30432b != null) {
            str = ", cause=" + this.f30432b;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
