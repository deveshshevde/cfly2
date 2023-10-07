package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.a;
import fj.u;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f15636a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15637b;

    /* renamed from: c  reason: collision with root package name */
    public final u.a f15638c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15639d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f15640e;

    public k(boolean z2, String str, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        boolean z3 = true;
        a.a((bArr2 != null ? false : z3) ^ (i2 == 0));
        this.f15636a = z2;
        this.f15637b = str;
        this.f15639d = i2;
        this.f15640e = bArr2;
        this.f15638c = new u.a(a(str), bArr, i3, i4);
    }

    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68);
                sb.append("Unsupported protection scheme type '");
                sb.append(str);
                sb.append("'. Assuming AES-CTR crypto mode.");
                com.google.android.exoplayer2.util.k.c("TrackEncryptionBox", sb.toString());
                break;
        }
        return 1;
    }
}
