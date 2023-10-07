package com.amap.api.mapcore.util;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class fp {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f8800a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f8801b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c  reason: collision with root package name */
    private static int[] f8802c = null;

    private static int a(int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 = (i4 >> 1) | Integer.MIN_VALUE;
        }
        return (i2 << i3) | ((i2 & i4) >>> (32 - i3));
    }

    public static String a() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator instance = KeyGenerator.getInstance(fg.c("EQUVT"));
            instance.init(128, secureRandom);
            return fk.a(instance.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(int i2) {
        char[] cArr = new char[4];
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = (4 - i3) - 1;
            cArr[i4] = (char) ((i2 >>> (i3 * 8)) & 255);
            char c2 = cArr[i4];
            String str = " ";
            for (int i5 = 0; i5 < 32; i5++) {
                str = str + (((Integer.MIN_VALUE >>> i5) & c2) >>> (31 - i5));
            }
        }
        return new String(cArr);
    }

    public static String a(String str) {
        return fd.b(str);
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                sb.append(a(a(b(iArr[i2]), i2)));
            }
        }
        return sb.toString();
    }

    private static byte[] a(byte[] bArr) {
        try {
            if (f8800a == null) {
                f8800a = fg.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f8800a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(b()).getBytes("UTF-8"), fg.c("EQUVT"));
            Cipher instance = Cipher.getInstance(fg.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static int b(int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < 15; i4++) {
            i3 = (i3 << 2) | 1;
        }
        return ((i2 & i3) << 1) | (((i3 << 1) & i2) >>> 1);
    }

    public static String b(String str) {
        try {
            return fk.a(a(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int[] b() {
        int[] iArr = f8802c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i2 = 0;
        while (true) {
            String[] strArr = f8801b;
            if (i2 >= strArr.length) {
                return iArr2;
            }
            byte[] b2 = fa.b(strArr[i2]);
            iArr2[i2] = ((b2[0] & 255) << 24) | (b2[3] & 255) | ((b2[2] & 255) << 8) | ((b2[1] & 255) << 16);
            i2++;
        }
    }
}
