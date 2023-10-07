package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;
import java.util.List;

public final class d implements j {

    /* renamed from: a  reason: collision with root package name */
    private final p f27731a;

    /* renamed from: b  reason: collision with root package name */
    private final q f27732b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27733c;

    /* renamed from: d  reason: collision with root package name */
    private String f27734d;

    /* renamed from: e  reason: collision with root package name */
    private u f27735e;

    /* renamed from: f  reason: collision with root package name */
    private int f27736f;

    /* renamed from: g  reason: collision with root package name */
    private int f27737g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27738h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27739i;

    /* renamed from: j  reason: collision with root package name */
    private long f27740j;

    /* renamed from: k  reason: collision with root package name */
    private Format f27741k;

    /* renamed from: l  reason: collision with root package name */
    private int f27742l;

    /* renamed from: m  reason: collision with root package name */
    private long f27743m;

    public d() {
        this((String) null);
    }

    public d(String str) {
        p pVar = new p(new byte[16]);
        this.f27731a = pVar;
        this.f27732b = new q(pVar.f17155a);
        this.f27736f = 0;
        this.f27737g = 0;
        this.f27738h = false;
        this.f27739i = false;
        this.f27733c = str;
    }

    private boolean a(q qVar, byte[] bArr, int i2) {
        int min = Math.min(qVar.b(), i2 - this.f27737g);
        qVar.a(bArr, this.f27737g, min);
        int i3 = this.f27737g + min;
        this.f27737g = i3;
        return i3 == i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.google.android.exoplayer2.util.q r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6.b()
            r1 = 0
            if (r0 <= 0) goto L_0x0031
            boolean r0 = r5.f27738h
            r2 = 172(0xac, float:2.41E-43)
            r3 = 1
            if (r0 != 0) goto L_0x0018
            int r0 = r6.h()
            if (r0 != r2) goto L_0x0015
            r1 = 1
        L_0x0015:
            r5.f27738h = r1
            goto L_0x0000
        L_0x0018:
            int r0 = r6.h()
            if (r0 != r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r5.f27738h = r2
            r2 = 64
            r4 = 65
            if (r0 == r2) goto L_0x002b
            if (r0 != r4) goto L_0x0000
        L_0x002b:
            if (r0 != r4) goto L_0x002e
            r1 = 1
        L_0x002e:
            r5.f27739i = r1
            return r3
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.d.b(com.google.android.exoplayer2.util.q):boolean");
    }

    private void c() {
        this.f27731a.a(0);
        b.a a2 = b.a(this.f27731a);
        if (this.f27741k == null || a2.f15264c != this.f27741k.f15105v || a2.f15263b != this.f27741k.f15106w || !"audio/ac4".equals(this.f27741k.f15092i)) {
            Format a3 = Format.a(this.f27734d, "audio/ac4", (String) null, -1, -1, a2.f15264c, a2.f15263b, (List<byte[]>) null, (DrmInitData) null, 0, this.f27733c);
            this.f27741k = a3;
            this.f27735e.a(a3);
        }
        this.f27742l = a2.f15265d;
        this.f27740j = (((long) a2.f15266e) * 1000000) / ((long) this.f27741k.f15106w);
    }

    public void a() {
        this.f27736f = 0;
        this.f27737g = 0;
        this.f27738h = false;
        this.f27739i = false;
    }

    public void a(long j2, int i2) {
        this.f27743m = j2;
    }

    public void a(q qVar) {
        while (qVar.b() > 0) {
            int i2 = this.f27736f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(qVar.b(), this.f27742l - this.f27737g);
                        this.f27735e.a(qVar, min);
                        int i3 = this.f27737g + min;
                        this.f27737g = i3;
                        int i4 = this.f27742l;
                        if (i3 == i4) {
                            this.f27735e.a(this.f27743m, 1, i4, 0, (u.a) null);
                            this.f27743m += this.f27740j;
                            this.f27736f = 0;
                        }
                    }
                } else if (a(qVar, this.f27732b.f17159a, 16)) {
                    c();
                    this.f27732b.c(0);
                    this.f27735e.a(this.f27732b, 16);
                    this.f27736f = 2;
                }
            } else if (b(qVar)) {
                this.f27736f = 1;
                this.f27732b.f17159a[0] = -84;
                this.f27732b.f17159a[1] = (byte) (this.f27739i ? 65 : 64);
                this.f27737g = 2;
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27734d = dVar.c();
        this.f27735e = iVar.a(dVar.b(), 1);
    }

    public void b() {
    }
}
