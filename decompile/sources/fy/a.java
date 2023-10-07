package fy;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final q f28309a = new q();

    /* renamed from: b  reason: collision with root package name */
    private final q f28310b = new q();

    /* renamed from: c  reason: collision with root package name */
    private final C0182a f28311c = new C0182a();

    /* renamed from: d  reason: collision with root package name */
    private Inflater f28312d;

    /* renamed from: fy.a$a  reason: collision with other inner class name */
    private static final class C0182a {

        /* renamed from: a  reason: collision with root package name */
        private final q f28313a = new q();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f28314b = new int[256];

        /* renamed from: c  reason: collision with root package name */
        private boolean f28315c;

        /* renamed from: d  reason: collision with root package name */
        private int f28316d;

        /* renamed from: e  reason: collision with root package name */
        private int f28317e;

        /* renamed from: f  reason: collision with root package name */
        private int f28318f;

        /* renamed from: g  reason: collision with root package name */
        private int f28319g;

        /* renamed from: h  reason: collision with root package name */
        private int f28320h;

        /* renamed from: i  reason: collision with root package name */
        private int f28321i;

        /* access modifiers changed from: private */
        public void a(q qVar, int i2) {
            if (i2 % 5 == 2) {
                qVar.d(2);
                Arrays.fill(this.f28314b, 0);
                int i3 = i2 / 5;
                int i4 = 0;
                while (i4 < i3) {
                    int h2 = qVar.h();
                    int h3 = qVar.h();
                    int h4 = qVar.h();
                    int h5 = qVar.h();
                    int h6 = qVar.h();
                    double d2 = (double) h3;
                    double d3 = (double) (h4 - 128);
                    Double.isNaN(d3);
                    Double.isNaN(d2);
                    int i5 = i4;
                    double d4 = (double) (h5 - 128);
                    Double.isNaN(d4);
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    Double.isNaN(d2);
                    int[] iArr = this.f28314b;
                    int a2 = ad.a((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255) << 8;
                    iArr[h2] = ad.a((int) (d2 + (d4 * 1.772d)), 0, 255) | a2 | (h6 << 24) | (ad.a((int) ((1.402d * d3) + d2), 0, 255) << 16);
                    i4 = i5 + 1;
                }
                this.f28315c = true;
            }
        }

        /* access modifiers changed from: private */
        public void b(q qVar, int i2) {
            int l2;
            if (i2 >= 4) {
                qVar.d(3);
                int i3 = i2 - 4;
                if ((qVar.h() & 128) != 0) {
                    if (i3 >= 7 && (l2 = qVar.l()) >= 4) {
                        this.f28320h = qVar.i();
                        this.f28321i = qVar.i();
                        this.f28313a.a(l2 - 4);
                        i3 -= 7;
                    } else {
                        return;
                    }
                }
                int d2 = this.f28313a.d();
                int c2 = this.f28313a.c();
                if (d2 < c2 && i3 > 0) {
                    int min = Math.min(i3, c2 - d2);
                    qVar.a(this.f28313a.f17159a, d2, min);
                    this.f28313a.c(d2 + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void c(q qVar, int i2) {
            if (i2 >= 19) {
                this.f28316d = qVar.i();
                this.f28317e = qVar.i();
                qVar.d(11);
                this.f28318f = qVar.i();
                this.f28319g = qVar.i();
            }
        }

        public b a() {
            int h2;
            if (this.f28316d == 0 || this.f28317e == 0 || this.f28320h == 0 || this.f28321i == 0 || this.f28313a.c() == 0 || this.f28313a.d() != this.f28313a.c() || !this.f28315c) {
                return null;
            }
            this.f28313a.c(0);
            int i2 = this.f28320h * this.f28321i;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int h3 = this.f28313a.h();
                if (h3 != 0) {
                    h2 = i3 + 1;
                    iArr[i3] = this.f28314b[h3];
                } else {
                    int h4 = this.f28313a.h();
                    if (h4 != 0) {
                        h2 = ((h4 & 64) == 0 ? h4 & 63 : ((h4 & 63) << 8) | this.f28313a.h()) + i3;
                        Arrays.fill(iArr, i3, h2, (h4 & 128) == 0 ? 0 : this.f28314b[this.f28313a.h()]);
                    }
                }
                i3 = h2;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.f28320h, this.f28321i, Bitmap.Config.ARGB_8888);
            int i4 = this.f28316d;
            float f2 = ((float) this.f28318f) / ((float) i4);
            int i5 = this.f28317e;
            return new b(createBitmap, f2, 0, ((float) this.f28319g) / ((float) i5), 0, ((float) this.f28320h) / ((float) i4), ((float) this.f28321i) / ((float) i5));
        }

        public void b() {
            this.f28316d = 0;
            this.f28317e = 0;
            this.f28318f = 0;
            this.f28319g = 0;
            this.f28320h = 0;
            this.f28321i = 0;
            this.f28313a.a(0);
            this.f28315c = false;
        }
    }

    public a() {
        super("PgsDecoder");
    }

    private static b a(q qVar, C0182a aVar) {
        int c2 = qVar.c();
        int h2 = qVar.h();
        int i2 = qVar.i();
        int d2 = qVar.d() + i2;
        b bVar = null;
        if (d2 > c2) {
            qVar.c(c2);
            return null;
        }
        if (h2 != 128) {
            switch (h2) {
                case 20:
                    aVar.a(qVar, i2);
                    break;
                case 21:
                    aVar.b(qVar, i2);
                    break;
                case 22:
                    aVar.c(qVar, i2);
                    break;
            }
        } else {
            bVar = aVar.a();
            aVar.b();
        }
        qVar.c(d2);
        return bVar;
    }

    private void a(q qVar) {
        if (qVar.b() > 0 && qVar.f() == 120) {
            if (this.f28312d == null) {
                this.f28312d = new Inflater();
            }
            if (ad.a(qVar, this.f28310b, this.f28312d)) {
                qVar.a(this.f28310b.f17159a, this.f28310b.c());
            }
        }
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f28309a.a(bArr, i2);
        a(this.f28309a);
        this.f28311c.b();
        ArrayList arrayList = new ArrayList();
        while (this.f28309a.b() >= 3) {
            b a2 = a(this.f28309a, this.f28311c);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
