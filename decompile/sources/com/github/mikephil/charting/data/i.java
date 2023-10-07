package com.github.mikephil.charting.data;

import fa.d;
import fc.b;
import java.util.ArrayList;
import java.util.List;

public class i extends b<b<? extends Entry>> {

    /* renamed from: j  reason: collision with root package name */
    private j f15028j;

    /* renamed from: k  reason: collision with root package name */
    private a f15029k;

    /* renamed from: l  reason: collision with root package name */
    private o f15030l;

    /* renamed from: m  reason: collision with root package name */
    private g f15031m;

    /* renamed from: n  reason: collision with root package name */
    private f f15032n;

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.mikephil.charting.data.Entry a(fa.d r6) {
        /*
            r5 = this;
            int r0 = r6.e()
            java.util.List r1 = r5.o()
            int r1 = r1.size()
            r2 = 0
            if (r0 < r1) goto L_0x0010
            return r2
        L_0x0010:
            int r0 = r6.e()
            com.github.mikephil.charting.data.b r0 = r5.b((int) r0)
            int r1 = r6.f()
            int r3 = r0.c()
            if (r1 < r3) goto L_0x0023
            return r2
        L_0x0023:
            int r1 = r6.f()
            fc.e r0 = r0.a((int) r1)
            float r1 = r6.a()
            java.util.List r0 = r0.a((float) r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            float r3 = r1.b()
            float r4 = r6.b()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0059
            float r3 = r6.b()
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0059:
            return r1
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.i.a(fa.d):com.github.mikephil.charting.data.Entry");
    }

    public f a() {
        return this.f15032n;
    }

    public b b(int i2) {
        return o().get(i2);
    }

    public b<? extends Entry> b(d dVar) {
        if (dVar.e() >= o().size()) {
            return null;
        }
        b b2 = b(dVar.e());
        if (dVar.f() >= b2.c()) {
            return null;
        }
        return (b) b2.h().get(dVar.f());
    }

    public void b() {
        if (this.f15027i == null) {
            this.f15027i = new ArrayList();
        }
        this.f15027i.clear();
        this.f15019a = -3.4028235E38f;
        this.f15020b = Float.MAX_VALUE;
        this.f15021c = -3.4028235E38f;
        this.f15022d = Float.MAX_VALUE;
        this.f15023e = -3.4028235E38f;
        this.f15024f = Float.MAX_VALUE;
        this.f15025g = -3.4028235E38f;
        this.f15026h = Float.MAX_VALUE;
        for (h next : o()) {
            next.b();
            this.f15027i.addAll(next.h());
            if (next.e() > this.f15019a) {
                this.f15019a = next.e();
            }
            if (next.d() < this.f15020b) {
                this.f15020b = next.d();
            }
            if (next.g() > this.f15021c) {
                this.f15021c = next.g();
            }
            if (next.f() < this.f15022d) {
                this.f15022d = next.f();
            }
            if (next.f15023e > this.f15023e) {
                this.f15023e = next.f15023e;
            }
            if (next.f15024f < this.f15024f) {
                this.f15024f = next.f15024f;
            }
            if (next.f15025g > this.f15025g) {
                this.f15025g = next.f15025g;
            }
            if (next.f15026h < this.f15026h) {
                this.f15026h = next.f15026h;
            }
        }
    }

    public j k() {
        return this.f15028j;
    }

    public a l() {
        return this.f15029k;
    }

    public o m() {
        return this.f15030l;
    }

    public g n() {
        return this.f15031m;
    }

    public List<b> o() {
        ArrayList arrayList = new ArrayList();
        j jVar = this.f15028j;
        if (jVar != null) {
            arrayList.add(jVar);
        }
        a aVar = this.f15029k;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        o oVar = this.f15030l;
        if (oVar != null) {
            arrayList.add(oVar);
        }
        g gVar = this.f15031m;
        if (gVar != null) {
            arrayList.add(gVar);
        }
        f fVar = this.f15032n;
        if (fVar != null) {
            arrayList.add(fVar);
        }
        return arrayList;
    }
}
