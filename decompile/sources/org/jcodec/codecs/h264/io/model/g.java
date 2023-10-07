package org.jcodec.codecs.h264.io.model;

import od.a;
import od.b;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public int[] f33043a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33044b;

    public static g a(a aVar, int i2) {
        g gVar = new g();
        gVar.f33043a = new int[i2];
        int i3 = 8;
        int i4 = 8;
        int i5 = 0;
        while (i5 < i2) {
            if (i3 != 0) {
                i3 = ((nw.a.b(aVar, "deltaScale") + i4) + 256) % 256;
                gVar.f33044b = i5 == 0 && i3 == 0;
            }
            int[] iArr = gVar.f33043a;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i5] = i4;
            i4 = iArr[i5];
            i5++;
        }
        return gVar;
    }

    public void a(b bVar) {
        int i2 = 0;
        if (this.f33044b) {
            nz.a.b(bVar, 0, "SPS: ");
            return;
        }
        int i3 = 8;
        while (true) {
            int[] iArr = this.f33043a;
            if (i2 < iArr.length) {
                nz.a.b(bVar, (iArr[i2] - i3) - 256, "SPS: ");
                i3 = this.f33043a[i2];
                i2++;
            } else {
                return;
            }
        }
    }
}
