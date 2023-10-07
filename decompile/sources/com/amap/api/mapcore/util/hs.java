package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

public final class hs extends hu {

    /* renamed from: a  reason: collision with root package name */
    public static int f9172a = 13;

    /* renamed from: b  reason: collision with root package name */
    public static int f9173b = 6;

    /* renamed from: e  reason: collision with root package name */
    private Context f9174e;

    public hs(Context context, hu huVar) {
        super(huVar);
        this.f9174e = context;
    }

    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            fg.a(byteArrayOutputStream, "1.2." + f9172a + "." + f9173b);
            fg.a(byteArrayOutputStream, "Android");
            fg.a(byteArrayOutputStream, ez.u(context));
            fg.a(byteArrayOutputStream, ez.m(context));
            fg.a(byteArrayOutputStream, ez.h(context));
            fg.a(byteArrayOutputStream, Build.MANUFACTURER);
            fg.a(byteArrayOutputStream, Build.MODEL);
            fg.a(byteArrayOutputStream, Build.DEVICE);
            fg.a(byteArrayOutputStream, ez.x(context));
            fg.a(byteArrayOutputStream, ev.c(context));
            fg.a(byteArrayOutputStream, ev.d(context));
            fg.a(byteArrayOutputStream, ev.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final byte[] a(byte[] bArr) {
        byte[] a2 = a(this.f9174e);
        byte[] bArr2 = new byte[(a2.length + bArr.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }
}
