package fj;

import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.ad;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f27362a = new byte[4096];

    /* renamed from: b  reason: collision with root package name */
    private final f f27363b;

    /* renamed from: c  reason: collision with root package name */
    private final long f27364c;

    /* renamed from: d  reason: collision with root package name */
    private long f27365d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f27366e = new byte[65536];

    /* renamed from: f  reason: collision with root package name */
    private int f27367f;

    /* renamed from: g  reason: collision with root package name */
    private int f27368g;

    public d(f fVar, long j2, long j3) {
        this.f27363b = fVar;
        this.f27365d = j2;
        this.f27364c = j3;
    }

    private int a(byte[] bArr, int i2, int i3, int i4, boolean z2) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int a2 = this.f27363b.a(bArr, i2 + i4, i3 - i4);
            if (a2 != -1) {
                return i4 + a2;
            }
            if (i4 == 0 && z2) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private void d(int i2) {
        int i3 = this.f27367f + i2;
        byte[] bArr = this.f27366e;
        if (i3 > bArr.length) {
            this.f27366e = Arrays.copyOf(this.f27366e, ad.a(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    private int e(int i2) {
        int min = Math.min(this.f27368g, i2);
        f(min);
        return min;
    }

    private int e(byte[] bArr, int i2, int i3) {
        int i4 = this.f27368g;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f27366e, 0, bArr, i2, min);
        f(min);
        return min;
    }

    private void f(int i2) {
        int i3 = this.f27368g - i2;
        this.f27368g = i3;
        this.f27367f = 0;
        byte[] bArr = this.f27366e;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[(65536 + i3)] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f27366e = bArr2;
    }

    private void g(int i2) {
        if (i2 != -1) {
            this.f27365d += (long) i2;
        }
    }

    public int a(int i2) throws IOException, InterruptedException {
        int e2 = e(i2);
        if (e2 == 0) {
            byte[] bArr = this.f27362a;
            e2 = a(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        g(e2);
        return e2;
    }

    public int a(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int e2 = e(bArr, i2, i3);
        if (e2 == 0) {
            e2 = a(bArr, i2, i3, 0, true);
        }
        g(e2);
        return e2;
    }

    public void a() {
        this.f27367f = 0;
    }

    public boolean a(int i2, boolean z2) throws IOException, InterruptedException {
        int e2 = e(i2);
        while (e2 < i2 && e2 != -1) {
            e2 = a(this.f27362a, -e2, Math.min(i2, this.f27362a.length + e2), e2, z2);
        }
        g(e2);
        return e2 != -1;
    }

    public boolean a(byte[] bArr, int i2, int i3, boolean z2) throws IOException, InterruptedException {
        int e2 = e(bArr, i2, i3);
        while (e2 < i3 && e2 != -1) {
            e2 = a(bArr, i2, i3, e2, z2);
        }
        g(e2);
        return e2 != -1;
    }

    public long b() {
        return this.f27365d + ((long) this.f27367f);
    }

    public void b(int i2) throws IOException, InterruptedException {
        a(i2, false);
    }

    public void b(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        a(bArr, i2, i3, false);
    }

    public boolean b(int i2, boolean z2) throws IOException, InterruptedException {
        d(i2);
        int i3 = this.f27368g - this.f27367f;
        while (i3 < i2) {
            i3 = a(this.f27366e, this.f27367f, i2, i3, z2);
            if (i3 == -1) {
                return false;
            }
            this.f27368g = this.f27367f + i3;
        }
        this.f27367f += i2;
        return true;
    }

    public boolean b(byte[] bArr, int i2, int i3, boolean z2) throws IOException, InterruptedException {
        if (!b(i3, z2)) {
            return false;
        }
        System.arraycopy(this.f27366e, this.f27367f - i3, bArr, i2, i3);
        return true;
    }

    public int c(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int i4;
        d(i3);
        int i5 = this.f27368g;
        int i6 = this.f27367f;
        int i7 = i5 - i6;
        if (i7 == 0) {
            i4 = a(this.f27366e, i6, i3, 0, true);
            if (i4 == -1) {
                return -1;
            }
            this.f27368g += i4;
        } else {
            i4 = Math.min(i3, i7);
        }
        System.arraycopy(this.f27366e, this.f27367f, bArr, i2, i4);
        this.f27367f += i4;
        return i4;
    }

    public long c() {
        return this.f27365d;
    }

    public void c(int i2) throws IOException, InterruptedException {
        b(i2, false);
    }

    public long d() {
        return this.f27364c;
    }

    public void d(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        b(bArr, i2, i3, false);
    }
}
