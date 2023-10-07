package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.q;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f17217a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17218b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17219c;

    private b(int i2, int i3, String str) {
        this.f17217a = i2;
        this.f17218b = i3;
        this.f17219c = str;
    }

    public static b a(q qVar) {
        String str;
        qVar.d(2);
        int h2 = qVar.h();
        int i2 = h2 >> 1;
        int h3 = ((qVar.h() >> 3) & 31) | ((h2 & 1) << 5);
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            str = "dvhe";
        } else if (i2 == 8) {
            str = "hev1";
        } else if (i2 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder(str.length() + 26);
        sb.append(str);
        sb.append(".0");
        sb.append(i2);
        sb.append(".0");
        sb.append(h3);
        return new b(i2, h3, sb.toString());
    }
}
