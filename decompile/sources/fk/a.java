package fk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ad;
import fj.c;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fj.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27439a = $$Lambda$a$yOkjKhZ8lHbAWW8hmXrqsf6AU.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f27440b = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f27441c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f27442d = ad.c("#!AMR\n");

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f27443e = ad.c("#!AMR-WB\n");

    /* renamed from: f  reason: collision with root package name */
    private static final int f27444f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f27445g;

    /* renamed from: h  reason: collision with root package name */
    private final int f27446h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27447i;

    /* renamed from: j  reason: collision with root package name */
    private long f27448j;

    /* renamed from: k  reason: collision with root package name */
    private int f27449k;

    /* renamed from: l  reason: collision with root package name */
    private int f27450l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f27451m;

    /* renamed from: n  reason: collision with root package name */
    private long f27452n;

    /* renamed from: o  reason: collision with root package name */
    private int f27453o;

    /* renamed from: p  reason: collision with root package name */
    private int f27454p;

    /* renamed from: q  reason: collision with root package name */
    private long f27455q;

    /* renamed from: r  reason: collision with root package name */
    private i f27456r;

    /* renamed from: s  reason: collision with root package name */
    private u f27457s;

    /* renamed from: t  reason: collision with root package name */
    private s f27458t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f27459u;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f27441c = iArr;
        f27444f = iArr[8];
    }

    public a() {
        this(0);
    }

    public a(int i2) {
        this.f27446h = i2;
        this.f27445g = new byte[1];
        this.f27453o = -1;
    }

    private int a(int i2) throws ParserException {
        if (b(i2)) {
            return this.f27447i ? f27441c[i2] : f27440b[i2];
        }
        String str = this.f27447i ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i2);
        throw new ParserException(sb.toString());
    }

    private static int a(int i2, long j2) {
        return (int) ((((long) (i2 * 8)) * 1000000) / j2);
    }

    private s a(long j2) {
        return new c(j2, this.f27452n, a(this.f27453o, 20000), this.f27453o);
    }

    private void a() {
        if (!this.f27459u) {
            this.f27459u = true;
            boolean z2 = this.f27447i;
            this.f27457s.a(Format.a((String) null, z2 ? "audio/amr-wb" : "audio/3gpp", (String) null, -1, f27444f, 1, z2 ? 16000 : 8000, -1, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
        }
    }

    private void a(long j2, int i2) {
        s sVar;
        int i3;
        if (!this.f27451m) {
            if ((this.f27446h & 1) == 0 || j2 == -1 || !((i3 = this.f27453o) == -1 || i3 == this.f27449k)) {
                sVar = new s.b(-9223372036854775807L);
            } else if (this.f27454p >= 20 || i2 == -1) {
                sVar = a(j2);
            } else {
                return;
            }
            this.f27458t = sVar;
            this.f27456r.a(sVar);
            this.f27451m = true;
        }
    }

    private boolean a(h hVar, byte[] bArr) throws IOException, InterruptedException {
        hVar.a();
        byte[] bArr2 = new byte[bArr.length];
        hVar.d(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private boolean b(int i2) {
        return i2 >= 0 && i2 <= 15 && (c(i2) || d(i2));
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        int length;
        byte[] bArr = f27442d;
        if (a(hVar, bArr)) {
            this.f27447i = false;
            length = bArr.length;
        } else {
            byte[] bArr2 = f27443e;
            if (!a(hVar, bArr2)) {
                return false;
            }
            this.f27447i = true;
            length = bArr2.length;
        }
        hVar.b(length);
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] b() {
        return new g[]{new a()};
    }

    private int c(h hVar) throws IOException, InterruptedException {
        if (this.f27450l == 0) {
            try {
                int d2 = d(hVar);
                this.f27449k = d2;
                this.f27450l = d2;
                if (this.f27453o == -1) {
                    this.f27452n = hVar.c();
                    this.f27453o = this.f27449k;
                }
                if (this.f27453o == this.f27449k) {
                    this.f27454p++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int a2 = this.f27457s.a(hVar, this.f27450l, true);
        if (a2 == -1) {
            return -1;
        }
        int i2 = this.f27450l - a2;
        this.f27450l = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f27457s.a(this.f27455q + this.f27448j, 1, this.f27449k, 0, (u.a) null);
        this.f27448j += 20000;
        return 0;
    }

    private boolean c(int i2) {
        return this.f27447i && (i2 < 10 || i2 > 13);
    }

    private int d(h hVar) throws IOException, InterruptedException {
        hVar.a();
        hVar.d(this.f27445g, 0, 1);
        byte b2 = this.f27445g[0];
        if ((b2 & 131) <= 0) {
            return a((b2 >> 3) & 15);
        }
        StringBuilder sb = new StringBuilder(42);
        sb.append("Invalid padding bits for frame header ");
        sb.append(b2);
        throw new ParserException(sb.toString());
    }

    private boolean d(int i2) {
        return !this.f27447i && (i2 < 12 || i2 > 14);
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        if (hVar.c() != 0 || b(hVar)) {
            a();
            int c2 = c(hVar);
            a(hVar.d(), c2);
            return c2;
        }
        throw new ParserException("Could not find AMR header.");
    }

    public void a(long j2, long j3) {
        this.f27448j = 0;
        this.f27449k = 0;
        this.f27450l = 0;
        if (j2 != 0) {
            s sVar = this.f27458t;
            if (sVar instanceof c) {
                this.f27455q = ((c) sVar).b(j2);
                return;
            }
        }
        this.f27455q = 0;
    }

    public void a(i iVar) {
        this.f27456r = iVar;
        this.f27457s = iVar.a(0, 1);
        iVar.a();
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        return b(hVar);
    }

    public void c() {
    }
}
