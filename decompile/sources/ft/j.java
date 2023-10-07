package ft;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.ad;
import java.io.IOException;
import java.util.Arrays;

public abstract class j extends d {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f28102a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f28103b;

    public j(f fVar, h hVar, int i2, Format format, int i3, Object obj, byte[] bArr) {
        super(fVar, hVar, i2, format, i3, obj, -9223372036854775807L, -9223372036854775807L);
        this.f28102a = bArr;
    }

    private void a(int i2) {
        byte[] bArr = this.f28102a;
        if (bArr == null) {
            this.f28102a = new byte[16384];
        } else if (bArr.length < i2 + 16384) {
            this.f28102a = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    public final void a() {
        this.f28103b = true;
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public final void b() throws IOException, InterruptedException {
        try {
            this.f13117j.a(this.f13110c);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f28103b) {
                a(i3);
                i2 = this.f13117j.a(this.f28102a, i3, 16384);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f28103b) {
                a(this.f28102a, i3);
            }
        } finally {
            ad.a((f) this.f13117j);
        }
    }

    public byte[] c() {
        return this.f28102a;
    }
}
