package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f16995a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16996b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f16997c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f16998d;

    /* renamed from: e  reason: collision with root package name */
    public final long f16999e;

    /* renamed from: f  reason: collision with root package name */
    public final long f17000f;

    /* renamed from: g  reason: collision with root package name */
    public final long f17001g;

    /* renamed from: h  reason: collision with root package name */
    public final String f17002h;

    /* renamed from: i  reason: collision with root package name */
    public final int f17003i;

    public h(Uri uri, int i2) {
        this(uri, 0, -1, (String) null, i2);
    }

    public h(Uri uri, int i2, byte[] bArr, long j2, long j3, long j4, String str, int i3) {
        this(uri, i2, bArr, j2, j3, j4, str, i3, Collections.emptyMap());
    }

    public h(Uri uri, int i2, byte[] bArr, long j2, long j3, long j4, String str, int i3, Map<String, String> map) {
        byte[] bArr2 = bArr;
        long j5 = j2;
        long j6 = j3;
        long j7 = j4;
        boolean z2 = true;
        a.a(j5 >= 0);
        a.a(j6 >= 0);
        if (j7 <= 0 && j7 != -1) {
            z2 = false;
        }
        a.a(z2);
        this.f16995a = uri;
        this.f16996b = i2;
        this.f16997c = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f16999e = j5;
        this.f17000f = j6;
        this.f17001g = j7;
        this.f17002h = str;
        this.f17003i = i3;
        this.f16998d = Collections.unmodifiableMap(new HashMap(map));
    }

    public h(Uri uri, long j2, long j3, long j4, String str, int i2) {
        this(uri, (byte[]) null, j2, j3, j4, str, i2);
    }

    public h(Uri uri, long j2, long j3, String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    public h(Uri uri, long j2, long j3, String str, int i2) {
        this(uri, j2, j2, j3, str, i2);
    }

    public h(Uri uri, long j2, long j3, String str, int i2, Map<String, String> map) {
        this(uri, a((byte[]) null), (byte[]) null, j2, j2, j3, str, i2, map);
    }

    public h(Uri uri, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        this(uri, a(bArr), bArr, j2, j3, j4, str, i2);
    }

    private static int a(byte[] bArr) {
        return bArr != null ? 2 : 1;
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return "GET";
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "HEAD";
        }
        throw new AssertionError(i2);
    }

    public h a(long j2) {
        long j3 = this.f17001g;
        long j4 = -1;
        if (j3 != -1) {
            j4 = j3 - j2;
        }
        return a(j2, j4);
    }

    public h a(long j2, long j3) {
        if (j2 == 0 && this.f17001g == j3) {
            return this;
        }
        return new h(this.f16995a, this.f16996b, this.f16997c, this.f16999e + j2, this.f17000f + j2, j3, this.f17002h, this.f17003i, this.f16998d);
    }

    public final String a() {
        return b(this.f16996b);
    }

    public boolean a(int i2) {
        return (this.f17003i & i2) == i2;
    }

    public String toString() {
        String a2 = a();
        String valueOf = String.valueOf(this.f16995a);
        String arrays = Arrays.toString(this.f16997c);
        long j2 = this.f16999e;
        long j3 = this.f17000f;
        long j4 = this.f17001g;
        String str = this.f17002h;
        int i2 = this.f17003i;
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 94 + String.valueOf(valueOf).length() + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(a2);
        sb.append(" ");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }
}
