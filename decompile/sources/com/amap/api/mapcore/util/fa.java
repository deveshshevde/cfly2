package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class fa {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f8733a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f8734b = new byte[128];

    static {
        for (int i2 = 0; i2 < 128; i2++) {
            f8734b[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            f8734b[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            f8734b[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            f8734b[i5] = (byte) ((i5 - 48) + 52);
        }
        byte[] bArr = f8734b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(String str) {
        return fg.a(b(str));
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance(fg.c("EQUVT"));
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey d2 = fg.d();
        if (d2 == null) {
            return null;
        }
        byte[] a2 = a(encoded, (Key) d2);
        byte[] a3 = a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        return bArr2;
    }

    static byte[] a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(fg.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return c(bArr, bArr2, fg.c());
        } catch (Throwable th) {
            fw.a(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, fg.c("EQUVT"));
        Cipher instance = Cipher.getInstance(fg.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr2);
    }

    public static String b(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            fw.a(th, "er", "e64");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[LOOP:2: B:11:0x0024->B:14:0x0031, LOOP_START, PHI: r4 
      PHI: (r4v1 int) = (r4v0 int), (r4v8 int) binds: [B:10:0x0022, B:14:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[EDGE_INSN: B:49:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096 A[EDGE_INSN: B:51:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.lang.String r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0006
            byte[] r8 = new byte[r0]
            return r8
        L_0x0006:
            byte[] r8 = com.amap.api.mapcore.util.fg.a((java.lang.String) r8)
            int r1 = r8.length
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>(r1)
        L_0x0010:
            if (r0 >= r1) goto L_0x0096
        L_0x0012:
            byte[] r3 = f8734b
            int r4 = r0 + 1
            byte r0 = r8[r0]
            byte r0 = r3[r0]
            r3 = -1
            if (r4 >= r1) goto L_0x0022
            if (r0 == r3) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = r4
            goto L_0x0012
        L_0x0022:
            if (r0 == r3) goto L_0x0096
        L_0x0024:
            byte[] r5 = f8734b
            int r6 = r4 + 1
            byte r4 = r8[r4]
            byte r4 = r5[r4]
            if (r6 >= r1) goto L_0x0033
            if (r4 == r3) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r4 = r6
            goto L_0x0024
        L_0x0033:
            if (r4 == r3) goto L_0x0096
            int r0 = r0 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r0 = r0 | r5
            r2.write(r0)
        L_0x003f:
            if (r6 != r1) goto L_0x0046
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x0046:
            int r0 = r6 + 1
            byte r5 = r8[r6]
            r6 = 61
            if (r5 != r6) goto L_0x0053
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x0053:
            byte[] r7 = f8734b
            byte r5 = r7[r5]
            if (r0 >= r1) goto L_0x005e
            if (r5 == r3) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r6 = r0
            goto L_0x003f
        L_0x005e:
            if (r5 == r3) goto L_0x0096
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            r2.write(r4)
        L_0x006c:
            if (r0 != r1) goto L_0x0073
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x0073:
            int r4 = r0 + 1
            byte r0 = r8[r0]
            if (r0 != r6) goto L_0x007e
            byte[] r8 = r2.toByteArray()
            return r8
        L_0x007e:
            byte[] r7 = f8734b
            byte r0 = r7[r0]
            if (r4 >= r1) goto L_0x0089
            if (r0 == r3) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r0 = r4
            goto L_0x006c
        L_0x0089:
            if (r0 == r3) goto L_0x0096
            r3 = r5 & 3
            int r3 = r3 << 6
            r0 = r0 | r3
            r2.write(r0)
            r0 = r4
            goto L_0x0010
        L_0x0096:
            byte[] r8 = r2.toByteArray()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fa.b(java.lang.String):byte[]");
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return c(bArr, bArr2, bArr3);
    }

    public static String c(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, fg.c("EQUVT"));
        Cipher instance = Cipher.getInstance(fg.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }

    private static String d(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (i3 == length) {
                char[] cArr = f8733a;
                stringBuffer.append(cArr[b2 >>> 2]);
                stringBuffer.append(cArr[(b2 & 3) << 4]);
                str = "==";
                break;
            }
            int i4 = i3 + 1;
            byte b3 = bArr[i3] & 255;
            if (i4 == length) {
                char[] cArr2 = f8733a;
                stringBuffer.append(cArr2[b2 >>> 2]);
                stringBuffer.append(cArr2[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(b3 & 15) << 2]);
                str = "=";
                break;
            }
            int i5 = i4 + 1;
            byte b4 = bArr[i4] & 255;
            char[] cArr3 = f8733a;
            stringBuffer.append(cArr3[b2 >>> 2]);
            stringBuffer.append(cArr3[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((b3 & 15) << 2) | ((b4 & 192) >>> 6)]);
            stringBuffer.append(cArr3[b4 & 63]);
            i2 = i5;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
