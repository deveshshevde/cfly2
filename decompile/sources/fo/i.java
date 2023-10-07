package fo;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.q;
import fj.w;
import fo.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class i extends h {

    /* renamed from: a  reason: collision with root package name */
    private a f27645a;

    /* renamed from: b  reason: collision with root package name */
    private int f27646b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27647c;

    /* renamed from: d  reason: collision with root package name */
    private w.d f27648d;

    /* renamed from: e  reason: collision with root package name */
    private w.b f27649e;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final w.d f27650a;

        /* renamed from: b  reason: collision with root package name */
        public final w.b f27651b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f27652c;

        /* renamed from: d  reason: collision with root package name */
        public final w.c[] f27653d;

        /* renamed from: e  reason: collision with root package name */
        public final int f27654e;

        public a(w.d dVar, w.b bVar, byte[] bArr, w.c[] cVarArr, int i2) {
            this.f27650a = dVar;
            this.f27651b = bVar;
            this.f27652c = bArr;
            this.f27653d = cVarArr;
            this.f27654e = i2;
        }
    }

    i() {
    }

    static int a(byte b2, int i2, int i3) {
        return (b2 >> i3) & (255 >>> (8 - i2));
    }

    private static int a(byte b2, a aVar) {
        return !aVar.f27653d[a(b2, aVar.f27654e, 1)].f27425a ? aVar.f27650a.f27435g : aVar.f27650a.f27436h;
    }

    static void a(q qVar, long j2) {
        qVar.b(qVar.c() + 4);
        qVar.f17159a[qVar.c() - 4] = (byte) ((int) (j2 & 255));
        qVar.f17159a[qVar.c() - 3] = (byte) ((int) ((j2 >>> 8) & 255));
        qVar.f17159a[qVar.c() - 2] = (byte) ((int) ((j2 >>> 16) & 255));
        qVar.f17159a[qVar.c() - 1] = (byte) ((int) ((j2 >>> 24) & 255));
    }

    public static boolean a(q qVar) {
        try {
            return w.a(1, qVar, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.f27645a = null;
            this.f27648d = null;
            this.f27649e = null;
        }
        this.f27646b = 0;
        this.f27647c = false;
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar, long j2, h.a aVar) throws IOException, InterruptedException {
        if (this.f27645a != null) {
            return false;
        }
        a c2 = c(qVar);
        this.f27645a = c2;
        if (c2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f27645a.f27650a.f27438j);
        arrayList.add(this.f27645a.f27652c);
        aVar.f27643a = Format.a((String) null, "audio/vorbis", (String) null, this.f27645a.f27650a.f27433e, -1, this.f27645a.f27650a.f27430b, (int) this.f27645a.f27650a.f27431c, (List<byte[]>) arrayList, (DrmInitData) null, 0, (String) null);
        return true;
    }

    /* access modifiers changed from: protected */
    public long b(q qVar) {
        int i2 = 0;
        if ((qVar.f17159a[0] & 1) == 1) {
            return -1;
        }
        int a2 = a(qVar.f17159a[0], this.f27645a);
        if (this.f27647c) {
            i2 = (this.f27646b + a2) / 4;
        }
        long j2 = (long) i2;
        a(qVar, j2);
        this.f27647c = true;
        this.f27646b = a2;
        return j2;
    }

    /* access modifiers changed from: package-private */
    public a c(q qVar) throws IOException {
        if (this.f27648d == null) {
            this.f27648d = w.a(qVar);
            return null;
        } else if (this.f27649e == null) {
            this.f27649e = w.b(qVar);
            return null;
        } else {
            byte[] bArr = new byte[qVar.c()];
            System.arraycopy(qVar.f17159a, 0, bArr, 0, qVar.c());
            w.c[] a2 = w.a(qVar, this.f27648d.f27430b);
            return new a(this.f27648d, this.f27649e, bArr, a2, w.a(a2.length - 1));
        }
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        super.c(j2);
        int i2 = 0;
        this.f27647c = j2 != 0;
        w.d dVar = this.f27648d;
        if (dVar != null) {
            i2 = dVar.f27435g;
        }
        this.f27646b = i2;
    }
}
