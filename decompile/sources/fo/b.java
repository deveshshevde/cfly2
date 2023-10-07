package fo;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.q;
import fj.l;
import fj.m;
import fj.n;
import fj.s;
import fo.h;
import java.io.IOException;
import java.util.Arrays;

final class b extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public h f27603a;

    /* renamed from: b  reason: collision with root package name */
    private a f27604b;

    private class a implements f {

        /* renamed from: b  reason: collision with root package name */
        private long f27606b = -1;

        /* renamed from: c  reason: collision with root package name */
        private long f27607c = -1;

        public a() {
        }

        public long a(fj.h hVar) throws IOException, InterruptedException {
            long j2 = this.f27607c;
            if (j2 < 0) {
                return -1;
            }
            long j3 = -(j2 + 2);
            this.f27607c = -1;
            return j3;
        }

        public void a(long j2) {
            com.google.android.exoplayer2.util.a.b(b.this.f27603a.f17123k);
            long[] jArr = b.this.f27603a.f17123k.f17125a;
            this.f27607c = jArr[ad.a(jArr, j2, true, true)];
        }

        public s b() {
            com.google.android.exoplayer2.util.a.b(this.f27606b != -1);
            return new n(b.this.f27603a, this.f27606b);
        }

        public void b(long j2) {
            this.f27606b = j2;
        }
    }

    b() {
    }

    public static boolean a(q qVar) {
        return qVar.b() >= 5 && qVar.h() == 127 && qVar.n() == 1179402563;
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    private int c(q qVar) {
        int i2 = (qVar.f17159a[2] & 255) >> 4;
        if (i2 == 6 || i2 == 7) {
            qVar.d(4);
            qVar.C();
        }
        int a2 = l.a(qVar, i2);
        qVar.c(0);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.f27603a = null;
            this.f27604b = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar, long j2, h.a aVar) {
        byte[] bArr = qVar.f17159a;
        if (this.f27603a == null) {
            this.f27603a = new com.google.android.exoplayer2.util.h(bArr, 17);
            aVar.f27643a = this.f27603a.a(Arrays.copyOfRange(bArr, 9, qVar.c()), (Metadata) null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.f27604b = new a();
            this.f27603a = this.f27603a.a(m.a(qVar));
            return true;
        } else if (!a(bArr)) {
            return true;
        } else {
            a aVar2 = this.f27604b;
            if (aVar2 != null) {
                aVar2.b(j2);
                aVar.f27644b = this.f27604b;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public long b(q qVar) {
        if (!a(qVar.f17159a)) {
            return -1;
        }
        return (long) c(qVar);
    }
}
