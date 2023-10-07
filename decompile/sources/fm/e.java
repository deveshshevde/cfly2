package fm;

import com.google.android.exoplayer2.util.q;
import fj.h;
import java.io.IOException;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final q f27553a = new q(8);

    /* renamed from: b  reason: collision with root package name */
    private int f27554b;

    private long b(h hVar) throws IOException, InterruptedException {
        int i2 = 0;
        hVar.d(this.f27553a.f17159a, 0, 1);
        byte b2 = this.f27553a.f17159a[0] & 255;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((b2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = b2 & (i3 ^ -1);
        hVar.d(this.f27553a.f17159a, 1, i4);
        while (i2 < i4) {
            i2++;
            i5 = (this.f27553a.f17159a[i2] & 255) + (i5 << 8);
        }
        this.f27554b += i4 + 1;
        return (long) i5;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        h hVar2 = hVar;
        long d2 = hVar.d();
        long j2 = 1024;
        if (d2 != -1 && d2 <= 1024) {
            j2 = d2;
        }
        int i2 = (int) j2;
        hVar2.d(this.f27553a.f17159a, 0, 4);
        this.f27554b = 4;
        for (long n2 = this.f27553a.n(); n2 != 440786851; n2 = ((n2 << 8) & -256) | ((long) (this.f27553a.f17159a[0] & 255))) {
            int i3 = this.f27554b + 1;
            this.f27554b = i3;
            if (i3 == i2) {
                return false;
            }
            hVar2.d(this.f27553a.f17159a, 0, 1);
        }
        long b2 = b(hVar);
        long j3 = (long) this.f27554b;
        if (b2 == Long.MIN_VALUE) {
            return false;
        }
        if (d2 != -1 && j3 + b2 >= d2) {
            return false;
        }
        while (true) {
            int i4 = this.f27554b;
            long j4 = j3 + b2;
            if (((long) i4) >= j4) {
                return ((long) i4) == j4;
            }
            if (b(hVar) == Long.MIN_VALUE) {
                return false;
            }
            long b3 = b(hVar);
            if (b3 < 0 || b3 > 2147483647L) {
                return false;
            }
            if (b3 != 0) {
                int i5 = (int) b3;
                hVar2.c(i5);
                this.f27554b += i5;
            }
        }
        return false;
    }
}
