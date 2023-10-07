package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import java.util.Collections;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f17220a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17221b;

    private c(List<byte[]> list, int i2) {
        this.f17220a = list;
        this.f17221b = i2;
    }

    public static c a(q qVar) throws ParserException {
        try {
            qVar.d(21);
            int h2 = qVar.h() & 3;
            int h3 = qVar.h();
            int d2 = qVar.d();
            int i2 = 0;
            for (int i3 = 0; i3 < h3; i3++) {
                qVar.d(1);
                int i4 = qVar.i();
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = qVar.i();
                    i2 += i6 + 4;
                    qVar.d(i6);
                }
            }
            qVar.c(d2);
            byte[] bArr = new byte[i2];
            int i7 = 0;
            for (int i8 = 0; i8 < h3; i8++) {
                qVar.d(1);
                int i9 = qVar.i();
                for (int i10 = 0; i10 < i9; i10++) {
                    int i11 = qVar.i();
                    System.arraycopy(o.f17135a, 0, bArr, i7, o.f17135a.length);
                    int length = i7 + o.f17135a.length;
                    System.arraycopy(qVar.f17159a, qVar.d(), bArr, length, i11);
                    i7 = length + i11;
                    qVar.d(i11);
                }
            }
            return new c(i2 == 0 ? null : Collections.singletonList(bArr), h2 + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ParserException("Error parsing HEVC config", e2);
        }
    }
}
