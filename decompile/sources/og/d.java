package og;

import com.xeagle.android.login.amba.connectivity.IChannelListener;
import org.jcodec.common.model.b;

public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private int f31730a;

    /* renamed from: b  reason: collision with root package name */
    private int f31731b;

    /* renamed from: c  reason: collision with root package name */
    private int f31732c;

    public d(int i2, int i3) {
        this.f31730a = i2;
        this.f31731b = i3;
        this.f31732c = i3 + 2;
    }

    private static final int a(int i2) {
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    public static final void a(int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2, int i6, int[] iArr3, int i7) {
        int i8 = (i2 * 66) + (i3 * IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN) + (i4 * 25);
        iArr[i5] = a(((i8 + 128) >> 8) + 16);
        iArr2[i6] = iArr2[i6] + a((((((i2 * -38) - (i3 * 74)) + (i4 * 112)) + 128) >> 8) + 128);
        iArr3[i7] = iArr3[i7] + a((((((i2 * 112) - (i3 * 94)) - (i4 * 18)) + 128) >> 8) + 128);
    }

    public void a(b bVar, b bVar2) {
        int[] iArr = bVar.d()[0];
        int[][] d2 = bVar2.d();
        int a2 = bVar.a() * 3;
        int a3 = bVar2.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < (bVar.b() >> 1); i5++) {
            for (int i6 = 0; i6 < (bVar.a() >> 1); i6++) {
                d2[1][i2] = 0;
                d2[2][i2] = 0;
                int i7 = i2;
                int i8 = i2;
                a(iArr[i4], iArr[i4 + 1], iArr[i4 + 2], d2[0], i3, d2[1], i7, d2[2], i8);
                d2[0][i3] = (d2[0][i3] << this.f31730a) >> this.f31731b;
                int i9 = i4 + a2;
                int i10 = i3 + a3;
                a(iArr[i9], iArr[i9 + 1], iArr[i9 + 2], d2[0], i10, d2[1], i7, d2[2], i8);
                d2[0][i10] = (d2[0][i10] << this.f31730a) >> this.f31731b;
                int i11 = i3 + 1;
                a(iArr[i4 + 3], iArr[i4 + 4], iArr[i4 + 5], d2[0], i11, d2[1], i7, d2[2], i8);
                d2[0][i11] = (d2[0][i11] << this.f31730a) >> this.f31731b;
                int i12 = i11 + a3;
                a(iArr[i9 + 3], iArr[i9 + 4], iArr[i9 + 5], d2[0], i12, d2[1], i7, d2[2], i8);
                int[] iArr2 = d2[0];
                int i13 = d2[0][i12];
                int i14 = this.f31730a;
                iArr2[i12] = (i13 << i14) >> this.f31731b;
                i3 = i11 + 1;
                int[] iArr3 = d2[1];
                int i15 = this.f31732c;
                iArr3[i2] = (d2[1][i2] << i14) >> i15;
                d2[2][i2] = (d2[2][i2] << i14) >> i15;
                i2++;
                i4 += 6;
            }
            i3 += a3;
            i4 += a2;
        }
    }
}
