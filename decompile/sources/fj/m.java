package fj;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class m {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public h f27380a;

        public a(h hVar) {
            this.f27380a = hVar;
        }
    }

    public static Metadata a(h hVar, boolean z2) throws IOException, InterruptedException {
        Metadata a2 = new p().a(hVar, z2 ? null : com.google.android.exoplayer2.metadata.id3.a.f15925a);
        if (a2 == null || a2.a() == 0) {
            return null;
        }
        return a2;
    }

    public static h.a a(q qVar) {
        qVar.d(1);
        int l2 = qVar.l();
        long d2 = (long) (qVar.d() + l2);
        int i2 = l2 / 18;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            long r2 = qVar.r();
            if (r2 == -1) {
                jArr = Arrays.copyOf(jArr, i3);
                jArr2 = Arrays.copyOf(jArr2, i3);
                break;
            }
            jArr[i3] = r2;
            jArr2[i3] = qVar.r();
            qVar.d(2);
            i3++;
        }
        qVar.d((int) (d2 - ((long) qVar.d())));
        return new h.a(jArr, jArr2);
    }

    private static h.a a(h hVar, int i2) throws IOException, InterruptedException {
        q qVar = new q(i2);
        hVar.b(qVar.f17159a, 0, i2);
        return a(qVar);
    }

    public static boolean a(h hVar) throws IOException, InterruptedException {
        q qVar = new q(4);
        hVar.d(qVar.f17159a, 0, 4);
        return qVar.n() == 1716281667;
    }

    public static boolean a(h hVar, a aVar) throws IOException, InterruptedException {
        h b2;
        hVar.a();
        p pVar = new p(new byte[4]);
        hVar.d(pVar.f17155a, 0, 4);
        boolean e2 = pVar.e();
        int c2 = pVar.c(7);
        int c3 = pVar.c(24) + 4;
        if (c2 == 0) {
            b2 = d(hVar);
        } else {
            h hVar2 = aVar.f27380a;
            if (hVar2 == null) {
                throw new IllegalArgumentException();
            } else if (c2 == 3) {
                b2 = hVar2.a(a(hVar, c3));
            } else if (c2 == 4) {
                b2 = hVar2.a(b(hVar, c3));
            } else if (c2 == 6) {
                b2 = hVar2.b((List<PictureFrame>) Collections.singletonList(c(hVar, c3)));
            } else {
                hVar.b(c3);
                return e2;
            }
        }
        aVar.f27380a = b2;
        return e2;
    }

    public static Metadata b(h hVar, boolean z2) throws IOException, InterruptedException {
        hVar.a();
        long b2 = hVar.b();
        Metadata a2 = a(hVar, z2);
        hVar.b((int) (hVar.b() - b2));
        return a2;
    }

    private static List<String> b(h hVar, int i2) throws IOException, InterruptedException {
        q qVar = new q(i2);
        hVar.b(qVar.f17159a, 0, i2);
        qVar.d(4);
        return Arrays.asList(w.a(qVar, false, false).f27423b);
    }

    public static void b(h hVar) throws IOException, InterruptedException {
        q qVar = new q(4);
        hVar.b(qVar.f17159a, 0, 4);
        if (qVar.n() != 1716281667) {
            throw new ParserException("Failed to read FLAC stream marker.");
        }
    }

    public static int c(h hVar) throws IOException, InterruptedException {
        hVar.a();
        q qVar = new q(2);
        hVar.d(qVar.f17159a, 0, 2);
        int i2 = qVar.i();
        int i3 = i2 >> 2;
        hVar.a();
        if (i3 == 16382) {
            return i2;
        }
        throw new ParserException("First frame does not start with sync code.");
    }

    private static PictureFrame c(h hVar, int i2) throws IOException, InterruptedException {
        q qVar = new q(i2);
        hVar.b(qVar.f17159a, 0, i2);
        qVar.d(4);
        int p2 = qVar.p();
        String a2 = qVar.a(qVar.p(), Charset.forName("US-ASCII"));
        String e2 = qVar.e(qVar.p());
        int p3 = qVar.p();
        int p4 = qVar.p();
        int p5 = qVar.p();
        int p6 = qVar.p();
        int p7 = qVar.p();
        byte[] bArr = new byte[p7];
        qVar.a(bArr, 0, p7);
        return new PictureFrame(p2, a2, e2, p3, p4, p5, p6, bArr);
    }

    private static h d(h hVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[38];
        hVar.b(bArr, 0, 38);
        return new h(bArr, 4);
    }
}
