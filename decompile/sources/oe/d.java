package oe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jcodec.common.model.a;
import org.jcodec.common.model.f;
import org.jcodec.containers.mp4.boxes.aj;
import org.jcodec.containers.mp4.boxes.az;
import org.jcodec.containers.mp4.boxes.c;
import org.jcodec.containers.mp4.boxes.o;

public class d extends b {

    /* renamed from: n  reason: collision with root package name */
    private f f31717n;

    /* renamed from: o  reason: collision with root package name */
    private f f31718o;

    /* renamed from: p  reason: collision with root package name */
    private int f31719p;

    /* renamed from: q  reason: collision with root package name */
    private long f31720q;

    /* renamed from: r  reason: collision with root package name */
    private long f31721r;

    /* renamed from: s  reason: collision with root package name */
    private int f31722s;

    /* renamed from: t  reason: collision with root package name */
    private List<o> f31723t;

    /* renamed from: u  reason: collision with root package name */
    private List<a> f31724u;

    private int a(f fVar) {
        return (fVar.a() * 3600) + (fVar.b() * 60) + fVar.c();
    }

    private int a(f fVar, int i2) {
        int a2 = (a(fVar) * i2) + fVar.d();
        return fVar.e() ? (int) (((long) a2) - ((((long) (a2 / 18000)) * 18) + (((((long) (a2 % 18000)) - 2) / 1800) * 2))) : a2;
    }

    private boolean a(f fVar, f fVar2) {
        if (fVar == null && fVar2 != null) {
            return true;
        }
        if (fVar == null) {
            return false;
        }
        if (fVar2 != null && fVar.e() == fVar2.e()) {
            return b(fVar, fVar2);
        }
        return true;
    }

    private List<a> b(List<a> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator<a>() {
            /* renamed from: a */
            public int compare(a aVar, a aVar2) {
                if (aVar == null && aVar2 == null) {
                    return 0;
                }
                if (aVar == null) {
                    return -1;
                }
                if (aVar2 != null && aVar.e() <= aVar2.e()) {
                    return aVar.e() == aVar2.e() ? 0 : -1;
                }
                return 1;
            }
        });
        return arrayList;
    }

    private void b(a aVar) throws IOException {
        f d2 = aVar.d();
        boolean a2 = a(this.f31717n, d2);
        this.f31717n = d2;
        if (a2) {
            f();
            this.f31718o = d2;
            this.f31719p = d2.e() ? 30 : -1;
            this.f31721r += this.f31720q;
            this.f31720q = 0;
            this.f31722s = 0;
        }
        this.f31720q += aVar.c();
        this.f31722s++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(org.jcodec.common.model.f r6, org.jcodec.common.model.f r7) {
        /*
            r5 = this;
            int r0 = r5.a((org.jcodec.common.model.f) r7)
            int r1 = r5.a((org.jcodec.common.model.f) r6)
            int r1 = r0 - r1
            r2 = -1
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x0021
            byte r7 = r7.d()
            byte r6 = r6.d()
            int r7 = r7 - r6
            int r6 = r5.f31719p
            if (r6 == r2) goto L_0x001e
            int r7 = r7 + r6
            int r7 = r7 % r6
        L_0x001e:
            if (r7 == r4) goto L_0x0056
            goto L_0x0055
        L_0x0021:
            if (r1 != r4) goto L_0x0055
            int r1 = r5.f31719p
            if (r1 != r2) goto L_0x0035
            byte r7 = r7.d()
            if (r7 != 0) goto L_0x0055
            byte r6 = r6.d()
            int r6 = r6 + r4
            r5.f31719p = r6
            goto L_0x0056
        L_0x0035:
            boolean r1 = r7.e()
            if (r1 == 0) goto L_0x0045
            int r1 = r0 % 60
            if (r1 != 0) goto L_0x0045
            int r0 = r0 % 600
            if (r0 == 0) goto L_0x0045
            r0 = 2
            goto L_0x0046
        L_0x0045:
            r0 = 0
        L_0x0046:
            byte r7 = r7.d()
            if (r7 != r0) goto L_0x0055
            byte r6 = r6.d()
            int r7 = r5.f31719p
            int r7 = r7 - r4
            if (r6 == r7) goto L_0x0056
        L_0x0055:
            r3 = 1
        L_0x0056:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: oe.d.b(org.jcodec.common.model.f, org.jcodec.common.model.f):boolean");
    }

    private void e() throws IOException {
        if (this.f31724u.size() > 0) {
            for (a b2 : b(this.f31724u)) {
                b(b2);
            }
            this.f31724u.clear();
        }
    }

    private void f() throws IOException {
        long j2 = this.f31720q;
        if (j2 <= 0) {
            return;
        }
        if (this.f31718o != null) {
            if (this.f31719p == -1) {
                this.f31719p = this.f31717n.d() + 1;
            }
            boolean e2 = this.f31718o.e();
            this.f31696l.add(new az(e2 ? 1 : 0, this.f31687c, (int) (this.f31720q / ((long) this.f31722s)), this.f31719p));
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(a(this.f31718o, this.f31719p));
            allocate.flip();
            a(new org.jcodec.containers.mp4.a(allocate, this.f31721r, (long) this.f31687c, this.f31720q, 0, true, (f) null, this.f31721r, this.f31696l.size() - 1));
            this.f31723t.add(new o(this.f31720q, this.f31721r, 1.0f));
            return;
        }
        this.f31723t.add(new o(j2, -1, 1.0f));
    }

    /* access modifiers changed from: protected */
    public c a(aj ajVar) throws IOException {
        e();
        f();
        if (this.f31696l.size() == 0) {
            return null;
        }
        this.f31697m = this.f31697m != null ? of.a.a(new org.jcodec.common.model.c(1, 1), this.f31723t, (List<o>) this.f31697m) : this.f31723t;
        return super.a(ajVar);
    }

    public void a(a aVar) throws IOException {
        if (aVar.f()) {
            e();
        }
        this.f31724u.add(new a(aVar, (ByteBuffer) null));
    }
}
