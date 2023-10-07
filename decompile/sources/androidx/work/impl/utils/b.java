package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.d;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.c;
import androidx.work.impl.e;
import androidx.work.impl.f;
import androidx.work.impl.g;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.j;
import androidx.work.l;
import ao.p;
import java.util.List;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5353a = j.a("EnqueueRunnable");

    /* renamed from: b  reason: collision with root package name */
    private final g f5354b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5355c = new c();

    public b(g gVar) {
        this.f5354b = gVar;
    }

    private static void a(p pVar) {
        androidx.work.b bVar = pVar.f5504j;
        String str = pVar.f5497c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (bVar.d() || bVar.e()) {
            d.a aVar = new d.a();
            aVar.a(pVar.f5499e).a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f5497c = ConstraintTrackingWorker.class.getName();
            pVar.f5499e = aVar.a();
        }
    }

    private static boolean a(g gVar) {
        List<g> h2 = gVar.h();
        boolean z2 = false;
        if (h2 != null) {
            boolean z3 = false;
            for (g next : h2) {
                if (!next.f()) {
                    z3 |= a(next);
                } else {
                    j.a().d(f5353a, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.e())}), new Throwable[0]);
                }
            }
            z2 = z3;
        }
        return b(gVar) | z2;
    }

    private static boolean a(androidx.work.impl.j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (e eVar : jVar.e()) {
                if (cls.isAssignableFrom(eVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01e5 A[LOOP:7: B:121:0x01df->B:123:0x01e5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x020e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(androidx.work.impl.j r18, java.util.List<? extends androidx.work.q> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r18.c()
            r7 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            ao.q r8 = r6.o()
            ao.p r8 = r8.b((java.lang.String) r15)
            if (r8 != 0) goto L_0x0045
            androidx.work.j r0 = androidx.work.j.a()
            java.lang.String r1 = f5353a
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.e(r1, r2, r4)
            return r3
        L_0x0045:
            androidx.work.WorkInfo$State r8 = r8.f5496b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r8 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r8 != r15) goto L_0x0055
            r14 = 1
            goto L_0x005a
        L_0x0055:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r8 != r15) goto L_0x005a
            r13 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r8 = android.text.TextUtils.isEmpty(r21)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x0154
            ao.q r10 = r6.o()
            java.util.List r10 = r10.c(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0154
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND
            if (r3 == r11) goto L_0x00cf
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x0085
            goto L_0x00cf
        L_0x0085:
            androidx.work.ExistingWorkPolicy r11 = androidx.work.ExistingWorkPolicy.KEEP
            if (r3 != r11) goto L_0x00aa
            java.util.Iterator r3 = r10.iterator()
        L_0x008d:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x00aa
            java.lang.Object r11 = r3.next()
            ao.p$a r11 = (ao.p.a) r11
            androidx.work.WorkInfo$State r15 = r11.f5514b
            androidx.work.WorkInfo$State r7 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 == r7) goto L_0x00a8
            androidx.work.WorkInfo$State r7 = r11.f5514b
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.RUNNING
            if (r7 != r11) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r7 = 1
            goto L_0x008d
        L_0x00a8:
            r7 = 0
            return r7
        L_0x00aa:
            r7 = 0
            androidx.work.impl.utils.a r3 = androidx.work.impl.utils.a.a(r2, r0, r7)
            r3.run()
            ao.q r3 = r6.o()
            java.util.Iterator r10 = r10.iterator()
        L_0x00ba:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00cc
            java.lang.Object r11 = r10.next()
            ao.p$a r11 = (ao.p.a) r11
            java.lang.String r11 = r11.f5513a
            r3.a((java.lang.String) r11)
            goto L_0x00ba
        L_0x00cc:
            r3 = 1
            goto L_0x0155
        L_0x00cf:
            r7 = 0
            ao.b r9 = r6.p()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00dd:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0119
            java.lang.Object r15 = r10.next()
            ao.p$a r15 = (ao.p.a) r15
            java.lang.String r7 = r15.f5513a
            boolean r7 = r9.c(r7)
            if (r7 != 0) goto L_0x0113
            androidx.work.WorkInfo$State r7 = r15.f5514b
            r16 = r9
            androidx.work.WorkInfo$State r9 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r9) goto L_0x00fb
            r7 = 1
            goto L_0x00fc
        L_0x00fb:
            r7 = 0
        L_0x00fc:
            r7 = r7 & r12
            androidx.work.WorkInfo$State r9 = r15.f5514b
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.FAILED
            if (r9 != r12) goto L_0x0105
            r14 = 1
            goto L_0x010c
        L_0x0105:
            androidx.work.WorkInfo$State r9 = r15.f5514b
            androidx.work.WorkInfo$State r12 = androidx.work.WorkInfo.State.CANCELLED
            if (r9 != r12) goto L_0x010c
            r13 = 1
        L_0x010c:
            java.lang.String r9 = r15.f5513a
            r11.add(r9)
            r12 = r7
            goto L_0x0115
        L_0x0113:
            r16 = r9
        L_0x0115:
            r9 = r16
            r7 = 0
            goto L_0x00dd
        L_0x0119:
            androidx.work.ExistingWorkPolicy r7 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x0146
            if (r13 != 0) goto L_0x0121
            if (r14 == 0) goto L_0x0146
        L_0x0121:
            ao.q r3 = r6.o()
            java.util.List r7 = r3.c(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x012d:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x013f
            java.lang.Object r9 = r7.next()
            ao.p$a r9 = (ao.p.a) r9
            java.lang.String r9 = r9.f5513a
            r3.a((java.lang.String) r9)
            goto L_0x012d
        L_0x013f:
            java.util.List r11 = java.util.Collections.emptyList()
            r3 = 0
            r13 = 0
            goto L_0x0147
        L_0x0146:
            r3 = r14
        L_0x0147:
            java.lang.Object[] r1 = r11.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 <= 0) goto L_0x0152
            r9 = 1
            goto L_0x0153
        L_0x0152:
            r9 = 0
        L_0x0153:
            r14 = r3
        L_0x0154:
            r3 = 0
        L_0x0155:
            java.util.Iterator r7 = r19.iterator()
        L_0x0159:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0214
            java.lang.Object r10 = r7.next()
            androidx.work.q r10 = (androidx.work.q) r10
            ao.p r11 = r10.b()
            if (r9 == 0) goto L_0x017c
            if (r12 != 0) goto L_0x017c
            if (r14 == 0) goto L_0x0174
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
        L_0x0171:
            r11.f5496b = r15
            goto L_0x0184
        L_0x0174:
            if (r13 == 0) goto L_0x0179
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            goto L_0x0171
        L_0x0179:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            goto L_0x0171
        L_0x017c:
            boolean r15 = r11.a()
            if (r15 != 0) goto L_0x0187
            r11.f5508n = r4
        L_0x0184:
            r16 = r4
            goto L_0x018d
        L_0x0187:
            r16 = r4
            r4 = 0
            r11.f5508n = r4
        L_0x018d:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x019d
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 25
            if (r4 > r5) goto L_0x019d
        L_0x0199:
            a((ao.p) r11)
            goto L_0x01ac
        L_0x019d:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 22
            if (r4 > r5) goto L_0x01ac
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = a(r0, r4)
            if (r4 == 0) goto L_0x01ac
            goto L_0x0199
        L_0x01ac:
            androidx.work.WorkInfo$State r4 = r11.f5496b
            androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.ENQUEUED
            if (r4 != r5) goto L_0x01b3
            r3 = 1
        L_0x01b3:
            ao.q r4 = r6.o()
            r4.a((ao.p) r11)
            if (r9 == 0) goto L_0x01d7
            int r4 = r1.length
            r5 = 0
        L_0x01be:
            if (r5 >= r4) goto L_0x01d7
            r11 = r1[r5]
            ao.a r15 = new ao.a
            java.lang.String r0 = r10.a()
            r15.<init>(r0, r11)
            ao.b r0 = r6.p()
            r0.a((ao.a) r15)
            int r5 = r5 + 1
            r0 = r18
            goto L_0x01be
        L_0x01d7:
            java.util.Set r0 = r10.c()
            java.util.Iterator r0 = r0.iterator()
        L_0x01df:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01fc
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            ao.t r5 = r6.q()
            ao.s r11 = new ao.s
            java.lang.String r15 = r10.a()
            r11.<init>(r4, r15)
            r5.a((ao.s) r11)
            goto L_0x01df
        L_0x01fc:
            if (r8 == 0) goto L_0x020e
            ao.k r0 = r6.s()
            ao.j r4 = new ao.j
            java.lang.String r5 = r10.a()
            r4.<init>(r2, r5)
            r0.a((ao.j) r4)
        L_0x020e:
            r0 = r18
            r4 = r16
            goto L_0x0159
        L_0x0214:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.b.a(androidx.work.impl.j, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean b(g gVar) {
        boolean a2 = a(gVar.a(), gVar.d(), (String[]) g.a(gVar).toArray(new String[0]), gVar.b(), gVar.c());
        gVar.g();
        return a2;
    }

    public l a() {
        return this.f5355c;
    }

    public boolean b() {
        WorkDatabase c2 = this.f5354b.a().c();
        c2.g();
        try {
            boolean a2 = a(this.f5354b);
            c2.j();
            return a2;
        } finally {
            c2.h();
        }
    }

    public void c() {
        androidx.work.impl.j a2 = this.f5354b.a();
        f.a(a2.d(), a2.c(), a2.e());
    }

    public void run() {
        try {
            if (!this.f5354b.j()) {
                if (b()) {
                    d.a(this.f5354b.a().b(), RescheduleReceiver.class, true);
                    c();
                }
                this.f5355c.a(l.f5450a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.f5354b}));
        } catch (Throwable th) {
            this.f5355c.a(new l.a.C0046a(th));
        }
    }
}
