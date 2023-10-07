package fm;

import fj.h;
import java.io.IOException;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final long[] f27555a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f27556b = new byte[8];

    /* renamed from: c  reason: collision with root package name */
    private int f27557c;

    /* renamed from: d  reason: collision with root package name */
    private int f27558d;

    public static int a(int i2) {
        int i3;
        int i4 = 0;
        do {
            long[] jArr = f27555a;
            if (i4 >= jArr.length) {
                return -1;
            }
            i3 = ((jArr[i4] & ((long) i2)) > 0 ? 1 : ((jArr[i4] & ((long) i2)) == 0 ? 0 : -1));
            i4++;
        } while (i3 == 0);
        return i4;
    }

    public static long a(byte[] bArr, int i2, boolean z2) {
        long j2 = ((long) bArr[0]) & 255;
        if (z2) {
            j2 &= f27555a[i2 - 1] ^ -1;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }

    public long a(h hVar, boolean z2, boolean z3, int i2) throws IOException, InterruptedException {
        if (this.f27557c == 0) {
            if (!hVar.a(this.f27556b, 0, 1, z2)) {
                return -1;
            }
            int a2 = a(this.f27556b[0] & 255);
            this.f27558d = a2;
            if (a2 != -1) {
                this.f27557c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.f27558d;
        if (i3 > i2) {
            this.f27557c = 0;
            return -2;
        }
        if (i3 != 1) {
            hVar.b(this.f27556b, 1, i3 - 1);
        }
        this.f27557c = 0;
        return a(this.f27556b, this.f27558d, z3);
    }

    public void a() {
        this.f27557c = 0;
        this.f27558d = 0;
    }

    public int b() {
        return this.f27558d;
    }
}
