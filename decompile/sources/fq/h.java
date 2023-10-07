package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.l;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;

public final class h implements j {

    /* renamed from: a  reason: collision with root package name */
    private final q f27781a = new q(new byte[18]);

    /* renamed from: b  reason: collision with root package name */
    private final String f27782b;

    /* renamed from: c  reason: collision with root package name */
    private String f27783c;

    /* renamed from: d  reason: collision with root package name */
    private u f27784d;

    /* renamed from: e  reason: collision with root package name */
    private int f27785e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f27786f;

    /* renamed from: g  reason: collision with root package name */
    private int f27787g;

    /* renamed from: h  reason: collision with root package name */
    private long f27788h;

    /* renamed from: i  reason: collision with root package name */
    private Format f27789i;

    /* renamed from: j  reason: collision with root package name */
    private int f27790j;

    /* renamed from: k  reason: collision with root package name */
    private long f27791k;

    public h(String str) {
        this.f27782b = str;
    }

    private boolean a(q qVar, byte[] bArr, int i2) {
        int min = Math.min(qVar.b(), i2 - this.f27786f);
        qVar.a(bArr, this.f27786f, min);
        int i3 = this.f27786f + min;
        this.f27786f = i3;
        return i3 == i2;
    }

    private boolean b(q qVar) {
        while (qVar.b() > 0) {
            int i2 = this.f27787g << 8;
            this.f27787g = i2;
            int h2 = i2 | qVar.h();
            this.f27787g = h2;
            if (l.a(h2)) {
                this.f27781a.f17159a[0] = (byte) ((this.f27787g >> 24) & 255);
                this.f27781a.f17159a[1] = (byte) ((this.f27787g >> 16) & 255);
                this.f27781a.f17159a[2] = (byte) ((this.f27787g >> 8) & 255);
                this.f27781a.f17159a[3] = (byte) (this.f27787g & 255);
                this.f27786f = 4;
                this.f27787g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArr = this.f27781a.f17159a;
        if (this.f27789i == null) {
            Format a2 = l.a(bArr, this.f27783c, this.f27782b, (DrmInitData) null);
            this.f27789i = a2;
            this.f27784d.a(a2);
        }
        this.f27790j = l.b(bArr);
        this.f27788h = (long) ((int) ((((long) l.a(bArr)) * 1000000) / ((long) this.f27789i.f15106w)));
    }

    public void a() {
        this.f27785e = 0;
        this.f27786f = 0;
        this.f27787g = 0;
    }

    public void a(long j2, int i2) {
        this.f27791k = j2;
    }

    public void a(q qVar) {
        while (qVar.b() > 0) {
            int i2 = this.f27785e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(qVar.b(), this.f27790j - this.f27786f);
                        this.f27784d.a(qVar, min);
                        int i3 = this.f27786f + min;
                        this.f27786f = i3;
                        int i4 = this.f27790j;
                        if (i3 == i4) {
                            this.f27784d.a(this.f27791k, 1, i4, 0, (u.a) null);
                            this.f27791k += this.f27788h;
                            this.f27785e = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (a(qVar, this.f27781a.f17159a, 18)) {
                    c();
                    this.f27781a.c(0);
                    this.f27784d.a(this.f27781a, 18);
                    this.f27785e = 2;
                }
            } else if (b(qVar)) {
                this.f27785e = 1;
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27783c = dVar.c();
        this.f27784d = iVar.a(dVar.b(), 1);
    }

    public void b() {
    }
}
