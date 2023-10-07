package fo;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.q;
import fo.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f27628a = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: b  reason: collision with root package name */
    private boolean f27629b;

    g() {
    }

    private long a(byte[] bArr) {
        byte b2 = bArr[0] & 255;
        byte b3 = b2 & 3;
        byte b4 = 2;
        if (b3 == 0) {
            b4 = 1;
        } else if (!(b3 == 1 || b3 == 2)) {
            b4 = bArr[1] & 63;
        }
        int i2 = b2 >> 3;
        int i3 = i2 & 3;
        return ((long) b4) * ((long) (i2 >= 16 ? 2500 << i3 : i2 >= 12 ? 10000 << (i3 & 1) : i3 == 3 ? 60000 : 10000 << i3));
    }

    private void a(List<byte[]> list, int i2) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i2) * 1000000000) / 48000).array());
    }

    public static boolean a(q qVar) {
        int b2 = qVar.b();
        byte[] bArr = f27628a;
        if (b2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        qVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.f27629b = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar, long j2, h.a aVar) {
        boolean z2 = true;
        if (!this.f27629b) {
            byte[] copyOf = Arrays.copyOf(qVar.f17159a, qVar.c());
            byte b2 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            a(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            a(arrayList, 3840);
            aVar.f27643a = Format.a((String) null, "audio/opus", (String) null, -1, -1, (int) b2, 48000, (List<byte[]>) arrayList, (DrmInitData) null, 0, (String) null);
            this.f27629b = true;
            return true;
        }
        if (qVar.p() != 1332770163) {
            z2 = false;
        }
        qVar.c(0);
        return z2;
    }

    /* access modifiers changed from: protected */
    public long b(q qVar) {
        return b(a(qVar.f17159a));
    }
}
