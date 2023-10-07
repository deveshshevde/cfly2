package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f17212a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17213b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17214c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17215d;

    /* renamed from: e  reason: collision with root package name */
    public final float f17216e;

    private a(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.f17212a = list;
        this.f17213b = i2;
        this.f17214c = i3;
        this.f17215d = i4;
        this.f17216e = f2;
    }

    public static a a(q qVar) throws ParserException {
        float f2;
        int i2;
        int i3;
        try {
            qVar.d(4);
            int h2 = (qVar.h() & 3) + 1;
            if (h2 != 3) {
                ArrayList arrayList = new ArrayList();
                int h3 = qVar.h() & 31;
                for (int i4 = 0; i4 < h3; i4++) {
                    arrayList.add(b(qVar));
                }
                int h4 = qVar.h();
                for (int i5 = 0; i5 < h4; i5++) {
                    arrayList.add(b(qVar));
                }
                if (h3 > 0) {
                    o.b a2 = o.a((byte[]) arrayList.get(0), h2, ((byte[]) arrayList.get(0)).length);
                    int i6 = a2.f17146e;
                    int i7 = a2.f17147f;
                    f2 = a2.f17148g;
                    i3 = i6;
                    i2 = i7;
                } else {
                    i3 = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new a(arrayList, h2, i3, i2, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ParserException("Error parsing AVC config", e2);
        }
    }

    private static byte[] b(q qVar) {
        int i2 = qVar.i();
        int d2 = qVar.d();
        qVar.d(i2);
        return c.a(qVar.f17159a, d2, i2);
    }
}
