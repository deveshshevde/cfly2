package bj;

import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5710a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f5711b;

    /* renamed from: c  reason: collision with root package name */
    private c f5712c;

    /* renamed from: d  reason: collision with root package name */
    private int f5713d = 0;

    private void a(int i2) {
        boolean z2 = false;
        while (!z2 && !o() && this.f5712c.f5699c <= i2) {
            int m2 = m();
            if (m2 == 33) {
                int m3 = m();
                if (m3 != 1) {
                    if (m3 == 249) {
                        this.f5712c.f5700d = new b();
                        e();
                    } else if (m3 != 254 && m3 == 255) {
                        l();
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < 11; i3++) {
                            sb.append((char) this.f5710a[i3]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            g();
                        }
                    }
                }
                k();
            } else if (m2 == 44) {
                if (this.f5712c.f5700d == null) {
                    this.f5712c.f5700d = new b();
                }
                f();
            } else if (m2 != 59) {
                this.f5712c.f5698b = 1;
            } else {
                z2 = true;
            }
        }
    }

    private int[] b(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f5711b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f5712c.f5698b = 1;
        }
        return iArr;
    }

    private void c() {
        this.f5711b = null;
        Arrays.fill(this.f5710a, (byte) 0);
        this.f5712c = new c();
        this.f5713d = 0;
    }

    private void d() {
        a((int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    private void e() {
        m();
        int m2 = m();
        this.f5712c.f5700d.f5692g = (m2 & 28) >> 2;
        boolean z2 = true;
        if (this.f5712c.f5700d.f5692g == 0) {
            this.f5712c.f5700d.f5692g = 1;
        }
        b bVar = this.f5712c.f5700d;
        if ((m2 & 1) == 0) {
            z2 = false;
        }
        bVar.f5691f = z2;
        int n2 = n();
        if (n2 < 2) {
            n2 = 10;
        }
        this.f5712c.f5700d.f5694i = n2 * 10;
        this.f5712c.f5700d.f5693h = m();
        m();
    }

    private void f() {
        this.f5712c.f5700d.f5686a = n();
        this.f5712c.f5700d.f5687b = n();
        this.f5712c.f5700d.f5688c = n();
        this.f5712c.f5700d.f5689d = n();
        int m2 = m();
        boolean z2 = false;
        boolean z3 = (m2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((m2 & 7) + 1));
        b bVar = this.f5712c.f5700d;
        if ((m2 & 64) != 0) {
            z2 = true;
        }
        bVar.f5690e = z2;
        b bVar2 = this.f5712c.f5700d;
        if (z3) {
            bVar2.f5696k = b(pow);
        } else {
            bVar2.f5696k = null;
        }
        this.f5712c.f5700d.f5695j = this.f5711b.position();
        j();
        if (!o()) {
            this.f5712c.f5699c++;
            this.f5712c.f5701e.add(this.f5712c.f5700d);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r3 = this;
        L_0x0000:
            r3.l()
            byte[] r0 = r3.f5710a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            bj.c r2 = r3.f5712c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f5709m = r0
        L_0x001b:
            int r0 = r3.f5713d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.o()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.d.g():void");
    }

    private void h() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) m());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f5712c.f5698b = 1;
            return;
        }
        i();
        if (this.f5712c.f5704h && !o()) {
            c cVar = this.f5712c;
            cVar.f5697a = b(cVar.f5705i);
            c cVar2 = this.f5712c;
            cVar2.f5708l = cVar2.f5697a[this.f5712c.f5706j];
        }
    }

    private void i() {
        this.f5712c.f5702f = n();
        this.f5712c.f5703g = n();
        int m2 = m();
        this.f5712c.f5704h = (m2 & 128) != 0;
        this.f5712c.f5705i = (int) Math.pow(2.0d, (double) ((m2 & 7) + 1));
        this.f5712c.f5706j = m();
        this.f5712c.f5707k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m2;
        do {
            m2 = m();
            this.f5711b.position(Math.min(this.f5711b.position() + m2, this.f5711b.limit()));
        } while (m2 > 0);
    }

    private void l() {
        int m2 = m();
        this.f5713d = m2;
        if (m2 > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    int i4 = this.f5713d;
                    if (i2 < i4) {
                        i3 = i4 - i2;
                        this.f5711b.get(this.f5710a, i2, i3);
                        i2 += i3;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f5713d, e2);
                    }
                    this.f5712c.f5698b = 1;
                    return;
                }
            }
        }
    }

    private int m() {
        try {
            return this.f5711b.get() & 255;
        } catch (Exception unused) {
            this.f5712c.f5698b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f5711b.getShort();
    }

    private boolean o() {
        return this.f5712c.f5698b != 0;
    }

    public d a(ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f5711b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f5711b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f5711b = null;
        this.f5712c = null;
    }

    public c b() {
        if (this.f5711b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (o()) {
            return this.f5712c;
        } else {
            h();
            if (!o()) {
                d();
                if (this.f5712c.f5699c < 0) {
                    this.f5712c.f5698b = 1;
                }
            }
            return this.f5712c;
        }
    }
}
