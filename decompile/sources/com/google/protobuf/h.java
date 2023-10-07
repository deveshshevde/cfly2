package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f20137a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f20138b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f20139c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f20140d;

    /* renamed from: e  reason: collision with root package name */
    public static final d f20141e;

    public interface a {
    }

    public interface b<T extends a> {
    }

    static {
        byte[] bArr = new byte[0];
        f20139c = bArr;
        f20140d = ByteBuffer.wrap(bArr);
        f20141e = d.a(bArr);
    }

    static int a(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }
}
