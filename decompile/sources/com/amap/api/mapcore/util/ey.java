package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class ey {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        String f8675a;

        /* renamed from: b  reason: collision with root package name */
        String f8676b;

        /* renamed from: c  reason: collision with root package name */
        String f8677c;

        /* renamed from: d  reason: collision with root package name */
        String f8678d;

        /* renamed from: e  reason: collision with root package name */
        String f8679e;

        /* renamed from: f  reason: collision with root package name */
        String f8680f;

        /* renamed from: g  reason: collision with root package name */
        String f8681g;

        /* renamed from: h  reason: collision with root package name */
        String f8682h;

        /* renamed from: i  reason: collision with root package name */
        String f8683i;

        /* renamed from: j  reason: collision with root package name */
        String f8684j;

        /* renamed from: k  reason: collision with root package name */
        String f8685k;

        /* renamed from: l  reason: collision with root package name */
        String f8686l;

        /* renamed from: m  reason: collision with root package name */
        String f8687m;

        /* renamed from: n  reason: collision with root package name */
        String f8688n;

        /* renamed from: o  reason: collision with root package name */
        String f8689o;

        /* renamed from: p  reason: collision with root package name */
        String f8690p;

        /* renamed from: q  reason: collision with root package name */
        String f8691q;

        /* renamed from: r  reason: collision with root package name */
        String f8692r;

        /* renamed from: s  reason: collision with root package name */
        String f8693s;

        /* renamed from: t  reason: collision with root package name */
        String f8694t;

        /* renamed from: u  reason: collision with root package name */
        String f8695u;

        /* renamed from: v  reason: collision with root package name */
        String f8696v;

        /* renamed from: w  reason: collision with root package name */
        String f8697w;

        /* renamed from: x  reason: collision with root package name */
        String f8698x;

        /* renamed from: y  reason: collision with root package name */
        String f8699y;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!ev.a()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            fw.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.f8678d = ev.c(context);
            aVar.f8683i = ev.d(context);
            return a(aVar);
        } catch (Throwable th) {
            fw.a(th, "CI", "IX");
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e2 = ev.e(context);
            return fd.b(e2 + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            fw.a(th, "CI", "Sco");
            return null;
        }
    }

    private static String a(a aVar) {
        return fa.b(b(aVar));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            fg.a(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, fg.a(str));
        } else {
            fg.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    public static byte[] a(Context context, boolean z2, boolean z3) {
        try {
            return b(b(context, z2, z3));
        } catch (Throwable th) {
            fw.a(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return fa.a(bArr);
    }

    private static a b(Context context, boolean z2, boolean z3) {
        a aVar = new a((byte) 0);
        aVar.f8675a = ez.u(context);
        aVar.f8676b = ez.m(context);
        String h2 = ez.h(context);
        if (h2 == null) {
            h2 = "";
        }
        aVar.f8677c = h2;
        aVar.f8678d = ev.c(context);
        aVar.f8679e = Build.MODEL;
        aVar.f8680f = Build.MANUFACTURER;
        aVar.f8681g = Build.DEVICE;
        aVar.f8682h = ev.b(context);
        aVar.f8683i = ev.d(context);
        aVar.f8684j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f8685k = ez.x(context);
        aVar.f8686l = ez.r(context);
        StringBuilder sb = new StringBuilder();
        sb.append(ez.p(context));
        aVar.f8687m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ez.o(context));
        aVar.f8688n = sb2.toString();
        aVar.f8689o = ez.z(context);
        aVar.f8690p = ez.n(context);
        if (z2) {
            aVar.f8691q = "";
        } else {
            aVar.f8691q = ez.l(context);
        }
        if (z2) {
            aVar.f8692r = "";
        } else {
            aVar.f8692r = ez.k(context);
        }
        if (z2) {
            aVar.f8693s = "";
            aVar.f8694t = "";
        } else {
            String[] d2 = ez.d();
            aVar.f8693s = d2[0];
            aVar.f8694t = d2[1];
        }
        aVar.f8697w = ez.a();
        String a2 = ez.a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.f8698x = a2;
        } else {
            aVar.f8698x = "";
        }
        aVar.f8699y = "aid=" + ez.j(context);
        if ((z3 && fv.f8848d) || fv.f8849e) {
            String g2 = ez.g(context);
            if (!TextUtils.isEmpty(g2)) {
                aVar.f8699y += "|oaid=" + g2;
            }
        }
        String a3 = ez.a(context, ",");
        if (!TextUtils.isEmpty(a3)) {
            aVar.f8699y += "|multiImeis=" + a3;
        }
        String w2 = ez.w(context);
        if (!TextUtils.isEmpty(w2)) {
            aVar.f8699y += "|meid=" + w2;
        }
        aVar.f8699y += "|serial=" + ez.i(context);
        String b2 = ez.b();
        if (!TextUtils.isEmpty(b2)) {
            aVar.f8699y += "|adiuExtras=" + b2;
        }
        aVar.f8699y += "|storage=" + ez.e() + "|ram=" + ez.y(context) + "|arch=" + ez.f();
        return aVar;
    }

    public static String b(Context context) {
        return c(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a5 A[SYNTHETIC, Splitter:B:17:0x00a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(com.amap.api.mapcore.util.ey.a r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = r4.f8675a     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8676b     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8677c     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8678d     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8679e     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8680f     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8681g     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8682h     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8683i     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8684j     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8685k     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8686l     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8687m     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8688n     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8689o     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8690p     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8691q     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8692r     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8693s     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8694t     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8695u     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8696v     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8697w     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = r4.f8698x     // Catch:{ all -> 0x0098 }
            a(r1, r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = r4.f8699y     // Catch:{ all -> 0x0098 }
            a(r1, r4)     // Catch:{ all -> 0x0098 }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x0098 }
            byte[] r4 = com.amap.api.mapcore.util.fg.b((byte[]) r4)     // Catch:{ all -> 0x0098 }
            byte[] r4 = b((byte[]) r4)     // Catch:{ all -> 0x0098 }
            r1.close()     // Catch:{ all -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0097:
            return r4
        L_0x0098:
            r4 = move-exception
            goto L_0x009c
        L_0x009a:
            r4 = move-exception
            r1 = r0
        L_0x009c:
            java.lang.String r2 = "CI"
            java.lang.String r3 = "gzx"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r4, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x00ad
            r1.close()     // Catch:{ all -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00ad:
            return r0
        L_0x00ae:
            r4 = move-exception
            if (r1 == 0) goto L_0x00b9
            r1.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b9:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ey.b(com.amap.api.mapcore.util.ey$a):byte[]");
    }

    private static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d2 = fg.d();
        if (bArr.length <= 117) {
            return fa.a(bArr, (Key) d2);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = fa.a(bArr2, (Key) d2);
        byte[] bArr3 = new byte[((bArr.length + 128) - 117)];
        System.arraycopy(a2, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    private static String c(Context context) {
        try {
            return a(b(context, false, false));
        } catch (Throwable th) {
            fw.a(th, "CI", "gCXi");
            return null;
        }
    }
}
