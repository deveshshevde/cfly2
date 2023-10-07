package fr;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import fj.h;
import java.io.IOException;

final class c {

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f28024a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28025b;

        private a(int i2, long j2) {
            this.f28024a = i2;
            this.f28025b = j2;
        }

        public static a a(h hVar, q qVar) throws IOException, InterruptedException {
            hVar.d(qVar.f17159a, 0, 8);
            qVar.c(0);
            return new a(qVar.p(), qVar.o());
        }
    }

    public static b a(h hVar) throws IOException, InterruptedException {
        a a2;
        byte[] bArr;
        com.google.android.exoplayer2.util.a.b(hVar);
        q qVar = new q(16);
        if (a.a(hVar, qVar).f28024a != 1380533830) {
            return null;
        }
        hVar.d(qVar.f17159a, 0, 4);
        qVar.c(0);
        int p2 = qVar.p();
        if (p2 != 1463899717) {
            StringBuilder sb = new StringBuilder(36);
            sb.append("Unsupported RIFF format: ");
            sb.append(p2);
            k.d("WavHeaderReader", sb.toString());
            return null;
        }
        while (true) {
            a2 = a.a(hVar, qVar);
            if (a2.f28024a == 1718449184) {
                break;
            }
            hVar.c((int) a2.f28025b);
        }
        com.google.android.exoplayer2.util.a.b(a2.f28025b >= 16);
        hVar.d(qVar.f17159a, 0, 16);
        qVar.c(0);
        int j2 = qVar.j();
        int j3 = qVar.j();
        int w2 = qVar.w();
        int w3 = qVar.w();
        int j4 = qVar.j();
        int j5 = qVar.j();
        int i2 = ((int) a2.f28025b) - 16;
        if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            hVar.d(bArr2, 0, i2);
            bArr = bArr2;
        } else {
            bArr = ad.f11760f;
        }
        return new b(j2, j3, w2, w3, j4, j5, bArr);
    }

    public static Pair<Long, Long> b(h hVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.b(hVar);
        hVar.a();
        q qVar = new q(8);
        while (true) {
            a a2 = a.a(hVar, qVar);
            if (a2.f28024a != 1684108385) {
                if (!(a2.f28024a == 1380533830 || a2.f28024a == 1718449184)) {
                    int i2 = a2.f28024a;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Ignoring unknown WAV chunk: ");
                    sb.append(i2);
                    k.c("WavHeaderReader", sb.toString());
                }
                long j2 = a2.f28025b + 8;
                if (a2.f28024a == 1380533830) {
                    j2 = 12;
                }
                if (j2 <= 2147483647L) {
                    hVar.b((int) j2);
                } else {
                    int i3 = a2.f28024a;
                    StringBuilder sb2 = new StringBuilder(51);
                    sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                    sb2.append(i3);
                    throw new ParserException(sb2.toString());
                }
            } else {
                hVar.b(8);
                long c2 = hVar.c();
                long j3 = a2.f28025b + c2;
                long d2 = hVar.d();
                if (d2 != -1 && j3 > d2) {
                    StringBuilder sb3 = new StringBuilder(69);
                    sb3.append("Data exceeds input length: ");
                    sb3.append(j3);
                    sb3.append(", ");
                    sb3.append(d2);
                    k.c("WavHeaderReader", sb3.toString());
                    j3 = d2;
                }
                return Pair.create(Long.valueOf(c2), Long.valueOf(j3));
            }
        }
    }
}
